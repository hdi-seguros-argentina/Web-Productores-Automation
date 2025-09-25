package steps;

import io.cucumber.java.en.*;
import pages.SiniestroPage;
public class SiniestroSteps {
    SiniestroPage siniestroPage = new SiniestroPage();

    @And("el usuario selecciona {string} en Buscar por")
    public void elUsuarioSeleccionaEnBuscarPor(String arg0) {
        siniestroPage.seleccionDeBusqueda(arg0);
    }
}