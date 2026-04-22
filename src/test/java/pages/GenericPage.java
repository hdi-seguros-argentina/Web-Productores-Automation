package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;

import java.util.Arrays;
import java.util.List;

import static locators.GenericLocators.*;
import static locators.HomeLocators.GENERIC_TITULO_XPATH;
import static locators.ProduccionLocators.ASEGURADO1_INPUT_XPATH;

public class GenericPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_NEGRO = "rgb(0, 0, 0)";
    public static final String COLOR_NEGRO2 = "rgba(0, 0, 0, 0.88)";
    public static final String COLOR_GRIS = "rgb(110, 110, 110)";
    public static final String COLOR_BORDE_INACTIVO = "rgb(240, 240, 240)";
    public static final String COLOR_GRIS_PLACEHOLDER = "rgb(106, 106, 106)";
    public static final String COLOR_BLANCO = "rgb(255, 255, 255)";
    public static final String COLOR_TRANSPARENTE = "rgba(0, 0, 0, 0)";
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta
    public static final String COLOR_7 = "rgb(232, 69, 121)";    //Magenta claro
    public static final String COLOR_8 = "rgb(217, 217, 217)";   //Gris claro
    public static final String COLOR_3 = "rgb(0, 91, 187)";      //Azul
    public static final String COLOR_GRIS_FONDO_TEMA = "rgb(250, 250, 250)";
    public static final String COLOR_GRIS_TEXTO_TEMA = "rgb(157, 157, 157)";
    public static final String COLOR_NARANJA = "rgb(219, 99, 1)";
    public static final String FUENTE_BASE = "Montserrat, sans-serif";

    public void verificaTitulo(String args) {
        Locator titulo = page.get().locator(String.format(GENERIC_TITULO_XPATH, args)).first();
        softAssertions.assertThat(auto_getCssValue(titulo, "color"))
                .as("Color de texto titulo info incorrecto")
                .isEqualTo(COLOR_NEGRO);
    }

    public void verificaSubTitulo(String args) {
        auto_waitForElementVisibility(String.format(GENERIC_TITULO_XPATH, args));
        Locator titulo = page.get().locator(String.format(GENERIC_TITULO_XPATH, args)).first();
        softAssertions.assertThat(auto_getCssValue(titulo, "color"))
                .as("Color de texto titulo info incorrecto")
                .isEqualTo(COLOR_1);
    }

    public void validarInput(String arg0) {
        String xpath;
        String colorTexto;
        String colorBorde;
        String colorFondo;
        String fuente;
        boolean soloColor = false;

        switch (arg0) {
            case "Ramo":
            case "Estado":
            case "Más reciente primero":
            case "Quincena":
            case "Seleccione un grupo":
            case "ACCIDENTES PERSONALES COLECTIV":
            case "Operación":
            case "76095 - ORTUONDO FERNANDO MARCIO":
            case "ORTUONDO FERNANDO MARCIO (1-76095)":
            case "Siniestro más reciente primero":
            case "Rama":
            case "Articulo":
            case "Productor":
                xpath = GENERIC5_INPUT_XPATH;
                colorTexto = COLOR_NEGRO;
                colorBorde = COLOR_1;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            case "Nível":
                xpath = GENERIC5_INPUT_XPATH;
                colorTexto = COLOR_GRIS;
                colorBorde = COLOR_BORDE_INACTIVO;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            case "Asegurado":
                xpath = ASEGURADO1_INPUT_XPATH;
                colorTexto = COLOR_GRIS_PLACEHOLDER;
                colorBorde = COLOR_1;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                soloColor = true;
                break;

            // GRIS OSCURO
            case "Usuario":
            case "Contraseña":
            case "Bien Siniestrado":
            case "Siniestro":
            case "Patente":
                xpath = GENERIC1_INPUT_XPATH;
                colorTexto = COLOR_NEGRO2;
                colorBorde = COLOR_1;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            case "CUIT":
            case "Código Interno":
            case "Número de póliza":
            case "Número de Cotización":
                xpath = GENERIC2_INPUT_XPATH;
                colorTexto = COLOR_NEGRO2;
                colorBorde = COLOR_1;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            case "Póliza":
            case "Poliza":
            case "Nombre":
            case "Apellido y Nombre":
                xpath = GENERIC3_INPUT_XPATH;
                colorTexto = COLOR_NEGRO2;
                colorBorde = COLOR_1;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            // GRIS
            case "Fecha inicial":
            case "Mes":
            case "Seleccionar fecha":
            case "Seleccionar hora":
                xpath = GENERIC4_INPUT_XPATH;
                colorTexto = COLOR_GRIS;
                colorBorde = COLOR_1;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            case "Año":
                xpath = GENERIC4_INPUT_XPATH;
                colorTexto = COLOR_GRIS;
                colorBorde = COLOR_8;
                colorFondo = COLOR_BLANCO;
                fuente = FUENTE_BASE;
                break;

            default:
                throw new IllegalArgumentException("Input no soportado: " + arg0);
        }
        Locator locator;
        if ("Asegurado".equals(arg0)) {
            Locator aseguradoInput = page.get().locator(String.format(GENERIC1_INPUT_XPATH, arg0)).first();
            Locator aseguradoSelect = page.get().locator(ASEGURADO1_INPUT_XPATH).first();
            locator = (aseguradoInput.count() > 0 && aseguradoInput.isVisible()) ? aseguradoInput : aseguradoSelect;
        } else if ("Articulo".equals(arg0)) {
            // Prioriza el contenedor del input real por placeholder y deja fallback al label.
            Locator articuloInput = page.get().locator(String.format(GENERIC1_INPUT_XPATH, arg0)).first();
            Locator articuloLabel = page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first();
            locator = (articuloInput.count() > 0 && articuloInput.isVisible()) ? articuloInput : articuloLabel;
        } else {
            locator = page.get().locator(String.format(xpath, arg0)).first();
        }
        locator.click();
        if (soloColor) {
            String colorActual = auto_getCssValue(locator, "color");
            if ("Asegurado".equals(arg0)) {
                softAssertions.assertThat(colorActual)
                        .as("Color de texto input [%s] incorrecto", arg0)
                        .isIn(COLOR_GRIS_PLACEHOLDER, "rgb(109, 109, 109)", "rgb(76, 76, 76)", COLOR_NEGRO2);
            } else {
                softAssertions.assertThat(colorActual)
                        .as("Color de texto input [%s] incorrecto", arg0)
                        .isEqualTo(colorTexto);
            }
            softAssertions.assertAll();
            return;
        }
        auto_verificarEstilosInput(arg0, locator, colorTexto, colorBorde, colorFondo, fuente);
    }

    private void auto_verificarEstilosInput(String nombreInput, Locator locator, String colorEsperado, String bordeEsperado, String fondoEsperado, String fuenteEsperada) {
        page.get().waitForTimeout(300);

        String colorActual = auto_getCssValue(locator, "color");
        String bordeActual = auto_getCssValue(locator, "border-color");
        String fondoActual = auto_getCssValue(locator, "background-color");
        String fuenteActual = auto_getCssValue(locator, "font-family");

        boolean esInputConEstadoActivoValido = "NÃ­vel".equals(nombreInput)
                || "Nível".equals(nombreInput)
                || "AÃ±o".equals(nombreInput)
                || "Año".equals(nombreInput);
        boolean esArticulo = "Articulo".equals(nombreInput);

        boolean colorOk = colorActual.equals(colorEsperado)
                || (COLOR_NEGRO.equals(colorEsperado) && esColorNegroValido(colorActual));

        boolean bordeOk = bordeActual.equals(bordeEsperado)
                || (COLOR_1.equals(bordeEsperado) && esBordeMagentaValido(bordeActual));

        if (esInputConEstadoActivoValido) {
            colorOk = colorOk || esColorNegroValido(colorActual);
            bordeOk = bordeOk || esBordeMagentaValido(bordeActual);
        }

        boolean fondoOk = fondoActual.equals(fondoEsperado)
                || (COLOR_BLANCO.equals(fondoEsperado) && "rgba(255, 255, 255, 0.973)".equals(fondoActual));

        if (esArticulo) {
            fondoOk = fondoOk
                    || COLOR_GRIS_FONDO_TEMA.equals(fondoActual)
                    || "rgba(255, 255, 255, 1)".equals(fondoActual)
                    || COLOR_TRANSPARENTE.equals(fondoActual);
        }

        softAssertions.assertThat(colorOk)
                .as("Color de texto input [%s] incorrecto. Esperado: [%s] | Actual: [%s] | Locator: %s",
                        nombreInput, colorEsperado, colorActual, locator)
                .isTrue();
        softAssertions.assertThat(bordeOk)
                .as("Borde input [%s] incorrecto. Esperado: [%s] | Actual: [%s] | Locator: %s",
                        nombreInput, bordeEsperado, bordeActual, locator)
                .isTrue();
        softAssertions.assertThat(fondoOk)
                .as("Background input [%s] incorrecto. Esperado: [%s] | Actual: [%s] | Locator: %s",
                        nombreInput, fondoEsperado, fondoActual, locator)
                .isTrue();
        softAssertions.assertThat(fuenteActual)
                .as("Fuente input [%s] incorrecta. Esperado contiene: [%s] | Actual: [%s] | Locator: %s",
                        nombreInput, fuenteEsperada, fuenteActual, locator)
                .contains(fuenteEsperada);
        softAssertions.assertAll();
    }

    private boolean esColorNegroValido(String colorActual) {
        return "rgb(0, 0, 0)".equals(colorActual)
                || "rgba(0, 0, 0, 1)".equals(colorActual)
                || "rgba(0, 0, 0, 0.98)".equals(colorActual)
                || "rgba(0, 0, 0, 0.88)".equals(colorActual);
    }

    private boolean esBordeMagentaValido(String bordeActual) {
        return COLOR_1.equals(bordeActual)
                || "rgb(227, 34, 96)".equals(bordeActual)
                || "rgb(229, 67, 119)".equals(bordeActual)
                || COLOR_BORDE_INACTIVO.equals(bordeActual)
                || COLOR_8.equals(bordeActual);
    }

    public void ValidarBoton(String arg0) {
        Locator boton;

        switch (arg0) {
            // PRINCIPAL
            case "Iniciar sesión":
                boton = page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(boton, COLOR_BLANCO, COLOR_BLANCO, COLOR_1, FUENTE_BASE);
                break;

            case "Filtrar":
            case "Aceptar":
            case "Iniciar Cotización":
            case "Buscar Póliza":
            case "Continuar":
                boton = page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(boton, COLOR_BLANCO, COLOR_BLANCO, COLOR_7, FUENTE_BASE);
                break;

            // SECUNDARIO
            case "Borrar Filtros":
            case "Cancelar":
                boton = page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(boton, COLOR_1, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "¿Olvidaste tu contraseña?":
                boton = page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(boton, COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            // AZULES
            case "Seleccionar":
            case "Procesar Selección":
                boton = page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(boton, COLOR_3, COLOR_3, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Acciones":
                boton = page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                if (boton.count() == 0 || !boton.isVisible()) {
                    break;
                }
                auto_verificarEstilos(boton, COLOR_3, COLOR_3, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            default:
                throw new IllegalArgumentException("Botón no soportado: " + arg0);
        }
    }

    public void validarTab(String arg0) {
        Locator tab;

        switch (arg0) {
            // SUPERIOR
            case "Principal":
            case "Endoso de Aumento de Suma de Ascensores y Calderas":
            case "Continuar":
                tab = page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first();
                auto_verificarEstilos(tab, COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Endoso de Aumento de Vehículos":
                tab = page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first();
                auto_verificarEstilos(tab, COLOR_NEGRO2, COLOR_NEGRO2, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            // LATERAL
            case "Datos generales":
            case "Comisiones":
            case "Premio":
                tab = page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first();
                auto_verificarEstilos(tab, COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            default:
                throw new IllegalArgumentException("Tab no soportado: " + arg0);
        }
    }

    public void validarIconos(String nombreIcono) {
        switch (nombreIcono) {
            // COLOR_1
            case "Polizas Vigentes":
                auto_verificarIconos(POLIZAS_ICONS_XPATH, COLOR_1);
                break;
            case "Cotizaciones":
                auto_verificarIconos(COTIZACIONES_ICONS_XPATH, COLOR_1);
                break;

            // COLOR_NARANJA
            case "Siniestros Denunciados":
                auto_verificarIconos(SINIESTROS_ICONS_XPATH, COLOR_NARANJA);
                break;
            case "Siniestros Cartera":
                auto_verificarIconos(SINIESTROSCARTERA_ICONS_XPATH, COLOR_NARANJA);
                break;

            default:
                throw new IllegalArgumentException("Nombre de icono no soportado: " + nombreIcono);
        }
    }

    public void verificarPaginado(String arg0) {
        Locator totalIntermediarios = page.get().locator(String.format(PAGINADO_TOTAL_XPATH, arg0));
        Locator paginaActiva = page.get().locator(PAGINADO_PAGINA_ACTIVA_XPATH);
        Locator selectorPorPagina = page.get().locator(PAGINADO_SELECTOR_XPATH);
        Locator flechaAnterior = page.get().locator(PAGINADO_FLECHA_ANTERIOR_XPATH);
        Locator flechaSiguiente = page.get().locator(PAGINADO_FLECHA_SIGUIENTE_XPATH);
        Locator selectorItem = page.get().locator(PAGINADO_SELECTOR_ITEM_XPATH);

        totalIntermediarios.waitFor();
        selectorItem.waitFor();

        List<String> seccionesTemaGris = Arrays.asList("quincenas", "cotizaciones", "retenciones", "cuotas");

        String backgroundEsperado = seccionesTemaGris.contains(arg0.toLowerCase()) ? COLOR_GRIS_FONDO_TEMA : COLOR_BLANCO;
        String colorTextoEsperado = seccionesTemaGris.contains(arg0.toLowerCase()) ? COLOR_GRIS_TEXTO_TEMA : "rgba(0, 0, 0, 0.25)";

        auto_verificarEstilos(totalIntermediarios, COLOR_NEGRO2, COLOR_NEGRO2, COLOR_TRANSPARENTE, FUENTE_BASE);
        if (paginaActiva.count() > 0) {
            auto_verificarEstilos(paginaActiva, COLOR_NEGRO2, COLOR_1, backgroundEsperado, FUENTE_BASE);
        }
        auto_verificarEstilos(selectorPorPagina, COLOR_NEGRO2, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
        auto_verificarEstilos(flechaAnterior, COLOR_NEGRO2, COLOR_NEGRO2, COLOR_TRANSPARENTE, FUENTE_BASE);
        auto_verificarEstilos(flechaSiguiente, COLOR_NEGRO2, COLOR_NEGRO2, COLOR_TRANSPARENTE, FUENTE_BASE);

        selectorItem.click();
        page.get().waitForTimeout(200);
        auto_verificarEstilos(selectorItem, colorTextoEsperado, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
    }

    public void clickEnPopup(){
        for (int i = 0; i < 10; i++) {
            Locator aceptarModalBtn = page.get().locator(HOME_MODAL_ACEPTAR_BTN_XPATH).first();
            if (aceptarModalBtn.count() > 0 && aceptarModalBtn.isVisible()) {
                auto_waitForElementVisibility(HOME_MODAL_ACEPTAR_BTN_XPATH);
                auto_setClickElement(HOME_MODAL_ACEPTAR_BTN_XPATH);
                return;
            }

            Locator aceptarBtn = page.get().locator(ACEPTAR_BTN_XPATH).first();
            if (aceptarBtn.count() > 0 && aceptarBtn.isVisible()) {
                auto_waitForElementVisibility(ACEPTAR_BTN_XPATH);
                auto_setClickElement(ACEPTAR_BTN_XPATH);
                return;
            }

            page.get().waitForTimeout(300);
        }
    }
}

