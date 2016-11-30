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

package org.openfact.report.theme;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportTheme.Type;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class JarReportProvider implements ReportThemeProvider {

    private Map<ReportTheme.Type, Map<String, ClassLoaderReport>> reports;

    public JarReportProvider(Map<ReportTheme.Type, Map<String, ClassLoaderReport>> reports) {
        this.reports = reports;
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportTheme getReportTheme(String name, ReportTheme.Type type) throws IOException {
        return hasReportTheme(name, type) ? reports.get(type).get(name) : null;
    }

    @Override
    public Set<String> nameSet(ReportTheme.Type type) {
        if (reports.containsKey(type)) {
            return reports.get(type).keySet();
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean hasReportTheme(String name, ReportTheme.Type type) {
        return reports.containsKey(type) && reports.get(type).containsKey(name);
    }

    @Override
    public void close() {
    }

}
