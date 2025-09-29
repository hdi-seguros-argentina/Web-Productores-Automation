package steps;

import io.cucumber.java.en.*;
import pages.SiniestroPage;
public class SiniestroSteps {
    SiniestroPage siniestroPage = new SiniestroPage();

    @And("el usuario selecciona {string}")
    public void elUsuarioSelecciona(String arg0) {
        siniestroPage.seleccionDeBusqueda(arg0);
    }

    @And("el usuario verifica que el radio-boton {string} es correcto")
    public void elUsuarioVerificaQueElRadioBotonEsCorrecto(String arg0) {
        siniestroPage.verificaRadioBotonCorrecto(arg0);
    }
}