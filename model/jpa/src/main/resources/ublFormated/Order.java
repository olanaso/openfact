package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to order goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:53 a. m.
 */
public class Order{

	/**
	 * The buyer's accounting cost centre, applied to the Order as a whole, expressed
	 * as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the Order as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * A supplementary reference for the Order.
	 */
	private TextType CustomerReference;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * The number of OrderLines in the document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the type of Order.
	 */
	private CodeType OrderTypeCode;
	/**
	 * A code signifying the currency used for all prices in the Order.
	 */
	private CurrencyCodeType CodeTypePricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * A code signifying the currency requested for amount totals in Invoices related
	 * to this Order.
	 */
	private CurrencyCodeType CodeTypeRequestedInvoiceCurrencyCode;
	/**
	 * An identifier for the Order, assigned by the seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * A code signifying the currency requested for tax amounts in Invoices related to
	 * this Order.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<CatalogueReference> CatalogueReferences = new ArrayList<>();
	private List<Contract> Contracts = new ArrayList<>();
	private Country DestinationCountry;
	private CustomerParty OriginatorCustomerParty;
	private CustomerParty AccountingCustomerParty;
	private CustomerParty BuyerCustomerParty;
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<DeliveryTerms> DeliveriesTerms = new ArrayList<>();
	private DocumentReference OrderDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference OriginatorDocumentReference;
	private DocumentReference QuotationDocumentReference;
	private ExchangeRate PaymentExchangeRate;
	private ExchangeRate PricingExchangeRate;
	private ExchangeRate TaxExchangeRate;
	private MonetaryTotal AnticipatedMonetaryTotal;
	private List<OrderLine> OrderLines = new ArrayList<>();
	private Party FreightForwarderParty;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period ValidityPeriod;
	private List<ProjectReference> ProjectReferences = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;
	private List<TaxTotal> TaxTotals = new ArrayList<>();
	private List<TransactionConditions> TransactionConditionses = new ArrayList<>();

}