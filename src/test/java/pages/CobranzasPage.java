package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import models.Preliquidacion;
import org.assertj.core.api.SoftAssertions;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static locators.CobranzasLocators.*;

public class CobranzasPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_3 = "rgb(0, 91, 187)";      //Azul
    public void ingresoPantalla(String arg0) {
        page.get().waitForTimeout(8000);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
        auto_waitForElementVisibility(String.format(TITLE_GENERIC_XPATH, arg0));
    }

    public void verificaStepActivo(String arg0){
        Locator check = page.get().locator(String.format(STEP_GENERIC_XPATH, arg0)).first();
        softAssertions.assertThat(auto_getCssValue(check, "background-color"))
                .as("Color de background de step-boton incorrecto")
                .isEqualTo(COLOR_3);
    }

    public void validarPantallaPrincipalPreliquidacion() {
        auto_verifyVisibility(PRELIQUIDACION_NUMERO_XPATH);
        auto_verifyVisibility(FILTRO_RAMA_SELECT_XPATH);
        auto_verifyVisibility(FILTRO_ASEGURADO_INPUT_XPATH);
        auto_verifyVisibility(FILTRO_POLIZA_INPUT_XPATH);
        auto_verifyVisibility(PRELIQUIDACION_TABLA_POLIZAS_XPATH);
        auto_verifyVisibility(RESUMEN_TITULO_XPATH);
    }

    public void filtrarRamaYSeleccionarPrimeraCuota(String rama) {
        seleccionarOpcion(FILTRO_RAMA_SELECT_XPATH, rama);
        auto_setClickElement("//button[.//span[normalize-space()='Filtrar']]");
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);

        auto_waitForElementVisibility(PRIMER_CHECKBOX_CUOTA_HABILITADO_XPATH);
        Locator checkbox = page.get().locator(PRIMER_CHECKBOX_CUOTA_HABILITADO_XPATH).first();
        checkbox.scrollIntoViewIfNeeded();
        softAssertions.assertThat(checkbox.count())
                .as("No se encontró un checkbox habilitado en el primer registro del listado")
                .isGreaterThan(0);
        softAssertions.assertThat(checkbox.isEnabled())
                .as("El checkbox del primer registro no estÃ¡ habilitado")
                .isTrue();
        checkbox.check();
        softAssertions.assertAll();
    }

    public void continuarDesdePrincipalPreliquidacion() {
        page.get().locator(CONTINUAR_BUTTON_XPATH).scrollIntoViewIfNeeded();
        auto_setClickElement(CONTINUAR_BUTTON_XPATH);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
        auto_waitForElementVisibility(String.format(TITLE_GENERIC_XPATH, "Cuotas Seleccionadas"));
    }

    public void validarPantallaCuotasSeleccionadas() {
        auto_waitForElementVisibility(CUOTAS_SELECCIONADAS_TITULO_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_TITULO_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_RAMA_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_POLIZA_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_ENDOSO_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_CUOTA_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_SUBCUOTA_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_VENCIMIENTO_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_ASEGURADO_HEADER_XPATH);
        auto_verifyVisibility(CUOTAS_SELECCIONADAS_SUBTOTAL_PREMIO_HEADER_XPATH);
        auto_verifyVisibility(TOTAL_PREMIO_RESUMEN_XPATH);
        auto_verifyVisibility(CONTINUAR_BUTTON_XPATH);
    }

    public void seleccionarCuotaYContinuar() {
        Locator rama = page.get().locator(PRIMERA_RAMA_CUOTA_SELECCIONADA_XPATH).first();
        rama.scrollIntoViewIfNeeded();
        softAssertions.assertThat(rama.count())
                .as("No se encontró la rama de la primera cuota seleccionada")
                .isGreaterThan(0);
        rama.click();
        softAssertions.assertAll();

        page.get().locator(CONTINUAR_BUTTON_XPATH).scrollIntoViewIfNeeded();
        auto_setClickElement(CONTINUAR_BUTTON_XPATH);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
        auto_waitForElementVisibility(String.format(TITLE_GENERIC_XPATH, "Forma de Pago"));
    }

    public void validarPantallaConfirmarPreliquidacion() {
        auto_verifyVisibility(String.format(TITLE_GENERIC_XPATH, "Forma de Pago"));
        auto_verifyVisibility(FORMA_PAGO_SELECT_XPATH);
        auto_verifyVisibility(FORMA_PAGO_TABLE_HEADER_XPATH);
        auto_verifyVisibility(MONTO_EXACTO_TABLE_HEADER_XPATH);
        auto_verifyVisibility(BANCO_TABLE_HEADER_XPATH);
        auto_verifyVisibility(FECHA_TRANSFERENCIA_TABLE_HEADER_XPATH);
        auto_verifyVisibility(COMPROBANTE_PAGO_TABLE_HEADER_XPATH);
        auto_verifyVisibility(TOTAL_A_PAGAR_LABEL_XPATH);
        auto_verifyVisibility(SUMA_VALORES_LABEL_XPATH);
        auto_verifyVisibility(SALDO_A_CUBRIR_LABEL_XPATH);
        auto_verifyVisibility(CONFIRMAR_PAGO_BUTTON_XPATH);
    }

    public void completarFormaPago(Preliquidacion preliquidacion) {
        seleccionarOpcion(FORMA_PAGO_SELECT_XPATH, preliquidacion.getFormaPago());

        String totalAPagar = auto_getElementTextOrValue("//span[normalize-space()='Total a Pagar']/following::b[1]");
        auto_setTextToInput(MONTO_EXACTO_INPUT_XPATH, normalizarImporteParaInput(totalAPagar));

        seleccionarOpcion(BANCO_SELECT_XPATH, preliquidacion.getBanco());
        cargarComprobante(preliquidacion.getComprobantePath());

        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        auto_setTextToInput(FECHA_TRANSFERENCIA_INPUT_XPATH, fechaActual);
        auto_pressKey(FECHA_TRANSFERENCIA_INPUT_XPATH, "Tab");

        auto_setClickElement(AGREGAR_BUTTON_XPATH);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
    }

    public void validarFormaPagoAgregada(Preliquidacion preliquidacion) {
        page.get().waitForTimeout(1000);
        auto_waitForElementVisibility(String.format(FORMA_PAGO_AGREGADA_XPATH, preliquidacion.getFormaPago()));
        auto_verifyVisibility(String.format(FORMA_PAGO_AGREGADA_XPATH, preliquidacion.getFormaPago()));
        auto_verifyVisibility(String.format(BANCO_AGREGADO_XPATH, preliquidacion.getBanco()));
        auto_verifyVisibility(SALDO_A_CUBRIR_CERO_XPATH);
    }

    public void confirmarPagoPreliquidacion() {
        auto_waitForElementVisibility(SALDO_A_CUBRIR_CERO_XPATH);
        auto_setClickElement(CONFIRMAR_PAGO_BUTTON_XPATH);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
        auto_waitForElementVisibility(PRELIQUIDACION_ENVIADA_XPATH);
    }

    public void validarPreliquidacionEnviada() {
        auto_verifyVisibility(PRELIQUIDACION_ENVIADA_XPATH);
    }

    public void validarTabPreliquidacionesYFiltro(String tab) {
        abrirTabPreliquidaciones(tab);
        validarEstructuraPreliquidaciones();
        validarAccionesPorTabPreliquidaciones(tab);
        validarFiltroPorNumeroEnTabActiva();
    }

    private void abrirTabPreliquidaciones(String tab) {
        auto_waitForLoadStates(LoadState.DOMCONTENTLOADED);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
        auto_waitForElementVisibility(PRELIQUIDACIONES_GUARDADAS_ENVIADAS_TITULO_XPATH);
        auto_waitForElementVisibility(String.format(PRELIQUIDACIONES_TAB_XPATH, tab));

        if (page.get().locator(String.format(PRELIQUIDACIONES_TAB_ACTIVA_XPATH, tab)).count() == 0) {
            auto_setClickElement(String.format(PRELIQUIDACIONES_TAB_XPATH, tab));
        }

        auto_waitForElementVisibility(String.format(PRELIQUIDACIONES_TAB_ACTIVA_XPATH, tab));
        esperarTablaPreliquidacionesGuardadasEnviadas();
    }

    private void validarEstructuraPreliquidaciones() {
        auto_verifyVisibilities(
                PRELIQUIDACIONES_GUARDADAS_ENVIADAS_TITULO_XPATH,
                String.format(PRELIQUIDACIONES_TAB_XPATH, "Preliquidaciones Guardadas"),
                String.format(PRELIQUIDACIONES_TAB_XPATH, "Preliquidaciones Enviadas"),
                PRELIQUIDACIONES_NUMERO_INPUT_XPATH,
                PRELIQUIDACIONES_FECHA_INICIAL_INPUT_XPATH,
                PRELIQUIDACIONES_FECHA_FINAL_INPUT_XPATH,
                PRELIQUIDACIONES_FILTRAR_BUTTON_XPATH,
                PRELIQUIDACIONES_BORRAR_FILTROS_BUTTON_XPATH,
                PRELIQUIDACIONES_TABLE_XPATH,
                String.format(PRELIQUIDACIONES_TABLE_HEADER_XPATH, "Número"),
                String.format(PRELIQUIDACIONES_TABLE_HEADER_XPATH, "Fecha"),
                String.format(PRELIQUIDACIONES_TABLE_HEADER_XPATH, "Importe Total"),
                String.format(PRELIQUIDACIONES_TABLE_HEADER_XPATH, "Estado"),
                String.format(PRELIQUIDACIONES_TABLE_HEADER_XPATH, "Acciones"),
                PRELIQUIDACIONES_PAGINATION_TOTAL_XPATH,
                PRELIQUIDACIONES_PAGE_SIZE_XPATH
        );
    }

    private void validarAccionesPorTabPreliquidaciones(String tab) {
        auto_waitForElementVisibility(PRELIQUIDACIONES_FIRST_ROW_XPATH);

        if ("Preliquidaciones Enviadas".equals(tab)) {
            auto_verifyVisibility(PRELIQUIDACIONES_ACCION_DOWNLOAD_XPATH);
        } else {
            auto_verifyVisibility(PRELIQUIDACIONES_ACCION_EDIT_XPATH);
            auto_verifyVisibility(PRELIQUIDACIONES_ACCION_DELETE_XPATH);
        }
    }

    private void validarFiltroPorNumeroEnTabActiva() {
        auto_waitForElementVisibility(PRELIQUIDACIONES_FIRST_ROW_XPATH);
        String numero = page.get().locator(PRELIQUIDACIONES_FIRST_ROW_NUMBER_XPATH).first().textContent().trim();

        auto_setTextToInput(PRELIQUIDACIONES_NUMERO_INPUT_XPATH, numero);
        auto_setClickElement(PRELIQUIDACIONES_FILTRAR_BUTTON_XPATH);
        esperarTablaPreliquidacionesGuardadasEnviadas();

        String filaFiltradaXpath = String.format(PRELIQUIDACIONES_ROW_BY_NUMBER_XPATH, numero);
        auto_waitForElementVisibility(filaFiltradaXpath);
        Locator filaFiltrada = page.get().locator(filaFiltradaXpath).first();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(filaFiltrada.count())
                .as("El filtro por número no devolvió la preliquidación " + numero)
                .isGreaterThan(0);
        softly.assertThat(page.get().locator(PRELIQUIDACIONES_FIRST_ROW_NUMBER_XPATH).first().textContent().trim())
                .as("El primer registro filtrado no corresponde al número buscado")
                .isEqualTo(numero);
        softly.assertAll();
    }

    private void esperarTablaPreliquidacionesGuardadasEnviadas() {
        auto_waitForLoadStates(LoadState.DOMCONTENTLOADED);
        auto_waitForElementInvisibilityIfPresent(SPINNER_XPATH);
        auto_waitForElementVisibility(PRELIQUIDACIONES_TABLE_XPATH);
    }

    private void seleccionarOpcion(String select, String opcion) {
        auto_waitForElementVisibility(select);
        auto_setClickElement(select);
        auto_waitForElementVisibility(String.format(SELECT_OPTION_XPATH, opcion));
        auto_setClickElement(String.format(SELECT_OPTION_XPATH, opcion));
    }

    private void cargarComprobante(String comprobantePath) {
        auto_setClickElement(COMPROBANTE_UPLOAD_BUTTON_XPATH);
        auto_waitForElementPresent(COMPROBANTE_FILE_INPUT_XPATH);
        page.get().locator(COMPROBANTE_FILE_INPUT_XPATH)
                .setInputFiles(Paths.get(comprobantePath).toAbsolutePath());
        auto_waitForElementVisibility(MODAL_CONFIRMAR_BUTTON_XPATH);
        auto_setClickElement(MODAL_CONFIRMAR_BUTTON_XPATH);
    }

    private String normalizarImporteParaInput(String importe) {
        return importe
                .replace("\u00a0", "")
                .replace("$", "")
                .replace(".", "")
                .replaceAll("\\s+", "")
                .trim();
    }
}
