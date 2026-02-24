package models;

import java.util.List;

public class CotizacionAccidentes extends CotizacionBase {
    private String plan;
    private String actividad;
    private int cantidadPersonas;
    private Cobertura cobertura;
    private Emision emision;
    private List<Persona> personas;

    public String getPlan() {
        return plan;
    }

    public String getActividad() {
        return actividad;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public Emision getEmision() {
        return emision;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}