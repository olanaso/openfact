package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the acceptance or rejection of an economic operator in a
 * tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:13 a. m.
 */
public class QualificationResolution{

	/**
	 * An indicator that the economic operator has been accepted into the tendering
	 * process (true) or rejected from the tendering process (false).
	 */
	private CodeType AdmissionCode;
	/**
	 * Text describing a reason for an exclusion from the tendering process.
	 */
	private TextType ExclusionReason;
	/**
	 * Text describing this qualification resolution.
	 */
	private TextType Resolution;
	/**
	 * The date on which this qualification resolution was formalized.
	 */
	private LocalDate ResolutionDate;
	/**
	 * The time at which this qualification resolution was formalized.
	 */
	private LocalTime ResolutionTime;
	private List<ProcurementProjectLot> ProcurementProjectLots = new ArrayList<>();

}
