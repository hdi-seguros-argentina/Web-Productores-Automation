package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.assertj.core.api.SoftAssertions;
import static locators.HomeLocators.*;

public class HomePage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta

    public void IngresoHome() {
        auto_waitForLoadStates(LoadState.DOMCONTENTLOADED);
        auto_waitForElementInvisibility("(//div[contains(@class,'ant-skeleton')])[1]");
    }

    public void seleccionIntermediario() {
        auto_waitForElementVisibility("//*[text()='1 / 76018']");
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

    public void ingresarValor(String arg0) {
        auto_waitForElementVisibility("//*[text()='1 / 76018']");
        auto_setTextToInput(NAME_INPUT_XPATH, arg0);
        auto_setClickElement(FILTER_BTN_XPATH);
    }
}