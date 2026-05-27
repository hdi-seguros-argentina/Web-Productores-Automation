package steps;

import Utils.JsonLoader;
import io.cucumber.java.en.*;
import models.Siniestro;
import pages.ProduccionPage;
import pages.SiniestroPage;

public class SiniestroSteps {
    SiniestroPage siniestroPage = new SiniestroPage();

    Siniestro dataAutomoviles =
            JsonLoader.load("Datos/siniestro_automoviles.json",
                    Siniestro.class);
    Siniestro dataAutosRespCivil =
            JsonLoader.load("Datos/siniestro_autos_resp_civil.json",
                    Siniestro.class);
    Siniestro dataSiniestroActual;

    @And("el usuario selecciona {string}")
    public void elUsuarioSelecciona(String arg0) {
        siniestroPage.seleccionDeBusqueda(arg0);
    }

    @And("el usuario verifica que el radio-boton {string} es correcto")
    public void elUsuarioVerificaQueElRadioBotonEsCorrecto(String arg0) {
        siniestroPage.verificaRadioBotonCorrecto(arg0);
    }

    @And("el usuario completa la busqueda de póliza vigente del ramo {string}")
    public void elUsuarioCompletaLaBusquedaDePolizaVigenteDelRamo(String ramo) {
        siniestroPage.completarBusquedaPorPolizaVigente(ramo);
    }

    @And("el usuario busca una poliza vigente")
    public void elUsuarioBuscaUnaPolizaVigente() {
        siniestroPage.buscarYGuardarPolizaVigente(ProduccionPage.getUltimoRamoSeleccionado());
    }

    @And("el usuario genera un siniestro de AUTOMOVILES")
    public void elUsuarioGeneraUnSiniestroDeAutomoviles() {
        dataAutomoviles = JsonLoader.load("Datos/siniestro_automoviles.json", Siniestro.class);
        dataSiniestroActual = dataAutomoviles;
        siniestroPage.iniciarDenuncia();
        siniestroPage.completarFechaYLugar(dataAutomoviles.getFechaLugar());
        siniestroPage.completarConductor(dataAutomoviles.getConductor());
        siniestroPage.completarAseguradoYTipoSiniestro(dataAutomoviles.getTipoSiniestro());
        siniestroPage.completarTercerosOtrosVehiculos(dataAutomoviles.getTercero());
        siniestroPage.finalizarDenuncia();
    }

    @And("el usuario genera un siniestro de AUTOS - RESP. CIVIL")
    public void elUsuarioGeneraUnSiniestroDeAutosRespCivil() {
        dataAutosRespCivil = JsonLoader.load("Datos/siniestro_autos_resp_civil.json", Siniestro.class);
        dataSiniestroActual = dataAutosRespCivil;
        siniestroPage.iniciarDenuncia();
        siniestroPage.completarFechaYLugar(dataAutosRespCivil.getFechaLugar());
        siniestroPage.completarConductor(dataAutosRespCivil.getConductor());
        siniestroPage.completarAseguradoYTipoSiniestro(dataAutosRespCivil.getTipoSiniestro());
        siniestroPage.completarTercerosOtrosVehiculos(dataAutosRespCivil.getTercero());
        siniestroPage.finalizarDenunciaConPasoIntermedio();
    }

    @Then("el usuario verifica que la denuncia fue registrada correctamente")
    public void elUsuarioVerificaQueLaDenunciaFueRegistradaCorrectamente() {
        siniestroPage.verificarDenunciaRegistrada(dataSiniestroActual);
    }
}
