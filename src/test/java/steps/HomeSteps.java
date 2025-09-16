package steps;
import io.cucumber.java.en.*;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Given("el usuario ingresa a la home")
    public void elUsuarioIngresaALaHome() {
        homePage.IngresoHome();
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
    @Then("el usuario verifica que los input Nombre son correctos")
    public void elUsuarioVerificaQueLosInputNombreSonCorrectos() {
        homePage.validarInputNombre();
    }

    @Then("el usuario verifica que los input Cuit son correctos")
    public void elUsuarioVerificaQueLosInputCuitSonCorrectos() {
        homePage.validarInputCuit();
    }

    @Then("el usuario verifica que los input Codigo Interno son correctos")
    public void elUsuarioVerificaQueLosInputCodigoInternoSonCorrectos() {
        homePage.validarInputCodigoInterno();
    }

    @Then("el usuario verifica que los input Nivel son correctos")
    public void elUsuarioVerificaQueLosInputNivelSonCorrectos() {
        homePage.validarInputNivel();
    }

    @Then("el usuario verifica que el boton filtrar es correcto")
    public void elUsuarioVerificaQueElBotonFiltrarEsCorrecto() {
        homePage.validarBotonFiltrar();
    }

    @Then("el usuario verifica que el boton borrar filtros es correcto")
    public void elUsuarioVerificaQueElBotonBorrarFiltrosEsCorrecto() {
        homePage.validarBotonBorrarFiltros();
        homePage.validarBotonBorrarFiltrosActivo();
    }

    @Then("el usuario verifica que el boton seleccionar es correcto")
    public void elUsuarioVerificaQueElBotonSeleccionarEsCorrecto() {
        homePage.validarBotonSeleccionar();
    }

    @Then("el usuario verifica que los iconos son correcto")
    public void elUsuarioVerificaQueLosIconosSonCorrecto() {
        homePage.verificarIconosPolizasVigentes();
        homePage.verificarIconosSiniestrosDeununciados();
        homePage.verificarIconosCotizaciones();
        homePage.verificarIconosSiniestrosCartera();
    }
}