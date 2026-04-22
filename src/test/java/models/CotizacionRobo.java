package models;

import java.util.List;

public class CotizacionRobo extends CotizacionBase {

    private String plan;
    private DatosDelCliente datosDelCliente;
    private DatosDelBien datosDelBien;
    private List<Cobertura> cobertura;
    private Emision emision;

    public String getPlan() {
        return plan;
    }

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
