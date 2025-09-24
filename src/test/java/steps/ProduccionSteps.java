package steps;
import io.cucumber.java.en.*;
import pages.GenericPage;
import pages.ProduccionPage;

public class ProduccionSteps {
    ProduccionPage produccionPage = new ProduccionPage();
    GenericPage genericPage = new GenericPage();

    @And("el usuario ingresa al menu de Listado de polizas en Produccion")
    public void elUsuarioIngresaAlMenuDeListadoDePolizasEnProduccion() {
        produccionPage.ingresaListadoPolizas();
    }

    @And("el usuario verifica que los iconos de acceso directo son correctos")
    public void elUsuarioVerificaQueLosIconosDeAccesoDirectoSonCorrectos() {
        produccionPage.validarIconosAccesoDirecto();
    }

    @When("el usuario selecciona {string} en Ramo")
    public void elUsuarioSeleccionaEnRamo(String arg0) {
        produccionPage.seleccionRamo(arg0);
    }

    @And("el usuario selecciona {string} en Número de póliza")
    public void elUsuarioSeleccionaEnNúmeroDePóliza(String arg0) {
        produccionPage.ingresoNumeroPoliza(arg0);
    }

    @And("el usuario selecciona {string} en Fecha")
    public void elUsuarioSeleccionaEnFecha(String arg0) {
        produccionPage.seleccionFecha(arg0);
    }

    @And("el usuario hace clic en el boton {string}")
    public void elUsuarioHaceClicEnElBoton(String arg0) {
        produccionPage.clickBoton(arg0);
    }

    @Then("el usuario verifica que el boton de Poliza es correcto")
    public void elUsuarioVerificaQueElBotonDePolizaEsCorrecto() {
        produccionPage.verificaBotonPoliza();
        produccionPage.verificaBotonPolizaActivo();
    }

    @And("el usuario verifica que el icono de info es correcto")
    public void elUsuarioVerificaQueElIconoDeInfoEsCorrecto() {
        produccionPage.verificaIconoInfo();
    }
    @And("el usuario verifica que la tab {string} es correcta")
    public void elUsuarioVerificaQueLaTabEsCorrecta(String arg0) {
        genericPage.validarTab(arg0);
    }

    @And("el usuario verifica que el tab {string} del panel de contenido es correcto")
    public void elUsuarioVerificaQueElTabDelPanelDeContenidoEsCorrecto(String arg0) {
        produccionPage.verificaPanel(arg0);
    }

    @When("el usuario ingresa al menu de {string} en {string}")
    public void elUsuarioIngresaAlMenuDeEn(String arg0, String arg1) {
        produccionPage.ingresarAWeb(arg0, arg1);
    }

    @And("el usuario verifica que el boton {string} Activo en Listado de polizas es correcto")
    public void elUsuarioVerificaQueElBotonActivoEnListadoDePolizasEsCorrecto(String arg0) {
        produccionPage.validarBotonBorrarFiltrosActivo(arg0);
    }
}