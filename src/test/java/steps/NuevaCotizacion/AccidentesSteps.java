package steps.NuevaCotizacion;

import io.cucumber.java.en.And;
import models.CotizacionAccidentes;
import models.Persona;
import pages.NuevaCotizacion.AccidentePage;
import Utils.JsonLoader;
import pages.CommonPage;

public class AccidentesSteps{
    AccidentePage accidentePage = new AccidentePage();
    CommonPage commonPage = new CommonPage();
    private CotizacionAccidentes dataAccidentes =
            JsonLoader.load(
                    "Datos/Cotizacion_accidentes.json",
                    CotizacionAccidentes.class
            );

    @And("el usuario selecciona ACCIDENTES desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        commonPage.seleccionarRama(dataAccidentes.getRama());
    }

    @And("el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        commonPage.seleccionarArticulo(dataAccidentes.getArticulo());
    }

    @And("el usuario realiza la cotización de ACCIDENTES PERSONALES COLECTIV")
    public void elUsuarioRealizaLaCotizacionDeACCIDENTESPERSONALESCOLECTIV() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataAccidentes.getCliente());
        commonPage.clickBotonContinuar();

        commonPage.seleccionarPlan(dataAccidentes.getPlan());
        accidentePage.seleccionarActividad(dataAccidentes.getActividad());
        accidentePage.ingresarCantidad(dataAccidentes.getCantidadPersonas());
        commonPage.completarCoberturas(dataAccidentes.getCobertura());

        commonPage.clickBotonCotizar();
    }

    @And("el usuario modifica la variación de ACCIDENTES PERSONALES COLECTIV desde el json")
    public void elUsuarioModificaLaVariacionDeACCIDENTESPERSONALESCOLECTIVDesdeElJson() {
        Integer variacion = dataAccidentes.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotización de ACCIDENTES PERSONALES COLECTIV con persistencia de comisión")
    public void elUsuarioEnviaLaCotizacionDeACCIDENTESPERSONALESCOLECTIV() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataAccidentes.getVariacion());
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAccidentes.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAccidentes.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataAccidentes.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataAccidentes.getEmision().getTarjeta().getVencimiento());
        for (Persona persona : dataAccidentes.getPersonas()) {
            accidentePage.agregarPersona(persona);
            commonPage.clickBotonGuardar();
        }
        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de ACCIDENTES PERSONALES COLECTIV")
    public void elUsuarioEmiteLaCotizacionDeACCIDENTESPERSONALESCOLECTIVSinValidarVariacion() {
        commonPage.clickEditarCotizacion();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAccidentes.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAccidentes.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataAccidentes.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataAccidentes.getEmision().getTarjeta().getVencimiento());
        for (Persona persona : dataAccidentes.getPersonas()) {
            accidentePage.agregarPersona(persona);
            commonPage.clickBotonGuardar();
        }
        commonPage.clickBotonEnviar();
    }

    @And("el usuario emite la cotización de ACCIDENTES PERSONALES COLECTIV validando variación de comisión")
    public void elUsuarioValidaLaVariacionDeACCIDENTESPERSONALESCOLECTIV() {
        commonPage.clickEditarCotizacion();
        commonPage.seleccionarMetodoPago("DEB BANCARIO 1 CUOTA AP");
        commonPage.validarSubaYBajaDeComisionYExtraPrima(dataAccidentes.getVariacion());
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAccidentes.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAccidentes.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataAccidentes.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataAccidentes.getEmision().getTarjeta().getVencimiento());
        for (Persona persona : dataAccidentes.getPersonas()) {
            accidentePage.agregarPersona(persona);
            commonPage.clickBotonGuardar();
        }
        commonPage.clickBotonEnviar();
    }

    @And("el usuario envia la cotización de ACCIDENTES PERSONALES COLECTIV sin guardar")
    public void elUsuarioEnviaLaCotizacionDeACCIDENTESPERSONALESCOLECTIVSinGuardar() {
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAccidentes.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAccidentes.getEmision().getTarjeta().getNumero());
        commonPage.seleccionarEmpresaTarjeta(dataAccidentes.getEmision().getTarjeta().getCredito());
        commonPage.ingresarVencimiento(dataAccidentes.getEmision().getTarjeta().getVencimiento());
        for (Persona persona : dataAccidentes.getPersonas()) {
            accidentePage.agregarPersona(persona);
            commonPage.clickBotonGuardar();
        }
        commonPage.clickBotonEnviar();
    }
}

