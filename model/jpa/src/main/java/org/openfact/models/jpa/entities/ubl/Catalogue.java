package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document that describes items, prices, and price validity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class Catalogue {

	/**
	 * A code signifying whether the transaction is a replacement or an update.
	 */
	private String actionCode;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String description;
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
	 * The number of Catalogue Lines in the document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	private String name;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * An identifier for the previous version of the Catalogue that is
	 * superseded by this version.
	 */
	private String previousVersionID;
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
	 * The date, assigned by the seller party, on which the information in the
	 * Catalogue was last revised.
	 */
	private LocalDate revisionDate;
	/**
	 * The time, assigned by the Seller party, at which the information in the
	 * Catalogue was last revised.
	 */
	private LocalTime revisionTime;
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
	/**
	 * An identifier for the current version of the Catalogue.
	 */
	private String versionID;
	private List<CatalogueLine> catalogueLines= new ArrayList<>();
	private CatalogueReference sourceCatalogueReference;
	private Contract referencedContract;
	private CustomerParty contractorCustomerParty;
	private List<DocumentReference> documentReferences= new ArrayList<>();
	private Party providerParty;
	private Party receiverParty;
	private Period validityPeriod;
	private List<Signature> signatures= new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private List<TradingTerms> tradingTerms= new ArrayList<>();

	public Catalogue() {

	}

	public void finalize() throws Throwable {

	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public BigDecimal getLineCountNumeric() {
		return lineCountNumeric;
	}

	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPreviousVersionID() {
		return previousVersionID;
	}

	public void setPreviousVersionID(String previousVersionID) {
		this.previousVersionID = previousVersionID;
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

	public LocalDate getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(LocalDate revisionDate) {
		this.revisionDate = revisionDate;
	}

	public LocalTime getRevisionTime() {
		return revisionTime;
	}

	public void setRevisionTime(LocalTime revisionTime) {
		this.revisionTime = revisionTime;
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

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public List<CatalogueLine> getCatalogueLines() {
		return catalogueLines;
	}

	public void setCatalogueLines(List<CatalogueLine> catalogueLines) {
		this.catalogueLines = catalogueLines;
	}

	public CatalogueReference getSourceCatalogueReference() {
		return sourceCatalogueReference;
	}

	public void setSourceCatalogueReference(CatalogueReference sourceCatalogueReference) {
		this.sourceCatalogueReference = sourceCatalogueReference;
	}

	public Contract getReferencedContract() {
		return referencedContract;
	}

	public void setReferencedContract(Contract referencedContract) {
		this.referencedContract = referencedContract;
	}

	public CustomerParty getContractorCustomerParty() {
		return contractorCustomerParty;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		this.contractorCustomerParty = contractorCustomerParty;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public Party getProviderParty() {
		return providerParty;
	}

	public void setProviderParty(Party providerParty) {
		this.providerParty = providerParty;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	public List<TradingTerms> getTradingTerms() {
		return tradingTerms;
	}

	public void setTradingTerms(List<TradingTerms> tradingTerms) {
		this.tradingTerms = tradingTerms;
	}
}// end Catalogue