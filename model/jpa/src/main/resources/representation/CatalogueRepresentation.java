package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that describes items, prices, and price validity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class CatalogueRepresentation{

	/**
	 * A code signifying whether the transaction is a replacement or an update.
	 */
	private CodeType actionCode; 
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
	 * The number of catalogueLines in the document.
	 */
	private BigDecimal lineCountNumeric; 
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
	 * An identifier for the previous version of the CatalogueRepresentation that is superseded by
	 * this version.
	 */
	private IdentifierType previousVersionID; 
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
	 * The date, assigned by the seller party, on which the information in the
	 * CatalogueRepresentation was last revised.
	 */
	private LocalDate revisionDate; 
	/**
	 * The time, assigned by the Seller party, at which the information in the
	 * CatalogueRepresentation was last revised.
	 */
	private LocalTime revisionTime; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	/**
	 * An identifier for the current version of the Catalogue.
	 */
	private IdentifierType versionID; 
	private List<CatalogueLineRepresentation> catalogueLines = new ArrayList<>(); 
	private CatalogueReferenceRepresentation sourceCatalogueReference; 
	private ContractRepresentation referencedContract; 
	private CustomerPartyRepresentation contractorCustomerParty; 
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>(); 
	private PartyRepresentation providerParty; 
	private PartyRepresentation receiverParty; 
	private PeriodRepresentation validityPeriod; 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private SupplierPartyRepresentation sellerSupplierParty; 
	private List<TradingTermsRepresentation> tradingTermses = new ArrayList<>(); 

}
