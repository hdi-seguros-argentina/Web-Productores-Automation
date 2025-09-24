package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static locators.GenericLocators.BORRARFILTROS1_BTN_XPATH;
import static locators.HomeLocators.*;

public class HomePage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_BLANCO = "rgb(255, 255, 255)";
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta
    public static final String FUENTE_BASE = "Montserrat, sans-serif";

    public void IngresoHome() {
        auto_waitForLoadStates(LoadState.DOMCONTENTLOADED);
        auto_waitForElementInvisibility("(//div[contains(@class,'ant-skeleton')])[1]");
    }

    public void seleccionIntermediario() {
        page.get().waitForTimeout(50000);
        auto_setTextToInput(NAME_INPUT_XPATH, "Ortuondo");
        auto_setClickElement(FILTER_BTN_XPATH);

        auto_setClickElement(SELECT_BTN_XPATH);
        auto_setClickElement(CONFIRM_BTN_XPATH);
    }

    public void ingresoPanelInicio() {
        auto_verifyVisibility(PANEL_TITLE_XPATH);
        page.get().waitForTimeout(500);
        auto_waitForElementVisibility(CONTENT_MODAL_XPATH);
        page.get().waitForTimeout(500);
        auto_setClickElement(CHECKBOX_INPUT_XPATH);
        auto_setClickElement(ACEPT_BTN_XPATH);
        auto_waitForLoadStates(LoadState.NETWORKIDLE);
    }

    public void validarHeader() {
        auto_waitForElementVisibility(HEADER_BAR_XPATH);
        Locator fondo = page.get().locator(HEADER_BAR_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(fondo, "background-color"))
                .as("Background de header incorrecto")
                .contains(COLOR_1);
        softAssertions.assertAll();
    }

    public void validarBotonBorrarFiltrosActivo() {
        auto_setTextToInput(NAME_INPUT_XPATH, "Ortuondo");
        page.get().waitForTimeout(1000);
        Locator boton = page.get().locator(BORRARFILTROS1_BTN_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Seleccionar incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Seleccionar incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Seleccionar incorrecto")
                .isEqualTo(COLOR_BLANCO);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Seleccionar incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }
}