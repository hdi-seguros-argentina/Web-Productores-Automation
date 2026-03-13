package models;

import java.util.List;

public class CotizacionIntegralComercio extends CotizacionBase {

    private DatosDelCliente datosDelCliente;
    private String rubro;
    private DatosDelBien datosDelBien;
    private List<Cobertura> cobertura;
    private Emision emision;
    private InformacionDeContacto informacionDeContacto;

    public DatosDelCliente getDatosDelCliente() { return datosDelCliente; }
    public String getRubro() { return rubro; }
    public DatosDelBien getDatosDelBien() { return datosDelBien; }
    public List<Cobertura> getCobertura() { return cobertura; }
    public Emision getEmision() { return emision; }
    public InformacionDeContacto getInformacionDeContacto() { return informacionDeContacto; }
}