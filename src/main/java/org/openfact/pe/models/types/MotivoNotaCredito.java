package org.openfact.pe.models.types;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by lxpary on 10/01/17.
 */
public enum MotivoNotaCredito {

    ANULACION_OPERACION("01", "ANULACION DE LA OPERACION"),
    ANULACION_RUC("02", "ANULACION POR ERROR EN EL RUC"),
    CORRECCION("03", "CORRECCION POR ERROR EN LA DESCRIPCION"),
    DECUENTO_GLOBAL("04", "DESCUENTO GLOBAL"),
    DESCUENTO_ITEM("05", "DESCUENTO POR ITEM"),
    DEVOLUCION_TOTAL("06", "DEVOLUCION TOTAL"),
    DEVOLUCION_PARCIAL("07", "DEVOLUCION POR ITEM"),
    BONIFICACION("08", "BONIFICACION"),
    DISMINUCION_VALOR("09", "DISMINUCION EN EL VALOR");
    //OTROS_CONCEPTOS("10", "OTROS CONCEPTOS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    MotivoNotaCredito(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public static Optional<MotivoNotaCredito> buscarPorCodigo(String codigo) {
        return Stream.of(MotivoNotaCredito.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }
}
