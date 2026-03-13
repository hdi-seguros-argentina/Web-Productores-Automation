package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.CotizacionHogar;
import pages.CommonPage;
import pages.NuevaCotizacion.HogarPage;

public class HogarSteps {
    HogarPage hogarPage = new HogarPage();
    CommonPage commonPage = new CommonPage();
    private CotizacionHogar dataHogar =
            JsonLoader.load(
                    "Datos/cotizacion_hogar.json",
                    CotizacionHogar.class
            );

    @And("el usuario selecciona HOGAR desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        commonPage.seleccionarRama(dataHogar.getRama());
    }

    @And("el usuario selecciona COMBINADO FAMILIAR desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        commonPage.seleccionarArticulo(dataHogar.getArticulo());
    }

    @And("el usuario realiza la cotizacion de COMBINADO FAMILIAR")
    public void elUsuarioRealizaLaCotizacionDeCOMBINADOFAMILIAR() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataHogar.getCliente());
        commonPage.clickBotonContinuar();

        hogarPage.seleccionarPlan(dataHogar.getPlan());
        commonPage.seleccionarProvincia(dataHogar.getDatosDelBien().getProvincia());
        commonPage.seleccionarLocalidad(dataHogar.getDatosDelBien().getLocalidad());
        hogarPage.seleccionarTipoVivienda(dataHogar.getDatosDelBien().getTipoVivienda());
        commonPage.clickBotonContinuar();

        commonPage.completarCoberturas(dataHogar.getCobertura());

        commonPage.clickBotonCotizar();

        Integer variacion = dataHogar.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario guarda la cotizacion")
    public void elUsuarioGuardaCotizacion() {
        commonPage.guardarCotizacion();
    }

    @And("el usuario envia la cotizacion de COMBINADO FAMILIAR")
    public void elUsuarioEnviaCotizacionDeCOMBINADOFAMILIAR() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataHogar.getVariacion());
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataHogar.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataHogar.getEmision().getTarjeta().getNumero());
        commonPage.ingresarVencimiento(dataHogar.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataHogar.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();
    }

    @Then("el usuario verifica el envio de la cotizacion")
    public void elUsuarioVerificaElEnvioDeLaCotizacion() {
        commonPage.verificaEnvioCotizacion();
    }
}
