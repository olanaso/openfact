package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document describing how goods are packed.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:05 a. m.
 */
public class PackingListAdapter{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * Textual description of the document instance.
	 */
	private TextType description; 
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType name; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * Contains other free-text-based instructions related to the shipment to the
	 * forwarders or carriers. This should only be used where such information cannot
	 * be represented in other structured information entities within the document.
	 */
	private TextType otherInstruction; 
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID; 
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private IdentifierType profileID; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document..
	 */
	private IdentifierType UUID; 
	/**
	 * Version identifier of a PackingList.
	 */
	private IdentifierType versionID; 
	private List<DocumentDistributionAdapter> documentDistributions = new ArrayList<>(); 
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>(); 
	private PartyAdapter consignorParty; 
	private PartyAdapter carrierParty; 
	private PartyAdapter freightForwarderParty; 
	private List<ShipmentAdapter> shipments = new ArrayList<>(); 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 

}
