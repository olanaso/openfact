package org.openfact.pe.idm;

import javax.validation.constraints.Pattern;

public class BoletaRepresentation extends AbstractInvoiceRepresentation {

    @Pattern(regexp = "[B][A-Z]+[0-9]+")
    private String serie;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

}