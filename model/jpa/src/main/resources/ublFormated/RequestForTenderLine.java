package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Request for Tender describing an item of goods or
 * a service solicited in the Request for Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLine{

	/**
	 * The estimated total amount of the deliverable.
	 */
	private BigDecimal EstimatedAmount;
	/**
	 * An identifier for this request for tender line.
	 */
	private IdentifierType ID;
	/**
	 * The maximum amount allowed for this deliverable.
	 */
	private BigDecimal MaximumAmount;
	/**
	 * The maximum quantity of the item associated with this request for tender line.
	 */
	private QuantityType MaximumQuantity;
	/**
	 * The minimum amount allowed for this deliverable.
	 */
	private BigDecimal MinimumAmount;
	/**
	 * The minimum quantity of the item associated with this request for tender line.
	 */
	private QuantityType MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * The quantity of the item for which a tender is requested in this line.
	 */
	private QuantityType Quantity;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private boolean TaxIncludedIndicator;
	/**
	 * A universally unique identifier for this request for tender line.
	 */
	private IdentifierType UUID;
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<Item> Items = new ArrayList<>();
	private ItemLocationQuantity RequiredItemLocationQuantity;
	private Period DeliveryPeriod;
	private Period WarrantyValidityPeriod;
	private Request ForTenderLineSubRequestForTenderLine;

}
