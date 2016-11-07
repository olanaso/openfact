/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.email;

import org.openfact.events.Event;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public interface EmailTemplateProvider extends Provider {

	String IDENTITY_PROVIDER_BROKER_CONTEXT = "identityProviderBrokerCtx";

	public EmailTemplateProvider setOrganization(OrganizationModel organization);

	public EmailTemplateProvider setUser(UserSenderModel user);

	public EmailTemplateProvider setAttribute(String name, Object value);

	public void sendEvent(Event event) throws EmailException;

	void sendInvoice(InvoiceModel invoice) throws EmailException ;

	void sendCreditNote(CreditNoteModel creditNote) throws EmailException ;

	void sendDebitNote(DebitNoteModel debitNote) throws EmailException ;

}
