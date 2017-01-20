/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.testsuite.performance;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public final class PerfTestUtils {

    private PerfTestUtils() {
    }

    public static <T> T readSystemProperty(String propertyName, Class<T> expectedClass) {
        String propAsString = System.getProperty(propertyName);
        if (propAsString == null || propAsString.length() == 0) {
            throw new IllegalArgumentException("Property '" + propertyName + "' not specified");
        }

        if (Integer.class.equals(expectedClass)) {
            return expectedClass.cast(Integer.parseInt(propAsString));
        } else if (Boolean.class.equals(expectedClass)) {
            return expectedClass.cast(Boolean.valueOf(propAsString));
        }  else {
            throw new IllegalArgumentException("Not supported type " + expectedClass);
        }
    }

    public static String getOrganizationName(int organizationNumber) {
        return "organization" + organizationNumber;
    }

    public static String getApplicationName(int organizationNumber, int applicationNumber) {
        return getOrganizationName(organizationNumber) + "application" + applicationNumber;
    }

    public static String getInvoiceDocumentId(int invoiceNumber) {
        return "invoice" + invoiceNumber;
    }
}
