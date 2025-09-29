package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;

import static locators.SiniestroLocators.*;

public class SiniestroPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta1
    public void seleccionDeBusqueda(String arg0) {
        page.get().waitForTimeout(500);
        auto_setClickElement(String.format(BUSQUEDA_BTN_XPATH, arg0));
    }

    public void verificaRadioBotonCorrecto(String arg0){
        Locator check = page.get().locator(String.format(RADIO_BTN_XPATH, arg0)).first();
        softAssertions.assertThat(auto_getCssValue(check, "background-color"))
                .as("Color de background de radio-boton incorrecto")
                .isEqualTo(COLOR_1);
    }
}