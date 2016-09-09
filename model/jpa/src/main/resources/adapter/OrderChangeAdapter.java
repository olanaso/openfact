package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify changes to an existing Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:57 a. m.
 */
public class OrderChangeAdapter{

	/**
	 * The buyer's accounting code, applied to the OrderChangeAdapter as a whole, expressed
	 * as text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting code, applied to the OrderChangeAdapter as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
	/**
	 * A supplementary reference for the transaction (e.g., CRI when using purchasing
	 * card).
	 */
	private TextType customerReference; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode; 
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID; 
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * The number of OrderChangeAdapter lines in the document.
	 */
	private BigDecimal lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the currency that is used for all prices in the OrderChange.
	 */
	private CurrencyCodeType codeTypePricingCurrencyCode; 
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID; 
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID; 
	/**
	 * A code signifying he currency requested for amount totals in Invoices related
	 * to this OrderChange.
	 */
	private CurrencyCodeType codeTypeRequestedInvoiceCurrencyCode; 
	/**
	 * An identifier for the OrderChange, assigned by the seller.
	 */
	private IdentifierType salesOrderID; 
	/**
	 * The OrderChangeAdapter Sequence Number assigned by the Buyer to ensure the proper
	 * sequencing of changes.
	 */
	private IdentifierType sequenceNumberID; 
	/**
	 * A code signifying the currency requested for tax amounts in Invoices related to
	 * this OrderChange.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<ContractAdapter> contracts = new ArrayList<>(); 
	private CountryAdapter destinationCountry; 
	private CustomerPartyAdapter accountingCustomerParty; 
	private CustomerPartyAdapter originatorCustomerParty; 
	private CustomerPartyAdapter buyerCustomerParty; 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceAdapter additionalDocumentReference; 
	private DocumentReferenceAdapter originatorDocumentReference; 
	private DocumentReferenceAdapter quotationDocumentReference; 
	private ExchangeRateAdapter pricingExchangeRate; 
	private ExchangeRateAdapter paymentExchangeRate; 
	private ExchangeRateAdapter taxExchangeRate; 
	private MonetaryTotalAdapter anticipatedMonetaryTotal; 
	private List<OrderLineAdapter> orderLines = new ArrayList<>(); 
	private List<OrderReferenceAdapter> orderReferences = new ArrayList<>(); 
	private PartyAdapter freightForwarderParty; 
	private List<PaymentMeansAdapter> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>(); 
	private PeriodAdapter validityPeriod; 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private SupplierPartyAdapter sellerSupplierParty; 
	private SupplierPartyAdapter accountingSupplierParty; 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 
	private List<TransactionConditionsAdapter> transactionConditionses = new ArrayList<>(); 

}