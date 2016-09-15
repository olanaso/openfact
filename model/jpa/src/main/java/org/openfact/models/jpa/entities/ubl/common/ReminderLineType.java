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

@Entity(name = "ReminderLineType")
@Table(name = "REMINDERLINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ReminderLineType {

    protected IDType ID;
    protected NoteType note;
    protected UUIDType uuid;
    protected BalanceBroughtForwardIndicatorType balanceBroughtForwardIndicator;
    protected DebitLineAmountType debitLineAmount;
    protected CreditLineAmountType creditLineAmount;
    protected AccountingCostCodeType accountingCostCode;
    protected AccountingCostType accountingCost;
    protected List<PeriodType> reminderPeriod;
    protected List<BillingReferenceType> billingReference;
    protected ExchangeRateType exchangeRate;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_REMINDERLINETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_REMINDERLINETYPE_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_REMINDERLINETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = BalanceBroughtForwardIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BALANCEBROUGHTFORWARDINDICAT_3")
    public BalanceBroughtForwardIndicatorType getBalanceBroughtForwardIndicator() {
        return balanceBroughtForwardIndicator;
    }

    public void setBalanceBroughtForwardIndicator(BalanceBroughtForwardIndicatorType value) {
        this.balanceBroughtForwardIndicator = value;
    }

    @ManyToOne(targetEntity = DebitLineAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DEBITLINEAMOUNT_REMINDERLINE_0")
    public DebitLineAmountType getDebitLineAmount() {
        return debitLineAmount;
    }

    public void setDebitLineAmount(DebitLineAmountType value) {
        this.debitLineAmount = value;
    }

    @ManyToOne(targetEntity = CreditLineAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CREDITLINEAMOUNT_REMINDERLIN_0")
    public CreditLineAmountType getCreditLineAmount() {
        return creditLineAmount;
    }

    public void setCreditLineAmount(CreditLineAmountType value) {
        this.creditLineAmount = value;
    }

    @ManyToOne(targetEntity = AccountingCostCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOSTCODE_REMINDERL_0")
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOST_REMINDERLINET_0")
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    @OneToMany(targetEntity = PeriodType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REMINDERPERIOD_REMINDERLINET_0")
    public List<PeriodType> getReminderPeriod() {
        if (reminderPeriod == null) {
            reminderPeriod = new ArrayList<PeriodType>();
        }
        return this.reminderPeriod;
    }

    public void setReminderPeriod(List<PeriodType> reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }

    @OneToMany(targetEntity = BillingReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_REMINDERLIN_0")
    public List<BillingReferenceType> getBillingReference() {
        if (billingReference == null) {
            billingReference = new ArrayList<BillingReferenceType>();
        }
        return this.billingReference;
    }

    public void setBillingReference(List<BillingReferenceType> billingReference) {
        this.billingReference = billingReference;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXCHANGERATE_REMINDERLINETYP_0")
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
