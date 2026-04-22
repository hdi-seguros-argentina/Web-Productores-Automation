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
                    "Datos/cotizacion_accidentes.json",
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

    @And("el usuario realiza la cotizacion de ACCIDENTES PERSONALES COLECTIV")
    public void elUsuarioRealizaLaCotizacionDeACCIDENTESPERSONALESCOLECTIV() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataAccidentes.getCliente());
        commonPage.clickBotonContinuar();

        commonPage.seleccionarPlan(dataAccidentes.getPlan());
        accidentePage.seleccionarActividad(dataAccidentes.getActividad());
        accidentePage.ingresarCantidad(dataAccidentes.getCantidadPersonas());
        accidentePage.ingresarCoberturaMuerte(dataAccidentes.getCobertura().getMuerte());

        commonPage.clickBotonCotizar();

        Integer variacion = dataAccidentes.getVariacion();
        commonPage.guardarValoresAntesDeVariacion();
        commonPage.validarCambioVariacion(variacion);

        commonPage.clickBotonRecotizar();
    }

    @And("el usuario envia la cotizacion de ACCIDENTES PERSONALES COLECTIV")
    public void elUsuarioEnviaLaCotizacionDeACCIDENTESPERSONALESCOLECTIV() {
        commonPage.clickEditarCotizacion();
        commonPage.validarVariacionPersistida(dataAccidentes.getVariacion());
        commonPage.validarResumenActualizado();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAccidentes.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAccidentes.getEmision().getTarjeta().getNumero());
        commonPage.ingresarVencimiento(dataAccidentes.getEmision().getTarjeta().getVencimiento());
        for (Persona persona : dataAccidentes.getPersonas()) {
            accidentePage.agregarPersona(persona);
            commonPage.clickBotonGuardar();
        }
        commonPage.clickBotonEnviar();
    }
}
