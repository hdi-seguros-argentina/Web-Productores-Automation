package models;

import java.util.Map;

public class CotizacionHogar extends CotizacionBase {

    private String plan;
    private DatosDelBien datosDelBien;
    private Map<String, Integer> cobertura;
    private Emision emision;

    public String getPlan() {
        return plan;
    }

    public DatosDelBien getDatosDelBien() {
        return datosDelBien;
    }

    public Map<String, Integer> getCobertura() {
        return cobertura;
    }

    public Emision getEmision() {
        return emision;
    }
}