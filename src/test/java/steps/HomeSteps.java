package steps;
import io.cucumber.java.en.*;
import pages.GenericPage;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage();
    GenericPage genericPage = new GenericPage();

    @Given("el usuario ingresa a la home")
    public void elUsuarioIngresaALaHome() {
        homePage.IngresoHome();
    }

    @And("el usuario verifica que el titulo {string} es correcto")
    public void elUsuarioVerificaQueElTituloEsCorrecto(String arg0) {
        genericPage.verificaTitulo(arg0);
    }

    @And("el usuario verifica que el subtitulo {string} es correcto")
    public void elUsuarioVerificaQueElSubTituloEsCorrecto(String arg0) {
        genericPage.verificaSubTitulo(arg0);
    }
    @When("el usuario selecciona un intermediario")
    public void elUsuarioSeleccionaUnIntermediario() {
        homePage.seleccionIntermediario();
    }

    @Then("el usuario verifica que el sistema muestra el panel de inicio")
    public void elUsuarioVerificaQueElSistemaMuestraElPanelDeInicio() {
        homePage.ingresoPanelInicio();
    }

    @When("el usuario se posiciona en la pantalla de home")
    public void elUsuarioSePosicionaEnLaPantallaDeHome() {
    }

    @Then("el usuario verifica que el header el correcto")
    public void elUsuarioVerificaQueElHeaderElCorrecto() {
        homePage.validarHeader();
    }

    @And("el usuario ingresa {string} en el input")
    public void elUsuarioIngresaEnElInput(String arg0) {
        homePage.ingresarValor(arg0);
    }

    @And("el usuario verifica que los iconos de {string} son correcto")
    public void elUsuarioVerificaQueLosIconosDeSonCorrecto(String arg0) {
        genericPage.validarIconos(arg0);
    }

    @And("el usuario verifica que el paginado de {string} es correcto")
    public void elUsuarioVerificaQueElPaginadoDeEsCorrecto(String arg0) {
        genericPage.verificarPaginado(arg0);

    }
}