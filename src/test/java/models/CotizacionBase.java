package models;

public class CotizacionBase {

    protected String rama;
    protected String articulo;
    protected String cliente;
    protected Integer variacion;

    public String getRama() { return rama; }
    public String getArticulo() { return articulo; }
    public String getCliente() { return cliente; }
    public Integer getVariacion() { return variacion; }
    public void setVariacion(Integer variacion) { this.variacion = variacion; }
}
