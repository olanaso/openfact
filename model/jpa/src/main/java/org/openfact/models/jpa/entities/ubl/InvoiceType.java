//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl;

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
import org.openfact.models.jpa.entities.ubl.common.AccountingCostCodeType;
import org.openfact.models.jpa.entities.ubl.common.AccountingCostType;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeType;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceType;
import org.openfact.models.jpa.entities.ubl.common.CopyIndicatorType;
import org.openfact.models.jpa.entities.ubl.common.CustomerPartyType;
import org.openfact.models.jpa.entities.ubl.common.CustomizationIDType;
import org.openfact.models.jpa.entities.ubl.common.DeliveryTermsType;
import org.openfact.models.jpa.entities.ubl.common.DeliveryType;
import org.openfact.models.jpa.entities.ubl.common.DocumentCurrencyCodeType;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceType;
import org.openfact.models.jpa.entities.ubl.common.ExchangeRateType;
import org.openfact.models.jpa.entities.ubl.common.IDType;
import org.openfact.models.jpa.entities.ubl.common.InvoiceLineType;
import org.openfact.models.jpa.entities.ubl.common.InvoiceTypeCodeType;
import org.openfact.models.jpa.entities.ubl.common.IssueDateType;
import org.openfact.models.jpa.entities.ubl.common.IssueTimeType;
import org.openfact.models.jpa.entities.ubl.common.LineCountNumericType;
import org.openfact.models.jpa.entities.ubl.common.MonetaryTotalType;
import org.openfact.models.jpa.entities.ubl.common.NoteType;
import org.openfact.models.jpa.entities.ubl.common.OrderReferenceType;
import org.openfact.models.jpa.entities.ubl.common.PartyType;
import org.openfact.models.jpa.entities.ubl.common.PaymentAlternativeCurrencyCodeType;
import org.openfact.models.jpa.entities.ubl.common.PaymentCurrencyCodeType;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansType;
import org.openfact.models.jpa.entities.ubl.common.PaymentTermsType;
import org.openfact.models.jpa.entities.ubl.common.PaymentType;
import org.openfact.models.jpa.entities.ubl.common.PeriodType;
import org.openfact.models.jpa.entities.ubl.common.PricingCurrencyCodeType;
import org.openfact.models.jpa.entities.ubl.common.ProfileIDType;
import org.openfact.models.jpa.entities.ubl.common.SignatureType;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyType;
import org.openfact.models.jpa.entities.ubl.common.TaxCurrencyCodeType;
import org.openfact.models.jpa.entities.ubl.common.TaxPointDateType;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalType;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsType;
import org.openfact.models.jpa.entities.ubl.common.UBLVersionIDType;
import org.openfact.models.jpa.entities.ubl.common.UUIDType;

@Entity(name = "InvoiceType")
@Table(name = "INVOICETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class InvoiceType {

    protected UBLExtensionsType ublExtensions;
    protected UBLVersionIDType ublVersionID;
    protected CustomizationIDType customizationID;
    protected ProfileIDType profileID;
    protected IDType ID;
    protected CopyIndicatorType copyIndicator;
    protected UUIDType uuid;
    protected IssueDateType issueDate;
    protected IssueTimeType issueTime;
    protected InvoiceTypeCodeType invoiceTypeCode;
    protected List<NoteType> note;
    protected TaxPointDateType taxPointDate;
    protected DocumentCurrencyCodeType documentCurrencyCode;
    protected TaxCurrencyCodeType taxCurrencyCode;
    protected PricingCurrencyCodeType pricingCurrencyCode;
    protected PaymentCurrencyCodeType paymentCurrencyCode;
    protected PaymentAlternativeCurrencyCodeType paymentAlternativeCurrencyCode;
    protected AccountingCostCodeType accountingCostCode;
    protected AccountingCostType accountingCost;
    protected LineCountNumericType lineCountNumeric;
    protected List<PeriodType> invoicePeriod;
    protected OrderReferenceType orderReference;
    protected List<BillingReferenceType> billingReference;
    protected List<DocumentReferenceType> despatchDocumentReference;
    protected List<DocumentReferenceType> receiptDocumentReference;
    protected List<DocumentReferenceType> originatorDocumentReference;
    protected List<DocumentReferenceType> contractDocumentReference;
    protected List<DocumentReferenceType> additionalDocumentReference;
    protected List<SignatureType> signature;
    protected SupplierPartyType accountingSupplierParty;
    protected CustomerPartyType accountingCustomerParty;
    protected PartyType payeeParty;
    protected CustomerPartyType buyerCustomerParty;
    protected SupplierPartyType sellerSupplierParty;
    protected PartyType taxRepresentativeParty;
    protected List<DeliveryType> delivery;
    protected DeliveryTermsType deliveryTerms;
    protected List<PaymentMeansType> paymentMeans;
    protected List<PaymentTermsType> paymentTerms;
    protected List<PaymentType> prepaidPayment;
    protected List<AllowanceChargeType> allowanceCharge;
    protected ExchangeRateType taxExchangeRate;
    protected ExchangeRateType pricingExchangeRate;
    protected ExchangeRateType paymentExchangeRate;
    protected ExchangeRateType paymentAlternativeExchangeRate;
    protected List<TaxTotalType> taxTotal;
    protected MonetaryTotalType legalMonetaryTotal;
    protected List<InvoiceLineType> invoiceLine;
    protected String id;

    @ManyToOne(targetEntity = UBLExtensionsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UBLEXTENSIONS_INVOICETYPE_HJ_0")
    public UBLExtensionsType getUBLExtensions() {
        return ublExtensions;
    }

    public void setUBLExtensions(UBLExtensionsType value) {
        this.ublExtensions = value;
    }

    @ManyToOne(targetEntity = UBLVersionIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UBLVERSIONID_INVOICETYPE_OFID")
    public UBLVersionIDType getUBLVersionID() {
        return ublVersionID;
    }

    public void setUBLVersionID(UBLVersionIDType value) {
        this.ublVersionID = value;
    }

    @ManyToOne(targetEntity = CustomizationIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CUSTOMIZATIONID_INVOICETYPE__0")
    public CustomizationIDType getCustomizationID() {
        return customizationID;
    }

    public void setCustomizationID(CustomizationIDType value) {
        this.customizationID = value;
    }

    @ManyToOne(targetEntity = ProfileIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PROFILEID_INVOICETYPE_OFID")
    public ProfileIDType getProfileID() {
        return profileID;
    }

    public void setProfileID(ProfileIDType value) {
        this.profileID = value;
    }

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_INVOICETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = CopyIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COPYINDICATOR_INVOICETYPE_HJ_0")
    public CopyIndicatorType getCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(CopyIndicatorType value) {
        this.copyIndicator = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_INVOICETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = IssueDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUEDATE_INVOICETYPE_OFID")
    public IssueDateType getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(IssueDateType value) {
        this.issueDate = value;
    }

    @ManyToOne(targetEntity = IssueTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUETIME_INVOICETYPE_OFID")
    public IssueTimeType getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(IssueTimeType value) {
        this.issueTime = value;
    }

    @ManyToOne(targetEntity = InvoiceTypeCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICETYPECODE_INVOICETYPE__0")
    public InvoiceTypeCodeType getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(InvoiceTypeCodeType value) {
        this.invoiceTypeCode = value;
    }

    @OneToMany(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_INVOICETYPE_OFID")
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    public void setNote(List<NoteType> note) {
        this.note = note;
    }

    @ManyToOne(targetEntity = TaxPointDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXPOINTDATE_INVOICETYPE_OFID")
    public TaxPointDateType getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate(TaxPointDateType value) {
        this.taxPointDate = value;
    }

    @ManyToOne(targetEntity = DocumentCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTCURRENCYCODE_INVOICE_0")
    public DocumentCurrencyCodeType getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(DocumentCurrencyCodeType value) {
        this.documentCurrencyCode = value;
    }

    @ManyToOne(targetEntity = TaxCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXCURRENCYCODE_INVOICETYPE__0")
    public TaxCurrencyCodeType getTaxCurrencyCode() {
        return taxCurrencyCode;
    }

    public void setTaxCurrencyCode(TaxCurrencyCodeType value) {
        this.taxCurrencyCode = value;
    }

    @ManyToOne(targetEntity = PricingCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGCURRENCYCODE_INVOICET_0")
    public PricingCurrencyCodeType getPricingCurrencyCode() {
        return pricingCurrencyCode;
    }

    public void setPricingCurrencyCode(PricingCurrencyCodeType value) {
        this.pricingCurrencyCode = value;
    }

    @ManyToOne(targetEntity = PaymentCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTCURRENCYCODE_INVOICET_0")
    public PaymentCurrencyCodeType getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(PaymentCurrencyCodeType value) {
        this.paymentCurrencyCode = value;
    }

    @ManyToOne(targetEntity = PaymentAlternativeCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTALTERNATIVECURRENCYCO_1")
    public PaymentAlternativeCurrencyCodeType getPaymentAlternativeCurrencyCode() {
        return paymentAlternativeCurrencyCode;
    }

    public void setPaymentAlternativeCurrencyCode(PaymentAlternativeCurrencyCodeType value) {
        this.paymentAlternativeCurrencyCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOSTCODE_INVOICETY_0")
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOST_INVOICETYPE_H_0")
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    @ManyToOne(targetEntity = LineCountNumericType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINECOUNTNUMERIC_INVOICETYPE_0")
    public LineCountNumericType getLineCountNumeric() {
        return lineCountNumeric;
    }

    public void setLineCountNumeric(LineCountNumericType value) {
        this.lineCountNumeric = value;
    }

    @OneToMany(targetEntity = PeriodType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEPERIOD_INVOICETYPE_HJ_0")
    public List<PeriodType> getInvoicePeriod() {
        if (invoicePeriod == null) {
            invoicePeriod = new ArrayList<PeriodType>();
        }
        return this.invoicePeriod;
    }

    public void setInvoicePeriod(List<PeriodType> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    @ManyToOne(targetEntity = OrderReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERREFERENCE_INVOICETYPE_H_0")
    public OrderReferenceType getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(OrderReferenceType value) {
        this.orderReference = value;
    }

    @OneToMany(targetEntity = BillingReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_INVOICETYPE_0")
    public List<BillingReferenceType> getBillingReference() {
        if (billingReference == null) {
            billingReference = new ArrayList<BillingReferenceType>();
        }
        return this.billingReference;
    }

    public void setBillingReference(List<BillingReferenceType> billingReference) {
        this.billingReference = billingReference;
    }

    @OneToMany(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCHDOCUMENTREFERENCE_IN_0")
    public List<DocumentReferenceType> getDespatchDocumentReference() {
        if (despatchDocumentReference == null) {
            despatchDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.despatchDocumentReference;
    }

    public void setDespatchDocumentReference(List<DocumentReferenceType> despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIPTDOCUMENTREFERENCE_INV_0")
    public List<DocumentReferenceType> getReceiptDocumentReference() {
        if (receiptDocumentReference == null) {
            receiptDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.receiptDocumentReference;
    }

    public void setReceiptDocumentReference(List<DocumentReferenceType> receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINATORDOCUMENTREFERENCE__0")
    public List<DocumentReferenceType> getOriginatorDocumentReference() {
        if (originatorDocumentReference == null) {
            originatorDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.originatorDocumentReference;
    }

    public void setOriginatorDocumentReference(List<DocumentReferenceType> originatorDocumentReference) {
        this.originatorDocumentReference = originatorDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTRACTDOCUMENTREFERENCE_IN_0")
    public List<DocumentReferenceType> getContractDocumentReference() {
        if (contractDocumentReference == null) {
            contractDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.contractDocumentReference;
    }

    public void setContractDocumentReference(List<DocumentReferenceType> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALDOCUMENTREFERENCE__0")
    public List<DocumentReferenceType> getAdditionalDocumentReference() {
        if (additionalDocumentReference == null) {
            additionalDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(List<DocumentReferenceType> additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    @OneToMany(targetEntity = SignatureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SIGNATURE_INVOICETYPE_OFID")
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }

    public void setSignature(List<SignatureType> signature) {
        this.signature = signature;
    }

    @ManyToOne(targetEntity = SupplierPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_INVO_0")
    public SupplierPartyType getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyType value) {
        this.accountingSupplierParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_INVO_0")
    public CustomerPartyType getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyType value) {
        this.accountingCustomerParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYEEPARTY_INVOICETYPE_OFID")
    public PartyType getPayeeParty() {
        return payeeParty;
    }

    public void setPayeeParty(PartyType value) {
        this.payeeParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BUYERCUSTOMERPARTY_INVOICETY_0")
    public CustomerPartyType getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    public void setBuyerCustomerParty(CustomerPartyType value) {
        this.buyerCustomerParty = value;
    }

    @ManyToOne(targetEntity = SupplierPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELLERSUPPLIERPARTY_INVOICET_0")
    public SupplierPartyType getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    public void setSellerSupplierParty(SupplierPartyType value) {
        this.sellerSupplierParty = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXREPRESENTATIVEPARTY_INVOI_0")
    public PartyType getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    public void setTaxRepresentativeParty(PartyType value) {
        this.taxRepresentativeParty = value;
    }

    @OneToMany(targetEntity = DeliveryType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERY_INVOICETYPE_OFID")
    public List<DeliveryType> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryType>();
        }
        return this.delivery;
    }

    public void setDelivery(List<DeliveryType> delivery) {
        this.delivery = delivery;
    }

    @ManyToOne(targetEntity = DeliveryTermsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYTERMS_INVOICETYPE_HJ_0")
    public DeliveryTermsType getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(DeliveryTermsType value) {
        this.deliveryTerms = value;
    }

    @OneToMany(targetEntity = PaymentMeansType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTMEANS_INVOICETYPE_OFID")
    public List<PaymentMeansType> getPaymentMeans() {
        if (paymentMeans == null) {
            paymentMeans = new ArrayList<PaymentMeansType>();
        }
        return this.paymentMeans;
    }

    public void setPaymentMeans(List<PaymentMeansType> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    @OneToMany(targetEntity = PaymentTermsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTTERMS_INVOICETYPE_OFID")
    public List<PaymentTermsType> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsType>();
        }
        return this.paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTermsType> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @OneToMany(targetEntity = PaymentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PREPAIDPAYMENT_INVOICETYPE_H_0")
    public List<PaymentType> getPrepaidPayment() {
        if (prepaidPayment == null) {
            prepaidPayment = new ArrayList<PaymentType>();
        }
        return this.prepaidPayment;
    }

    public void setPrepaidPayment(List<PaymentType> prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }

    @OneToMany(targetEntity = AllowanceChargeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALLOWANCECHARGE_INVOICETYPE__0")
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXEXCHANGERATE_INVOICETYPE__0")
    public ExchangeRateType getTaxExchangeRate() {
        return taxExchangeRate;
    }

    public void setTaxExchangeRate(ExchangeRateType value) {
        this.taxExchangeRate = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGEXCHANGERATE_INVOICET_0")
    public ExchangeRateType getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    public void setPricingExchangeRate(ExchangeRateType value) {
        this.pricingExchangeRate = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTEXCHANGERATE_INVOICET_0")
    public ExchangeRateType getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    public void setPaymentExchangeRate(ExchangeRateType value) {
        this.paymentExchangeRate = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTALTERNATIVEEXCHANGERA_1")
    public ExchangeRateType getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    public void setPaymentAlternativeExchangeRate(ExchangeRateType value) {
        this.paymentAlternativeExchangeRate = value;
    }

    @OneToMany(targetEntity = TaxTotalType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_INVOICETYPE_OFID")
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    public void setTaxTotal(List<TaxTotalType> taxTotal) {
        this.taxTotal = taxTotal;
    }

    @ManyToOne(targetEntity = MonetaryTotalType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LEGALMONETARYTOTAL_INVOICETY_0")
    public MonetaryTotalType getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(MonetaryTotalType value) {
        this.legalMonetaryTotal = value;
    }

    @OneToMany(targetEntity = InvoiceLineType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICELINE_INVOICETYPE_OFID")
    public List<InvoiceLineType> getInvoiceLine() {
        if (invoiceLine == null) {
            invoiceLine = new ArrayList<InvoiceLineType>();
        }
        return this.invoiceLine;
    }

    public void setInvoiceLine(List<InvoiceLineType> invoiceLine) {
        this.invoiceLine = invoiceLine;
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
