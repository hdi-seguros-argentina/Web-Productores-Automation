package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import models.Cobertura;
import models.InformacionDeContacto;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static locators.CommonLocators.*;

public class CommonPage extends MasterPage {

    SoftAssertions softAssertions = new SoftAssertions();
    private String comisionAntes;
    private String extraPrimaAntes;
    private String primaTecnicaResumen;
    private String comisionResumen;
    private String premioResumen;

    public void seleccionarRama(String rama) {
        auto_setClickElement(RAMA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, rama));
    }

    public void seleccionarArticulo(String articulo) {
        auto_setClickElement(ARTICULO_SELECT);
        String opcionBase = String.format(SELECT_OPCION, articulo);
        String opcionDuplicada = "(" + opcionBase + ")[2]";
        auto_setClickElement(page.get().locator(opcionDuplicada).count() > 0 ? opcionDuplicada : opcionBase);
    }

    public void clickIniciarCotizacion() {
        auto_setClickElement(BOTON_INICIAR_COTIZACION);
        auto_waitForElementVisibility("//div[contains(@class,'ant-spin-spinning')]");
        auto_waitForElementInvisibility("//div[contains(@class,'ant-spin-spinning')]");
    }

    public void seleccionarIva(String iva) {
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "IVA"));
        auto_setClickElement(String.format(SELECT_OPCION, iva));
    }

    public void seleccionarTipoDePersona(String tipoDePersona) {
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Tipo de Persona"));
        auto_setClickElement(String.format(SELECT_OPCION, tipoDePersona));
    }

    public void buscarCliente(String cliente) {
        auto_waitForElementInvisibility(".ant-spin-spinning");
        clickConReintento(BOTON_BUSCAR_CLIENTE);
        clickConReintento(String.format(RESULTADO_CLIENTE, cliente));
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
        page.get().waitForTimeout(300);

        String opcionTarjeta = TARJETA_CREDITO_OPCION_VISA;
        if (page.get().locator(opcionTarjeta).first().isVisible()) {
            auto_setClickElement(opcionTarjeta);
            return;
        }

        Locator selectorTarjeta = page.get().locator(TARJETA_CREDITO_SELECT).first();
        if (!selectorTarjeta.isVisible()) {
            return;
        }

        selectorTarjeta.click();
        if (page.get().locator(opcionTarjeta).first().isVisible()) {
            auto_setClickElement(opcionTarjeta);
        }
    }

    public void ingresarVencimiento(String vencimiento) {
        auto_setTextToInput(INPUT_VENCIMIENTO, vencimiento);
    }

    public void clickBotonCotizar() {
        auto_setClickElement(BOTON_COTIZAR);
    }

    public void guardarCotizacion() {
        auto_waitForElementVisibility(BOTON_GUARDAR_COTIZACION);
        auto_setClickElement(BOTON_GUARDAR_COTIZACION);
    }

    public void clickEditarCotizacion() {
        auto_waitForElementVisibility(BOTON_LAPIZ_EDITAR);
        auto_setClickElement(BOTON_LAPIZ_EDITAR);
        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_waitForElementVisibility(TITULO_NUEVACOTIZACION_XPATH);
    }

    public void clickBotonEmitir() {
        page.get().waitForTimeout(4000);
        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_setClickElement(BOTON_EMITIR);
    }

    public void clickBotonRecotizar() {
        page.get().waitForTimeout(4000);
        auto_waitForElementVisibility(BOTON_RECOTIZAR);
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
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(POLIZA_ENVIO_TITULO))
                .as("No se pudo enviar la cotizacion")
                .doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(POLIZA_ENVIO_TEXTO))
                .as("No se visualiza el texto de envio de cotizacion")
                .doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(POLIZA_ENVIO_BOTON_ACEPTAR))
                .as("No se visualiza el boton Aceptar en el envio de cotizacion")
                .doesNotThrowAnyException();
        softAssertions.assertAll();
    }

    public void seleccionarProvincia(String provincia) {
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Provincia"));
        auto_setClickElement(String.format(SELECT_OPCION, provincia));
    }

    public void seleccionarLocalidad(String localidad) {
        page.get().waitForTimeout(4000);

        clickConReintento(String.format(SELECT_DESPLEGABLE, "Localidad"));
        clickConReintento(String.format(SELECT_OPCION, localidad));
    }

    public void seleccionarCobertura(String nombreCobertura) {
        String checkbox = String.format(COBERTURA_CHECKBOX, nombreCobertura);
        auto_waitForElementVisibility(checkbox);

        boolean checked = page.get().isChecked(checkbox);
        if (!checked) {
            auto_setClickElement(checkbox);
        }
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

    public void guardarValoresAntesDeVariacion() {
        guardarValoresAntesDeVariacion(false);
    }

    public void guardarValoresAntesDeVariacion(boolean esAuto) {
        String locatorPrima = esAuto ? PRIMA_TECNICA_AUTO__RESUMEN : PRIMA_TECNICA_RESUMEN;
        String locatorComision = esAuto ? COMISION_AUTO_RESUMEN : COMISION_RESUMEN;
        String locatorPremio = esAuto ? PREMIO_AUTO_RESUMEN : PREMIO_RESUMEN;

        auto_waitForElementInvisibility(".ant-spin-spinning");
        comisionAntes = auto_getElementTextOrValue(COMISION_CAMPO);
        extraPrimaAntes = auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO);
        primaTecnicaResumen = esperarValorResumenValido(locatorPrima, "Prima tecnica");
        comisionResumen = esperarValorResumenValido(locatorComision, "Comision");
        premioResumen = esperarValorResumenValido(locatorPremio, "Premio");
    }

    public void validarCambioVariacion(Integer variacion) {
        auto_setTextToInput(INPUT_VARIACION, String.valueOf(variacion));
        auto_pressKey(INPUT_VARIACION, "Enter");

        page.get().waitForTimeout(2000);

        String comisionDespues = auto_getElementTextOrValue(COMISION_CAMPO);
        String extraPrimaDespues = auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO);

        softAssertions.assertThat(comisionDespues)
                .as("La comision debe cambiar al modificar la variacion")
                .isNotEqualTo(comisionAntes);

        softAssertions.assertThat(extraPrimaDespues)
                .as("La extra prima variable debe cambiar al modificar la variacion")
                .isNotEqualTo(extraPrimaAntes);
    }

    public void validarVariacionPersistida(Integer variacionEsperada) {
        page.get().waitForTimeout(1000);

        auto_waitForElementVisibility(INPUT_VARIACION);

        String variacionActual = auto_getElementTextOrValue(INPUT_VARIACION);
        String esperado = String.valueOf(variacionEsperada).trim();

        softAssertions.assertThat(variacionActual == null ? "" : variacionActual.trim())
                .as("La variacion debe persistir luego de editar cotizacion")
                .isEqualTo(esperado);
    }

    public void validarResumenActualizado() {
        validarResumenActualizado(false);
    }

    public void validarResumenActualizado(boolean esAuto) {
        String locatorPrima = esAuto ? PRIMA_TECNICA_AUTO__RESUMEN : PRIMA_TECNICA_RESUMEN;
        String locatorComision = esAuto ? COMISION_AUTO_RESUMEN : COMISION_RESUMEN;
        String locatorPremio = esAuto ? PREMIO_AUTO_RESUMEN : PREMIO_RESUMEN;

        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_waitForElementVisibility(locatorPrima);
        auto_waitForElementVisibility(locatorComision);
        auto_waitForElementVisibility(locatorPremio);

        String primaTecnicaActual = esperarValorResumenValido(locatorPrima, "Prima tecnica");
        String comisionActual = esperarValorResumenValido(locatorComision, "Comision");
        String premioActual = esperarValorResumenValido(locatorPremio, "Premio");

        softAssertions.assertThat(primaTecnicaActual)
                .as("La prima tecnica del resumen debe mantenerse sin cambios")
                .isEqualTo(primaTecnicaResumen);

        softAssertions.assertThat(comisionActual)
                .as("La comision del resumen debe actualizarse")
                .isNotEqualTo(comisionResumen);

        softAssertions.assertThat(premioActual)
                .as("El premio del resumen debe actualizarse")
                .isNotEqualTo(premioResumen);
        softAssertions.assertAll();
    }

    public void ingresarDomicilio(String vencimiento) {
        auto_setTextToInput(INPUT_DOMICILIO, vencimiento);
    }

    public void seleccionarRubro(String rubro) {
        page.get().waitForTimeout(1000);
        auto_waitForElementVisibility(String.format(SELECT_DESPLEGABLE, "Rubro"));
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Rubro"));
        auto_waitForElementVisibility(String.format(SELECT_OPCION, rubro));
        auto_setClickElement(String.format(SELECT_OPCION, rubro));
    }

    public void completarInformacionContacto(InformacionDeContacto contacto) {
        auto_setTextToInput(INPUT_NOMBRE_APELLIDO_CONTACTO, contacto.getNombreApellido());
        auto_setTextToInput(INPUT_TELEFONO_CONTACTO, contacto.getTelefono());
        auto_setTextToInput(INPUT_EMAIL_CONTACTO, contacto.getEmail());
        completarHorarioContacto(contacto);
    }

    public void completarHorarioContacto(InformacionDeContacto contacto) {
        auto_setTextToInput(INPUT_HORA_DESDE, contacto.getHoraDesde());
        auto_pressKey(INPUT_HORA_DESDE, "Enter");
        auto_setTextToInput(INPUT_HORA_HASTA, contacto.getHoraHasta());
        auto_pressKey(INPUT_HORA_HASTA, "Enter");
    }

    private String esperarValorResumenValido(String locator, String campo) {
        auto_waitForElementVisibility(locator);
        String ultimoValor = "";
        String patronValido = "(?i)^(?!recotizar$|cotizar$|emitir$).*[0-9].*$";

        for (int i = 0; i < 75; i++) {
            String valor = auto_getElementTextOrValue(locator);
            ultimoValor = valor == null ? "" : valor.trim();
            if (ultimoValor.matches(patronValido)) return ultimoValor;
            page.get().waitForTimeout(200);
        }
        softAssertions.assertThat(ultimoValor)
                .as("No se obtuvo un valor valido para " + campo + ". Ultimo valor leido: " + ultimoValor)
                .matches(patronValido);
        return ultimoValor;
    }
    public void seleccionarPlan(String plan) {
        auto_setClickElement(PLAN_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, plan));
    }
}
