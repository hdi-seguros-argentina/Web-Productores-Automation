package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionAutomoviles;
import pages.CommonPage;
import pages.NuevaCotizacion.AutomovilesPage;
import pages.NuevaCotizacion.AutomovilesMyWayPage;

public class AutomovilesMyWaySteps {
    private static final String JSON_AUTOS_MYWAY = "Datos/Cotizacion_autos_myway.json";
    private static final String RUTA_JSON_AUTOS_MYWAY = "src/test/resources/Datos/Cotizacion_autos_myway.json";

    AutomovilesPage automovilesPage = new AutomovilesPage();
    AutomovilesMyWayPage automovilesMyWayPage = new AutomovilesMyWayPage();
    CommonPage commonPage = new CommonPage();

    CotizacionAutomoviles dataAutomovilesMyWay = JsonLoader.load(JSON_AUTOS_MYWAY, CotizacionAutomoviles.class);

    @And("el usuario selecciona AUTOMOVILES MYWAY desde el json")
    public void elUsuarioSeleccionaAutomovilesMyWayDesdeElJson() {
        commonPage.seleccionarRama(dataAutomovilesMyWay.getRama());
    }

    @And("el usuario selecciona PRODUCTO MYWAY HAZLO A TU MANERA desde el json")
    public void elUsuarioSeleccionaProductoMyWayHazloATuManeraDesdeElJson() {
        commonPage.seleccionarArticulo(dataAutomovilesMyWay.getArticulo());
    }

    @And("el usuario realiza la cotización de AUTOMOVILES MYWAY")
    public void elUsuarioRealizaLaCotizacionDeAUTOMOVILESMYWAY() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataAutomovilesMyWay.getCliente());
        commonPage.clickBotonContinuar();

        automovilesPage.completarDatosVehiculo(dataAutomovilesMyWay.getVehiculo());
        automovilesMyWayPage.completarInformacionAdicional(dataAutomovilesMyWay.getInformacionAdicional());
        commonPage.clickBotonCotizar();

        automovilesPage.seleccionarCobertura(dataAutomovilesMyWay.getVehiculo().getCoberturas());
        automovilesPage.seleccionarFormaPago(dataAutomovilesMyWay.getFormaPago());
        commonPage.clickBotonRecotizar();
    }

    @And("el usuario modifica la variación de AUTOMOVILES MYWAY desde el json")
    public void elUsuarioModificaLaVariacionDeAUTOMOVILESMYWAYDesdeElJson() {
        Integer variacion = dataAutomovilesMyWay.getVariacion();
        commonPage.guardarValoresAntesDeVariacionAuto();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotización de AUTOMOVILES MYWAY")
    public void elUsuarioEnviaLaCotizacionDeAUTOMOVILESMYWAY() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataAutomovilesMyWay.getVariacion());
        commonPage.validarResumenActualizadoAuto();
        emitirCotizacionMyWay();
    }

    @And("el usuario emite la cotización de AUTOMOVILES MYWAY")
    public void elUsuarioEmiteLaCotizacionDeAUTOMOVILESMYWAY() {
        commonPage.clickEditarCotizacion();
        emitirCotizacionMyWay();
    }

    @And("el usuario emite la cotización de AUTOMOVILES MYWAY validando variación de comisión")
    public void elUsuarioEmiteLaCotizacionDeAUTOMOVILESMYWAYValidandoVariacionDeComision() {
        commonPage.clickEditarCotizacion();
        commonPage.validarSubaYBajaDeComisionYExtraPrimaAuto(dataAutomovilesMyWay.getVariacion());
        emitirCotizacionMyWay();
    }

    public void emitirCotizacionMyWay() {
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAutomovilesMyWay.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAutomovilesMyWay.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataAutomovilesMyWay.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataAutomovilesMyWay.getEmision().getTarjeta().getVencimiento());

        String patenteOriginal = dataAutomovilesMyWay.getDatosTecnicos().getPatente();
        String patenteNueva = automovilesPage.incrementarPatente(patenteOriginal);

        dataAutomovilesMyWay.getDatosTecnicos().setPatente(patenteNueva);
        automovilesPage.completarDatosTecnicos(dataAutomovilesMyWay);

        guardarYEnviarConReintentoPorPatenteDuplicada();
    }

    private void guardarYEnviarConReintentoPorPatenteDuplicada() {
        automovilesPage.guardarJsonActualizado(dataAutomovilesMyWay, RUTA_JSON_AUTOS_MYWAY);
        commonPage.clickBotonEnviar();

        for (int intento = 1; intento <= 8 && commonPage.seVisualizaPatenteDuplicada(); intento++) {
            String patenteNueva = automovilesPage.incrementarPatente(dataAutomovilesMyWay.getDatosTecnicos().getPatente());
            dataAutomovilesMyWay.getDatosTecnicos().setPatente(patenteNueva);
            automovilesPage.actualizarPatente(patenteNueva);
            automovilesPage.guardarJsonActualizado(dataAutomovilesMyWay, RUTA_JSON_AUTOS_MYWAY);
            commonPage.clickBotonEnviar();
        }
    }
}
