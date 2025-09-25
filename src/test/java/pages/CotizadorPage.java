package pages;

import com.core.utility.MasterPage;
import static locators.CotizadorLocators.*;

public class CotizadorPage extends MasterPage {
    public void seleccionarValor(String arg0){
        auto_setClickElement(String.format(ACCPERSONALES_BTN_XPATH, arg0));
    }
}