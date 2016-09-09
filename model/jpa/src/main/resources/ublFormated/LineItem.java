package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a line item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:55 a. m.
 */
public class LineItem{

	/**
	 * The buyer's accounting cost centre for this line item, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting cost centre for this line item, expressed as a code.
	 */
	private CodeType AccountingCostCode;
	/**
	 * An indicator that back order is allowed (true) or not (false).
	 */
	private boolean BackOrderAllowedIndicator;
	/**
	 * An identifier for this line item, assigned by the buyer.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the inspection requirements for the item associated with this
	 * line item.
	 */
	private CodeType InspectionMethodCode;
	/**
	 * The total amount for this line item, including allowance charges but net of
	 * taxes.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * A code signifying the status of this line item with respect to its original
	 * state.
	 */
	private LineStatusCodeType LineStatusCode;
	/**
	 * The maximum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private QuantityType MaximumBackorderQuantity;
	/**
	 * The maximum quantity of the item associated with this line.
	 */
	private QuantityType MaximumQuantity;
	/**
	 * The minimum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private QuantityType MinimumBackorderQuantity;
	/**
	 * The minimum quantity of the item associated with this line.
	 */
	private QuantityType MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * An indicator that a partial delivery is allowed (true) or not (false).
	 */
	private boolean PartialDeliveryIndicator;
	/**
	 * The quantity of items associated with this line item.
	 */
	private QuantityType Quantity;
	/**
	 * An identifier for this line item, assigned by the seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * The total tax amount for this line item.
	 */
	private BigDecimal TotalTaxAmount;
	/**
	 * A universally unique identifier for this line item.
	 */
	private IdentifierType UUID;
	/**
	 * Text describing a warranty (provided by WarrantyParty) for the good or service
	 * described in this line item.
	 */
	private TextType WarrantyInformation;
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<DeliveryTerms> DeliveriesTerms = new ArrayList<>();
	private List<Item> Items = new ArrayList<>();
	private LineItem SubLineItem;
	private List<LineReference> LineReferences = new ArrayList<>();
	private Party OriginatorParty;
	private Party WarrantyParty;
	private Period WarrantyValidityPeriod;
	private List<OrderedShipment> OrderedShipments = new ArrayList<>();
	private List<Price> Prices = new ArrayList<>();
	private PriceExtension ItemPriceExtension;
	private List<PricingReference> PricingReferences = new ArrayList<>();
	private List<TaxTotal> TaxTotals = new ArrayList<>();

}