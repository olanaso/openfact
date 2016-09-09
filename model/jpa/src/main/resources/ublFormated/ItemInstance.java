package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a specific, trackable instance of an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:45 a. m.
 */
public class ItemInstance{

	/**
	 * The date before which it is best to use this item instance.
	 */
	private LocalDate BestBeforeDate;
	/**
	 * The date on which this item instance was manufactured.
	 */
	private LocalDate ManufactureDate;
	/**
	 * The time at which this item instance was manufactured.
	 */
	private LocalTime ManufactureTime;
	/**
	 * An identifier used for tracing this item instance, such as the EPC number used
	 * in RFID.
	 */
	private IdentifierType ProductTraceID;
	/**
	 * The registration identifier of this item instance.
	 */
	private IdentifierType RegistrationID;
	/**
	 * The serial number of this item instance.
	 */
	private IdentifierType SerialID;
	private ItemProperty AdditionalItemProperty;
	private List<LotIdentification> LotIdentifications = new ArrayList<>();

}
