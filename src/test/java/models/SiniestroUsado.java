package models;

public class SiniestroUsado {
    private String poliza;
    private String fecha;
    private String hora;

    public SiniestroUsado() {
    }

    public SiniestroUsado(String poliza, String fecha, String hora) {
        this.poliza = poliza;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getPoliza() {
        return poliza;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
}