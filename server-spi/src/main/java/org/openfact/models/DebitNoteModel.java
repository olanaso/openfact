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
package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.models.enums.RequiredAction;
import org.openfact.provider.ProviderEvent;
import org.openfact.ubl.SendEventModel;

public interface DebitNoteModel {

    String DOCUMENT_ID = "documentId";
    String ISSUE_DATETIME = "issueDateTime";

    String getId();

    String getDocumentId();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * */

    LocalDateTime getIssueDateTime();

    void setIssueDateTime(LocalDateTime value);

    String getDocumentCurrencyCode();

    void setDocumentCurrencyCode(String value);

    String getCustomerRegistrationName();

    void setCustomerRegistrationName(String value);

    String getCustomerAssignedAccountId();

    void setCustomerAssignedAccountId(String value);

    String getCustomerElectronicMail();

    void setCustomerElectronicMail(String value);

    BigDecimal getAllowanceTotalAmount();

    void setAllowanceTotalAmount(BigDecimal value);

    BigDecimal getChargeTotalAmount();

    void setChargeTotalAmount(BigDecimal value);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal value);

    InvoiceModel getInvoice();

    /**
     * Xml
     */

    @Deprecated
    byte[] getXmlDocument();

    @Deprecated
    void setXmlDocument(byte[] value);

    org.openfact.file.FileModel getXmlFile();

    void setXmlFileContent(byte[] value);

    /**
     * attributes
     */
    void setSingleAttribute(String name, String value);
    void setAttribute(String name, List<String> values);
    void removeAttribute(String name);
    String getFirstAttribute(String name);
    List<String> getAttribute(String name);
    Map<String, List<String>> getAttributes();

    /**
     * Required Actions
     */
    Set<String> getRequiredActions();
    void addRequiredAction(String action);
    void removeRequiredAction(String action);
    void addRequiredAction(RequiredAction action);
    void removeRequiredAction(RequiredAction action);

    /**
     * Send events*/
    List<SendEventModel> getSendEvents();
    
    /**
     * Events interfaces
     */
    interface DebitNoteCreationEvent extends ProviderEvent {
        DebitNoteModel getCreatedDebitNote();
    }

    interface DebitNotePostCreateEvent extends ProviderEvent {
        DebitNoteModel getCreatedDebitNote();

        OpenfactSession getOpenfactSession();
    }

    interface DebitNoteRemovedEvent extends ProviderEvent {
        DebitNoteModel getDebitNote();

        OpenfactSession getOpenfactSession();
    }

}
