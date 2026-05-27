package models;

public class Siniestro {
    private String rama;
    private String poliza;
    private FechaLugarSiniestro fechaLugar;
    private ConductorSiniestro conductor;
    private TipoSiniestro tipoSiniestro;
    private TerceroSiniestro tercero;

    public Siniestro() {
    }

    public Siniestro(String rama, String poliza) {
        this.rama = rama;
        this.poliza = poliza;

        this.fechaLugar = new FechaLugarSiniestro();
        this.conductor = new ConductorSiniestro();
        this.tipoSiniestro = new TipoSiniestro();
        this.tercero = new TerceroSiniestro();
        this.tercero.vehiculo = new VehiculoTercero();
    }

    public String getRama() {
        return rama;
    }

    public String getPoliza() {
        return poliza;
    }

    public FechaLugarSiniestro getFechaLugar() {
        return fechaLugar;
    }

    public ConductorSiniestro getConductor() {
        return conductor;
    }

    public TipoSiniestro getTipoSiniestro() {
        return tipoSiniestro;
    }

    public TerceroSiniestro getTercero() {
        return tercero;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public static class FechaLugarSiniestro {
        private String fecha;
        private String hora;
        private String provincia;
        private String localidad;
        private String calle;
        private String altura;
        private String tipoCalzada;

        public String getFecha() {
            return fecha;
        }

        public String getHora() {
            return hora;
        }

        public String getProvincia() {
            return provincia;
        }

        public String getLocalidad() {
            return localidad;
        }

        public String getCalle() {
            return calle;
        }

        public String getAltura() {
            return altura;
        }

        public String getTipoCalzada() {
            return tipoCalzada;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public void setLocalidad(String localidad) {
            this.localidad = localidad;
        }

        public void setCalle(String calle) {
            this.calle = calle;
        }

        public void setAltura(String altura) {
            this.altura = altura;
        }

        public void setTipoCalzada(String tipoCalzada) {
            this.tipoCalzada = tipoCalzada;
        }
    }

    public static class ConductorSiniestro {
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class TipoSiniestro {
        private String causa;
        private String detalle;

        public String getCausa() {
            return causa;
        }

        public String getDetalle() {
            return detalle;
        }

        public void setCausa(String causa) {
            this.causa = causa;
        }

        public void setDetalle(String detalle) {
            this.detalle = detalle;
        }
    }

    public static class TerceroSiniestro {
        private String nombrePropietario;
        private String tipoDocumento;
        private String numeroDocumento;
        private String email;
        private String domicilio;
        private String provincia;
        private String localidad;
        private String genero;
        private String registro;
        private String telefono;
        private String tipoLesion;
        private String transportado;
        private VehiculoTercero vehiculo;

        public String getNombrePropietario() {
            return nombrePropietario;
        }

        public String getTipoDocumento() {
            return tipoDocumento;
        }

        public String getNumeroDocumento() {
            return numeroDocumento;
        }

        public String getEmail() {
            return email;
        }

        public String getDomicilio() {
            return domicilio;
        }

        public String getProvincia() {
            return provincia;
        }

        public String getLocalidad() {
            return localidad;
        }

        public String getGenero() {
            return genero;
        }

        public String getRegistro() {
            return registro;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getTipoLesion() {
            return tipoLesion;
        }

        public String getTransportado() {
            return transportado;
        }

        public VehiculoTercero getVehiculo() {
            return vehiculo;
        }

        public void setNombrePropietario(String nombrePropietario) {
            this.nombrePropietario = nombrePropietario;
        }

        public void setTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }

        public void setNumeroDocumento(String numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setDomicilio(String domicilio) {
            this.domicilio = domicilio;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public void setLocalidad(String localidad) {
            this.localidad = localidad;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public void setRegistro(String registro) {
            this.registro = registro;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setTipoLesion(String tipoLesion) {
            this.tipoLesion = tipoLesion;
        }

        public void setTransportado(String transportado) {
            this.transportado = transportado;
        }

        public void setVehiculo(VehiculoTercero vehiculo) {
            this.vehiculo = vehiculo;
        }
    }

    public static class VehiculoTercero {
        private String dominio;
        private String anio;
        private String marca;
        private String modelo;
        private String uso;
        private String tipo;
        private String numeroMotor;
        private String numeroChasis;

        public String getDominio() {
            return dominio;
        }

        public String getAnio() {
            return anio;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public String getUso() {
            return uso;
        }

        public String getTipo() {
            return tipo;
        }

        public String getNumeroMotor() {
            return numeroMotor;
        }

        public String getNumeroChasis() {
            return numeroChasis;
        }

        public void setDominio(String dominio) {
            this.dominio = dominio;
        }

        public void setAnio(String anio) {
            this.anio = anio;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public void setUso(String uso) {
            this.uso = uso;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public void setNumeroMotor(String numeroMotor) {
            this.numeroMotor = numeroMotor;
        }

        public void setNumeroChasis(String numeroChasis) {
            this.numeroChasis = numeroChasis;
        }
    }
}