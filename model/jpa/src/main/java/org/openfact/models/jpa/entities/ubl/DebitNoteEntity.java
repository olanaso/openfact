//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import org.openfact.models.jpa.entities.ubl.common.*;

@Entity
@Table(name = "DEBITNOTE")
public class DebitNoteEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(targetEntity = UBLExtensionsEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UBLEXTENSIONS_DEBITNOTE")
    protected UBLExtensionsEntity ublExtensions;

    @Column(name = "UBL_VERSIONID")
    protected String ublVersionID;

    @Column(name = "CUSTOMIZATIONID")
    protected String customizationID;

    @Column(name = "PROFILEID")
    protected String profileID;

    @Column(name = "ID")
    protected String ID;

    @Column(name = "COPY_INDICATOR")
    protected boolean copyIndicator;

    @Column(name = "UUID")
    protected String uuid;

    @Column(name = "ISSUE_DATE")
    protected LocalDate issueDate;

    @Column(name = "ISSUE_TIME")
    protected LocalTime issueTime;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "NOTE_DEBITNOTE", joinColumns = { @JoinColumn(name = "DEBITNOTE_ID") })
    protected List<String> note = new ArrayList<>();

    @Column(name = "TAX_POINT_DATE")
    protected LocalDate taxPointDate;

    @Column(name = "DOCUMENT_CURRENCY_CODE")
    protected String documentCurrencyCode;

    @Column(name = "TAX_CURRENCY_CODE")
    protected String taxCurrencyCode;

    @Column(name = "PRICING_CURRENCY_CODE")
    protected String pricingCurrencyCode;

    @Column(name = "PAYMENT_CURRENCY_CODE")
    protected String paymentCurrencyCode;

    @Column(name = "PAYMENT_ALTERNATIVE_CURRENCY_CODE")
    protected String paymentAlternativeCurrencyCode;

    @Column(name = "ACCOUNTING_COST_CODE")
    protected String accountingCostCode;

    @Column(name = "ACCOUNTING_COST")
    protected String accountingCost;

    @Column(name = "LINE_COUNT_NUMERIC")
    protected BigDecimal lineCountNumeric;

    @OneToMany(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEPERIOD_DEBITNOTE")
    protected List<PeriodEntity> invoicePeriod = new ArrayList<>();

    @OneToMany(targetEntity = ResponseEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DISCREPANCYRESPONSE_DEBITNOTE")
    protected List<ResponseEntity> discrepancyResponse = new ArrayList<>();

    @ManyToOne(targetEntity = OrderReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERREFERENCE_DEBITNOTE")
    protected OrderReferenceEntity orderReference = new OrderReferenceEntity();

    @OneToMany(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_DEBITNOTE")
    protected List<BillingReferenceEntity> billingReference = new ArrayList<>();

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCHDOCUMENTREFERENCE_DEBITNOTE")
    protected List<DocumentReferenceEntity> despatchDocumentReference = new ArrayList<>();

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIPTDOCUMENTREFERENCE_DEBITNOTE")
    protected List<DocumentReferenceEntity> receiptDocumentReference = new ArrayList<>();

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTRACTDOCUMENTREFERENCE_DEBITNOTE")
    protected List<DocumentReferenceEntity> contractDocumentReference = new ArrayList<>();

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALDOCUMENTREFERENCE_DEBITNOTE")
    protected List<DocumentReferenceEntity> additionalDocumentReference = new ArrayList<>();

    @OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SIGNATURE_DEBITNOTETYPE_ID")
    protected List<SignatureEntity> signature = new ArrayList<>();

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_DEBITNOTE")
    protected SupplierPartyEntity accountingSupplierParty = new SupplierPartyEntity();

    @ManyToOne(targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_DEBITNOTE")
    protected CustomerPartyEntity accountingCustomerParty = new CustomerPartyEntity();

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYEEPARTY_DEBITNOTE_ID")
    protected PartyEntity payeeParty = new PartyEntity();

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXREPRESENTATIVEPARTY_DEBITNOTE")
    protected PartyEntity taxRepresentativeParty = new PartyEntity();

    @OneToMany(targetEntity = PaymentEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PREPAIDPAYMENT_DEBITNOTE")
    protected List<PaymentEntity> prepaidPayment = new ArrayList<>();

    @ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXEXCHANGERATE_DEBITNOTE")
    protected ExchangeRateEntity taxExchangeRate = new ExchangeRateEntity();

    @ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGEXCHANGERATE_DEBITNOTE")
    protected ExchangeRateEntity pricingExchangeRate = new ExchangeRateEntity();

    @ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTEXCHANGERATE_DEBITNOTE")
    protected ExchangeRateEntity paymentExchangeRate = new ExchangeRateEntity();

    @ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTALTERNATIVEEXCHANGERATE_DEBITNOTE")
    protected ExchangeRateEntity paymentAlternativeExchangeRate = new ExchangeRateEntity();

    @OneToMany(targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_DEBITNOTE_ID")
    protected List<TaxTotalEntity> taxTotal = new ArrayList<>();

    @ManyToOne(targetEntity = MonetaryTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REQUESTEDMONETARYTOTAL_DEBITNOTE")
    protected MonetaryTotalEntity requestedMonetaryTotal = new MonetaryTotalEntity();

    @OneToMany(targetEntity = DebitNoteLineEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DEBITNOTELINE_DEBITNOTE")
    protected List<DebitNoteLineEntity> debitNoteLine = new ArrayList<>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the ublExtensions
     */
    public UBLExtensionsEntity getUblExtensions() {
        return ublExtensions;
    }

    /**
     * @param ublExtensions
     *            the ublExtensions to set
     */
    public void setUblExtensions(UBLExtensionsEntity ublExtensions) {
        this.ublExtensions = ublExtensions;
    }

    /**
     * @return the ublVersionID
     */
    public String getUblVersionID() {
        return ublVersionID;
    }

    /**
     * @param ublVersionID
     *            the ublVersionID to set
     */
    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     *            the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the note
     */
    public List<String> getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(List<String> note) {
        this.note = note;
    }

    /**
     * @return the taxPointDate
     */
    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * @param taxPointDate
     *            the taxPointDate to set
     */
    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
    }

    /**
     * @return the documentCurrencyCode
     */
    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    /**
     * @param documentCurrencyCode
     *            the documentCurrencyCode to set
     */
    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    /**
     * @return the taxCurrencyCode
     */
    public String getTaxCurrencyCode() {
        return taxCurrencyCode;
    }

    /**
     * @param taxCurrencyCode
     *            the taxCurrencyCode to set
     */
    public void setTaxCurrencyCode(String taxCurrencyCode) {
        this.taxCurrencyCode = taxCurrencyCode;
    }

    /**
     * @return the pricingCurrencyCode
     */
    public String getPricingCurrencyCode() {
        return pricingCurrencyCode;
    }

    /**
     * @param pricingCurrencyCode
     *            the pricingCurrencyCode to set
     */
    public void setPricingCurrencyCode(String pricingCurrencyCode) {
        this.pricingCurrencyCode = pricingCurrencyCode;
    }

    /**
     * @return the paymentCurrencyCode
     */
    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    /**
     * @param paymentCurrencyCode
     *            the paymentCurrencyCode to set
     */
    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    /**
     * @return the paymentAlternativeCurrencyCode
     */
    public String getPaymentAlternativeCurrencyCode() {
        return paymentAlternativeCurrencyCode;
    }

    /**
     * @param paymentAlternativeCurrencyCode
     *            the paymentAlternativeCurrencyCode to set
     */
    public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
        this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
    }

    /**
     * @return the accountingCostCode
     */
    public String getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    /**
     * @return the accountingCost
     */
    public String getAccountingCost() {
        return accountingCost;
    }

    /**
     * @param accountingCost
     *            the accountingCost to set
     */
    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    /**
     * @return the lineCountNumeric
     */
    public BigDecimal getLineCountNumeric() {
        return lineCountNumeric;
    }

    /**
     * @param lineCountNumeric
     *            the lineCountNumeric to set
     */
    public void setLineCountNumeric(BigDecimal lineCountNumeric) {
        this.lineCountNumeric = lineCountNumeric;
    }

    /**
     * @return the invoicePeriod
     */
    public List<PeriodEntity> getInvoicePeriod() {
        return invoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(List<PeriodEntity> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    /**
     * @return the discrepancyResponse
     */
    public List<ResponseEntity> getDiscrepancyResponse() {
        return discrepancyResponse;
    }

    /**
     * @param discrepancyResponse
     *            the discrepancyResponse to set
     */
    public void setDiscrepancyResponse(List<ResponseEntity> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }

    /**
     * @return the orderReference
     */
    public OrderReferenceEntity getOrderReference() {
        return orderReference;
    }

    /**
     * @param orderReference
     *            the orderReference to set
     */
    public void setOrderReference(OrderReferenceEntity orderReference) {
        this.orderReference = orderReference;
    }

    /**
     * @return the billingReference
     */
    public List<BillingReferenceEntity> getBillingReference() {
        return billingReference;
    }

    /**
     * @param billingReference
     *            the billingReference to set
     */
    public void setBillingReference(List<BillingReferenceEntity> billingReference) {
        this.billingReference = billingReference;
    }

    /**
     * @return the despatchDocumentReference
     */
    public List<DocumentReferenceEntity> getDespatchDocumentReference() {
        return despatchDocumentReference;
    }

    /**
     * @param despatchDocumentReference
     *            the despatchDocumentReference to set
     */
    public void setDespatchDocumentReference(List<DocumentReferenceEntity> despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    /**
     * @return the receiptDocumentReference
     */
    public List<DocumentReferenceEntity> getReceiptDocumentReference() {
        return receiptDocumentReference;
    }

    /**
     * @param receiptDocumentReference
     *            the receiptDocumentReference to set
     */
    public void setReceiptDocumentReference(List<DocumentReferenceEntity> receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    /**
     * @return the contractDocumentReference
     */
    public List<DocumentReferenceEntity> getContractDocumentReference() {
        return contractDocumentReference;
    }

    /**
     * @param contractDocumentReference
     *            the contractDocumentReference to set
     */
    public void setContractDocumentReference(List<DocumentReferenceEntity> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public List<DocumentReferenceEntity> getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(List<DocumentReferenceEntity> additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the signature
     */
    public List<SignatureEntity> getSignature() {
        return signature;
    }

    /**
     * @param signature
     *            the signature to set
     */
    public void setSignature(List<SignatureEntity> signature) {
        this.signature = signature;
    }

    /**
     * @return the accountingSupplierParty
     */
    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    /**
     * @param accountingSupplierParty
     *            the accountingSupplierParty to set
     */
    public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    /**
     * @return the accountingCustomerParty
     */
    public CustomerPartyEntity getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    /**
     * @param accountingCustomerParty
     *            the accountingCustomerParty to set
     */
    public void setAccountingCustomerParty(CustomerPartyEntity accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    /**
     * @return the payeeParty
     */
    public PartyEntity getPayeeParty() {
        return payeeParty;
    }

    /**
     * @param payeeParty
     *            the payeeParty to set
     */
    public void setPayeeParty(PartyEntity payeeParty) {
        this.payeeParty = payeeParty;
    }

    /**
     * @return the taxRepresentativeParty
     */
    public PartyEntity getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    /**
     * @param taxRepresentativeParty
     *            the taxRepresentativeParty to set
     */
    public void setTaxRepresentativeParty(PartyEntity taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
    }

    /**
     * @return the prepaidPayment
     */
    public List<PaymentEntity> getPrepaidPayment() {
        return prepaidPayment;
    }

    /**
     * @param prepaidPayment
     *            the prepaidPayment to set
     */
    public void setPrepaidPayment(List<PaymentEntity> prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }

    /**
     * @return the taxExchangeRate
     */
    public ExchangeRateEntity getTaxExchangeRate() {
        return taxExchangeRate;
    }

    /**
     * @param taxExchangeRate
     *            the taxExchangeRate to set
     */
    public void setTaxExchangeRate(ExchangeRateEntity taxExchangeRate) {
        this.taxExchangeRate = taxExchangeRate;
    }

    /**
     * @return the pricingExchangeRate
     */
    public ExchangeRateEntity getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    /**
     * @param pricingExchangeRate
     *            the pricingExchangeRate to set
     */
    public void setPricingExchangeRate(ExchangeRateEntity pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    /**
     * @return the paymentExchangeRate
     */
    public ExchangeRateEntity getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    /**
     * @param paymentExchangeRate
     *            the paymentExchangeRate to set
     */
    public void setPaymentExchangeRate(ExchangeRateEntity paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }

    /**
     * @return the paymentAlternativeExchangeRate
     */
    public ExchangeRateEntity getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    /**
     * @param paymentAlternativeExchangeRate
     *            the paymentAlternativeExchangeRate to set
     */
    public void setPaymentAlternativeExchangeRate(ExchangeRateEntity paymentAlternativeExchangeRate) {
        this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
    }

    /**
     * @return the taxTotal
     */
    public List<TaxTotalEntity> getTaxTotal() {
        return taxTotal;
    }

    /**
     * @param taxTotal
     *            the taxTotal to set
     */
    public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * @return the requestedMonetaryTotal
     */
    public MonetaryTotalEntity getRequestedMonetaryTotal() {
        return requestedMonetaryTotal;
    }

    /**
     * @param requestedMonetaryTotal
     *            the requestedMonetaryTotal to set
     */
    public void setRequestedMonetaryTotal(MonetaryTotalEntity requestedMonetaryTotal) {
        this.requestedMonetaryTotal = requestedMonetaryTotal;
    }

    /**
     * @return the debitNoteLine
     */
    public List<DebitNoteLineEntity> getDebitNoteLine() {
        return debitNoteLine;
    }

    /**
     * @param debitNoteLine
     *            the debitNoteLine to set
     */
    public void setDebitNoteLine(List<DebitNoteLineEntity> debitNoteLine) {
        this.debitNoteLine = debitNoteLine;
    }

}
