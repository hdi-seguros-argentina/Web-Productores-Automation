package steps;

import io.cucumber.java.en.*;
import pages.CotizadorPage;

public class CotizadorSteps {
    CotizadorPage cotizadorPage = new CotizadorPage();
    @And("el usuario selecciona {string} en grupo")
    public void elUsuarioSeleccionaEnGrupo(String arg0) {
        cotizadorPage.seleccionarValor(arg0);
    }
}