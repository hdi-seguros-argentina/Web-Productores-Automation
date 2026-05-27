package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionRobo;
import pages.CommonPage;

public class RoboSteps {
    CommonPage commonPage = new CommonPage();
    private CotizacionRobo dataRobo =
            JsonLoader.load(
                    "Datos/Cotizacion_robo.json",
                    CotizacionRobo.class
            );

    @And("el usuario selecciona ROBO desde el json")
    public void elUsuarioSeleccionaROBODesdeElJson() {
        commonPage.seleccionarRama(dataRobo.getRama());
    }

    @And("el usuario selecciona ROBO WEB desde el json")
    public void elUsuarioSeleccionaROBOWEBDesdeElJson() {
        commonPage.seleccionarArticulo(dataRobo.getArticulo());
    }

    @And("el usuario realiza la cotización de ROBO WEB")
    public void elUsuarioRealizaLaCotizacionDeROBOWEB() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataRobo.getCliente());

        commonPage.clickBotonContinuar();

        commonPage.seleccionarPlan(dataRobo.getPlan());

        commonPage.seleccionarProvincia(dataRobo.getDatosDelBien().getProvincia());
        commonPage.seleccionarLocalidad(dataRobo.getDatosDelBien().getLocalidad());

        commonPage.clickBotonContinuar();

        commonPage.completarCoberturas(dataRobo.getCobertura());

        commonPage.clickBotonCotizar();
    }

    @And("el usuario modifica la variación de ROBO WEB desde el json")
    public void elUsuarioModificaLaVariacionDeROBOWEBDesdeElJson() {
        Integer variacion = dataRobo.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotización de ROBO WEB")
    public void elUsuarioEnviaLaCotizacionDeROBOWEB() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataRobo.getVariacion());

        commonPage.validarResumenActualizado();

        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataRobo.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataRobo.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataRobo.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataRobo.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataRobo.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();

    }

    @And("el usuario emite la cotización de ROBO WEB")
    public void elUsuarioEmiteLaCotizacionDeROBOWEB() {
        commonPage.clickEditarCotizacion();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataRobo.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataRobo.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataRobo.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataRobo.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataRobo.getEmision().getDomicilio());
        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de ROBO WEB validando variación de comisión")
    public void elUsuarioEmiteLaCotizacionDeROBOWEBValidandoVariacion() {
        commonPage.clickEditarCotizacion();
        commonPage.validarSubaYBajaDeComisionYExtraPrima(dataRobo.getVariacion());
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataRobo.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataRobo.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataRobo.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataRobo.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataRobo.getEmision().getDomicilio());
        commonPage.clickBotonEnviar();
    }

    @And("el usuario envia la cotización de ROBO WEB sin guardar")
    public void elUsuarioEnviaLaCotizacionDeROBOWEBSinGuardar() {
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataRobo.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataRobo.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataRobo.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataRobo.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataRobo.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();
    }
}


