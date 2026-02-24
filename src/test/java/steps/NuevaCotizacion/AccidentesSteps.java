package steps.NuevaCotizacion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.CotizacionAccidentes;
import models.Persona;
import pages.NuevaCotizacion.AccidentePage;
import Utils.JsonLoader;

public class AccidentesSteps{

    private AccidentePage accidentePage = new AccidentePage();

    private CotizacionAccidentes dataAccidentes =
            JsonLoader.load(
                    "Datos/cotizacion_accidentes.json",
                    CotizacionAccidentes.class
            );

    @And("el usuario selecciona ACCIDENTES desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        accidentePage.seleccionarRamaAcc(dataAccidentes.getRama());
    }

    @And("el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        accidentePage.seleccionarArticuloAcc(dataAccidentes.getArticulo());
    }

    @And("el usuario inicia la cotizacion")
    public void elUsuarioIniciaLaCotizacion() {
        accidentePage.iniciarCotizacion();
    }

    @And("el usuario busca el cliente de ACCIDENTES desde el json")
    public void elUsuarioBuscaElClienteDesdeElJson() {
        accidentePage.buscarClienteAcc(dataAccidentes.getCliente());
    }

    @And("el usuario completa los datos del plan desde el json")
    public void elUsuarioCompletaLosDatosDelPlanDesdeElJson() {
        accidentePage.seleccionarPlan(dataAccidentes.getPlan());
        accidentePage.seleccionarActividad(dataAccidentes.getActividad());
        accidentePage.ingresarCantidad(dataAccidentes.getCantidadPersonas());
    }

    @And("el usuario completa la cobertura desde el json")
    public void elUsuarioCompletaLaCoberturaDesdeElJson() {
        accidentePage.ingresarCoberturaMuerte(
                dataAccidentes.getCobertura().getMuerte()
        );
    }

    @And("el usuario cotiza y guarda la cotizacion de ACCIDENTES")
    public void elUsuarioCotizaYGuardaLaCotizacion() {
        accidentePage.cotizar();
        accidentePage.guardarCotizacion();
    }

    @And("el usuario emite la cotizacion de ACCIDENTES desde el json")
    public void elUsuarioEmiteLaPolizaDesdeElJson() {
        accidentePage.editarCotizacion();

        accidentePage.emitir();

        accidentePage.seleccionarNacionalidadAcc(dataAccidentes.getEmision().getNacionalidad()
        );

        accidentePage.ingresarNumeroTarjetaAcc(dataAccidentes.getEmision().getTarjeta().getNumero()
        );

        accidentePage.ingresarVencimientoAcc(dataAccidentes.getEmision().getTarjeta().getVencimiento()
        );
    }

    @And("el usuario agrega las personas desde el json")
    public void elUsuarioAgregaLasPersonasDesdeElJson() {

        for (Persona persona : dataAccidentes.getPersonas()) {
            accidentePage.agregarPersona(persona);
            accidentePage.guardar();
        }
    }

    @And("el usuario guarda y envia la poliza")
    public void elUsuarioGuardaYEnviaLaPoliza() {
        accidentePage.enviar();
    }

    @Then("el usuario verifica el envio de la poliza")
    public void elUsuarioVerificaElEnvioDeLaPoliza() {
        accidentePage.envioPoliza();
    }
}