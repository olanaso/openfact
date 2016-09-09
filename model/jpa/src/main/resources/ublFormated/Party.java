package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an organization, sub-organization, or individual fulfilling
 * a role in a business process.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class Party{

	/**
	 * An identifier for the end point of the routing service (e.g., EAN Location
	 * Number, GLN).
	 */
	private IdentifierType EndpointID;
	/**
	 * This party's Industry Classification Code.
	 */
	private CodeType IndustryClassificationCode;
	/**
	 * An identifier for this party's logo.
	 */
	private IdentifierType LogoReferenceID;
	/**
	 * An indicator that this party is "for the attention of" (FAO) (true) or not
	 * (false).
	 */
	private boolean MarkAttentionIndicator;
	/**
	 * An indicator that this party is "care of" (c/o) (true) or not (false).
	 */
	private boolean MarkCareIndicator;
	/**
	 * The Uniform Resource Identifier (URI) that identifies this party's web site; i.
	 * e., the web site's Uniform Resource Locator (URL).
	 */
	private IdentifierType WebsiteURIID;
	private Address PostalAddress;
	private List<Contact> Contacts = new ArrayList<>();
	private List<FinancialAccount> FinancialAccounts = new ArrayList<>();
	private List<Language> Languages = new ArrayList<>();
	private Location PhysicalLocation;
	private List<Party> AgentParty = new ArrayList<>();
	private List<PartyIdentification> PartyIdentifications = new ArrayList<>();
	private List<PartyLegalEntity> PartyLegalEntities = new ArrayList<>();
	private List<PartyName> PartyNames = new ArrayList<>();
	private List<Party> TaxSchemePartyTaxSchemes = new ArrayList<>();
	private List<Person> Persons = new ArrayList<>();
	private List<PowerOfAttorney> PowerOfAttorneys = new ArrayList<>();
	private List<ServiceProviderParty> ServiceProviderParties = new ArrayList<>();

}
