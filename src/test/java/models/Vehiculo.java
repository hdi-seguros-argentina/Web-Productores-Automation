package models;

public class Vehiculo {

    private String anio;
    private String marca;
    private String modelo;
    private String version;
    private boolean gnc;
    private int valorInfoAuto;
    private String Coberturas;
    private String tipoVehiculo;
    private String origen;
    private String provincia;
    private String localidad;
    private String zona;
    private boolean clienteIntegral;

    public String getAnio() { return anio; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getVersion() { return version; }
    public boolean isGnc() { return gnc; }
    public int getValorInfoAuto() { return valorInfoAuto; }
    public String getCoberturas() { return Coberturas; }
    public String getTipoVehiculo() { return tipoVehiculo; }
    public String getOrigen() { return origen; }
    public String getProvincia() { return provincia; }
    public String getLocalidad() { return localidad; }
    public String getZona() { return zona; }
    public boolean isClienteIntegral() { return clienteIntegral; }
}