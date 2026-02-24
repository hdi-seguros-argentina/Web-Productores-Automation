package models;

public class DatosTecnicos {

    private String patente;
    private String numeroMotor;
    private String numeroChasis;

    public String getPatente() { return patente; }
    public String getNumeroMotor() { return numeroMotor; }
    public String getNumeroChasis() { return numeroChasis; }

    public void setPatente(String patente) { this.patente = patente; }
    public void setNumeroMotor(String numeroMotor) { this.numeroMotor = numeroMotor; }
    public void setNumeroChasis(String numeroChasis) { this.numeroChasis = numeroChasis; }
}