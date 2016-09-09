package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
public class AttachmentRepresentation{

	/**
	 * A binary large object containing an attached document.
	 */
	private BinaryObjectType embeddedDocumentBinaryObject; 
	private List<ExternalReferenceRepresentation> externalReferences = new ArrayList<>(); 

}