package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document to indicate the application's response to a transaction. This may be
 * a business response initiated by a user or a technical response sent
 * automatically by an application.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:06 a. m.
 */
public class ApplicationResponse {

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
	 * The date on which the information in the response was created.
	 */
	private LocalDate ResponseDate;
	/**
	 * The time at which the information in the response was created.
	 */
	private LocalTime ResponseTime;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	/**
	 * Identifies the current version of this document.
	 */
	private String VersionID;
	private DocumentResponse m_DocumentResponse;
	private Party SenderParty;
	private Party ReceiverParty;
	private Signature m_Signature;

	public ApplicationResponse(){

	}

	public void finalize() throws Throwable {

	}
	public String getCustomizationID(){
		return CustomizationID;
	}

	public DocumentResponse getDocumentResponse(){
		return m_DocumentResponse;
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

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Party getReceiverParty(){
		return ReceiverParty;
	}

	public LocalDate getResponseDate(){
		return ResponseDate;
	}

	public LocalTime getResponseTime(){
		return ResponseTime;
	}

	public Party getSenderParty(){
		return SenderParty;
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

	public String getVersionID(){
		return VersionID;
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
	public void setDocumentResponse(DocumentResponse newVal){
		m_DocumentResponse = newVal;
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
	public void setReceiverParty(Party newVal){
		ReceiverParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponseDate(LocalDate newVal){
		ResponseDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponseTime(LocalTime newVal){
		ResponseTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSenderParty(Party newVal){
		SenderParty = newVal;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal){
		VersionID = newVal;
	}
}//end Application Response