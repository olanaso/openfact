package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * Describes the location and schedule relating to a transport means.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:49 a. m.
 */
public class TransportSchedule{

	/**
	 * The reference date for the transport schedule status.
	 */
	private LocalDate ReferenceDate;
	/**
	 * The reference time for the transport schedule status.
	 */
	private LocalTime ReferenceTime;
	/**
	 * The reliability of the transport schedule status, expressed as a percentage.
	 */
	private BigDecimal ReliabilityPercent;
	/**
	 * Remarks related to the transport schedule status.
	 */
	private TextType Remarks;
	/**
	 * A number indicating the order of this status in the sequence in which statuses
	 * are to be presented.
	 */
	private BigDecimal SequenceNumeric;
	private Location StatusLocation;
	private TransportEvent ActualDepartureTransportEvent;
	private TransportEvent EstimatedDepartureTransportEvent;
	private TransportEvent EstimatedArrivalTransportEvent;
	private TransportEvent PlannedDepartureTransportEvent;
	private TransportEvent ActualArrivalTransportEvent;
	private TransportEvent PlannedArrivalTransportEvent;

}