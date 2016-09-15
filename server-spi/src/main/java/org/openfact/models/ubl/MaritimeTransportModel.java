package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a vessel used for transport by water (including sea,
 * river, and canal).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:05 a. m.
 */
public class MaritimeTransportModel {

    /**
     * Gross tonnage is calculated by measuring a ship's volume (from keel to
     * funnel, to the outside of the hull framing) and applying a mathematical
     * formula and is used to determine things such as a ship's manning
     * regulations, safety rules, registration fees an
     */
    private MeasureModel grossTonnageMeasure;
    /**
     * Net tonnage is calculated by measuring a ship's internal volume and
     * applying a mathematical formula and is used to calculate the port duties.
     */
    private MeasureModel netTonnageMeasure;
    /**
     * The radio call sign of the vessel.
     */
    private IdentifierModel radioCallSignID;
    /**
     * Information about what services a vessel will require when it arrives at
     * a port, such as refueling, maintenance, waste disposal etc.
     */
    private TextModel shipsRequirements;
    /**
     * An identifier for a specific vessel.
     */
    private IdentifierModel vesselID;
    /**
     * The name of the vessel.
     */
    private NameModel vesselName;
    private DocumentReferenceModel registryCertificateDocumentReference;
    private LocationModel registryPortLocation;

}