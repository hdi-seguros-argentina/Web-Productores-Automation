package steps;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.Preliquidacion;
import pages.CobranzasPage;

public class CobranzasSteps {
    CobranzasPage cobranzasPage = new CobranzasPage();
    Preliquidacion preliquidacion = JsonLoader.load("Datos/preliquidacion.json", Preliquidacion.class);

    @And("el usuario ingresa a la pantalla de {string}")
    public void elUsuarioIngresaALaPantallaDe(String arg0) {
        cobranzasPage.ingresoPantalla(arg0);
    }

    @And("el usuario verifica que step {string} está activo en el stepper")
    public void elUsuarioVerificaQueStepEstaActivoEnElStepper(String arg0) {
        cobranzasPage.verificaStepActivo(arg0);
    }

    @Then("el usuario verifica la pantalla principal de preliquidacion")
    public void elUsuarioVerificaLaPantallaPrincipalDePreliquidacion() {
        cobranzasPage.validarPantallaPrincipalPreliquidacion();
    }

    @And("el usuario filtra preliquidacion por rama desde el json y selecciona una cuota")
    public void elUsuarioFiltraPreliquidacionPorRamaDesdeElJsonYSeleccionaUnaCuota() {
        cobranzasPage.filtrarRamaYSeleccionarPrimeraCuota(preliquidacion.getRama());
    }

    @And("el usuario continua desde principal de preliquidacion")
    public void elUsuarioContinuaDesdePrincipalDePreliquidacion() {
        cobranzasPage.continuarDesdePrincipalPreliquidacion();
    }

    @Then("el usuario verifica la pantalla de cuotas seleccionadas")
    public void elUsuarioVerificaLaPantallaDeCuotasSeleccionadas() {
        cobranzasPage.validarPantallaCuotasSeleccionadas();
    }

    @And("el usuario selecciona la cuota y continua")
    public void elUsuarioSeleccionaLaCuotaYContinua() {
        cobranzasPage.seleccionarCuotaYContinuar();
    }

    @Then("el usuario verifica la pantalla de confirmacion de preliquidacion")
    public void elUsuarioVerificaLaPantallaDeConfirmacionDePreliquidacion() {
        cobranzasPage.validarPantallaConfirmarPreliquidacion();
    }

    @And("el usuario completa la forma de pago de preliquidacion desde el json")
    public void elUsuarioCompletaLaFormaDePagoDePreliquidacionDesdeElJson() {
        cobranzasPage.completarFormaPago(preliquidacion);
    }

    @And("el usuario verifica que la forma de pago fue agregada")
    public void elUsuarioVerificaQueLaFormaDePagoFueAgregada() {
        cobranzasPage.validarFormaPagoAgregada(preliquidacion);
    }

    @And("el usuario confirma el pago de preliquidacion")
    public void elUsuarioConfirmaElPagoDePreliquidacion() {
        cobranzasPage.confirmarPagoPreliquidacion();
    }

    @Then("el usuario verifica que la preliquidacion fue enviada correctamente")
    public void elUsuarioVerificaQueLaPreliquidacionFueEnviadaCorrectamente() {
        cobranzasPage.validarPreliquidacionEnviada();
    }

    @Then("el usuario verifica la tab de preliquidaciones {string} y su filtro por numero")
    public void elUsuarioVerificaLaTabDePreliquidacionesYSuFiltroPorNumero(String tab) {
        cobranzasPage.validarTabPreliquidacionesYFiltro(tab);
    }
}
