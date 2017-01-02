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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "CREDIT_NOTE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ORGANIZATION_ID", "DOCUMENT_ID"})
})
@NamedQueries({
        @NamedQuery(name = "getAllCreditNotesByOrganization", query = "select c from CreditNoteEntity c where c.organizationId = :organizationId order by c.createdTimestamp"),
        @NamedQuery(name = "getAllCreditNotesByOrganizationDesc", query = "select c from CreditNoteEntity c where c.organizationId = :organizationId order by c.createdTimestamp desc"),
        @NamedQuery(name = "getAllCreditNoteIdsByOrganization", query = "select c.id from CreditNoteEntity c where c.organizationId = :organizationId order by c.issueDateTime"),
        @NamedQuery(name = "getAllCreditNotesByRequiredActionAndOrganization", query = "select c from CreditNoteEntity c inner join c.requiredActions r where c.organizationId = :organizationId and r.action in :requiredAction order by c.issueDateTime"),
        @NamedQuery(name = "getOrganizationCreditNoteById", query = "select c from CreditNoteEntity c where c.id = :id and c.organizationId = :organizationId"),
        @NamedQuery(name = "getOrganizationCreditNoteByDocumentId", query = "select c from CreditNoteEntity c where c.documentId = :documentId and c.organizationId = :organizationId"),
        @NamedQuery(name = "searchForCreditNote", query = "select c from CreditNoteEntity c where c.organizationId = :organizationId and lower(c.documentId) like :search order by c.issueDateTime"),
        @NamedQuery(name = "getOrganizationCreditNoteCount", query = "select count(c) from CreditNoteEntity c where c.organizationId = :organizationId"),
        @NamedQuery(name = "deleteCreditNotesByOrganization", query = "delete from CreditNoteEntity u where u.organizationId = :organizationId")})
public class CreditNoteEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "DOCUMENT_ID")
    private String documentId;

    @Column(name = "XML_FILE_ID")
    private String xmlFileId;

    @NotNull
    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    @Column(name = "DOCUMENT_CURRENCY_CODE")
    private String documentCurrencyCode;

    @Column(name = "ISSUE_DATE_TIME")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime issueDateTime;

    @Column(name = "CUSTOMER_REGISTRATIONNAME")
    private String customerRegistrationName;

    @Column(name = "CUSTOMER_ASSIGNEDACCOUNTID")
    private String customerAssignedAccountId;

    @Column(name = "CUSTOMER_ELECTRONICMAIL")
    private String customerElectronicMail;

    @Column(name = "ALLOWANCE_TOTAL_AMOUNT")
    private BigDecimal allowanceTotalAmount;

    @Column(name = "CHARGE_TOTAL_AMOUNT")
    private BigDecimal chargeTotalAmount;

    @Column(name = "PAYABLE_AMOUNT")
    private BigDecimal payableAmount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CREDITNOTE_INVOICE", joinColumns = @JoinColumn(name = "CREDIT_NOTE_ID"), inverseJoinColumns = @JoinColumn(name = "INVOICE_ID"))
    private List<InvoiceEntity> invoices = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "creditNote")
    private Collection<CreditNoteAttributeEntity> attributes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "creditNote")
    private Collection<CreditNoteRequiredActionEntity> requiredActions = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "creditNote", fetch = FetchType.LAZY)
    private Collection<CreditNoteSendEventEntity> sendEvents = new ArrayList<>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditNoteEntity other = (CreditNoteEntity) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getXmlFileId() {
        return xmlFileId;
    }

    public void setXmlFileId(String xmlFileId) {
        this.xmlFileId = xmlFileId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public String getCustomerRegistrationName() {
        return customerRegistrationName;
    }

    public void setCustomerRegistrationName(String customerRegistrationName) {
        this.customerRegistrationName = customerRegistrationName;
    }

    public String getCustomerAssignedAccountId() {
        return customerAssignedAccountId;
    }

    public void setCustomerAssignedAccountId(String customerAssignedAccountId) {
        this.customerAssignedAccountId = customerAssignedAccountId;
    }

    public BigDecimal getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    public BigDecimal getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Collection<CreditNoteAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<CreditNoteAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public Collection<CreditNoteRequiredActionEntity> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(Collection<CreditNoteRequiredActionEntity> requiredActions) {
        this.requiredActions = requiredActions;
    }

    public Collection<CreditNoteSendEventEntity> getSendEvents() {
        return sendEvents;
    }

    public void setSendEvents(Collection<CreditNoteSendEventEntity> sendEvents) {
        this.sendEvents = sendEvents;
    }

    public String getCustomerElectronicMail() {
        return customerElectronicMail;
    }

    public void setCustomerElectronicMail(String customerElectronicMail) {
        this.customerElectronicMail = customerElectronicMail;
    }

    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }
}
