package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A document used by a ContractingPartyEntity to define a procurement project
 * to buy goods, services, or works during a specified period.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTendersEntity {

	/**
	 * The date, assigned by the contracting party, on which the
	 * CallForTendersEntity was approved.
	 */
	private LocalDate approvalDate;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e.,
	 * record) to which this document belongs.
	 */
	private IdentifierType contractFolderID;
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
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies the previous version of the Call for Tenders which is
	 * superceded by this version.
	 */
	private IdentifierType previousVersionID;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Indicates the current version of the Call for Tenders.
	 */
	private IdentifierType versionID;
	private List<ContractingPartyEntity> contractingParties = new ArrayList<>();
	private CustomerPartyEntity originatorCustomerParty;
	private DocumentReferenceEntity technicalDocumentReference;
	private DocumentReferenceEntity additionalDocumentReference;
	private DocumentReferenceEntity legalDocumentReference;
	private PartyEntity receiverParty;
	private List<ProcurementProjectEntity> procurementProjects = new ArrayList<>();
	private List<ProcurementProjectLotEntity> procurementProjectsLot = new ArrayList<>();
	private List<SignatureEntity> signatures = new ArrayList<>();
	private List<TenderingProcessEntity> tenderingProcesses = new ArrayList<>();
	private List<TenderingTermsEntity> tenderingTermses = new ArrayList<>();

}