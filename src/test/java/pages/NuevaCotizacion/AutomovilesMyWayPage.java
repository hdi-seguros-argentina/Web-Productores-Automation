package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import models.InformacionAdicionalAutomoviles;

import static locators.AutomovilesLocators.*;

public class AutomovilesMyWayPage extends MasterPage {
    public void completarInformacionAdicional(InformacionAdicionalAutomoviles informacionAdicional) {
        page.get().waitForTimeout(1000);
        auto_setClickElement(String.format(CONDUCTOR_MENOR_30_RADIO_MYWAY, informacionAdicional.getConductorMenor30()));
        auto_setClickElement(String.format(HIJOS_MENORES_RADIO_MYWAY, informacionAdicional.getHijosMenores()));
        auto_setClickElement(String.format(GUARDA_GARAGE_RADIO_MYWAY, informacionAdicional.getGuardaGarage()));
        page.get().waitForTimeout(1000);
    }
}
