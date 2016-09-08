package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for defining the name of a party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:30 a. m.
 */
public class PartyName {

	/**
	 * The name of the party.
	 */
	private String name;

	public PartyName() {

	}

	public void finalize() throws Throwable {

	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		name = newVal;
	}
}// end PartyName