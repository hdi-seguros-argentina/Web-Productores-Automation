package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import static locators.CommonLocators.*;

public class IncendioPage extends MasterPage {

    public void seleccionarRubro(String rubro) {
        page.get().waitForTimeout(1000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Rubro"));
        auto_setClickElement(String.format(SELECT_OPCION, rubro));
    }
}
