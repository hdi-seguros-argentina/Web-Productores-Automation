package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;
import static locators.CuentaCorrienteLocators.*;

public class CuentaCorrientePage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta1

    public void clicCassillaSeleccion(){
        auto_waitForElementVisibility(CHECKBOX_BTN_XPATH);
        auto_setClickElement(CHECKBOX_BTN_XPATH);
    }

    public void validarCheck(){
        Locator check = page.get().locator(CHECKBOX1_BTN_XPATH).first();
        softAssertions.assertThat(auto_getCssValue(check, "background-color"))
                .as("Color de background de checkbox incorrecto")
                .isEqualTo(COLOR_1);
    }
}