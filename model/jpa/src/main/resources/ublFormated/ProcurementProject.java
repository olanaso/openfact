package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a project to procure goods, works, or services.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:04 a. m.
 */
public class ProcurementProject{

	/**
	 * Text describing this procurement project.
	 */
	private TextType Description;
	/**
	 * The estimated overall quantity for this procurement project.
	 */
	private QuantityType EstimatedOverallContractQuantity;
	/**
	 * Text describing the reimbursement fee for concession procurement projects.
	 */
	private TextType FeeDescription;
	/**
	 * An identifier for this procurement project.
	 */
	private IdentifierType ID;
	/**
	 * A name of this procurement project.
	 */
	private NameType Name;
	/**
	 * Free-form text applying to the ProcurementProject. This element may contain
	 * additional information about the lot/contract that is not contained explicitly
	 * in another structure.
	 */
	private TextType Note;
	/**
	 * A code signifying the subcategory of the type of work for this project (e.g.,
	 * land surveying, IT consulting).
	 */
	private CodeType ProcurementSubTypeCode;
	/**
	 * A code signifying the type of procurement project (e.g., goods, works,
	 * services).
	 */
	private CodeType ProcurementTypeCode;
	/**
	 * The indication of whether or not the control quality is included in the works
	 * project.
	 */
	private CodeType QualityControlCode;
	/**
	 * The requested delivery date for this procurement project.
	 */
	private LocalDate RequestedDeliveryDate;
	/**
	 * The amount of the reimbursement fee for concession procurement projects.
	 */
	private BigDecimal RequiredFeeAmount;
	private CommodityClassification AdditionalCommodityClassification;
	private CommodityClassification MainCommodityClassification;
	private List<ContractExtension> ContractExtensions = new ArrayList<>();
	private Location RealizedLocation;
	private Period PlannedPeriod;
	private List<RequestedTenderTotal> RequestedTenderTotals = new ArrayList<>();
	private List<Request> ForTenderLineRequestForTenderLines = new ArrayList<>();

}
