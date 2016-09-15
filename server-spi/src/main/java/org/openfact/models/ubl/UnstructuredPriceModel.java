package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * A simplified version of the PriceModel class intended for applications such
 * as telephone billing.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:54 a. m.
 */
public class UnstructuredPriceModel {

    /**
     * The price amount.
     */
    private BigDecimal priceAmount;
    /**
     * The usage time upon which the price is based.
     */
    private TextModel timeAmount;

}