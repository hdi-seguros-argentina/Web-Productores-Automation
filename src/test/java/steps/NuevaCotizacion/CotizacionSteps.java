package steps.NuevaCotizacion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;

public class CotizacionSteps {
    CommonPage commonPage = new CommonPage();

    @And("el usuario guarda la cotización")
    public void elUsuarioGuardaCotizacion() {
        commonPage.guardarCotizacion();
    }

    @Then("el usuario verifica el envío de la cotización")
    public void elUsuarioVerificaElEnvioDeLaCotizacion() {
        commonPage.verificaEnvioCotizacion();
    }
}
