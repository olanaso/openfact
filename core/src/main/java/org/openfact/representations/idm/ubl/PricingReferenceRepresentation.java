package org.openfact.representations.idm.ubl;

/**
 * A reference to the basis for pricing. This may be based on a catalogue or a
 * quoted amount from a price list and include some alternative pricing
 * conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:57 a. m.
 */
public class PricingReferenceRepresentation {

    private PriceRepresentation alternativeConditionPrice;

    /**
     * @return the alternativeConditionPrice
     */
    public PriceRepresentation getAlternativeConditionPrice() {
        return alternativeConditionPrice;
    }

    /**
     * @param alternativeConditionPrice
     *            the alternativeConditionPrice to set
     */
    public void setAlternativeConditionPrice(PriceRepresentation alternativeConditionPrice) {
        this.alternativeConditionPrice = alternativeConditionPrice;
    }

}