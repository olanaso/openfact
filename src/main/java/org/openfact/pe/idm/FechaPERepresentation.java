package org.openfact.pe.idm;

import java.util.Date;

public class FechaPERepresentation {

    private Date fechaDeEmision;
    private Date fechaDeVencimiento;
    private Date fechaDeReferencia;

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Date getFechaDeReferencia() {
        return fechaDeReferencia;
    }

    public void setFechaDeReferencia(Date fechaDeReferencia) {
        this.fechaDeReferencia = fechaDeReferencia;
    }

}
