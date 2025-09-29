package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.assertj.core.api.SoftAssertions;
import static locators.CobranzasLocators.*;

public class CobranzasPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_3 = "rgb(0, 91, 187)";      //Azul
    public void ingresoPantalla(String arg0) {
        auto_waitForLoadStates(LoadState.DOMCONTENTLOADED);
        auto_waitForElementVisibility(String.format(TITLE_GENERIC_XPATH, arg0));
    }

    public void verificaStepActivo(String arg0){
        Locator check = page.get().locator(String.format(STEP_GENERIC_XPATH, arg0)).first();
        softAssertions.assertThat(auto_getCssValue(check, "background-color"))
                .as("Color de background de step-boton incorrecto")
                .isEqualTo(COLOR_3);
    }
}