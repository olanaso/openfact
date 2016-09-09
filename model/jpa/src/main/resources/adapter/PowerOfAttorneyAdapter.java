package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a power of attorney.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorneyAdapter{

	/**
	 * Text describing this power of attorney.
	 */
	private TextType description; 
	/**
	 * An identifier for this power of attorney.
	 */
	private IdentifierType ID; 
	/**
	 * The date on which this power of attorney was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time at which this power of attorney was issued.
	 */
	private LocalTime issueTime; 
	private DocumentReferenceAdapter mandateDocumentReference; 
	private PartyAdapter agentParty; 
	private PartyAdapter notaryParty; 
	private PartyAdapter witnessParty; 

}
