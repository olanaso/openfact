package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a delivery.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class DeliveryEntity {

	/**
	 * The actual date of delivery.
	 */
	private LocalDate actualDeliveryDate;
	/**
	 * The actual time of delivery.
	 */
	private LocalTime actualDeliveryTime;
	/**
	 * An identifier for this delivery.
	 */
	private IdentifierType ID;
	/**
	 * The latest date of delivery allowed by the buyer.
	 */
	private LocalDate latestDeliveryDate;
	/**
	 * The latest time of delivery allowed by the buyer.
	 */
	private LocalTime latestDeliveryTime;
	/**
	 * The maximum quantity of items, child consignments, shipments in this
	 * delivery.
	 */
	private QuantityType maximumQuantity;
	/**
	 * The minimum quantity of items, child consignments, shipments in this
	 * delivery.
	 */
	private QuantityType minimumQuantity;
	/**
	 * The quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType quantity;
	/**
	 * An identifier used for approval of access to delivery locations (e.g.,
	 * port terminals).
	 */
	private IdentifierType releaseID;
	/**
	 * The delivery Tracking ID (for transport tracking).
	 */
	private IdentifierType trackingID;
	private AddressEntity deliveryAddress;
	private DeliveryUnitEntity maximumDeliveryUnit;
	private DeliveryUnitEntity minimumDeliveryUnit;
	private List<DespatchEntity> despatches = new ArrayList<>();
	private PeriodEntity estimatedDeliveryPeriod;
	private PeriodEntity promisedDeliveryPeriod;
	private PeriodEntity requestedDeliveryPeriod;
	private LocationEntity deliveryLocation;
	private LocationEntity alternativeDeliveryLocation;
	private PartyEntity notifyParty;
	private PartyEntity carrierParty;
	private PartyEntity deliveryParty;
	private List<ShipmentEntity> shipments = new ArrayList<>();
	private List<DeliveryTermsEntity> deliveryTermses = new ArrayList<>();

}
