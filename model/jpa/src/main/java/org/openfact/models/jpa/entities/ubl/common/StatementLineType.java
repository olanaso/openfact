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

@Entity(name = "StatementLineType")
@Table(name = "STATEMENTLINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class StatementLineType {

    protected IDType ID;
    protected NoteType note;
    protected UUIDType uuid;
    protected BalanceBroughtForwardIndicatorType balanceBroughtForwardIndicator;
    protected DebitLineAmountType debitLineAmount;
    protected CreditLineAmountType creditLineAmount;
    protected BalanceAmountType balanceAmount;
    protected PaymentMeansEntity paymentMeans;
    protected List<PaymentTermsEntity> paymentTerms;
    protected CustomerPartyType buyerCustomerParty;
    protected SupplierPartyEntity sellerSupplierParty;
    protected CustomerPartyType originatorCustomerParty;
    protected CustomerPartyType accountingCustomerParty;
    protected SupplierPartyEntity accountingSupplierParty;
    protected PartyEntity payeeParty;
    protected List<PeriodEntity> invoicePeriod;
    protected List<BillingReferenceEntity> billingReference;
    protected List<DocumentReferenceEntity> documentReference;
    protected ExchangeRateType exchangeRate;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_STATEMENTLINETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_STATEMENTLINETYPE_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_STATEMENTLINETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = BalanceBroughtForwardIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BALANCEBROUGHTFORWARDINDICAT_1")
    public BalanceBroughtForwardIndicatorType getBalanceBroughtForwardIndicator() {
        return balanceBroughtForwardIndicator;
    }

    public void setBalanceBroughtForwardIndicator(BalanceBroughtForwardIndicatorType value) {
        this.balanceBroughtForwardIndicator = value;
    }

    @ManyToOne(targetEntity = DebitLineAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DEBITLINEAMOUNT_STATEMENTLIN_0")
    public DebitLineAmountType getDebitLineAmount() {
        return debitLineAmount;
    }

    public void setDebitLineAmount(DebitLineAmountType value) {
        this.debitLineAmount = value;
    }

    @ManyToOne(targetEntity = CreditLineAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CREDITLINEAMOUNT_STATEMENTLI_0")
    public CreditLineAmountType getCreditLineAmount() {
        return creditLineAmount;
    }

    public void setCreditLineAmount(CreditLineAmountType value) {
        this.creditLineAmount = value;
    }

    @ManyToOne(targetEntity = BalanceAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BALANCEAMOUNT_STATEMENTLINET_0")
    public BalanceAmountType getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BalanceAmountType value) {
        this.balanceAmount = value;
    }

    @ManyToOne(targetEntity = PaymentMeansEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTMEANS_STATEMENTLINETY_0")
    public PaymentMeansEntity getPaymentMeans() {
        return paymentMeans;
    }

    public void setPaymentMeans(PaymentMeansEntity value) {
        this.paymentMeans = value;
    }

    @OneToMany(targetEntity = PaymentTermsEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTTERMS_STATEMENTLINETY_0")
    public List<PaymentTermsEntity> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsEntity>();
        }
        return this.paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTermsEntity> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BUYERCUSTOMERPARTY_STATEMENT_0")
    public CustomerPartyType getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    public void setBuyerCustomerParty(CustomerPartyType value) {
        this.buyerCustomerParty = value;
    }

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELLERSUPPLIERPARTY_STATEMEN_0")
    public SupplierPartyEntity getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    public void setSellerSupplierParty(SupplierPartyEntity value) {
        this.sellerSupplierParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINATORCUSTOMERPARTY_STAT_0")
    public CustomerPartyType getOriginatorCustomerParty() {
        return originatorCustomerParty;
    }

    public void setOriginatorCustomerParty(CustomerPartyType value) {
        this.originatorCustomerParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_STAT_0")
    public CustomerPartyType getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyType value) {
        this.accountingCustomerParty = value;
    }

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_STAT_0")
    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyEntity value) {
        this.accountingSupplierParty = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYEEPARTY_STATEMENTLINETYPE_0")
    public PartyEntity getPayeeParty() {
        return payeeParty;
    }

    public void setPayeeParty(PartyEntity value) {
        this.payeeParty = value;
    }

    @OneToMany(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEPERIOD_STATEMENTLINET_0")
    public List<PeriodEntity> getInvoicePeriod() {
        if (invoicePeriod == null) {
            invoicePeriod = new ArrayList<PeriodEntity>();
        }
        return this.invoicePeriod;
    }

    public void setInvoicePeriod(List<PeriodEntity> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    @OneToMany(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_STATEMENTLI_0")
    public List<BillingReferenceEntity> getBillingReference() {
        if (billingReference == null) {
            billingReference = new ArrayList<BillingReferenceEntity>();
        }
        return this.billingReference;
    }

    public void setBillingReference(List<BillingReferenceEntity> billingReference) {
        this.billingReference = billingReference;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTREFERENCE_STATEMENTL_0")
    public List<DocumentReferenceEntity> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
        this.documentReference = documentReference;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXCHANGERATE_STATEMENTLINETY_0")
    public ExchangeRateType getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRateType value) {
        this.exchangeRate = value;
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
