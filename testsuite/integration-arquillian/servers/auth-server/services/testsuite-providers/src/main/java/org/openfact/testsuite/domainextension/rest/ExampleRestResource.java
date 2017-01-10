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

package org.openfact.testsuite.domainextension.rest;

import org.openfact.models.OpenfactSession;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;

public class ExampleRestResource {

	private final OpenfactSession session;
	
	public ExampleRestResource(OpenfactSession session) {
		this.session = session;
	}
	
    @Path("companies")
    public CompanyResource getCompanyResource() {
        return new CompanyResource(session);
    }

    // Same like "companies" endpoint, but REST endpoint is authenticated with Bearer token and user must be in realm role "admin"
    // Just for illustration purposes
    @Path("companies-auth")
    public CompanyResource getCompanyResourceAuthenticated() {
        checkOrganizationAdmin();
        return new CompanyResource(session);
    }

    private void checkOrganizationAdmin() {
        if (session == null) {
            throw new NotAuthorizedException("Bearer");
        }
    }

}
