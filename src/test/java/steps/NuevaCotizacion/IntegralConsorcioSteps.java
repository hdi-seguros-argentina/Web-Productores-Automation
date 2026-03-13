package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.CotizacionIntegralConsorcio;
import pages.CommonPage;

public class IntegralConsorcioSteps {
    CommonPage commonPage = new CommonPage();
    private CotizacionIntegralConsorcio dataIntegralConsorcio =
            JsonLoader.load(
                    "Datos/cotizacion_integralConsorcio.json",
                    CotizacionIntegralConsorcio.class
            );

    @And("el usuario selecciona INTEGRAL DE CONSORCIO desde el json")
    public void elUsuarioSeleccionaINTEGRALDECONSORCIODesdeElJson() {
        commonPage.seleccionarRama(dataIntegralConsorcio.getRama());
    }

    @And("el usuario selecciona INTEGRAL DE CONSORCIO WEB desde el json")
    public void elUsuarioSeleccionaINTEGRALDECONSORCIOWEBDesdeElJson() {
        commonPage.seleccionarArticulo(dataIntegralConsorcio.getArticulo());
    }

    @And("el usuario realiza la cotizacion de INTEGRAL DE CONSORCIO")
    public void elUsuarioRealizaLaCotizacionDeINTEGRALDECONSORCIO() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataIntegralConsorcio.getCliente());
        commonPage.seleccionarIva(dataIntegralConsorcio.getDatosDelCliente().getIva());
        commonPage.seleccionarTipoDePersona(dataIntegralConsorcio.getDatosDelCliente().getTipoDePersona());

        commonPage.clickBotonContinuar();

        commonPage.seleccionarProvincia(dataIntegralConsorcio.getDatosDelBien().getProvincia());
        commonPage.seleccionarLocalidad(dataIntegralConsorcio.getDatosDelBien().getLocalidad());

        commonPage.clickBotonContinuar();

        commonPage.completarCoberturas(dataIntegralConsorcio.getCobertura());

        commonPage.clickBotonCotizar();

        Integer variacion = dataIntegralConsorcio.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotizacion de INTEGRAL DE CONSORCIO")
    public void elUsuarioEnviaLaCotizacionDeINTEGRALDECONSORCIO() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataIntegralConsorcio.getVariacion());
        commonPage.validarResumenActualizado();

        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIntegralConsorcio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIntegralConsorcio.getEmision().getTarjeta().getNumero());
        commonPage.ingresarVencimiento(dataIntegralConsorcio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIntegralConsorcio.getEmision().getDomicilio());

        commonPage.clickBotonEnviar();
    }
}
