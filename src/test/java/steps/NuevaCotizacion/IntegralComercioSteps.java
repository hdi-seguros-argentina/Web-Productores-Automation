package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionIntegralComercio;
import models.InformacionDeContacto;
import pages.CommonPage;

public class IntegralComercioSteps {
    CommonPage commonPage = new CommonPage();
    private CotizacionIntegralComercio dataIntegralComercio =
            JsonLoader.load(
                    "Datos/cotizacion_integralComercio.json",
                    CotizacionIntegralComercio.class
            );

    @And("el usuario selecciona INTEGRAL DE COMERCIO desde el json")
    public void elUsuarioSeleccionaINTEGRALDECOMERCIODesdeElJson() {
        commonPage.seleccionarRama(dataIntegralComercio.getRama());

    }

    @And("el usuario selecciona INTEGRAL DE COMERCIO WEB desde el json")
    public void elUsuarioSeleccionaINTEGRALDECOMERCIOWEBDesdeElJson() {
        commonPage.seleccionarArticulo(dataIntegralComercio.getArticulo());

    }

    @And("el usuario realiza la cotizacion de INTEGRAL DE COMERCIO WEB")
    public void elUsuarioRealizaLaCotizacionDeINTEGRALDECOMERCIOWEB() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataIntegralComercio.getCliente());
        commonPage.seleccionarIva(dataIntegralComercio.getDatosDelCliente().getIva());

        commonPage.clickBotonContinuar();

        commonPage.seleccionarRubro(dataIntegralComercio.getRubro());

        commonPage.clickBotonContinuar();

        commonPage.seleccionarProvincia(dataIntegralComercio.getDatosDelBien().getProvincia());
        commonPage.seleccionarLocalidad(dataIntegralComercio.getDatosDelBien().getLocalidad());

        commonPage.clickBotonContinuar();

        commonPage.completarCoberturas(dataIntegralComercio.getCobertura());

        commonPage.clickBotonCotizar();

        Integer variacion = dataIntegralComercio.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotizacion de INTEGRAL DE COMERCIO WEB")
    public void elUsuarioEnviaLaCotizacionDeINTEGRALDECOMERCIOWEB() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataIntegralComercio.getVariacion());
        commonPage.validarResumenActualizado();

        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIntegralComercio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIntegralComercio.getEmision().getTarjeta().getNumero());
        commonPage.ingresarVencimiento(dataIntegralComercio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIntegralComercio.getEmision().getDomicilio());

        InformacionDeContacto contacto = dataIntegralComercio.getInformacionDeContacto();
        commonPage.completarInformacionContacto(contacto);

        commonPage.clickBotonEnviar();
    }
}
