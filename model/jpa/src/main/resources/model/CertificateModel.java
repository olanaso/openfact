package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a certificate applied to the item. Certificated can be a
 * requirement to sell goods or services in a jurisdiction.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:28 a. m.
 */
public class CertificateModel{

	/**
	 * The type of this certificate, expressed as a code. The type specifies what
	 * array it belongs to, e.g.. Environmental, security, health improvement etc.
	 */
	private TextType certificateType; 
	/**
	 * The type of this certificate, expressed as a code. The type specifies what
	 * array it belongs to, e.g.. Environmental, security, health improvement etc.
	 */
	private CodeType certificateTypeCode; 
	/**
	 * An identifier for this certificate.
	 */
	private IdentifierType ID; 
	/**
	 * remarks by the applicant for this certificate.
	 */
	private TextType remarks; 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private PartyModel issuerParty; 
	private List<SignatureModel> signatures = new ArrayList<>(); 

}
