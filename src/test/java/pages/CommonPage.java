package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.options.LoadState;
import models.Cobertura;

import java.util.List;

import static locators.CommonLocators.*;

public class CommonPage extends MasterPage {

    public void seleccionarRama(String rama) {
        auto_setClickElement(RAMA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, rama));
    }

    public void seleccionarArticulo(String articulo) {
        auto_setClickElement(ARTICULO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, articulo));

    }

    public void clickIniciarCotizacion() {
        auto_setClickElement(BOTON_INICIAR_COTIZACION);
        auto_waitForElementVisibility("//div[contains(@class,'ant-spin-spinning')]");
        auto_waitForElementInvisibility("//div[contains(@class,'ant-spin-spinning')]");
    }

    public void buscarCliente(String cliente) {
        page.get().waitForTimeout(1000);
        auto_setClickElement(BOTON_BUSCAR_CLIENTE);
        auto_setClickElement(String.format(RESULTADO_CLIENTE, cliente));
    }

    public void clickBotonContinuar() {
        auto_setClickElement(BOTON_CONTINUAR);
        auto_waitForLoadStates(LoadState.NETWORKIDLE);
    }

    public void seleccionarNacionalidad(String nacionalidad) {
        auto_waitForElementVisibility(NACIONALIDAD_SELECT);
        auto_setTextToInput(NACIONALIDAD_INPUT_SELECT, nacionalidad);
        auto_pressKey(NACIONALIDAD_INPUT_SELECT, "Enter");
    }

    public void ingresarNumeroTarjeta(String numero) {
        auto_typeSequentially(INPUT_TARJETA, numero);
        auto_pressKey(INPUT_TARJETA, "Enter");
    }

    public void ingresarVencimiento(String vencimiento) {
        auto_setTextToInput(INPUT_VENCIMIENTO, vencimiento);
    }

    public void clickBotonCotizar() {
        auto_setClickElement(BOTON_COTIZAR);
    }

    public void guardarCotizacion() {
        auto_setClickElement(BOTON_GUARDAR_COTIZACION);
    }

    public void clickEditarCotizacion() {
        auto_waitForElementVisibility(BOTON_LAPIZ_EDITAR);
        auto_setClickElement(BOTON_LAPIZ_EDITAR);
        auto_waitForElementVisibility(TITULO_NUEVACOTIZACION_XPATH);
    }

    public void clickBotonEmitir() {
        page.get().waitForTimeout(4000);
        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_setClickElement(BOTON_EMITIR);
    }

    public void clickBotonRecotizar() {
        page.get().waitForTimeout(4000);
        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_setClickElement(BOTON_RECOTIZAR);
    }

    public void clickBotonGuardar() {
        auto_waitForElementVisibility(BOTON_GUARDAR);
        auto_setClickElement(BOTON_GUARDAR);
    }

    public void clickBotonEnviar() {
        auto_setClickElement(BOTON_ENVIAR);
    }

    public void verificaEnvioCotizacion() {
        auto_waitForElementVisibility(POLIZA_ENVIO_TITULO);
        auto_waitForElementVisibility(POLIZA_ENVIO_TEXTO);
        auto_waitForElementVisibility(POLIZA_ENVIO_BOTON_ACEPTAR);
    }

    public void seleccionarProvincia(String provincia) {
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Provincia"));
        auto_setClickElement(String.format(SELECT_OPCION, provincia));
    }

    public void seleccionarLocalidad(String localidad) {
        page.get().waitForTimeout(1000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Localidad"));
        auto_setClickElement(String.format(SELECT_OPCION, localidad));
    }

    public void seleccionarCobertura(String nombreCobertura) {
        auto_waitForElementVisibility(String.format(COBERTURA_CHECKBOX, nombreCobertura));
        auto_setClickElement(String.format(COBERTURA_CHECKBOX, nombreCobertura));
    }

    public void ingresarSumaCobertura(String nombreCobertura, Integer suma) {
        auto_waitForElementVisibility(String.format(COBERTURA_INPUT, nombreCobertura));
        auto_setTextToInput(
                String.format(COBERTURA_INPUT, nombreCobertura),
                String.valueOf(suma)
        );
    }

    public void completarCoberturas(List<Cobertura> coberturas) {
        coberturas.forEach(c -> {
            seleccionarCobertura(c.getNombre());
            ingresarSumaCobertura(c.getNombre(), c.getSuma());

        });
    }

    public void ingresarDomicilio(String vencimiento) {
        auto_setTextToInput(INPUT_DOMICILIO, vencimiento);
    }
}