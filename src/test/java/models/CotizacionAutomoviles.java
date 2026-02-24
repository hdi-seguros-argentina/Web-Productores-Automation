package models;

import java.util.List;

public class CotizacionAutomoviles extends CotizacionBase {
    private Vehiculo vehiculo;
    private List<Accesorio> accesorios;
    private DatosTecnicos datosTecnicos;
    private String uso;
    private Emision emision;

    public Vehiculo getVehiculo() { return vehiculo; }
    public List<Accesorio> getAccesorios() { return accesorios; }
    public DatosTecnicos getDatosTecnicos() { return datosTecnicos; }
    public String getUso() { return uso; }
    public Emision getEmision() { return emision; }
}