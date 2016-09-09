package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * Agree can be renamed as PromotionalEvents
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:08 a. m.
 */
public class PromotionalEventModel{

	/**
	 * The first day that products will be available to ship from buyer to seller if
	 * the proposal for this promotional event is accepted.
	 */
	private LocalDate firstShipmentAvailibilityDate; 
	/**
	 * The deadline for acceptance of this promotional event.
	 */
	private LocalDate latestProposalAcceptanceDate; 
	/**
	 * A code signifying the type of this promotional event. Examples can be: Holiday,
	 * Seasonal Event, Store Closing, Trade ItemModel Introduction
	 */
	private CodeType promotionalEventTypeCode; 
	/**
	 * The date on which a proposal for this promotional event was submitted.
	 */
	private LocalDate submissionDate; 
	private List<PromotionalSpecificationModel> promotionalSpecifications = new ArrayList<>(); 

}
