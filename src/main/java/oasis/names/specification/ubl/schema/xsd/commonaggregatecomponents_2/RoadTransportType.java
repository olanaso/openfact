//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.05 at 03:42:27 PM PET 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LicensePlateIDType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.SUNATRoadTransportType;

import javax.xml.bind.annotation.*;


/**
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Road Transport. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Describes a road transport vehicle.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Road Transport&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * <p>
 * <p>
 * <p>Java class for RoadTransportType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RoadTransportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LicensePlateID"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoadTransportType", propOrder = {
        "licensePlateID"
})
@XmlSeeAlso({
        SUNATRoadTransportType.class
})
public class RoadTransportType {

    @XmlElement(name = "LicensePlateID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LicensePlateIDType licensePlateID;

    /**
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Road Transport. License Plate Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Identifies a specific vehicle.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Road Transport&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;License Plate Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;Vehicle registration number (WCO ID 167)&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     *
     * @return possible object is
     * {@link LicensePlateIDType }
     */
    public LicensePlateIDType getLicensePlateID() {
        return licensePlateID;
    }

    /**
     * Sets the value of the licensePlateID property.
     *
     * @param value allowed object is
     *              {@link LicensePlateIDType }
     */
    public void setLicensePlateID(LicensePlateIDType value) {
        this.licensePlateID = value;
    }

}
