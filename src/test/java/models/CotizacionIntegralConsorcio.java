package models;

import java.util.List;

public class CotizacionIntegralConsorcio extends CotizacionBase {

    private DatosDelCliente datosDelCliente;
    private DatosDelBien datosDelBien;

    private List<Cobertura> cobertura;

    private Emision emision;

    public DatosDelCliente getDatosDelCliente() {
        return datosDelCliente;
    }

    public DatosDelBien getDatosDelBien() {
        return datosDelBien;
    }

    public List<Cobertura> getCobertura() {
        return cobertura;
    }

    public Emision getEmision() {
        return emision;
    }
}
