package org.openfact.models.jpa.entities.ubl;


/**
 * A document used to cancel an entire fulfilment document (Despatch Advice or
 * Receipt Advice).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:42 a. m.
 */
public class FulfilmentCancellation {

	/**
	 * The reason for cancellation of the referenced document.
	 */
	private String CancellationNote;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Contract m_Contract;
	private CustomerParty Buyer CustomerParty;
	private CustomerParty Originator CustomerParty;
	private CustomerParty Delivery CustomerParty;
	private DocumentReference Additional DocumentReference;
	private DocumentReference Receipt DocumentReference;
	private DocumentReference Despatch DocumentReference;
	private Order Reference m_Order Reference;
	private Signature m_Signature;
	private SupplierParty Despatch SupplierParty;
	private SupplierParty Seller SupplierParty;

	public Fulfilment Cancellation(){

	}

	public void finalize() throws Throwable {

	}
	public DocumentReference getAdditional DocumentReference(){
		return Additional DocumentReference;
	}

	public CustomerParty getBuyer CustomerParty(){
		return Buyer CustomerParty;
	}

	public String getCancellationNote(){
		return CancellationNote;
	}

	public Contract getContract(){
		return m_Contract;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public CustomerParty getDelivery CustomerParty(){
		return Delivery CustomerParty;
	}

	public DocumentReference getDespatch DocumentReference(){
		return Despatch DocumentReference;
	}

	public SupplierParty getDespatch SupplierParty(){
		return Despatch SupplierParty;
	}

	public String getID(){
		return ID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public String getNote(){
		return Note;
	}

	public Order Reference getOrder Reference(){
		return m_Order Reference;
	}

	public CustomerParty getOriginator CustomerParty(){
		return Originator CustomerParty;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public DocumentReference getReceipt DocumentReference(){
		return Receipt DocumentReference;
	}

	public SupplierParty getSeller SupplierParty(){
		return Seller SupplierParty;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional DocumentReference(DocumentReference newVal){
		Additional DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyer CustomerParty(CustomerParty newVal){
		Buyer CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCancellationNote(String newVal){
		CancellationNote = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract(Contract newVal){
		m_Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(String newVal){
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery CustomerParty(CustomerParty newVal){
		Delivery CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch DocumentReference(DocumentReference newVal){
		Despatch DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch SupplierParty(SupplierParty newVal){
		Despatch SupplierParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrder Reference(Order Reference newVal){
		m_Order Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginator CustomerParty(CustomerParty newVal){
		Originator CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal){
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal){
		ProfileID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceipt DocumentReference(DocumentReference newVal){
		Receipt DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller SupplierParty(SupplierParty newVal){
		Seller SupplierParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(String newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Fulfilment Cancellation