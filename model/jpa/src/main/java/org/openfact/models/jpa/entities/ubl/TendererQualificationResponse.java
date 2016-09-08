package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document issued by a procurement organization to notify an economic
 * operator whether it has been admitted to or excluded from the tendering
 * process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:34 a. m.
 */
public class TendererQualificationResponse {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private String contractFolderID;
    /**
     * Short title of a contract associated with this Tender.
     */
    private String contractName;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String id;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String ublVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    private List<AppealTerms> appealTerms = new ArrayList<>();
    private DocumentReference resolutionDocumentReference;
    private Party senderParty;
    private Party receiverParty;
    private List<QualificationResolution> qualificationResolutions = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();

    public String getContractFolderID() {
        return contractFolderID;
    }

    public void setContractFolderID(String contractFolderID) {
        this.contractFolderID = contractFolderID;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getCustomizationID() {
        return customizationID;
    }

    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getUblVersionID() {
        return ublVersionID;
    }

    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<AppealTerms> getAppealTerms() {
        return appealTerms;
    }

    public void setAppealTerms(List<AppealTerms> appealTerms) {
        this.appealTerms = appealTerms;
    }

    public DocumentReference getResolutionDocumentReference() {
        return resolutionDocumentReference;
    }

    public void setResolutionDocumentReference(DocumentReference resolutionDocumentReference) {
        this.resolutionDocumentReference = resolutionDocumentReference;
    }

    public Party getSenderParty() {
        return senderParty;
    }

    public void setSenderParty(Party senderParty) {
        this.senderParty = senderParty;
    }

    public Party getReceiverParty() {
        return receiverParty;
    }

    public void setReceiverParty(Party receiverParty) {
        this.receiverParty = receiverParty;
    }

    public List<QualificationResolution> getQualificationResolutions() {
        return qualificationResolutions;
    }

    public void setQualificationResolutions(List<QualificationResolution> qualificationResolutions) {
        this.qualificationResolutions = qualificationResolutions;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }
}// end Tenderer Qualification Response