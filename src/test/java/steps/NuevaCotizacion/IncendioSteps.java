package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionIncendio;
import pages.CommonPage;
public class IncendioSteps {
    CommonPage commonPage = new CommonPage();
    private CotizacionIncendio dataIncendio =
            JsonLoader.load(
                    "Datos/cotizacion_incendio.json",
                    CotizacionIncendio.class
            );

    @And("el usuario selecciona INCENDIO WEB desde el json")
    public void elUsuarioSeleccionaINCENDIOWEBDesdeElJson() {
        commonPage.seleccionarRama(dataIncendio.getRama());
    }

    @And("el usuario selecciona INCENDIO VIVIENDAS desde el json")
    public void elUsuarioSeleccionaINCENDIOVIVIENDASDesdeElJson() {
        commonPage.seleccionarArticulo(dataIncendio.getArticulo());
    }

    @And("el usuario realiza la cotización de INCENDIO VIVIENDAS")
    public void elUsuarioRealizaLaCotizacionDeINCENDIOVIVIENDAS() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataIncendio.getCliente());
        commonPage.clickBotonContinuar();

        commonPage.seleccionarRubro(dataIncendio.getRubro());

        commonPage.clickBotonContinuar();

        commonPage.seleccionarProvincia(dataIncendio.getDatosDelBien().getProvincia());
        commonPage.seleccionarLocalidad(dataIncendio.getDatosDelBien().getLocalidad());

        commonPage.clickBotonContinuar();

        commonPage.completarCoberturas(dataIncendio.getCobertura());

        commonPage.clickBotonCotizar();

        Integer variacion = dataIncendio.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotización de INCENDIO VIVIENDAS")
    public void elUsuarioEnviaLaCotizacionDeINCENDIOVIVIENDAS() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataIncendio.getVariacion());

        commonPage.validarResumenActualizado();

        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIncendio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIncendio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIncendio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIncendio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIncendio.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de INCENDIO VIVIENDAS")
    public void elUsuarioEmiteLaCotizacionDeINCENDIOVIVIENDAS() {
        commonPage.clickEditarCotizacion();
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIncendio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIncendio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIncendio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIncendio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIncendio.getEmision().getDomicilio());
        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de INCENDIO VIVIENDAS validando variación de comisión")
    public void elUsuarioEmiteLaCotizacionDeINCENDIOVIVIENDASValidandoVariacion() {
        commonPage.clickEditarCotizacion();
        commonPage.validarSubaYBajaDeComisionYExtraPrima(dataIncendio.getVariacion());
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIncendio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIncendio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIncendio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIncendio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIncendio.getEmision().getDomicilio());
        commonPage.clickBotonEnviar();
    }

    @And("el usuario envia la cotización de INCENDIO VIVIENDAS sin guardar")
    public void elUsuarioEnviaLaCotizacionDeINCENDIOVIVIENDASSinGuardar() {
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIncendio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIncendio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIncendio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIncendio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIncendio.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();
    }
}


