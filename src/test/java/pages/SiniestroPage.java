package pages;

import com.core.utility.MasterPage;
import static locators.SiniestroLocators.*;

public class SiniestroPage extends MasterPage {

    public void seleccionDeBusqueda(String arg0) {
        page.get().waitForTimeout(500);
        auto_setClickElement(String.format(BUSQUEDA_BTN_XPATH, arg0));
    }
}