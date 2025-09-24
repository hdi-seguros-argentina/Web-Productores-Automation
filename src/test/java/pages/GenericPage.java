package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.SoftAssertions;

import static locators.GenericLocators.*;
import static locators.HomeLocators.GENERIC_TITULO_XPATH;

public class GenericPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_NEGRO = "rgb(0, 0, 0)";
    public static final String COLOR_NEGRO2 = "rgba(0, 0, 0, 0.88)";
    public static final String COLOR_GRIS = "rgb(110, 110, 110)";
    public static final String COLOR_BLANCO = "rgb(255, 255, 255)";
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta1
    public static final String COLOR_2 = "rgb(0, 103, 41)";      //Magenta2
    public static final String COLOR_4 = "rgb(252, 232, 239)";   //Magenta3
    public static final String COLOR_5 = "rgb(255, 233, 233)";   //Magenta4
    public static final String COLOR_6 = "rgb(64, 150, 255)";    //Magenta5
    public static final String COLOR_7 = "rgb(232, 69, 121)";    //Magenta6
    public static final String COLOR_3 = "rgb(0, 91, 187)";      //Azul
    public static final String COLOR_TRANSPARENTE = "rgba(0, 0, 0, 0)";
    public static final String COLOR_8 = "rgb(217, 217, 217)";
    public static final String COLOR_NARANJA = "rgb(219, 99, 1)";
    public static final String FUENTE_BASE = "Montserrat, sans-serif";

    public void verificaTitulo(String args) {
        Locator titulo = page.get().locator(String.format(GENERIC_TITULO_XPATH, args)).first();
        softAssertions.assertThat(auto_getCssValue(titulo, "color"))
                .as("Color de texto titulo info incorrecto")
                .isEqualTo(COLOR_NEGRO);
    }
    public void verificaSubTitulo(String args) {
        Locator titulo = page.get().locator(String.format(GENERIC_TITULO_XPATH, args)).first();
        softAssertions.assertThat(auto_getCssValue(titulo, "color"))
                .as("Color de texto titulo info incorrecto")
                .isEqualTo(COLOR_1);
    }


    public void validarInput(String arg0) {
        switch (arg0) {
            case "Usuario":
                page.get().locator(String.format(GENERIC1_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC1_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Contraseña":
                page.get().locator(String.format(GENERIC1_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC1_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Nombre":
                page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "CUIT":
                page.get().locator(String.format(GENERIC2_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC2_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Código Interno":
                page.get().locator(String.format(GENERIC2_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC2_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Nível":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Asegurado":
                page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Ramo":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Número de póliza":
                page.get().locator(String.format(GENERIC2_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC2_INPUT_XPATH, arg0)).first(), COLOR_NEGRO2, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Productor":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_8, FUENTE_BASE);
                break;

            case "Fecha inicial":
                page.get().locator(String.format(GENERIC4_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC4_INPUT_XPATH, arg0)).first(), COLOR_GRIS, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Estado":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Más reciente primero":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Año":
                page.get().locator(String.format(GENERIC4_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC4_INPUT_XPATH, arg0)).first(), COLOR_GRIS, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Mes":
                page.get().locator(String.format(GENERIC4_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC4_INPUT_XPATH, arg0)).first(), COLOR_GRIS, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Quincena":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Seleccione un grupo":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "ACCIDENTES PERSONALES COLECTIV":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Apellido y Nombre":
                page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Articulo":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Operación":
                page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC5_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Número de Cotización":
                page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC3_INPUT_XPATH, arg0)).first(), COLOR_NEGRO, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            default:
                throw new IllegalArgumentException("Botón no soportado: " + arg0);
        }
    }

    public void ValidarBoton(String arg0) {
        switch (arg0) {
            //PRINCIPAL
            case "Iniciar sesión":
                page.get().locator(String.format(LOGIN_BTN1_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(LOGIN_BTN1_XPATH, arg0)).first(), COLOR_BLANCO, COLOR_BLANCO, COLOR_1, FUENTE_BASE);
                break;

            case "Filtrar":
                page.get().locator(String.format(FILTER1_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(FILTER1_BTN_XPATH, arg0)).first(), COLOR_BLANCO, COLOR_BLANCO, COLOR_7, FUENTE_BASE);
                break;

            case "Aceptar":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_BLANCO, COLOR_BLANCO, COLOR_7, FUENTE_BASE);
                break;

            case "Iniciar Cotización":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_BLANCO, COLOR_8, COLOR_7, FUENTE_BASE);
                break;

            //SECUNDARIO
            case "¿Olvidaste tu contraseña?":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Borrar Filtros":
                page.get().locator(String.format(BORRARFILTROS1_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(BORRARFILTROS1_BTN_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Cancelar":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_BLANCO, FUENTE_BASE);
                break;

            //AZUL
            case "Acciones":
                page.get().locator(String.format(ACCIONES_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(ACCIONES_BTN_XPATH, arg0)).first(), COLOR_3, COLOR_3, COLOR_BLANCO, FUENTE_BASE);
                break;

            case "Procesar Selección":
                page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first();
                auto_verificarEstilos(page.get().locator(String.format(GENERIC_BTN_XPATH, arg0)).first(), COLOR_3, COLOR_3, COLOR_BLANCO, FUENTE_BASE);
                break;

            default:
                throw new IllegalArgumentException("Botón no soportado: " + arg0);
        }
    }

    public void validarTab(String arg0) {
        switch (arg0) {
            case "Principal":
                page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Datos generales":
                page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Comisiones":
                page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Premio":
                page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(LATERAL_TAB_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Endoso de Aumento de Suma de Ascensores y Calderas":
                page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            case "Endoso de Aumento de Vehículos":
                page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first().click();
                auto_verificarEstilos(page.get().locator(String.format(SUPERIOR_TAB_XPATH, arg0)).first(), COLOR_1, COLOR_1, COLOR_TRANSPARENTE, FUENTE_BASE);
                break;

            default:
                throw new IllegalArgumentException("Botón no soportado: " + arg0);
        }
    }

    public void validarIconos(String nombreIcono) {
        switch (nombreIcono) {
            case "Polizas Vigentes":
                auto_verificarIconos(POLIZAS_ICONS_XPATH, COLOR_1);
                break;

            case "Siniestros Denunciados":
                auto_verificarIconos(SINIESTROS_ICONS_XPATH, COLOR_NARANJA);
                break;

            case "Cotizaciones":
                auto_verificarIconos(COTIZACIONES_ICONS_XPATH, COLOR_1);
                break;

            case "Siniestros Cartera":
                auto_verificarIconos(SINIESTROSCARTERA_ICONS_XPATH, COLOR_NARANJA);
                break;

            default:
                throw new IllegalArgumentException("Nombre de icono no soportado: " + nombreIcono);
        }
    }
}