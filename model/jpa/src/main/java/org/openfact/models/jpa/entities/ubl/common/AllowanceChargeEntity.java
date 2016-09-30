//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "ALLOWANCECHARGE")
public class AllowanceChargeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @Column(name = "CHARGE_INDICATOR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean chargeIndicator;

    @Column(name = "ALLOWANCE_CHARGE_REASON_CODE")
    protected String allowanceChargeReasonCode;

    @Column(name = "CHARGE_CHARGE_REASON")
    protected String allowanceChargeReason;

    @Column(name = "MULTIPLE_FACTOR_NUMERIC")
    protected BigDecimal multiplierFactorNumeric;

    @Column(name = "PREPAID_INDICATOR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean prepaidIndicator;

    @Column(name = "SEQUENCE_NUMERIC")
    protected BigDecimal sequenceNumeric;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @Column(name = "BASE_AMOUNT")
    protected BigDecimal baseAmount;

    @Column(name = "ACCOUNTING_COST_CODE")
    protected String accountingCostCode;

    @Column(name = "ACCOUNTING_COST")
    protected String accountingCost;

    @OneToMany(targetEntity = TaxCategoryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXCATEGORY_ALLOWANCECHARGE_ID")
    protected List<TaxCategoryEntity> taxCategory = new ArrayList<>();

    @ManyToOne(targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_ALLOWANCECHARGE_ID")
    protected TaxTotalEntity taxTotal = new TaxTotalEntity();

    @OneToMany(targetEntity = PaymentMeansEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTMEANS_ALLOWANCECHARGE_ID")
    protected List<PaymentMeansEntity> paymentMeans = new ArrayList<>();

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
     * @return the chargeIndicator
     */
    public boolean isChargeIndicator() {
        return chargeIndicator;
    }

    /**
     * @param chargeIndicator
     *            the chargeIndicator to set
     */
    public void setChargeIndicator(boolean chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }

    /**
     * @return the allowanceChargeReasonCode
     */
    public String getAllowanceChargeReasonCode() {
        return allowanceChargeReasonCode;
    }

    /**
     * @param allowanceChargeReasonCode
     *            the allowanceChargeReasonCode to set
     */
    public void setAllowanceChargeReasonCode(String allowanceChargeReasonCode) {
        this.allowanceChargeReasonCode = allowanceChargeReasonCode;
    }

    /**
     * @return the allowanceChargeReason
     */
    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    /**
     * @param allowanceChargeReason
     *            the allowanceChargeReason to set
     */
    public void setAllowanceChargeReason(String allowanceChargeReason) {
        this.allowanceChargeReason = allowanceChargeReason;
    }

    /**
     * @return the multiplierFactorNumeric
     */
    public BigDecimal getMultiplierFactorNumeric() {
        return multiplierFactorNumeric;
    }

    /**
     * @param multiplierFactorNumeric
     *            the multiplierFactorNumeric to set
     */
    public void setMultiplierFactorNumeric(BigDecimal multiplierFactorNumeric) {
        this.multiplierFactorNumeric = multiplierFactorNumeric;
    }

    /**
     * @return the prepaidIndicator
     */
    public boolean isPrepaidIndicator() {
        return prepaidIndicator;
    }

    /**
     * @param prepaidIndicator
     *            the prepaidIndicator to set
     */
    public void setPrepaidIndicator(boolean prepaidIndicator) {
        this.prepaidIndicator = prepaidIndicator;
    }

    /**
     * @return the sequenceNumeric
     */
    public BigDecimal getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * @param sequenceNumeric
     *            the sequenceNumeric to set
     */
    public void setSequenceNumeric(BigDecimal sequenceNumeric) {
        this.sequenceNumeric = sequenceNumeric;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the baseAmount
     */
    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    /**
     * @param baseAmount
     *            the baseAmount to set
     */
    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
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
     * @return the taxCategory
     */
    public List<TaxCategoryEntity> getTaxCategory() {
        return taxCategory;
    }

    /**
     * @param taxCategory
     *            the taxCategory to set
     */
    public void setTaxCategory(List<TaxCategoryEntity> taxCategory) {
        this.taxCategory = taxCategory;
    }

    /**
     * @return the taxTotal
     */
    public TaxTotalEntity getTaxTotal() {
        return taxTotal;
    }

    /**
     * @param taxTotal
     *            the taxTotal to set
     */
    public void setTaxTotal(TaxTotalEntity taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * @return the paymentMeans
     */
    public List<PaymentMeansEntity> getPaymentMeans() {
        return paymentMeans;
    }

    /**
     * @param paymentMeans
     *            the paymentMeans to set
     */
    public void setPaymentMeans(List<PaymentMeansEntity> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

}