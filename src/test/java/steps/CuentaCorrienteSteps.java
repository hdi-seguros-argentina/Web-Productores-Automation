package steps;

import io.cucumber.java.en.And;
import pages.CuentaCorrientePage;

public class CuentaCorrienteSteps {
    CuentaCorrientePage cuentaCorrientePage = new CuentaCorrientePage();

    @And("el usuario hace clic en la casilla de seleccion")
    public void elUsuarioHaceClicEnLaCasillaDeSeleccion() {
        cuentaCorrientePage.clicCassillaSeleccion();
    }

    @And("el usuario valida que el check es correcto")
    public void elUsuarioValidaQueElCheckEsCorrecto() {
        cuentaCorrientePage.validarCheck();
    }
}