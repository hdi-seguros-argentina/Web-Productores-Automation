package steps;

import io.cucumber.java.en.And;
import pages.CobranzasPage;

public class CobranzasSteps {
    CobranzasPage cobranzasPage = new CobranzasPage();

    @And("el usuario ingresa a la pantalla de {string}")
    public void elUsuarioIngresaALaPantallaDe(String arg0) {
        cobranzasPage.ingresoPantalla(arg0);
    }

    @And("el usuario verifica que step {string} está activo en el stepper")
    public void elUsuarioVerificaQueStepEstáActivoEnElStepper(String arg0) {
        cobranzasPage.verificaStepActivo(arg0);
    }
}