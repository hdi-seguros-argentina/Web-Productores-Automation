package steps;
import io.cucumber.java.en.*;
import pages.ProduccionPage;

public class ProduccionSteps {
    ProduccionPage produccionPage = new ProduccionPage();

    @And("el usuario ingresa al menu de Listado de polizas en Produccion")
    public void elUsuarioIngresaAlMenuDeListadoDePolizasEnProduccion() {
        produccionPage.ingresaListadoPolizas();
    }
    @Then("el usuario verifica que los input Asegurado son correctos")
    public void elUsuarioVerificaQueLosInputAseguradoSonCorrectos() {
        produccionPage.validarInputAsegurado();
    }

    @Then("el usuario verifica que los input Ramo son correctos")
    public void elUsuarioVerificaQueLosInputRamoSonCorrectos() {
        produccionPage.validarDesplegableRamo();
    }

    @Then("el usuario verifica que los input Numero de poliza son correctos")
    public void elUsuarioVerificaQueLosInputNumeroDePolizaSonCorrectos() {
        produccionPage.validarInputNumeroPoliza();
    }

    @Then("el usuario verifica que los input Productor son correctos")
    public void elUsuarioVerificaQueLosInputProductorSonCorrectos() {
        produccionPage.validarDesplegableProductor();
    }

    @Then("el usuario verifica que los input Fecha son correctos")
    public void elUsuarioVerificaQueLosInputFechaSonCorrectos() {
        produccionPage.validarDesplegableFecha();
    }

    @Then("el usuario verifica que los input Estado son correctos")
    public void elUsuarioVerificaQueLosInputEstadoSonCorrectos() {
        produccionPage.validarDesplegableEstado();
    }

    @Then("el usuario verifica que los input Antiguedad son correctos")
    public void elUsuarioVerificaQueLosInputAntiguedadSonCorrectos() {
        produccionPage.validarDesplegableAntiguedad();
    }

    @Then("el usuario verifica que el boton borrar filtros en Listado de polizas es correcto")
    public void elUsuarioVerificaQueElBotonBorrarFiltrosEnListadoDePolizasEsCorrecto() {
        produccionPage.validarBotonBorrarFiltros();
        produccionPage.validarBotonBorrarFiltrosActivo();
    }

    @And("el usuario verifica que los iconos de acceso directo son correctos")
    public void elUsuarioVerificaQueLosIconosDeAccesoDirectoSonCorrectos() {
        produccionPage.validarIconosAccesoDirecto();
    }

    @Then("el usuario verifica que el boton Acciones es correcto")
    public void elUsuarioVerificaQueElBotonAccionesEsCorrecto() {
        produccionPage.validarBotonAcciones();
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
    }

    @And("el usuario verifica que el icono de info es correcto")
    public void elUsuarioVerificaQueElIconoDeInfoEsCorrecto() {
        produccionPage.verificaIconoInfo();
    }

    @And("el usuario verifica que el boton {string} es correcto")
    public void elUsuarioVerificaQueElBotonEsCorrecto(String arg0) {
        produccionPage.verificaBoton(arg0);
    }

    @And("el usuario verifica que el tab {string} es correcto")
    public void elUsuarioVerificaQueElTabEsCorrecto(String arg0) {
        produccionPage.verificaTab(arg0);
    }

    @And("el usuario verifica que el tab {string} del panel de contenido es correcto")
    public void elUsuarioVerificaQueElTabDelPanelDeContenidoEsCorrecto(String arg0) {
        produccionPage.verificaPanel(arg0);
    }

    @And("el usuario verifica que el titulo {string} es correcto")
    public void elUsuarioVerificaQueElTituloEsCorrecto(String arg0) {
        produccionPage.verificaTitulo(arg0);
    }
}