package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an immobilized security to be used as a guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:32 a. m.
 */
public class ImmobilizedSecurity{

	/**
	 * The value of the security on the day it was immobilized.
	 */
	private BigDecimal FaceValueAmount;
	/**
	 * An identifier for the certificate of this immobilized security.
	 */
	private IdentifierType ImmobilizationCertificateID;
	/**
	 * The date on which this immobilized security was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The current market value of the immobilized security.
	 */
	private BigDecimal MarketValueAmount;
	/**
	 * An identifier for the security being immobilized.
	 */
	private IdentifierType SecurityID;
	/**
	 * The number of shares immobilized.
	 */
	private QuantityType SharesNumberQuantity;
	private Party IssuerParty;

}
