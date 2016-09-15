package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * The consumption for a specific party for given consumption point provided by
 * a numbers of suppliers. An enterprise can have one utility statement for
 * several parties (e.g. a ministry of defence receiving a telephone bill). In
 * this way each subscriber cons
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:57 a. m.
 */
public class SubscriberConsumptionModel {

    /**
     * The identifier tor this specification.
     */
    private IdentifierModel consumptionID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * The code which specifies the type of this specification, e.g. an on
     * account specification or the yearly specification.
     */
    private CodeModel specificationTypeCode;
    /**
     * The total quantity consumed, as calculated from meter readings.
     */
    private QuantityModel totalMeteredQuantity;
    private List<ConsumptionModel> consumptions = new ArrayList<>();
    private ConsumptionPointModel utilityConsumptionPoint;
    private List<OnAccountPaymentModel> onAccountPayments = new ArrayList<>();
    private PartyModel subscriberParty;
    private List<SupplierConsumptionModel> supplierconsumptions = new ArrayList<>();

}