package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a location.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class Location{

	/**
	 * Free-form text describing the physical conditions of the location.
	 */
	private TextType Conditions;
	/**
	 * A territorial division of a country, such as a county or state, expressed as
	 * text.
	 */
	private TextType CountrySubentity;
	/**
	 * A territorial division of a country, such as a county or state, expressed as a
	 * code.
	 */
	private CodeType CountrySubentityCode;
	/**
	 * Text describing this location.
	 */
	private TextType Description;
	/**
	 * An identifier for this location, e.g., the EAN Location Number, GLN.
	 */
	private IdentifierType ID;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing information about
	 * this location.
	 */
	private IdentifierType InformationURIID;
	/**
	 * A code signifying the type of location.
	 */
	private CodeType LocationTypeCode;
	/**
	 * The name of this location.
	 */
	private NameType Name;
	private List<Address> Addresses = new ArrayList<>();
	private Period ValidityPeriod;
	private List<LocationCoordinate> LocationCoordinates = new ArrayList<>();
	private Location SubsidiaryLocation;

}
