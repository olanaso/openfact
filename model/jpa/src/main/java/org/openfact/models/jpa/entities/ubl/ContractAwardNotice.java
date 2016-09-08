package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document published by a ContractingParty to announce the awarding of a
 * procurement project.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:21 a. m.
 */
public class ContractAwardNotice {

	/**
	 * An identifier, assigned by the sender, for the process file (i.e.,
	 * record) to which this document belongs.
	 */
	private String contractFolderID;
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
	private String ID;
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
	 * An indicator specifying if the notice is published for service contracts
	 * within certain service categories (true) or not (false).
	 */
	private boolean publishAwardIndicator;
	/**
	 * Information about the law that defines the regulatory domain.
	 */
	private String regulatoryDomain;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private List<ContractingParty> contractingPartys= new ArrayList<>();
	private CustomerParty originatorCustomerParty;
	private DocumentReference previousDocumentReference;
	private DocumentReference minutesDocumentReference;
	private Party receiverParty;
	private List<ProcurementProjectLot> procurementProjectLots= new ArrayList<>();
	private List<ProcurementProject> procurementProjects= new ArrayList<>();
	private List<Signature> signatures= new ArrayList<>();
	private List<TenderResult> tenderResults= new ArrayList<>();
	private List<TenderingProcess> tenderingProcess= new ArrayList<>();
	private List<TenderingTerms> tenderingTerms= new ArrayList<>();

	public ContractAwardNotice() {

	}

	public void finalize() throws Throwable {

	}

	public String getContractFolderID() {
		return contractFolderID;
	}

	public void setContractFolderID(String contractFolderID) {
		this.contractFolderID = contractFolderID;
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

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

	public boolean isPublishAwardIndicator() {
		return publishAwardIndicator;
	}

	public void setPublishAwardIndicator(boolean publishAwardIndicator) {
		this.publishAwardIndicator = publishAwardIndicator;
	}

	public String getRegulatoryDomain() {
		return regulatoryDomain;
	}

	public void setRegulatoryDomain(String regulatoryDomain) {
		this.regulatoryDomain = regulatoryDomain;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public List<ContractingParty> getContractingPartys() {
		return contractingPartys;
	}

	public void setContractingPartys(List<ContractingParty> contractingPartys) {
		this.contractingPartys = contractingPartys;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return originatorCustomerParty;
	}

	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		this.originatorCustomerParty = originatorCustomerParty;
	}

	public DocumentReference getPreviousDocumentReference() {
		return previousDocumentReference;
	}

	public void setPreviousDocumentReference(DocumentReference previousDocumentReference) {
		this.previousDocumentReference = previousDocumentReference;
	}

	public DocumentReference getMinutesDocumentReference() {
		return minutesDocumentReference;
	}

	public void setMinutesDocumentReference(DocumentReference minutesDocumentReference) {
		this.minutesDocumentReference = minutesDocumentReference;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public List<ProcurementProjectLot> getProcurementProjectLots() {
		return procurementProjectLots;
	}

	public void setProcurementProjectLots(List<ProcurementProjectLot> procurementProjectLots) {
		this.procurementProjectLots = procurementProjectLots;
	}

	public List<ProcurementProject> getProcurementProjects() {
		return procurementProjects;
	}

	public void setProcurementProjects(List<ProcurementProject> procurementProjects) {
		this.procurementProjects = procurementProjects;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}

	public List<TenderResult> getTenderResults() {
		return tenderResults;
	}

	public void setTenderResults(List<TenderResult> tenderResults) {
		this.tenderResults = tenderResults;
	}

	public List<TenderingProcess> getTenderingProcess() {
		return tenderingProcess;
	}

	public void setTenderingProcess(List<TenderingProcess> tenderingProcess) {
		this.tenderingProcess = tenderingProcess;
	}

	public List<TenderingTerms> getTenderingTerms() {
		return tenderingTerms;
	}

	public void setTenderingTerms(List<TenderingTerms> tenderingTerms) {
		this.tenderingTerms = tenderingTerms;
	}
}// end Contract Award Notice