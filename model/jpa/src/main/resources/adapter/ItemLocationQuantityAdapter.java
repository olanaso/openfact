package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class for information about pricing structure, lead time, and location
 * associated with an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:47 a. m.
 */
public class ItemLocationQuantityAdapter{

	/**
	 * An indication that the transported item, as delivered, in the stated quantity
	 * to the stated location, is subject to an international regulation concerning
	 * the carriage of dangerous goods (true) or not (false).
	 */
	private boolean hazardousRiskIndicator; 
	/**
	 * The lead time, i.e., the time taken from the time at which an item is ordered
	 * to the time of its delivery.
	 */
	private MeasureType leadTimeMeasure; 
	/**
	 * The maximum quantity that can be ordered to qualify for a specific price.
	 */
	private QuantityType maximumQuantity; 
	/**
	 * The minimum quantity that can be ordered to qualify for a specific price.
	 */
	private QuantityType minimumQuantity; 
	/**
	 * Text describing trade restrictions on the quantity of this item or on the item
	 * itself.
	 */
	private TextType tradingRestrictions; 
	private AddressAdapter applicableTerritoryAddress; 
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<DeliveryUnitAdapter> deliveryUnits = new ArrayList<>(); 
	private List<DependentPriceReferenceAdapter> dependentPriceReferences = new ArrayList<>(); 
	private List<PackageAdapter> packages = new ArrayList<>(); 
	private List<PriceAdapter> prices = new ArrayList<>(); 
	private TaxCategoryAdapter applicableTaxCategory; 

}