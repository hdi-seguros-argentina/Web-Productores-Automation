package pages;

import com.core.utility.MasterPage;
import static locators.LoginLocators.*;

public class LoginPage extends MasterPage {

    public void ingresoALaWeb() {
        auto_waitForElementVisibility(HOME_TITLE_XPATH);
        auto_verifyVisibility(HOME_TITLE_XPATH);
    }
    public void ingresaUsuario(String username) {
        auto_setTextToInput(USUARIO_INPUT_XPATH, username);
    }

    public void ingresaContraseña(String password) {
        auto_setTextToInput(PASSWORD_INPUT_XPATH, password);
    }

    public void clickLogin() {
        auto_setClickElement(LOGIN_BTN_XPATH);
    }

    public void verificaLogin() {
        auto_waitForElementVisibility(HOME2_TITLE_XPATH);
        auto_verifyVisibility(HOME2_TITLE_XPATH);
    }

    public void logoCorrecto(){

    }
}