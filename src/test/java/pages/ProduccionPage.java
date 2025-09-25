package pages;
import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;
import java.util.List;

import static locators.GenericLocators.*;
import static locators.ProduccionLocators.*;
public class ProduccionPage extends MasterPage {

    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_BLANCO        = "rgb(255, 255, 255)";
    public static final String COLOR_1             = "rgb(227, 32, 94)";     //Magenta1
    public static final String COLOR_4             = "rgb(252, 232, 239)";   //Magenta3
    public static final String COLOR_5             = "rgb(255, 233, 233)";   //Magenta4
    public static final String COLOR_3             = "rgb(0, 91, 187)";      //Azul
    public static final String COLOR_TRANSPARENTE  = "rgba(0, 0, 0, 0)";
    public static final String FUENTE_BASE         = "Montserrat, sans-serif";

    public void ingresaListadoPolizas() {
        auto_setClickElement(PRODUCCION_MENU_XPATH);
        auto_setClickElement(LISTADOPOLIZAS_MENU_XPATH);
    }

    public void validarBotonBorrarFiltrosActivo(String arg0){
        auto_setTextToInput(ASEGURADO1_INPUT_XPATH, "Ortuondo");
        page.get().waitForTimeout(500);
        Locator boton = page.get().locator(String.format(BORRARFILTROS1_BTN_XPATH, arg0)).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Borrar Filtros Activo incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Borrar Filtros Activo incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Borrar Filtros Activo incorrecto")
                .isEqualTo(COLOR_BLANCO);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Borrar Filtros Activo incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarIconosAccesoDirecto() {
        page.get().waitForTimeout(1000);
        List<Locator> iconos = page.get().locator(ACCESODIRECTO_ICONS_XPATH).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as(STR."Color de icono en posición [\{i}] incorrecto")
                    .isEqualTo(COLOR_1);
        }
        softAssertions.assertAll();
    }

    public void seleccionRamo(String arg0){
        auto_setClickElement(RAMO_DESPLEGABLE_XPATH);
        auto_setClickElement(String.format(RAMO_DESPLEGABLE1_XPATH, arg0));
    }

    public void ingresoNumeroPoliza(String arg0){
        auto_setClickElement(NUMERPOLIZA_INPUT1_XPATH);
        auto_setTextToInput(NUMERPOLIZA_INPUT1_XPATH, arg0);
    }

    public void seleccionFecha(String arg0){
        auto_setClickElement(FECHA_DESPLEGABLE_XPATH);
        auto_setTextToInput(FECHA_DESPLEGABLE1_XPATH, arg0);
    }

    public void clickBoton(String arg0){
        auto_waitForElementVisibility(String.format(GENERIC_BOTON_XPATH, arg0));
        page.get().waitForTimeout(500);
        auto_setClickElement(String.format(GENERIC_BOTON_XPATH, arg0));
    }

    public void verificaBotonPoliza(){
        page.get().waitForTimeout(500);
        Locator boton = page.get().locator(POLIZA_BTN_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Poliza incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Poliza incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Poliza incorrecto")
                .isEqualTo(COLOR_4);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Poliza incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void verificaBotonPolizaActivo(){
        Locator boton = page.get().locator(POLIZA_BTN_XPATH).first();
        boton.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Poliza Activo incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Poliza Activo incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Poliza Activo incorrecto")
                .isEqualTo(COLOR_5);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Poliza Activo incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void verificaIconoInfo(){
        Locator boton = page.get().locator(INFO_BTN_XPATH).first();
        boton.click();
        page.get().waitForTimeout(1000);

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón info incorrecto")
                .isEqualTo(COLOR_3);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón info incorrecto")
                .isEqualTo(COLOR_3);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón info incorrecto")
                .isEqualTo(COLOR_TRANSPARENTE);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón info incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void verificaPanel(String args){
        Locator boton = page.get().locator(String.format(POLIZA_PANEL_XPATH, args)).first();
        boton.click();
        page.get().waitForTimeout(1000);

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto panel derecho incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background panel derecho incorrecto")
                .isEqualTo(COLOR_TRANSPARENTE);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente panel derecho incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void ingresarAWeb(String arg0, String arg1){
        auto_setClickElement(String.format(GENERIC_MENU_XPATH, arg1));
        auto_setClickElement(String.format(GENERIC_SUBMENU_XPATH, arg0));
    }
}