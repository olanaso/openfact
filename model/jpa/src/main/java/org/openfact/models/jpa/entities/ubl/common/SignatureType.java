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

@Entity(name = "SignatureType")
@Table(name = "SIGNATURETYPE_0")
@Inheritance(strategy = InheritanceType.JOINED)
public class SignatureType {

    protected IDType ID;
    protected NoteType note;
    protected ValidationDateType validationDate;
    protected ValidationTimeType validationTime;
    protected ValidatorIDType validatorID;
    protected CanonicalizationMethodType canonicalizationMethod;
    protected SignatureMethodType signatureMethod;
    protected PartyType signatoryParty;
    protected AttachmentType digitalSignatureAttachment;
    protected DocumentReferenceType originalDocumentReference;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_SIGNATURETYPE_0_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_SIGNATURETYPE_0_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = ValidationDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VALIDATIONDATE_SIGNATURETYPE_0")
    public ValidationDateType getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(ValidationDateType value) {
        this.validationDate = value;
    }

    @ManyToOne(targetEntity = ValidationTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VALIDATIONTIME_SIGNATURETYPE_0")
    public ValidationTimeType getValidationTime() {
        return validationTime;
    }

    public void setValidationTime(ValidationTimeType value) {
        this.validationTime = value;
    }

    @ManyToOne(targetEntity = ValidatorIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VALIDATORID_SIGNATURETYPE_0__0")
    public ValidatorIDType getValidatorID() {
        return validatorID;
    }

    public void setValidatorID(ValidatorIDType value) {
        this.validatorID = value;
    }

    @ManyToOne(targetEntity = CanonicalizationMethodType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CANONICALIZATIONMETHOD_SIGNA_0")
    public CanonicalizationMethodType getCanonicalizationMethod() {
        return canonicalizationMethod;
    }

    public void setCanonicalizationMethod(CanonicalizationMethodType value) {
        this.canonicalizationMethod = value;
    }

    @ManyToOne(targetEntity = SignatureMethodType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SIGNATUREMETHOD_SIGNATURETYP_0")
    public SignatureMethodType getSignatureMethod() {
        return signatureMethod;
    }

    public void setSignatureMethod(SignatureMethodType value) {
        this.signatureMethod = value;
    }

    @ManyToOne(targetEntity = PartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SIGNATORYPARTY_SIGNATURETYPE_0")
    public PartyType getSignatoryParty() {
        return signatoryParty;
    }

    public void setSignatoryParty(PartyType value) {
        this.signatoryParty = value;
    }

    @ManyToOne(targetEntity = AttachmentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DIGITALSIGNATUREATTACHMENT_S_0")
    public AttachmentType getDigitalSignatureAttachment() {
        return digitalSignatureAttachment;
    }

    public void setDigitalSignatureAttachment(AttachmentType value) {
        this.digitalSignatureAttachment = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINALDOCUMENTREFERENCE_SI_0")
    public DocumentReferenceType getOriginalDocumentReference() {
        return originalDocumentReference;
    }

    public void setOriginalDocumentReference(DocumentReferenceType value) {
        this.originalDocumentReference = value;
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
