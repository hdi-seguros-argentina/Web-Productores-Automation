package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import static locators.CommonLocators.*;

public class HogarPage extends MasterPage {

    public void seleccionarPlan(String plan) {
        page.get().waitForTimeout(1000);

        auto_waitForElementVisibility(PLAN_SELECT);
        auto_setClickElement(PLAN_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, plan));
    }

    public void seleccionarTipoVivienda(String tipoVivienda) {
        auto_setClickElement(TIPO_VIVIENDA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, tipoVivienda));
    }
}

