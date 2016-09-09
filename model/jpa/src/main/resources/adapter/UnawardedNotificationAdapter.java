package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document communicating to a tenderer that the contract has been awarded to
 * different tenderer.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:48 a. m.
 */
public class UnawardedNotificationAdapter{

	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private IdentifierType contractFolderID; 
	/**
	 * The name, expressed as text, of this procurement project.
	 */
	private TextType contractName; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID; 
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID; 
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<AppealTermsAdapter> appealTermses = new ArrayList<>(); 
	private DocumentReferenceAdapter minutesDocumentReference; 
	private DocumentReferenceAdapter additionalDocumentReference; 
	private PartyAdapter receiverParty; 
	private PartyAdapter senderParty; 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private List<TenderResultAdapter> tenderResults = new ArrayList<>(); 

}
