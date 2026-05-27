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
                    "Datos/Cotizacion_IntegralComercio.json",
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

    @And("el usuario realiza la cotización de INTEGRAL DE COMERCIO WEB")
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
    }

    @And("el usuario modifica la variación de INTEGRAL DE COMERCIO WEB desde el json")
    public void elUsuarioModificaLaVariacionDeINTEGRALDECOMERCIOWEBDesdeElJson() {
        Integer variacion = dataIntegralComercio.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotización de INTEGRAL DE COMERCIO WEB")
    public void elUsuarioEnviaLaCotizacionDeINTEGRALDECOMERCIOWEB() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataIntegralComercio.getVariacion());

        commonPage.validarResumenActualizado();

        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIntegralComercio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIntegralComercio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIntegralComercio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIntegralComercio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIntegralComercio.getEmision().getDomicilio());

        InformacionDeContacto contacto = dataIntegralComercio.getInformacionDeContacto();
        commonPage.completarInformacionContacto(contacto);

        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de INTEGRAL DE COMERCIO WEB")
    public void elUsuarioEmiteLaCotizacionDeINTEGRALDECOMERCIOWEB() {
        commonPage.clickEditarCotizacion();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIntegralComercio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIntegralComercio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIntegralComercio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIntegralComercio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIntegralComercio.getEmision().getDomicilio());
        InformacionDeContacto contacto = dataIntegralComercio.getInformacionDeContacto();
        commonPage.completarInformacionContacto(contacto);
        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de INTEGRAL DE COMERCIO WEB validando variación de comisión")
    public void elUsuarioEmiteLaCotizacionDeINTEGRALDECOMERCIOWEBValidandoVariacion() {
        commonPage.clickEditarCotizacion();
        commonPage.validarSubaYBajaDeComisionYExtraPrima(dataIntegralComercio.getVariacion());
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIntegralComercio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIntegralComercio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIntegralComercio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIntegralComercio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIntegralComercio.getEmision().getDomicilio());
        InformacionDeContacto contacto = dataIntegralComercio.getInformacionDeContacto();
        commonPage.completarInformacionContacto(contacto);
        commonPage.clickBotonEnviar();
    }

    @And("el usuario envia la cotización de INTEGRAL DE COMERCIO WEB sin guardar")
    public void elUsuarioEnviaLaCotizacionDeINTEGRALDECOMERCIOWEBSinGuardar() {
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataIntegralComercio.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataIntegralComercio.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataIntegralComercio.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataIntegralComercio.getEmision().getTarjeta().getVencimiento());
        commonPage.ingresarDomicilio(dataIntegralComercio.getEmision().getDomicilio());

        InformacionDeContacto contacto = dataIntegralComercio.getInformacionDeContacto();
        commonPage.completarInformacionContacto(contacto);

        commonPage.clickBotonEnviar();
    }
}


