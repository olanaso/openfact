package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a requirement for execution of a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:01 a. m.
 */
public class ContractExecutionRequirementEntity {

	/**
	 * Text describing this requirement.
	 */
	private TextType description;
	/**
	 * A code signifying the type of party independent of its role.
	 */
	private CodeType executionRequirementCode;
	/**
	 * A name for this requirement.
	 */
	private NameType name;

}