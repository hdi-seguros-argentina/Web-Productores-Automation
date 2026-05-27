package models;

import java.util.List;

public class CotizacionAutomoviles extends CotizacionBase {
    private Vehiculo vehiculo;
    private List<Accesorio> accesorios;
    private DatosTecnicos datosTecnicos;
    private String uso;
    private Emision emision;
    private InformacionAdicionalAutomoviles informacionAdicional;
    private InformacionDeContacto informacionDeContacto;
    private String formaPago;
    private String tipoInspeccion;

    public Vehiculo getVehiculo() { return vehiculo; }
    public List<Accesorio> getAccesorios() { return accesorios; }
    public DatosTecnicos getDatosTecnicos() { return datosTecnicos; }
    public String getUso() { return uso; }
    public Emision getEmision() { return emision; }
    public InformacionAdicionalAutomoviles getInformacionAdicional() { return informacionAdicional; }
    public InformacionDeContacto getInformacionDeContacto() { return informacionDeContacto; }
    public String getFormaPago() { return formaPago; }
    public String getTipoInspeccion() { return tipoInspeccion; }
}
