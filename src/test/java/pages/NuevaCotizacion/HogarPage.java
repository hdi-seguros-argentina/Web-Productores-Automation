package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Map;

import static locators.CotizadorNuevaCotizacionLocators.*;

public class HogarPage extends MasterPage {
    public void seleccionarRamaHogar(String rama) {
        auto_setClickElement(RAMA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, rama));
    }

    public void seleccionarArticuloAcc(String articulo) {
        String articuloSeleccionado =
                auto_getElementText("(//span[contains(@class,'ant-select-selection-item')])[2]");

        if (!articuloSeleccionado.equalsIgnoreCase(articulo)) {

            auto_setClickElement(ARTICULO_SELECT);
            auto_setClickElement(String.format(ARTICULO_SELECT, articulo));
        }
    }

    public void buscarClienteAcc(String cliente) {
        auto_setClickElement(BOTON_BUSCAR_CLIENTE);
        auto_setClickElement(String.format(RESULTADO_CLIENTE, cliente));

        auto_setClickElement(BOTON_CONTINUAR);
    }

    public void seleccionarPlan(String plan) {
        auto_setClickElement(PLAN_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, plan));
    }

    public void seleccionarProvincia(String provincia) {
        auto_setClickElement(PROVINCIA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, provincia));
    }

    public void seleccionarLocalidad(String localidad) {
        auto_setClickElement(LOCALIDAD_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, localidad));
    }

    public void seleccionarTipoVivienda(String tipoVivienda) {
        auto_setClickElement(TIPO_VIVIENDA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, tipoVivienda));

        auto_setClickElement(BOTON_CONTINUAR);
    }

    private static final Map<String, String> COBERTURA_LABELS = Map.of(
            "incendioEdificioAProrrata", "INCENDIO EDIFICIO A PRORRATA",
            "roboEIncendioDocumentos", "ROBO E INCENDIO DOCUMENTOS",
            "accidentesPersonalesTitularPoliza", "ACCIDENTES PERSONALES TITULAR POLIZA"
    );

    public void seleccionarCobertura(String key) {
        String textoVisible = COBERTURA_LABELS.get(key);
        auto_waitForElementVisibility(String.format(COBERTURA_CHECKBOX, textoVisible));
        auto_setClickElement(String.format(COBERTURA_CHECKBOX, textoVisible));
    }

    public void ingresarSumaCobertura(String key, Integer suma) {
        String textoVisible = COBERTURA_LABELS.get(key);
        auto_waitForElementVisibility(String.format(COBERTURA_INPUT, textoVisible));
        auto_setTextToInput(String.format(COBERTURA_INPUT, textoVisible), String.valueOf(suma));
    }

    public void cotizar() {
        auto_setClickElement(BOTON_COTIZAR);
    }

    public void guardarCotizacion() {
        auto_setClickElement(BOTON_GUARDAR_COTIZACION);
    }

    public void editarCotizacion() {
        auto_waitForElementVisibility(BOTON_LAPIZ_EDITAR);
        auto_setClickElement(BOTON_LAPIZ_EDITAR);
    }

    public void emitir() {
        page.get().waitForTimeout(4000);

        auto_waitForElementVisibility("//span[normalize-space()='INCENDIO EDIFICIO A PRORRATA']");

        auto_setClickElement(BOTON_RECOTIZAR);

        auto_waitForLoadStates(LoadState.NETWORKIDLE);

        auto_setClickElement(BOTON_EMITIR);
    }

    public void seleccionarNacionalidadHogar(String nacionalidad) {
        auto_waitForElementVisibility(NACIONALIDAD_SELECT);
        auto_setTextToInput(NACIONALIDAD_INPUT_SELECT, nacionalidad);
        auto_pressKey(NACIONALIDAD_INPUT_SELECT, "Enter");
    }

    public void ingresarNumeroTarjetaHogar(String numero) {
        auto_typeSequentially(INPUT_TARJETA, numero);
        auto_pressKey(INPUT_TARJETA, "Enter");
    }

    public void ingresarVencimientoHogar(String vencimiento) {
        auto_setTextToInput(INPUT_VENCIMIENTO, vencimiento);
    }

    public void ingresarDomicilioHogar(String vencimiento) {
        auto_setTextToInput(INPUT_DOMICILIO, vencimiento);
    }
}
