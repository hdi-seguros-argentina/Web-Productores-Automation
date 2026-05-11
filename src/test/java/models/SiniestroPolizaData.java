package models;

public class SiniestroPolizaData {
    private String rama;
    private String poliza;

    public SiniestroPolizaData() {
    }

    public SiniestroPolizaData(String rama, String poliza) {
        this.rama = rama;
        this.poliza = poliza;
    }

    public String getRama() {
        return rama;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }
}

