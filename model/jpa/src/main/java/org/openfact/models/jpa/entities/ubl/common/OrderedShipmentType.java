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

@Entity(name = "OrderedShipmentType")
@Table(name = "ORDEREDSHIPMENTTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderedShipmentType {

    protected ShipmentType shipment;
    protected List<PackageType> _package;
    protected String id;

    @ManyToOne(targetEntity = ShipmentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SHIPMENT_ORDEREDSHIPMENTTYPE_0")
    public ShipmentType getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentType value) {
        this.shipment = value;
    }

    @OneToMany(targetEntity = PackageType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PACKAGE_ORDEREDSHIPMENTTYPE__0")
    public List<PackageType> getPackage() {
        if (_package == null) {
            _package = new ArrayList<PackageType>();
        }
        return this._package;
    }

    public void setPackage(List<PackageType> _package) {
        this._package = _package;
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
