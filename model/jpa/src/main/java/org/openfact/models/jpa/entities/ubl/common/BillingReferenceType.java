//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "BillingReferenceType")
@Table(name = "BILLINGREFERENCETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingReferenceType {

    protected DocumentReferenceType invoiceDocumentReference;
    protected DocumentReferenceType selfBilledInvoiceDocumentReference;
    protected DocumentReferenceType creditNoteDocumentReference;
    protected DocumentReferenceType selfBilledCreditNoteDocumentReference;
    protected DocumentReferenceType debitNoteDocumentReference;
    protected DocumentReferenceType reminderDocumentReference;
    protected DocumentReferenceType additionalDocumentReference;
    protected List<BillingReferenceLineType> billingReferenceLine;
    protected String id;

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEDOCUMENTREFERENCE_BIL_0")
    public DocumentReferenceType getInvoiceDocumentReference() {
        return invoiceDocumentReference;
    }

    public void setInvoiceDocumentReference(DocumentReferenceType value) {
        this.invoiceDocumentReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELFBILLEDINVOICEDOCUMENTREF_1")
    public DocumentReferenceType getSelfBilledInvoiceDocumentReference() {
        return selfBilledInvoiceDocumentReference;
    }

    public void setSelfBilledInvoiceDocumentReference(DocumentReferenceType value) {
        this.selfBilledInvoiceDocumentReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CREDITNOTEDOCUMENTREFERENCE__0")
    public DocumentReferenceType getCreditNoteDocumentReference() {
        return creditNoteDocumentReference;
    }

    public void setCreditNoteDocumentReference(DocumentReferenceType value) {
        this.creditNoteDocumentReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELFBILLEDCREDITNOTEDOCUMENT_1")
    public DocumentReferenceType getSelfBilledCreditNoteDocumentReference() {
        return selfBilledCreditNoteDocumentReference;
    }

    public void setSelfBilledCreditNoteDocumentReference(DocumentReferenceType value) {
        this.selfBilledCreditNoteDocumentReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DEBITNOTEDOCUMENTREFERENCE_B_0")
    public DocumentReferenceType getDebitNoteDocumentReference() {
        return debitNoteDocumentReference;
    }

    public void setDebitNoteDocumentReference(DocumentReferenceType value) {
        this.debitNoteDocumentReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REMINDERDOCUMENTREFERENCE_BI_0")
    public DocumentReferenceType getReminderDocumentReference() {
        return reminderDocumentReference;
    }

    public void setReminderDocumentReference(DocumentReferenceType value) {
        this.reminderDocumentReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALDOCUMENTREFERENCE__2")
    public DocumentReferenceType getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(DocumentReferenceType value) {
        this.additionalDocumentReference = value;
    }

    @OneToMany(targetEntity = BillingReferenceLineType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCELINE_BILLING_0")
    public List<BillingReferenceLineType> getBillingReferenceLine() {
        if (billingReferenceLine == null) {
            billingReferenceLine = new ArrayList<BillingReferenceLineType>();
        }
        return this.billingReferenceLine;
    }

    public void setBillingReferenceLine(List<BillingReferenceLineType> billingReferenceLine) {
        this.billingReferenceLine = billingReferenceLine;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
