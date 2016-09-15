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

@Entity(name = "PriceListType")
@Table(name = "PRICELISTTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class PriceListType {

    protected IDType ID;
    protected StatusCodeType statusCode;
    protected List<PeriodType> validityPeriod;
    protected PriceListType previousPriceList;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_PRICELISTTYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = StatusCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "STATUSCODE_PRICELISTTYPE_OFID")
    public StatusCodeType getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCodeType value) {
        this.statusCode = value;
    }

    @OneToMany(targetEntity = PeriodType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VALIDITYPERIOD_PRICELISTTYPE_0")
    public List<PeriodType> getValidityPeriod() {
        if (validityPeriod == null) {
            validityPeriod = new ArrayList<PeriodType>();
        }
        return this.validityPeriod;
    }

    public void setValidityPeriod(List<PeriodType> validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    @ManyToOne(targetEntity = PriceListType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PREVIOUSPRICELIST_PRICELISTT_0")
    public PriceListType getPreviousPriceList() {
        return previousPriceList;
    }

    public void setPreviousPriceList(PriceListType value) {
        this.previousPriceList = value;
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
