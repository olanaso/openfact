package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A document used to specify the thresholds for forecast variance, product
 * activity, and performance history beyond which exceptions should be
 * triggered.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:34 a. m.
 */
public class ExceptionCriteriaEntity {

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
	 * Identifies the current version of this document.
	 */
	private IdentifierType versionID;
	private CustomerPartyEntity buyerCustomerParty;
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
	private List<ExceptionCriteriaEntity> lineExceptionCriteriaLines = new ArrayList<>();
	private PartyEntity receiverParty;
	private PartyEntity senderParty;
	private PeriodEntity validityPeriod;
	private List<SignatureEntity> signatures = new ArrayList<>();
	private SupplierPartyEntity sellerSupplierParty;

}
