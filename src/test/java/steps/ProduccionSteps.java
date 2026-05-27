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

    @And("el usuario selecciona el radio Ramo y Numero de Poliza")
    public void elUsuarioSeleccionaElRadioRamoYNumeroDePoliza() {
        produccionPage.seleccionTipoBusquedaRamoNumeroPoliza();
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

    @And("el usuario espera que aparezca el listado de polizas")
    public void elUsuarioEsperaQueAparezcaElListadoDePolizas() {
        produccionPage.esperarQueAparezcaListadoPolizas();
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

    @And("el usuario obtiene una póliza vigente del ramo {string}")
    public void elUsuarioObtieneUnaPolizaVigenteDelRamo(String ramo) {
        produccionPage.guardarPolizaVigenteDelRamoEnJson(ramo);
    }
    @And("el usuario selecciona el acceso directo {string}")
    public void elUsuarioSeleccionaElAccesoDirecto(String accesoDirecto) {
        produccionPage.seleccionarAccesoDirecto(accesoDirecto);
    }

    @Then("el usuario verifica el listado de proximas a vencer")
    public void elUsuarioVerificaElListadoDeProximasAVencer() {
        produccionPage.validarListadoProximasAVencer();
    }

    @Then("el usuario verifica el encabezado del detalle de poliza")
    public void elUsuarioVerificaElEncabezadoDelDetalleDePoliza() {
        produccionPage.validarEncabezadoDetallePoliza();
    }

    @And("el usuario abre la tab de detalle de poliza {string}")
    public void elUsuarioAbreLaTabDeDetalleDePoliza(String tab) {
        produccionPage.abrirTabDetallePoliza(tab);
    }

    @And("el usuario verifica las secciones principales de la tab de detalle {string}")
    public void elUsuarioVerificaLasSeccionesPrincipalesDeLaTabDeDetalle(String tab) {
        produccionPage.validarSeccionesPrincipalesTab(tab);
    }

    @And("el usuario descarga y valida el documento de poliza {string}")
    public void elUsuarioDescargaYValidaElDocumentoDePoliza(String opcionDocumento) throws Exception {
        produccionPage.descargarYValidarDocumentoPoliza(opcionDocumento);
    }
}

