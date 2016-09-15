//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "HazardousGoodsTransitType")
@Table(name = "HAZARDOUSGOODSTRANSITTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class HazardousGoodsTransitType {

    protected TransportEmergencyCardCodeType transportEmergencyCardCode;
    protected PackingCriteriaCodeType packingCriteriaCode;
    protected HazardousRegulationCodeType hazardousRegulationCode;
    protected InhalationToxicityZoneCodeType inhalationToxicityZoneCode;
    protected TransportAuthorizationCodeType transportAuthorizationCode;
    protected TemperatureType maximumTemperature;
    protected TemperatureType minimumTemperature;
    protected String id;

    @ManyToOne(targetEntity = TransportEmergencyCardCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRANSPORTEMERGENCYCARDCODE_H_0")
    public TransportEmergencyCardCodeType getTransportEmergencyCardCode() {
        return transportEmergencyCardCode;
    }

    public void setTransportEmergencyCardCode(TransportEmergencyCardCodeType value) {
        this.transportEmergencyCardCode = value;
    }

    @ManyToOne(targetEntity = PackingCriteriaCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PACKINGCRITERIACODE_HAZARDOU_0")
    public PackingCriteriaCodeType getPackingCriteriaCode() {
        return packingCriteriaCode;
    }

    public void setPackingCriteriaCode(PackingCriteriaCodeType value) {
        this.packingCriteriaCode = value;
    }

    @ManyToOne(targetEntity = HazardousRegulationCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "HAZARDOUSREGULATIONCODE_HAZA_0")
    public HazardousRegulationCodeType getHazardousRegulationCode() {
        return hazardousRegulationCode;
    }

    public void setHazardousRegulationCode(HazardousRegulationCodeType value) {
        this.hazardousRegulationCode = value;
    }

    @ManyToOne(targetEntity = InhalationToxicityZoneCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INHALATIONTOXICITYZONECODE_H_0")
    public InhalationToxicityZoneCodeType getInhalationToxicityZoneCode() {
        return inhalationToxicityZoneCode;
    }

    public void setInhalationToxicityZoneCode(InhalationToxicityZoneCodeType value) {
        this.inhalationToxicityZoneCode = value;
    }

    @ManyToOne(targetEntity = TransportAuthorizationCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRANSPORTAUTHORIZATIONCODE_H_0")
    public TransportAuthorizationCodeType getTransportAuthorizationCode() {
        return transportAuthorizationCode;
    }

    public void setTransportAuthorizationCode(TransportAuthorizationCodeType value) {
        this.transportAuthorizationCode = value;
    }

    @ManyToOne(targetEntity = TemperatureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMTEMPERATURE_HAZARDOUS_0")
    public TemperatureType getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(TemperatureType value) {
        this.maximumTemperature = value;
    }

    @ManyToOne(targetEntity = TemperatureType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMTEMPERATURE_HAZARDOUS_0")
    public TemperatureType getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(TemperatureType value) {
        this.minimumTemperature = value;
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
