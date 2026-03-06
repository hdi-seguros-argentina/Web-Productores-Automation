package models;

import java.util.List;

public class CotizacionIncendio extends CotizacionBase {

    private String rubro;
    private DatosDelBien datosDelBien;
    private List<Cobertura> cobertura;
    private Emision emision;

    public String getRubro() {
        return rubro;
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