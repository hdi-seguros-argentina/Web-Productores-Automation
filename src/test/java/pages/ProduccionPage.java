package pages;
import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;
import java.util.List;

import static locators.HomeLocators.BORRARFILTROS1_BTN_XPATH;
import static locators.ProduccionLocators.*;
public class ProduccionPage extends MasterPage {

    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_NEGRO = "rgba(0, 0, 0, 0.88)";
    public static final String COLOR_GRIS = "rgb(110, 110, 110)";
    public static final String COLOR_VERDE_OSCURO = "rgb(101, 165, 24)";
    public static final String COLOR_VERDE_CLARO1 = "rgb(0, 103, 41)";
    public static final String COLOR_TRANSPARENTE = "rgba(0, 0, 0, 0)";
    public static final String FUENTE_BASE = "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto";

    public void ingresaListadoPolizas() {
        auto_setClickElement(PRODUCCION_MENU_XPATH);
        auto_setClickElement(LISTADOPOLIZAS_MENU_XPATH);
    }

    public void validarInputAsegurado() {
        auto_waitForElementVisibility(ASEGURADO_INPUT_XPATH);
        Locator input = page.get().locator(ASEGURADO_INPUT_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input nombre incorrecto")
                .isEqualTo(COLOR_NEGRO);

        softAssertions.assertThat(auto_getCssValue(input, "border-bottom-color"))
                .as("Borde input nombre incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input nombre incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarDesplegableRamo() {
        auto_waitForElementVisibility(RAMO_DESPLEGABLE_XPATH);
        Locator input = page.get().locator(RAMO_DESPLEGABLE_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input nombre incorrecto")
                .isEqualTo(COLOR_GRIS);

        softAssertions.assertThat(auto_getCssValue(input, "border-bottom-color"))
                .as("Borde input nombre incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input nombre incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarInputNumeroPoliza() {
        Locator input = page.get().locator(NUMERPOLIZA_INPUT_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input cuit incorrecto")
                .isEqualTo(COLOR_NEGRO);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input cuit incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input cuit incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarDesplegableProductor() {
        Locator input = page.get().locator(PRODUCTOR_DESPLEGABLE_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input codigo interno incorrecto")
                .isEqualTo(COLOR_GRIS);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input codigo interno incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input codigo interno incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarDesplegableFecha() {
        Locator input = page.get().locator(FECHA_DESPLEGABLE_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input nivel incorrecto")
                .isEqualTo(COLOR_GRIS);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input nivel incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input nivel incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarDesplegableEstado() {
        Locator input = page.get().locator(ESTADO_DESPLEGABLE_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input nivel incorrecto")
                .isEqualTo(COLOR_GRIS);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input nivel incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input nivel incorrecta")
                .contains(FUENTE_BASE);
    }

    public void validarDesplegableAntiguedad() {
        Locator input = page.get().locator(ANTIGUEDAD_DESPLEGABLE_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input nivel incorrecto")
                .isEqualTo(COLOR_NEGRO);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input nivel incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input nivel incorrecta")
                .contains(FUENTE_BASE);
    }

    public void validarBotonBorrarFiltros() {
        Locator boton = page.get().locator(BORRARFILTROS1_BTN_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Borrar Filtros incorrecto")
                .isEqualTo(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Borrar Filtros incorrecto")
                .isEqualTo(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Borrar Filtros incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarBotonBorrarFiltrosActivo(){
        auto_setTextToInput(ASEGURADO1_INPUT_XPATH, "Ortuondo");
        page.get().waitForTimeout(500);
        Locator boton = page.get().locator(BORRARFILTROS1_BTN_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Seleccionar incorrecto")
                .isEqualTo(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Seleccionar incorrecto")
                .isEqualTo(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Seleccionar incorrecto")
                .isEqualTo(COLOR_TRANSPARENTE);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Seleccionar incorrecta")
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
                    .isEqualTo(COLOR_VERDE_CLARO1);
        }
        softAssertions.assertAll();
    }

    public void validarBotonAcciones() {
        page.get().waitForTimeout(500);
        Locator botones = page.get().locator(SELECT1_BTN_XPATH);

        int total = botones.count();
        for (int i = 0; i < total; i++) {
            Locator boton = botones.nth(i);

            softAssertions.assertThat(auto_getCssValue(boton, "color"))
                    .as(STR."Color de texto botón Seleccionar incorrecto en posición [\{i}]")
                    .isEqualTo(COLOR_VERDE_CLARO1);

            softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                    .as(STR."Borde botón Seleccionar incorrecto en posición [\{i}]")
                    .isEqualTo(COLOR_VERDE_CLARO1);

            softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                    .as(STR."Background botón Seleccionar incorrecto en posición [\{i}]")
                    .isEqualTo(COLOR_TRANSPARENTE);

            softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                    .as(STR."Fuente botón Seleccionar incorrecta en posición [\{i}]")
                    .contains(FUENTE_BASE);
        }
        softAssertions.assertAll();
    }

    public void seleccionRamo(String args){
        auto_setClickElement(RAMO_DESPLEGABLE_XPATH);
        auto_setClickElement(String.format(RAMO_DESPLEGABLE1_XPATH, args));
    }

    public void ingresoNumeroPoliza(String args){
        auto_setClickElement(NUMERPOLIZA_INPUT1_XPATH);
        auto_setTextToInput(NUMERPOLIZA_INPUT1_XPATH, args);
    }

    public void seleccionFecha(String args){
        auto_setClickElement(FECHA_DESPLEGABLE_XPATH);
        auto_setTextToInput(FECHA_DESPLEGABLE1_XPATH, args);
    }

    public void clickBoton(String args){
        page.get().waitForTimeout(500);
        auto_waitForElementVisibility(String.format(GENERIC_BOTON_XPATH, args));
        auto_setClickElement(String.format(GENERIC_BOTON_XPATH, args));
    }

    public void verificaBotonPoliza(){

    }

    public void verificaIconoInfo(){

    }

    public void verificaBoton(String args){

    }

    public void verificaTab(String args){

    }

    public void verificaPanel(String args){

    }

    public void verificaTitulo(String args){

    }
}