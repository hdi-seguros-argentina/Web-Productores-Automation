package models;

public class Emision {

    private String nacionalidad;
    private Tarjeta tarjeta;
    private String domicilio;

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}