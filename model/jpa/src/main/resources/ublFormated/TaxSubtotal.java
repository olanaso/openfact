package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define the subtotal for a particular tax category within a
 * particular taxation scheme, such as standard rate within VAT.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:05 a. m.
 */
public class TaxSubtotal{

	/**
	 * The unit of measure on which the tax calculation is based
	 */
	private MeasureType BaseUnitMeasure;
	/**
	 * The number of this tax subtotal in the sequence of subtotals corresponding to
	 * the order in which multiple taxes are applied. If all taxes are applied to the
	 * same taxable amount (i.e., their order of application is inconsequential), then
	 * CalculationSequenc
	 */
	private BigDecimal CalculationSequenceNumeric;
	/**
	 * The tax rate of the tax category applied to this tax subtotal, expressed as a
	 * percentage.
	 */
	private BigDecimal Percent;
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit applied.
	 */
	private BigDecimal PerUnitAmount;
	/**
	 * The net amount to which the tax percent (rate) is applied to calculate the tax
	 * amount.
	 */
	private BigDecimal TaxableAmount;
	/**
	 * The amount of this tax subtotal.
	 */
	private BigDecimal TaxAmount;
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the rate of
	 * tax applicable to this tax subtotal.
	 */
	private TextType TierRange;
	/**
	 * Where a tax is tiered, the tax rate that applies within a specified range of
	 * taxable amounts for this tax subtotal.
	 */
	private BigDecimal TierRatePercent;
	/**
	 * The amount of this tax subtotal, expressed in the currency used for invoicing.
	 */
	private BigDecimal TransactionCurrencyTaxAmount;
	private List<TaxCategory> TaxCategories = new ArrayList<>();

}
