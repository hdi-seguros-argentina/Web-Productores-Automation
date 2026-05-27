package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionAutomoviles;
import pages.CommonPage;
import pages.NuevaCotizacion.AutomovilesPage;

public class AutomovilesSteps {
    private static final String JSON_AUTOS = "Datos/Cotizacion_autos.json";
    private static final String RUTA_JSON_AUTOS = "src/test/resources/Datos/Cotizacion_autos.json";

    AutomovilesPage automovilesPage = new AutomovilesPage();
    CommonPage commonPage = new CommonPage();

    CotizacionAutomoviles dataAutomovilesRC = JsonLoader.load(JSON_AUTOS, CotizacionAutomoviles.class);
    String rutaJsonAutomovilesRC = RUTA_JSON_AUTOS;

    @And("el usuario selecciona AUTOMOVILES desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        commonPage.seleccionarRama(dataAutomovilesRC.getRama());
    }

    @And("el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        rutaJsonAutomovilesRC = RUTA_JSON_AUTOS;
        commonPage.seleccionarArticulo(dataAutomovilesRC.getArticulo());
    }

    @And("el usuario realiza la cotización de AUTOMOVILES RC")
    public void elUsuarioRealizaLaCotizacionDeAUTOMOVILESRC() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataAutomovilesRC.getCliente());
        commonPage.clickBotonContinuar();

        automovilesPage.completarDatosVehiculo(dataAutomovilesRC.getVehiculo());
        commonPage.clickBotonCotizar();

        automovilesPage.seleccionarCobertura(dataAutomovilesRC.getVehiculo().getCoberturas());
    }

    @And("el usuario modifica la variación de AUTOMOVILES RC desde el json")
    public void elUsuarioModificaLaVariacionDeAUTOMOVILESRCDesdeElJson() {
        Integer variacion = dataAutomovilesRC.getVariacion();
        commonPage.guardarValoresAntesDeVariacionAuto();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotización de AUTOMOVILES RC")
    public void elUsuarioEnviaLaCotizacionDeAUTOMOVILESRC() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataAutomovilesRC.getVariacion());
        commonPage.validarResumenActualizadoAuto();
        emitirCotizacionRC();
    }

    @And("el usuario emite la cotización de AUTOMOVILES RC")
    public void elUsuarioEmiteLaCotizacionDeAUTOMOVILESRC() {
        commonPage.clickEditarCotizacion();
        emitirCotizacionRC();
    }

    @And("el usuario emite la cotización de AUTOMOVILES RC validando variación de comisión")
    public void elUsuarioEmiteLaCotizacionDeAUTOMOVILESRCValidandoVariacionDeComision() {
        commonPage.clickEditarCotizacion();
        commonPage.validarSubaYBajaDeComisionYExtraPrima(dataAutomovilesRC.getVariacion());
        commonPage.validarResumenActualizadoAuto();
        emitirCotizacionRC();
    }

    @And("el usuario envia la cotización de AUTOMOVILES RC sin guardar")
    public void elUsuarioEnviaLaCotizacionDeAUTOMOVILESRCSinGuardar() {
        emitirCotizacionRC();
    }

    private void emitirCotizacionRC() {
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAutomovilesRC.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAutomovilesRC.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataAutomovilesRC.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataAutomovilesRC.getEmision().getTarjeta().getVencimiento());

        String patenteOriginal = dataAutomovilesRC.getDatosTecnicos().getPatente();
        String patenteNueva = automovilesPage.incrementarPatente(patenteOriginal);

        dataAutomovilesRC.getDatosTecnicos().setPatente(patenteNueva);
        automovilesPage.completarDatosTecnicos(dataAutomovilesRC);
        if (dataAutomovilesRC.getTipoInspeccion() != null) {
            automovilesPage.seleccionarTipoInspeccion(dataAutomovilesRC.getTipoInspeccion());
        }
        if (dataAutomovilesRC.getInformacionDeContacto() != null) {
            commonPage.completarInformacionContacto(dataAutomovilesRC.getInformacionDeContacto());
        }

        guardarYEnviarConReintentoPorPatenteDuplicada();
    }

    private void guardarYEnviarConReintentoPorPatenteDuplicada() {
        automovilesPage.guardarJsonActualizado(dataAutomovilesRC, rutaJsonAutomovilesRC);
        commonPage.clickBotonEnviar();

        for (int intento = 1; intento <= 8 && commonPage.seVisualizaPatenteDuplicada(); intento++) {
            String patenteNueva = automovilesPage.incrementarPatente(dataAutomovilesRC.getDatosTecnicos().getPatente());
            dataAutomovilesRC.getDatosTecnicos().setPatente(patenteNueva);
            automovilesPage.actualizarPatente(patenteNueva);
            automovilesPage.guardarJsonActualizado(dataAutomovilesRC, rutaJsonAutomovilesRC);
            commonPage.clickBotonEnviar();
        }
    }
}
