package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;
import static locators.LoginLocators.*;

public class LoginPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_NEGRO         = "rgba(0, 0, 0, 0.88)";
    public static final String COLOR_GRIS          = "rgb(110, 110, 110)";
    public static final String COLOR_VERDE_OSCURO  = "rgb(101, 165, 24)";
    public static final String COLOR_VERDE_CLARO1  = "rgb(0, 103, 41)";
    public static final String COLOR_VERDE_CLARO   = "rgb(208, 228, 185)";
    public static final String COLOR_BLANCO        = "rgb(255, 255, 255)";
    public static final String FUENTE_BASE         = "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto";

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
        auto_waitForElementVisibility(HOME3_TITLE_XPATH);
        auto_verifyVisibility(HOME3_TITLE_XPATH);
        auto_waitForElementVisibility(HOME2_TITLE_XPATH);
        auto_verifyVisibility(HOME2_TITLE_XPATH);
    }

    public void logoCorrecto(){

    }
    public void inputUser() {
        auto_waitForElementVisibility(USUARIO1_INPUT_XPATH);
        Locator input = page.get().locator(USUARIO1_INPUT_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input login incorrecto")
                .contains(COLOR_NEGRO);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input login incorrecto")
                .contains(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "background-color"))
                .as("Background input login incorrecto")
                .contains(COLOR_BLANCO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input login incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void inputPass() {
        auto_waitForElementVisibility(PASSWORD1_INPUT_XPATH);
        Locator input = page.get().locator(PASSWORD1_INPUT_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input pass incorrecto")
                .contains(COLOR_NEGRO);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input pass incorrecto")
                .contains(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "background-color"))
                .as("Background input pass incorrecto")
                .contains(COLOR_BLANCO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input pass incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void botonLogin() {
        auto_waitForElementVisibility(LOGIN_BTN1_XPATH);
        Locator boton = page.get().locator(LOGIN_BTN1_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón login incorrecto")
                .contains(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón login incorrecto")
                .contains(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón login incorrecto")
                .contains(COLOR_VERDE_CLARO);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón login incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void botonRecuperarContraseña() {
        auto_waitForElementVisibility(PASS_BTN1_XPATH);
        Locator texto = page.get().locator(PASS_BTN1_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(texto, "color"))
                .as("Color de texto en boton recuperar contraseña incorrecto en el elemento [%s]")
                .contains(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(texto, "font-family"))
                .as("Fuente de boton recuperar contraseña incorrecta en el elemento [%s]")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }
}