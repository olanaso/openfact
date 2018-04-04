//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.04 at 05:10:17 PM PET 
//


package org.openfact.pe.ubl20.uncefact.data.specification.unqualifieddatatypesschemamodule._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.AccountIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.AccountNumberIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.AdditionalAccountIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.AgencyIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.AircraftIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ApplicationIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.AttributeIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.CV2IDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.CarrierAssignedIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ChipApplicationIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.CompanyIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.CustomerAssignedAccountIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.CustomizationIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.CustomsIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.DocumentIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.EndpointIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ExchangeMarketIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ExtendedIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.HazardClassIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.IDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.IdentificationIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.InstructionIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.IssueNumberIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.IssuerIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.JobIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.JourneyIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LanguageIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LicensePlateIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LineIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LocationIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LogoReferenceIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LotNumberIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.LowerOrangeHazardPlacardIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.MarkingIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.NationalityIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.NetworkIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.NumberIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.OrangeHazardPlacardIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.OrderIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.OriginalJobIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ParentDocumentIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.PaymentIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.PaymentMeansIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.PrepaidPaymentReferenceIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.PreviousJobIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.PreviousVersionIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.PrimaryAccountNumberIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ProductTraceIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ProfileIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.RailCarIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ReferenceIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.RegistrationIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.RegistrationNationalityIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.RequiredCustomsIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SalesOrderIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SalesOrderLineIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SchemeURIType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SequenceIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SequenceNumberIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SerialIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ShippingOrderIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.SupplierAssignedAccountIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.TrackingIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.TrainIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.UBLVersionIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.URIType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.UUIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.UpperOrangeHazardPlacardIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.ValidatorIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.VersionIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.VesselIDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.WebsiteURIType;
import org.openfact.pe.ubl20.xsd.commonextensioncomponents_2.ExtensionAgencyIDType;
import org.openfact.pe.ubl20.xsd.commonextensioncomponents_2.ExtensionAgencyURIType;
import org.openfact.pe.ubl20.xsd.commonextensioncomponents_2.ExtensionURIType;
import org.openfact.pe.ubl20.xsd.commonextensioncomponents_2.ExtensionVersionIDType;


/**
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT0000011&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Identifier. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A character string to identify and distinguish uniquely, one instance of an object in an identification scheme from all other objects in the same scheme together with relevant supplementary information.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Identifier&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;xsd:BuiltinType xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2"&gt;normalizedString&lt;/xsd:BuiltinType&gt;
 * </pre>
 * 
 *             
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UsageRule xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:clm54217="urn:un:unece:uncefact:codelist:specification:54217:2001" xmlns:clm5639="urn:un:unece:uncefact:codelist:specification:5639:1988" xmlns:clm66411="urn:un:unece:uncefact:codelist:specification:66411:2001" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Other supplementary components in the CCT are captured as part of the token and name for the schema module containing the identifer list and thus, are not declared as attributes. &lt;/ccts:UsageRule&gt;
 * </pre>
 * 
 *          
 * 
 * <p>Java class for IdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentifierType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *       &lt;attribute name="schemeID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="schemeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="schemeAgencyID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="schemeAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="schemeVersionID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="schemeDataURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifierType", propOrder = {
    "value"
})
@XmlSeeAlso({
    CustomsIDType.class,
    CustomerAssignedAccountIDType.class,
    PreviousVersionIDType.class,
    IssuerIDType.class,
    VersionIDType.class,
    AttributeIDType.class,
    HazardClassIDType.class,
    CV2IDType.class,
    AircraftIDType.class,
    JourneyIDType.class,
    EndpointIDType.class,
    CompanyIDType.class,
    InstructionIDType.class,
    UBLVersionIDType.class,
    LocationIDType.class,
    IDType.class,
    ApplicationIDType.class,
    ValidatorIDType.class,
    NumberIDType.class,
    JobIDType.class,
    URIType.class,
    AccountIDType.class,
    ExchangeMarketIDType.class,
    PrimaryAccountNumberIDType.class,
    LogoReferenceIDType.class,
    DocumentIDType.class,
    SequenceIDType.class,
    RegistrationIDType.class,
    NetworkIDType.class,
    SequenceNumberIDType.class,
    AccountNumberIDType.class,
    ProductTraceIDType.class,
    SupplierAssignedAccountIDType.class,
    ExtendedIDType.class,
    LicensePlateIDType.class,
    LowerOrangeHazardPlacardIDType.class,
    PrepaidPaymentReferenceIDType.class,
    RegistrationNationalityIDType.class,
    ChipApplicationIDType.class,
    TrackingIDType.class,
    MarkingIDType.class,
    UpperOrangeHazardPlacardIDType.class,
    PreviousJobIDType.class,
    NationalityIDType.class,
    LotNumberIDType.class,
    TrainIDType.class,
    AdditionalAccountIDType.class,
    OrangeHazardPlacardIDType.class,
    VesselIDType.class,
    RequiredCustomsIDType.class,
    LanguageIDType.class,
    SalesOrderIDType.class,
    SalesOrderLineIDType.class,
    PaymentMeansIDType.class,
    CustomizationIDType.class,
    ShippingOrderIDType.class,
    IssueNumberIDType.class,
    SchemeURIType.class,
    AgencyIDType.class,
    SerialIDType.class,
    ParentDocumentIDType.class,
    LineIDType.class,
    RailCarIDType.class,
    OrderIDType.class,
    UUIDType.class,
    OriginalJobIDType.class,
    WebsiteURIType.class,
    CarrierAssignedIDType.class,
    PaymentIDType.class,
    IdentificationIDType.class,
    ProfileIDType.class,
    ReferenceIDType.class,
    ExtensionAgencyURIType.class,
    ExtensionVersionIDType.class,
    ExtensionURIType.class,
    ExtensionAgencyIDType.class
})
public class IdentifierType {

    @XmlValue
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String value;
    @XmlAttribute(name = "schemeID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String schemeID;
    @XmlAttribute(name = "schemeName")
    protected String schemeName;
    @XmlAttribute(name = "schemeAgencyID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String schemeAgencyID;
    @XmlAttribute(name = "schemeAgencyName")
    protected String schemeAgencyName;
    @XmlAttribute(name = "schemeVersionID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String schemeVersionID;
    @XmlAttribute(name = "schemeDataURI")
    @XmlSchemaType(name = "anyURI")
    protected String schemeDataURI;
    @XmlAttribute(name = "schemeURI")
    @XmlSchemaType(name = "anyURI")
    protected String schemeURI;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the schemeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeID() {
        return schemeID;
    }

    /**
     * Sets the value of the schemeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeID(String value) {
        this.schemeID = value;
    }

    /**
     * Gets the value of the schemeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeName() {
        return schemeName;
    }

    /**
     * Sets the value of the schemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeName(String value) {
        this.schemeName = value;
    }

    /**
     * Gets the value of the schemeAgencyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

    /**
     * Sets the value of the schemeAgencyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeAgencyID(String value) {
        this.schemeAgencyID = value;
    }

    /**
     * Gets the value of the schemeAgencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }

    /**
     * Sets the value of the schemeAgencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeAgencyName(String value) {
        this.schemeAgencyName = value;
    }

    /**
     * Gets the value of the schemeVersionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeVersionID() {
        return schemeVersionID;
    }

    /**
     * Sets the value of the schemeVersionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeVersionID(String value) {
        this.schemeVersionID = value;
    }

    /**
     * Gets the value of the schemeDataURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeDataURI() {
        return schemeDataURI;
    }

    /**
     * Sets the value of the schemeDataURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeDataURI(String value) {
        this.schemeDataURI = value;
    }

    /**
     * Gets the value of the schemeURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeURI() {
        return schemeURI;
    }

    /**
     * Sets the value of the schemeURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeURI(String value) {
        this.schemeURI = value;
    }

}