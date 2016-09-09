package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a procurement project.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:07 a. m.
 */
public class ProjectReference{

	/**
	 * An identifier for the referenced project.
	 */
	private IdentifierType ID;
	/**
	 * The date on which the referenced project was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * A universally unique identifier for the referenced project.
	 */
	private IdentifierType UUID;
	private List<WorkPhaseReference> WorkPhaseReferences = new ArrayList<>();

}
