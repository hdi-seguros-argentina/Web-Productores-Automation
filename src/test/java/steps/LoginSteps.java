package steps;

import com.core.utility.MasterPage;
import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    private static final Dotenv dotenv = Dotenv.load();
    public static final ThreadLocal<String> username = new ThreadLocal<>();
    public static final ThreadLocal<String> password = new ThreadLocal<>();
    @Given("el usuario ingresa a la web")
    public void elUsuarioIngresaALaWeb() {
        MasterPage.openUrl();
        loginPage.ingresoALaWeb();
    }

    @When("el usuario ingresa usuario")
    public void elUsuarioIngresaUsuario() {
        username.set(dotenv.get("USER"));
        loginPage.ingresaUsuario(username.get());
    }

    @And("el usuario ingresa contraseña")
    public void elUsuarioIngresaContraseña() {
        password.set(dotenv.get("PASS"));
        loginPage.ingresaContraseña(password.get());
    }

    @And("el usuario hace click en el boton de login")
    public void elUsuarioHaceClickEnElBotonDeLogin() {
        loginPage.clickLogin();
    }

    @Then("el usuario verifica que se logueo correctamente")
    public void elUsuarioVerificaQueSeLogueoCorrectamente() {
        loginPage.verificaLogin();
    }

    @When("el usuario se posiciona en la pantalla de login")
    public void elUsuarioSePosicionaEnLaPantallaDeLogin() {
    }

    @Then("el usuario verifica que el logo es correcto")
    public void elUsuarioVerificaQueElLogoEsCorrecto() {
        loginPage.logoCorrecto();
    }

    @Then("el usuario verifica que el input de user es correcto")
    public void elUsuarioVerificaQueElInputDeUserEsCorrecto() {
        loginPage.inputUser();
    }

    @Then("el usuario verifica que el input de pass es correcto")
    public void elUsuarioVerificaQueElInputDePassEsCorrecto() {
        loginPage.inputPass();
    }

    @Then("el usuario verifica que el boton de login es correcto")
    public void elUsuarioVerificaQueElBotonDeLoginEsCorrecto() {
        loginPage.botonLogin();
    }

    @Then("el usuario verifica que el boton de recuperar contraseña es correcto")
    public void elUsuarioVerificaQueElBotonDeRecuperarContraseñaEsCorrecto() {
        loginPage.botonRecuperarContraseña();
    }
}