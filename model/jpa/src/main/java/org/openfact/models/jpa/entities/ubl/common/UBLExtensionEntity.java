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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UBLEXTENSION")
public class UBLExtensionEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "EXTENSION_AGENCY_ID")
    protected String extensionAgencyID;

    @Column(name = "EXTENSION_AGENCY_NAME")
    protected String extensionAgencyName;

    @Column(name = "EXTENSION_VERSION_ID")
    protected String extensionVersionID;

    @Column(name = "EXTENSION_AGENCY_URI")
    protected String extensionAgencyURI;

    @Column(name = "EXTENSION_URI")
    protected String extensionURI;

    @Column(name = "EXTENSION_REASON_CODE")
    protected String extensionReasonCode;

    @Column(name = "EXTENSION_REASON")
    protected String extensionReason;

    @ManyToOne(targetEntity = ExtensionContentEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXTENSION_CONTENT_ID")
    protected ExtensionContentEntity extensionContent = new ExtensionContentEntity();

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the extensionAgencyID
     */
    public String getExtensionAgencyID() {
        return extensionAgencyID;
    }

    /**
     * @param extensionAgencyID
     *            the extensionAgencyID to set
     */
    public void setExtensionAgencyID(String extensionAgencyID) {
        this.extensionAgencyID = extensionAgencyID;
    }

    /**
     * @return the extensionAgencyName
     */
    public String getExtensionAgencyName() {
        return extensionAgencyName;
    }

    /**
     * @param extensionAgencyName
     *            the extensionAgencyName to set
     */
    public void setExtensionAgencyName(String extensionAgencyName) {
        this.extensionAgencyName = extensionAgencyName;
    }

    /**
     * @return the extensionVersionID
     */
    public String getExtensionVersionID() {
        return extensionVersionID;
    }

    /**
     * @param extensionVersionID
     *            the extensionVersionID to set
     */
    public void setExtensionVersionID(String extensionVersionID) {
        this.extensionVersionID = extensionVersionID;
    }

    /**
     * @return the extensionAgencyURI
     */
    public String getExtensionAgencyURI() {
        return extensionAgencyURI;
    }

    /**
     * @param extensionAgencyURI
     *            the extensionAgencyURI to set
     */
    public void setExtensionAgencyURI(String extensionAgencyURI) {
        this.extensionAgencyURI = extensionAgencyURI;
    }

    /**
     * @return the extensionURI
     */
    public String getExtensionURI() {
        return extensionURI;
    }

    /**
     * @param extensionURI
     *            the extensionURI to set
     */
    public void setExtensionURI(String extensionURI) {
        this.extensionURI = extensionURI;
    }

    /**
     * @return the extensionReasonCode
     */
    public String getExtensionReasonCode() {
        return extensionReasonCode;
    }

    /**
     * @param extensionReasonCode
     *            the extensionReasonCode to set
     */
    public void setExtensionReasonCode(String extensionReasonCode) {
        this.extensionReasonCode = extensionReasonCode;
    }

    /**
     * @return the extensionReason
     */
    public String getExtensionReason() {
        return extensionReason;
    }

    /**
     * @param extensionReason
     *            the extensionReason to set
     */
    public void setExtensionReason(String extensionReason) {
        this.extensionReason = extensionReason;
    }

    /**
     * @return the extensionContent
     */
    public ExtensionContentEntity getExtensionContent() {
        return extensionContent;
    }

    /**
     * @param extensionContent
     *            the extensionContent to set
     */
    public void setExtensionContent(ExtensionContentEntity extensionContent) {
        this.extensionContent = extensionContent;
    }

}