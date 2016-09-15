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

@Entity(name = "TaxTotalType")
@Table(name = "TAXTOTALTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class TaxTotalType {

    protected TaxAmountType taxAmount;
    protected RoundingAmountType roundingAmount;
    protected TaxEvidenceIndicatorType taxEvidenceIndicator;
    protected List<TaxSubtotalType> taxSubtotal;
    protected String id;

    @ManyToOne(targetEntity = TaxAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXAMOUNT_TAXTOTALTYPE_OFID")
    public TaxAmountType getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(TaxAmountType value) {
        this.taxAmount = value;
    }

    @ManyToOne(targetEntity = RoundingAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ROUNDINGAMOUNT_TAXTOTALTYPE__0")
    public RoundingAmountType getRoundingAmount() {
        return roundingAmount;
    }

    public void setRoundingAmount(RoundingAmountType value) {
        this.roundingAmount = value;
    }

    @ManyToOne(targetEntity = TaxEvidenceIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXEVIDENCEINDICATOR_TAXTOTA_0")
    public TaxEvidenceIndicatorType getTaxEvidenceIndicator() {
        return taxEvidenceIndicator;
    }

    public void setTaxEvidenceIndicator(TaxEvidenceIndicatorType value) {
        this.taxEvidenceIndicator = value;
    }

    @OneToMany(targetEntity = TaxSubtotalType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXSUBTOTAL_TAXTOTALTYPE_OFID")
    public List<TaxSubtotalType> getTaxSubtotal() {
        if (taxSubtotal == null) {
            taxSubtotal = new ArrayList<TaxSubtotalType>();
        }
        return this.taxSubtotal;
    }

    public void setTaxSubtotal(List<TaxSubtotalType> taxSubtotal) {
        this.taxSubtotal = taxSubtotal;
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
