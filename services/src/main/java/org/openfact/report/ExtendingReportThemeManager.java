/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.report;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.OpenfactSession;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class ExtendingReportThemeManager implements ReportThemeProvider {

    private static final Logger log = Logger.getLogger(ExtendingReportThemeManager.class);

    private final OpenfactSession session;
    private final ConcurrentHashMap<ExtendingReportThemeManagerFactory.ThemeKey, ReportTheme> themeCache;
    private List<ReportThemeProvider> providers;
    private String defaultTheme;

    public ExtendingReportThemeManager(OpenfactSession session, ConcurrentHashMap<ExtendingReportThemeManagerFactory.ThemeKey, ReportTheme> themeCache) {
        this.session = session;
        this.themeCache = themeCache;
        this.defaultTheme = Config.scope("theme").get("default", Version.NAME.toLowerCase());
    }

    private List<ReportThemeProvider> getProviders() {
        if (providers == null) {
            providers = new LinkedList();

            for (ReportThemeProvider p : session.getAllProviders(ReportThemeProvider.class)) {
                if (!(p instanceof ExtendingReportThemeManager)) {
                    if (!p.getClass().equals(ExtendingReportThemeManager.class)) {
                        providers.add(p);
                    }
                }
            }

            Collections.sort(providers, new Comparator<ReportThemeProvider>() {
                @Override
                public int compare(ReportThemeProvider o1, ReportThemeProvider o2) {
                    return o2.getProviderPriority() - o1.getProviderPriority();
                }
            });
        }

        return providers;
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportTheme getTheme(String name, ReportTheme.Type type) throws IOException {
        if (name == null) {
            name = defaultTheme;
        }

        if (themeCache != null) {
            ExtendingReportThemeManagerFactory.ThemeKey key = ExtendingReportThemeManagerFactory.ThemeKey.get(name, type);
            ReportTheme theme = themeCache.get(key);
            if (theme == null) {
                theme = loadTheme(name, type);
                if (theme == null) {
                    theme = loadTheme("openfact", type);
                    if (theme == null) {
                        theme = loadTheme("base", type);
                    }
                    log.errorv("Failed to find {0} report theme {1}, using built-in report themes", type, name);
                } else if (themeCache.putIfAbsent(key, theme) != null) {
                    theme = themeCache.get(key);
                }
            }
            return theme;
        } else {
            return loadTheme(name, type);
        }
    }

    private ReportTheme loadTheme(String name, ReportTheme.Type type) throws IOException {
        ReportTheme theme = findTheme(name, type);
        if (theme != null && (theme.getParentName() != null || theme.getImportName() != null)) {
            List<ReportTheme> themes = new LinkedList<>();
            themes.add(theme);

            if (theme.getImportName() != null) {
                String[] s = theme.getImportName().split("/");
                themes.add(findTheme(s[1], ReportTheme.Type.valueOf(s[0].toUpperCase())));
            }

            if (theme.getParentName() != null) {
                for (String parentName = theme.getParentName(); parentName != null; parentName = theme.getParentName()) {
                    theme = findTheme(parentName, type);
                    themes.add(theme);

                    if (theme.getImportName() != null) {
                        String[] s = theme.getImportName().split("/");
                        themes.add(findTheme(s[1], ReportTheme.Type.valueOf(s[0].toUpperCase())));
                    }
                }
            }

            return new ExtendingReportTheme(themes);
        } else {
            return theme;
        }
    }

    @Override
    public Set<String> nameSet(ReportTheme.Type type) {
        Set<String> themes = new HashSet<String>();
        for (ReportThemeProvider p : getProviders()) {
            themes.addAll(p.nameSet(type));
        }
        return themes;
    }

    @Override
    public boolean hasTheme(String name, ReportTheme.Type type) {
        for (ReportThemeProvider p : getProviders()) {
            if (p.hasTheme(name, type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() {
        providers = null;
    }

    private ReportTheme findTheme(String name, ReportTheme.Type type) {
        for (ReportThemeProvider p : getProviders()) {
            if (p.hasTheme(name, type)) {
                try {
                    return p.getTheme(name, type);
                } catch (IOException e) {
                    log.errorv(e, p.getClass() + " failed to load report theme, type={0}, name={1}", type, name);
                }
            }
        }
        return null;
    }

    public static class ExtendingReportTheme implements ReportTheme {

        private List<ReportTheme> themes;

        private Properties properties;

        private ConcurrentHashMap<String, ConcurrentHashMap<Locale, Properties>> messages = new ConcurrentHashMap<>();

        public ExtendingReportTheme(List<ReportTheme> themes) {
            this.themes = themes;
        }

        @Override
        public String getName() {
            return themes.get(0).getName();
        }

        @Override
        public String getParentName() {
            return themes.get(0).getParentName();
        }

        @Override
        public String getImportName() {
            return themes.get(0).getImportName();
        }

        @Override
        public Type getType() {
            return themes.get(0).getType();
        }

        @Override
        public URL getTemplate(String name) throws IOException {
            for (ReportTheme t : themes) {
                URL template = t.getTemplate(name);
                if (template != null) {
                    return template;
                }
            }
            return null;
        }

        @Override
        public InputStream getTemplateAsStream(String name) throws IOException {
            for (ReportTheme t : themes) {
                InputStream template = t.getTemplateAsStream(name);
                if (template != null) {
                    return template;
                }
            }
            return null;
        }


        @Override
        public URL getResource(String path) throws IOException {
            for (ReportTheme t : themes) {
                URL resource = t.getResource(path);
                if (resource != null) {
                    return resource;
                }
            }
            return null;
        }

        @Override
        public InputStream getResourceAsStream(String path) throws IOException {
            for (ReportTheme t : themes) {
                InputStream resource = t.getResourceAsStream(path);
                if (resource != null) {
                    return resource;
                }
            }
            return null;
        }

        @Override
        public Properties getMessages(Locale locale) throws IOException {
            return getMessages("messages", locale);
        }

        @Override
        public Properties getMessages(String baseBundlename, Locale locale) throws IOException {
            if (messages.get(baseBundlename) == null || messages.get(baseBundlename).get(locale) == null) {
                Properties messages = new Properties();

                if (!Locale.ENGLISH.equals(locale)) {
                    messages.putAll(getMessages(baseBundlename, Locale.ENGLISH));
                }

                ListIterator<ReportTheme> itr = themes.listIterator(themes.size());
                while (itr.hasPrevious()) {
                    Properties m = itr.previous().getMessages(baseBundlename, locale);
                    if (m != null) {
                        messages.putAll(m);
                    }
                }

                this.messages.putIfAbsent(baseBundlename, new ConcurrentHashMap<Locale, Properties>());
                this.messages.get(baseBundlename).putIfAbsent(locale, messages);

                return messages;
            } else {
                return messages.get(baseBundlename).get(locale);
            }
        }

        @Override
        public Properties getProperties() throws IOException {
            if (properties == null) {
                Properties properties = new Properties();
                ListIterator<ReportTheme> itr = themes.listIterator(themes.size());
                while (itr.hasPrevious()) {
                    Properties p = itr.previous().getProperties();
                    if (p != null) {
                        properties.putAll(p);
                    }
                }
                this.properties = properties;
                return properties;
            } else {
                return properties;
            }
        }

    }

}