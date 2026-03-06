package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionIncendio;
import pages.CommonPage;
import pages.NuevaCotizacion.IncendioPage;

public class IncendioSteps {
    IncendioPage incendioPage = new IncendioPage();
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

    @And("el usuario realiza la cotizacion de INCENDIO VIVIENDAS")
    public void elUsuarioRealizaLaCotizacionDeINCENDIOVIVIENDAS() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataIncendio.getCliente());
        commonPage.clickBotonContinuar();

        incendioPage.seleccionarRubro(dataIncendio.getRubro());

        commonPage.clickBotonContinuar();

        commonPage.seleccionarProvincia(dataIncendio.getDatosDelBien().getProvincia());
        commonPage.seleccionarLocalidad(dataIncendio.getDatosDelBien().getLocalidad());

        commonPage.clickBotonContinuar();

        commonPage.completarCoberturas(dataIncendio.getCobertura());

        commonPage.clickBotonCotizar();
    }

    @And("el usuario envia la cotizacion de INCENDIO VIVIENDAS")
    public void elUsuarioEnviaLaCotizacionDeINCENDIOVIVIENDAS() {
        commonPage.clickEditarCotizacion();

        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIncendio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIncendio.getEmision().getTarjeta().getNumero());
        commonPage.ingresarVencimiento(dataIncendio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIncendio.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();
    }
}