package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static locators.HomeLocators.*;
public class HomePage extends MasterPage {

    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_NEGRO         = "rgba(0, 0, 0, 0.88)";
    public static final String COLOR_GRIS          = "rgb(110, 110, 110)";
    public static final String COLOR_VERDE_OSCURO  = "rgb(101, 165, 24)";
    public static final String COLOR_VERDE_CLARO1  = "rgb(0, 103, 41)";
    public static final String COLOR_VERDE_CLARO   = "rgb(208, 228, 185)";
    public static final String COLOR_BLANCO        = "rgb(255, 255, 255)";
    public static final String COLOR_TRANSPARENTE  = "rgba(0, 0, 0, 0)";
    public static final String COLOR_NARANJA       = "rgb(219, 99, 1)";
    public static final String FUENTE_BASE         = "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto";

    public void IngresoHome() {
        auto_waitForLoadStates(LoadState.NETWORKIDLE);
    }

    public void seleccionIntermediario() {
        auto_waitForElementPresent(NAME_INPUT_XPATH);
        page.get().waitForTimeout(1000);
        auto_setTextToInput(NAME_INPUT_XPATH, "Ortuondo");
        page.get().waitForTimeout(1000);
        auto_setClickElement(FILTER_BTN_XPATH);
        auto_waitForElementVisibility(SELECT_BTN_XPATH);
        auto_setClickElement(SELECT_BTN_XPATH);
        auto_setClickElement(CONFIRM_BTN_XPATH);
    }

    public void ingresoPanelInicio() {
        auto_verifyVisibility(PANEL_TITLE_XPATH);
        page.get().waitForTimeout(1000);
        auto_waitForElementVisibility(CONTENT_MODAL_XPATH);
        page.get().waitForTimeout(1000);
        auto_setClickElement(CHECKBOX_INPUT_XPATH);
        auto_setClickElement(ACEPT_BTN_XPATH);
    }

    public void validarHeader() {
        auto_waitForElementVisibility(HEADER_BAR_XPATH);
        Locator fondo = page.get().locator(HEADER_BAR_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(fondo, "background-color"))
                .as("Background de header incorrecto")
                .contains(COLOR_VERDE_CLARO1);
        softAssertions.assertAll();
    }

    public void validarInputNombre() {
        auto_waitForElementVisibility(NAME1_INPUT_XPATH);
        Locator input = page.get().locator(NAME1_INPUT_XPATH).first();
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

    public void validarInputCuit() {
        Locator input = page.get().locator(CUIT1_INPUT_XPATH).first();
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

    public void validarInputCodigoInterno() {
        Locator input = page.get().locator(CODE1_INPUT_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input codigo interno incorrecto")
                .isEqualTo(COLOR_NEGRO);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input codigo interno incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO);

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input codigo interno incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarInputNivel() {
        Locator input = page.get().locator(NIVEL1_SELECT_XPATH).first();
        input.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(input, "color"))
                .as("Color de texto input nivel incorrecto")
                .isEqualTo(COLOR_GRIS);

        softAssertions.assertThat(auto_getCssValue(input, "border-color"))
                .as("Borde input nivel incorrecto")
                .isEqualTo(COLOR_VERDE_OSCURO); // verde cuando está activo

        softAssertions.assertThat(auto_getCssValue(input, "font-family"))
                .as("Fuente input nivel incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void validarBotonFiltrar() {
        Locator boton = page.get().locator(FILTER1_BTN_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Filtrar incorrecto")
                .contains(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Filtrar incorrecto")
                .contains(COLOR_VERDE_CLARO1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Filtrar incorrecto")
                .contains(COLOR_VERDE_CLARO);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Filtrar incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
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
        auto_setTextToInput(NAME_INPUT_XPATH, "Ortuondo");
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

    public void validarBotonSeleccionar() {
        page.get().waitForTimeout(500);

        Locator boton = page.get().locator(SELECT1_BTN_XPATH).first();

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

    public void verificarIconosPolizasVigentes() {
        page.get().waitForTimeout(1000);
        List<Locator> iconos = page.get().locator(POLIZAS_ICONS_XPATH).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as(STR."Color de icono en posición [\{i}] incorrecto")
                    .isEqualTo(COLOR_VERDE_CLARO1);
        }
        softAssertions.assertAll();
    }

    public void verificarIconosSiniestrosDeununciados() {
        page.get().waitForTimeout(1000);
        List<Locator> iconos = page.get().locator(SINIESTROS_ICONS_XPATH).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as(STR."Color de icono en posición [\{i}] incorrecto")
                    .isEqualTo(COLOR_NARANJA);
        }
        softAssertions.assertAll();
    }

    public void verificarIconosCotizaciones() {
        page.get().waitForTimeout(1000);
        List<Locator> iconos = page.get().locator(COTIZACIONES_ICONS_XPATH).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as(STR."Color de icono en posición [\{i}] incorrecto")
                    .isEqualTo(COLOR_VERDE_CLARO1);
        }
        softAssertions.assertAll();
    }

    public void verificarIconosSiniestrosCartera() {
        page.get().waitForTimeout(1000);
        List<Locator> iconos = page.get().locator(SINIESTROSCARTERA_ICONS_XPATH).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as(STR."Color de icono en posición [\{i}] incorrecto")
                    .isEqualTo(COLOR_NARANJA);
        }
        softAssertions.assertAll();
    }
}