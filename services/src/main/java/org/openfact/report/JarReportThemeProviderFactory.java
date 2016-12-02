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

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.theme.ClassLoaderTheme;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderFactory;
import org.openfact.util.JsonSerialization;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class JarReportThemeProviderFactory implements ReportThemeProviderFactory {

    protected static final String OPENFACT_THEMES_JSON = "META-INF/openfact-reports.json";
    protected static Map<ReportTheme.Type, Map<String, ClassLoaderReportTheme>> themes = new HashMap<>();

    public static class ThemeRepresentation {
        private String name;
        private String[] types;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String[] getTypes() {
            return types;
        }

        public void setTypes(String[] types) {
            this.types = types;
        }
    }

    public static class ThemesRepresentation {
        private ThemeRepresentation[] themes;

        public ThemeRepresentation[] getThemes() {
            return themes;
        }

        public void setThemes(ThemeRepresentation[] themes) {
            this.themes = themes;
        }
    }

    @Override
    public ReportThemeProvider create(OpenfactSession session) {
        return new JarReportThemeProvider(themes);
    }

    @Override
    public void init(Config.Scope config) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Enumeration<URL> resources = classLoader.getResources(OPENFACT_THEMES_JSON);
            while (resources.hasMoreElements()) {
                loadThemes(classLoader, resources.nextElement().openStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load report themes", e);
        }
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "jar";
    }

    protected void loadThemes(ClassLoader classLoader, InputStream themesInputStream) {
        try {
            ThemesRepresentation themesRep = JsonSerialization.readValue(themesInputStream, ThemesRepresentation.class);

            for (ThemeRepresentation themeRep : themesRep.getThemes()) {
                for (String t : themeRep.getTypes()) {
                    ReportTheme.Type type = ReportTheme.Type.valueOf(t.toUpperCase());
                    if (!themes.containsKey(type)) {
                        themes.put(type, new HashMap<String, ClassLoaderReportTheme>());
                    }
                    themes.get(type).put(themeRep.getName(), new ClassLoaderReportTheme(themeRep.getName(), type, classLoader));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load report themes", e);
        }
    }

}