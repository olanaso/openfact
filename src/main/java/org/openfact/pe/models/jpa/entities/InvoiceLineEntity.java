package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "comprobante_pago_detalle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_documento")
public abstract class InvoiceLineEntity {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "unidad_medida")
    private String unidadMedida;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "tipo_igv")
    private String tipoIGV;

    @NotNull
    @Column(name = "cantidad")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal cantidad;

    @NotNull
    @Column(name = "valor_unitario")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorUnitario;

    @NotNull
    @Column(name = "precio_unitario")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precioUnitario;

    @NotNull
    @Column(name = "subtotal")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal subtotal;

    @NotNull
    @Column(name = "total")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "total_igv")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalIGV;

    @Column(name = "total_isc")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalISC;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoIGV() {
        return tipoIGV;
    }

    public void setTipoIGV(String tipoIGV) {
        this.tipoIGV = tipoIGV;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalIGV() {
        return totalIGV;
    }

    public void setTotalIGV(BigDecimal totalIGV) {
        this.totalIGV = totalIGV;
    }

    public BigDecimal getTotalISC() {
        return totalISC;
    }

    public void setTotalISC(BigDecimal totalISC) {
        this.totalISC = totalISC;
    }
}