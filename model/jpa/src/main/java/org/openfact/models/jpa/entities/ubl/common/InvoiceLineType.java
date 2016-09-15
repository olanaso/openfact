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

@Entity(name = "InvoiceLineType")
@Table(name = "INVOICELINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class InvoiceLineType {

    protected IDType ID;
    protected UUIDType uuid;
    protected NoteType note;
    protected InvoicedQuantityType invoicedQuantity;
    protected LineExtensionAmountType lineExtensionAmount;
    protected TaxPointDateType taxPointDate;
    protected AccountingCostCodeType accountingCostCode;
    protected AccountingCostType accountingCost;
    protected FreeOfChargeIndicatorType freeOfChargeIndicator;
    protected List<OrderLineReferenceType> orderLineReference;
    protected List<LineReferenceType> despatchLineReference;
    protected List<LineReferenceType> receiptLineReference;
    protected List<BillingReferenceType> billingReference;
    protected List<DocumentReferenceType> documentReference;
    protected PricingReferenceType pricingReference;
    protected PartyType originatorParty;
    protected List<DeliveryType> delivery;
    protected List<PaymentTermsType> paymentTerms;
    protected List<AllowanceChargeType> allowanceCharge;
    protected List<TaxTotalType> taxTotal;
    protected ItemType item;
    protected PriceType price;
    protected DeliveryTermsType deliveryTerms;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_INVOICELINETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_INVOICELINETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_INVOICELINETYPE_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = InvoicedQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEDQUANTITY_INVOICELINE_0")
    public InvoicedQuantityType getInvoicedQuantity() {
        return invoicedQuantity;
    }

    public void setInvoicedQuantity(InvoicedQuantityType value) {
        this.invoicedQuantity = value;
    }

    @ManyToOne(targetEntity = LineExtensionAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINEEXTENSIONAMOUNT_INVOICEL_0")
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    @ManyToOne(targetEntity = TaxPointDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXPOINTDATE_INVOICELINETYPE_0")
    public TaxPointDateType getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate(TaxPointDateType value) {
        this.taxPointDate = value;
    }

    @ManyToOne(targetEntity = AccountingCostCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOSTCODE_INVOICELI_0")
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOST_INVOICELINETY_0")
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    @ManyToOne(targetEntity = FreeOfChargeIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FREEOFCHARGEINDICATOR_INVOIC_0")
    public FreeOfChargeIndicatorType getFreeOfChargeIndicator() {
        return freeOfChargeIndicator;
    }

    public void setFreeOfChargeIndicator(FreeOfChargeIndicatorType value) {
        this.freeOfChargeIndicator = value;
    }

    @OneToMany(targetEntity = OrderLineReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERLINEREFERENCE_INVOICELI_0")
    public List<OrderLineReferenceType> getOrderLineReference() {
        if (orderLineReference == null) {
            orderLineReference = new ArrayList<OrderLineReferenceType>();
        }
        return this.orderLineReference;
    }

    public void setOrderLineReference(List<OrderLineReferenceType> orderLineReference) {
        this.orderLineReference = orderLineReference;
    }

    @OneToMany(targetEntity = LineReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCHLINEREFERENCE_INVOIC_0")
    public List<LineReferenceType> getDespatchLineReference() {
        if (despatchLineReference == null) {
            despatchLineReference = new ArrayList<LineReferenceType>();
        }
        return this.despatchLineReference;
    }

    public void setDespatchLineReference(List<LineReferenceType> despatchLineReference) {
        this.despatchLineReference = despatchLineReference;
    }

    @OneToMany(targetEntity = LineReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIPTLINEREFERENCE_INVOICE_0")
    public List<LineReferenceType> getReceiptLineReference() {
        if (receiptLineReference == null) {
            receiptLineReference = new ArrayList<LineReferenceType>();
        }
        return this.receiptLineReference;
    }

    public void setReceiptLineReference(List<LineReferenceType> receiptLineReference) {
        this.receiptLineReference = receiptLineReference;
    }

    @OneToMany(targetEntity = BillingReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_INVOICELINE_0")
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
    @JoinColumn(name = "DOCUMENTREFERENCE_INVOICELIN_0")
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceType> documentReference) {
        this.documentReference = documentReference;
    }

    @ManyToOne(targetEntity = PricingReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGREFERENCE_INVOICELINE_0")
    public PricingReferenceType getPricingReference() {
        return pricingReference;
    }

    public void setPricingReference(PricingReferenceType value) {
        this.pricingReference = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINATORPARTY_INVOICELINET_0")
    public PartyType getOriginatorParty() {
        return originatorParty;
    }

    public void setOriginatorParty(PartyType value) {
        this.originatorParty = value;
    }

    @OneToMany(targetEntity = DeliveryType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERY_INVOICELINETYPE_OFID")
    public List<DeliveryType> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryType>();
        }
        return this.delivery;
    }

    public void setDelivery(List<DeliveryType> delivery) {
        this.delivery = delivery;
    }

    @OneToMany(targetEntity = PaymentTermsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTTERMS_INVOICELINETYPE_0")
    public List<PaymentTermsType> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsType>();
        }
        return this.paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTermsType> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @OneToMany(targetEntity = AllowanceChargeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALLOWANCECHARGE_INVOICELINET_0")
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    @OneToMany(targetEntity = TaxTotalType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_INVOICELINETYPE_OFID")
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    public void setTaxTotal(List<TaxTotalType> taxTotal) {
        this.taxTotal = taxTotal;
    }

    @ManyToOne(targetEntity = ItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEM_INVOICELINETYPE_OFID")
    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType value) {
        this.item = value;
    }

    @ManyToOne(targetEntity = PriceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICE_INVOICELINETYPE_OFID")
    public PriceType getPrice() {
        return price;
    }

    public void setPrice(PriceType value) {
        this.price = value;
    }

    @ManyToOne(targetEntity = DeliveryTermsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYTERMS_INVOICELINETYP_0")
    public DeliveryTermsType getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(DeliveryTermsType value) {
        this.deliveryTerms = value;
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
