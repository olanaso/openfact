package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class defining details about a train wagon used as a means of transport.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:17 a. m.
 */
public class RailTransportRepresentation{

	/**
	 * An identifier for the rail car on the train used as the means of transport.
	 */
	private IdentifierType railCarID; 
	/**
	 * An identifier for the train used as the means of transport.
	 */
	private IdentifierType trainID; 

}