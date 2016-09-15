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

@Entity(name = "ItemInstanceType")
@Table(name = "ITEMINSTANCETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemInstanceType {

    protected ProductTraceIDType productTraceID;
    protected ManufactureDateType manufactureDate;
    protected ManufactureTimeType manufactureTime;
    protected RegistrationIDType registrationID;
    protected SerialIDType serialID;
    protected List<ItemPropertyType> additionalItemProperty;
    protected LotIdentificationType lotIdentification;
    protected String id;

    @ManyToOne(targetEntity = ProductTraceIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRODUCTTRACEID_ITEMINSTANCET_0")
    public ProductTraceIDType getProductTraceID() {
        return productTraceID;
    }

    public void setProductTraceID(ProductTraceIDType value) {
        this.productTraceID = value;
    }

    @ManyToOne(targetEntity = ManufactureDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MANUFACTUREDATE_ITEMINSTANCE_0")
    public ManufactureDateType getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(ManufactureDateType value) {
        this.manufactureDate = value;
    }

    @ManyToOne(targetEntity = ManufactureTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MANUFACTURETIME_ITEMINSTANCE_0")
    public ManufactureTimeType getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(ManufactureTimeType value) {
        this.manufactureTime = value;
    }

    @ManyToOne(targetEntity = RegistrationIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REGISTRATIONID_ITEMINSTANCET_0")
    public RegistrationIDType getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(RegistrationIDType value) {
        this.registrationID = value;
    }

    @ManyToOne(targetEntity = SerialIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SERIALID_ITEMINSTANCETYPE_HJ_0")
    public SerialIDType getSerialID() {
        return serialID;
    }

    public void setSerialID(SerialIDType value) {
        this.serialID = value;
    }

    @OneToMany(targetEntity = ItemPropertyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALITEMPROPERTY_ITEMI_0")
    public List<ItemPropertyType> getAdditionalItemProperty() {
        if (additionalItemProperty == null) {
            additionalItemProperty = new ArrayList<ItemPropertyType>();
        }
        return this.additionalItemProperty;
    }

    public void setAdditionalItemProperty(List<ItemPropertyType> additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }

    @ManyToOne(targetEntity = LotIdentificationType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LOTIDENTIFICATION_ITEMINSTAN_0")
    public LotIdentificationType getLotIdentification() {
        return lotIdentification;
    }

    public void setLotIdentification(LotIdentificationType value) {
        this.lotIdentification = value;
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