package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import models.Persona;
import org.assertj.core.api.SoftAssertions;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static locators.CotizadorNuevaCotizacionLocators.*;

public class AccidentePage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();

    public void seleccionarRamaAcc(String rama) {
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

    public void iniciarCotizacion() {
        auto_setClickElement(BOTON_INICIAR_COTIZACION);
        auto_waitForElementVisibility("//div[contains(@class,'ant-spin-spinning')]");
        auto_waitForElementInvisibility("//div[contains(@class,'ant-spin-spinning')]");
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

    public void seleccionarActividad(String actividad) {
        page.get().waitForTimeout(1500);
        auto_waitForElementVisibility(ACTIVIDAD_SELECT);
        auto_setClickElement(ACTIVIDAD_SELECT);
        auto_waitForElementVisibility(String.format(SELECT_OPCION, actividad));
        auto_setClickElement(String.format(SELECT_OPCION, actividad));
    }

    public void ingresarCantidad(int cantidad) {
        auto_setTextToInput(INPUT_CANTIDAD, String.valueOf(cantidad));
        auto_setClickElement(BOTON_AGREGAR);
        auto_setClickElement(BOTON_CONTINUAR);
    }

    public void ingresarCoberturaMuerte(long monto) {
        auto_setTextToInput(INPUT_COBERTURA_MUERTE, String.valueOf(monto));
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
        auto_waitForElementVisibility(BOTON_EMITIR);
        auto_setClickElement(BOTON_EMITIR);
    }

    public void seleccionarNacionalidadAcc(String nacionalidad) {
        auto_setClickElement(NACIONALIDAD_SELECT);
        auto_setTextToInput(NACIONALIDAD_INPUT_SELECT, nacionalidad);
        auto_pressKey(NACIONALIDAD_INPUT_SELECT, "Enter");
    }

    public void ingresarNumeroTarjetaAcc(String numero) {
        auto_typeSequentially(INPUT_TARJETA, numero);
        auto_pressKey(INPUT_TARJETA, "Enter");
    }

    public void ingresarVencimientoAcc(String vencimiento) {
        auto_setTextToInput(INPUT_VENCIMIENTO, vencimiento);
    }

    public void agregarPersona(Persona persona) {

        auto_setClickElement(BOTON_AGREGAR_PERSONA);

        auto_setTextToInput(INPUT_APELLIDO_NOMBRE, persona.getApellidoYNombre());

        auto_setClickElement(TIPO_DOCUMENTO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, persona.getTipoDocumento()));

        auto_setTextToInput(INPUT_NUMERO_DOCUMENTO, persona.getNumeroDocumento());

        auto_setTextToInput(INPUT_CUIL, persona.getCuil());

        auto_setTextToInput(INPUT_FECHA_NACIMIENTO, persona.getFechaNacimiento());
        auto_pressKey(INPUT_FECHA_NACIMIENTO, "Enter");

        auto_setTextToInput(NACIONALIDAD_PERSONA_SELECT2, persona.getNacionalidad());
        auto_pressKey(NACIONALIDAD_PERSONA_SELECT2, "Enter");

        auto_setClickElement(GENERO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, persona.getGenero()));
    }

    public void guardar() {
        auto_waitForElementVisibility(BOTON_GUARDAR);
        auto_setClickElement(BOTON_GUARDAR);
    }

    public void enviar() {
        auto_setClickElement(BOTON_ENVIAR);
    }

    public void validarResultadoEmision() {

        Locator errores = page.get()
                .locator("//div[contains(@class,'ant-message-error')]");

        Locator exito = page.get()
                .locator(POLIZA_ENVIO_TITULO);
        page.get().waitForFunction(
                "() => document.querySelectorAll('div.ant-message-error').length > 0 "
                        + "|| document.querySelector('" + POLIZA_ENVIO_TITULO + "') !== null",
                null,
                new Page.WaitForFunctionOptions().setTimeout(8000)
        );
        if (exito.isVisible()) {
            return;
        }
        Set<String> mensajes = new LinkedHashSet<>();
        List<String> textos = errores.allInnerTexts();

        for (String t : textos) {
            String limpio = t.trim();
            if (!limpio.isEmpty()) {
                mensajes.add(limpio);
            }
        }

        if (!mensajes.isEmpty()) {

            StringBuilder todos = new StringBuilder();
            mensajes.forEach(m -> todos.append(m).append("\n"));

            throw new AssertionError("Errores en emisión:\n" + todos);
        }
    }

    public void envioPoliza() {
        auto_waitForElementVisibility(POLIZA_ENVIO_TITULO);
        auto_waitForElementVisibility(POLIZA_ENVIO_TEXTO);
        auto_waitForElementVisibility(POLIZA_ENVIO_BOTON_ACEPTAR);
    }
}
