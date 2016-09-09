package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a tendered project or project lot.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:21 a. m.
 */
public class TenderedProjectEntity {

	/**
	 * The fee amount for tendered projects.
	 */
	private BigDecimal feeAmount;
	/**
	 * Text describing the fee amount for tendered projects.
	 */
	private TextType feeDescription;
	/**
	 * An identifier for the tender envelope this tendered project belongs to.
	 */
	private IdentifierType tenderEnvelopeID;
	/**
	 * A code signifying the type of tender envelope this tendered project
	 * belongs to.
	 */
	private CodeType tenderEnvelopeTypeCode;
	/**
	 * An identifier for this variant of a tendered project.
	 */
	private IdentifierType variantID;
	private List<AwardingCriterionResponseEntity> awardingCriterionResponses = new ArrayList<>();
	private DocumentReferenceEntity evidenceDocumentReference;
	private MonetaryTotalEntity legalMonetaryTotal;
	private List<ProcurementProjectLotEntity> procurementProjectLots = new ArrayList<>();
	private List<TaxTotalEntity> taxTotals = new ArrayList<>();
	private List<TenderLineEntity> tenderLines = new ArrayList<>();

}