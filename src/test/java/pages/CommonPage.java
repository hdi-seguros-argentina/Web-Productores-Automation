package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import models.Cobertura;
import models.InformacionDeContacto;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static locators.AutomovilesLocators.*;
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
        auto_waitForElementInvisibilityIfPresent("//div[contains(@class,'ant-spin-spinning')]");
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
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        clickConReintento(BOTON_BUSCAR_CLIENTE);
        clickConReintento(String.format(RESULTADO_CLIENTE, cliente));
    }

    public void clickBotonContinuar() {
        auto_setClickElement(BOTON_CONTINUAR);
        auto_waitForLoadStates(LoadState.NETWORKIDLE);
    }

    public void seleccionarNacionalidad(String nacionalidad) {
        auto_waitForElementVisibility(NACIONALIDAD_SELECT);
        Locator nacionalidadSelect = page.get().locator(NACIONALIDAD_SELECT).first();
        Locator nacionalidadInput = page.get().locator(NACIONALIDAD_INPUT_SELECT).first();

        String clasesSelect = nacionalidadSelect.getAttribute("class");
        if ((clasesSelect != null && clasesSelect.contains("ant-select-disabled"))
                || nacionalidadInput.isDisabled()) {
            return;
        }

        auto_setTextToInput(NACIONALIDAD_INPUT_SELECT, nacionalidad);
        auto_pressKey(NACIONALIDAD_INPUT_SELECT, "Enter");
    }

    public void ingresarNumeroTarjeta(String numero) {
        auto_typeSequentially(INPUT_TARJETA, numero);
        auto_pressKey(INPUT_TARJETA, "Enter");
        page.get().waitForTimeout(300);
    }

    public void seleccionarEmpresaTarjeta(String empresaTarjeta) {
        String tarjetaSeleccionada = String.format(TARJETA_CREDITO_SELECCIONADA, empresaTarjeta);
        Locator valor = page.get().locator(tarjetaSeleccionada).first();

        if (empresaTarjeta != null && !empresaTarjeta.isBlank() &&
                (valor.count() == 0 || valor.textContent().trim().isBlank())) {
            auto_setClickElement(TARJETA_CREDITO_SELECT);
            Locator opcion = page.get().locator(String.format(TARJETA_CREDITO_OPCION_POR_TEXTO, empresaTarjeta)).first();
            if (opcion.count() > 0 && opcion.isVisible()) opcion.click();
        }
        auto_waitForElementVisibility(tarjetaSeleccionada);
        softAssertions.assertThat(valor.isVisible() ? valor.textContent().trim() : "")
                .as("La compañía de tarjeta no coincide con el valor del JSON")
                .isEqualTo(empresaTarjeta);
        softAssertions.assertAll();
    }
    public void seleccionarMetodoPago(String metodoPago) {
        String valorActual = auto_getElementTextOrValue(METODO_PAGO_VALOR_ACTUAL);
        auto_setClickElement(METODO_PAGO_SELECT);
        if (valorActual != null && valorActual.trim().equalsIgnoreCase("undefined")) {
            auto_setClickElement(String.format(SELECT_OPCION, metodoPago));
        }
    }

    public void ingresarVencimiento(String vencimiento) {
        auto_setTextToInput(INPUT_VENCIMIENTO, vencimiento);
    }

    public void clickBotonCotizar() {
        auto_setClickElement(BOTON_COTIZAR);
    }

    public void guardarCotizacion() {
        try {
            auto_waitForElementVisibility(BOTON_GUARDAR_COTIZACION);
            clickConReintento(BOTON_GUARDAR_COTIZACION);
        } catch (Exception e) {
            page.get().waitForTimeout(1500);
            auto_waitForElementVisibility(BOTON_GUARDAR_COTIZACION);
            clickConReintento(BOTON_GUARDAR_COTIZACION);
        }
    }

    public void clickEditarCotizacion() {
        page.get().waitForTimeout(1000);
        auto_waitForElementVisibility(BOTON_LAPIZ_EDITAR);
        auto_setClickElement(BOTON_LAPIZ_EDITAR);
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        auto_waitForElementVisibility(TITULO_NUEVACOTIZACION_XPATH);
    }

    public void clickBotonEmitir() {
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        auto_waitForElementVisibility(BOTON_EMITIR);
        auto_setClickElement(BOTON_EMITIR);
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
    }

    public void clickBotonRecotizar() {
        page.get().waitForTimeout(4000);
        auto_waitForElementVisibility(BOTON_RECOTIZAR);
        auto_setClickElement(BOTON_RECOTIZAR);
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
    }

    public void clickBotonGuardar() {
        auto_waitForElementVisibility(BOTON_GUARDAR);
        auto_setClickElement(BOTON_GUARDAR);
    }

    public void clickBotonEnviar() {
        Exception ultimoError = null;

        for (int intento = 1; intento <= 4; intento++) {
            try {
                if (cotizacionEnviadaCorrectamente()) {
                    return;
                }
                auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
                Locator botonEnviar = page.get().locator(BOTON_ENVIAR).first();
                botonEnviar.waitFor();
                botonEnviar.scrollIntoViewIfNeeded();
                botonEnviar.click(new Locator.ClickOptions()
                        .setTimeout(5000)
                        .setForce(intento == 4));
                return;
            } catch (Exception e) {
                if (cotizacionEnviadaCorrectamente()) {
                    return;
                }
                ultimoError = e;
                page.get().waitForTimeout(700);
            }
        }

        throw new RuntimeException("No se pudo hacer click en el boton Enviar luego de reintentos", ultimoError);
    }

    public boolean seVisualizaPatenteDuplicada() {
        for (int i = 0; i < 20; i++) {
            if (cotizacionEnviadaCorrectamente()) {
                return false;
            }
            if (estaVisible(MENSAJE_PATENTE_DUPLICADA)) {
                return true;
            }
            page.get().waitForTimeout(500);
        }
        return false;
    }

    public boolean cotizacionEnviadaCorrectamente() {
        return estaVisible(POLIZA_ENVIO_TITULO) || estaVisible(POLIZA_ENVIO_TEXTO);
    }

    private boolean estaVisible(String locator) {
        Locator elemento = page.get().locator(locator).first();
        return elemento.count() > 0 && elemento.isVisible();
    }

    public void verificaEnvioCotizacion() {
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(POLIZA_ENVIO_TITULO))
                .as("No se pudo enviar la cotización")
                .doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(POLIZA_ENVIO_TEXTO))
                .as("No se visualiza el texto de envío de cotización")
                .doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(POLIZA_ENVIO_BOTON_ACEPTAR))
                .as("No se visualiza el boton Aceptar en el envío de cotización")
                .doesNotThrowAnyException();
        softAssertions.assertAll();
    }

    public void seleccionarProvincia(String provincia) {
        String desplegableProvincia = resolverSelectVisible(
                String.format(SELECT_DESPLEGABLE, "Provincia"),
                PROVINCIA_CONSORCIO_SELECT
        );
        auto_setClickElement(desplegableProvincia);
        auto_setClickElement(String.format(SELECT_OPCION, provincia));
    }

    public void seleccionarLocalidad(String localidad) {
        String desplegableLocalidad = resolverSelectVisible(String.format(SELECT_DESPLEGABLE, "Localidad"));
        String opcionLocalidad = String.format(SELECT_OPCION, localidad);
        String contenidoVisibleLocalidad = desplegableLocalidad
                + "//span[contains(@class,'ant-select-selection-item') or contains(@class,'ant-select-selection-placeholder')]";

        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        auto_waitForElementVisibility(contenidoVisibleLocalidad);

        Locator selectLocalidad = page.get().locator(desplegableLocalidad).first();
        for (int i = 0; i < 20; i++) {
            String clases = selectLocalidad.getAttribute("class");
            if (clases != null && !clases.contains("ant-select-disabled") && !clases.contains("ant-select-loading")) {
                break;
            }
            page.get().waitForTimeout(300);
        }

        auto_setClickElement(desplegableLocalidad);
        auto_waitForElementVisibility(opcionLocalidad);
        auto_setClickElement(opcionLocalidad);
    }

    private String resolverSelectVisible(String... locators) {
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        for (int intento = 0; intento < 30; intento++) {
            for (String locator : locators) {
                Locator select = page.get().locator(locator).first();
                if (select.count() > 0 && select.isVisible()) {
                    return locator;
                }
            }
            page.get().waitForTimeout(300);
        }
        return locators[0];
    }

    public void seleccionarCobertura(String nombreCobertura) {
        validarCoberturaSinEnie(nombreCobertura);
        String label = String.format(COBERTURA_LABEL, nombreCobertura);
        String checkbox = String.format(COBERTURA_CHECKBOX, nombreCobertura);
        softAssertions.assertThatCode(() -> auto_waitForElementVisibility(label))
                .as("No se encuentra la cobertura: " + nombreCobertura)
                .doesNotThrowAnyException();

        Locator checkboxInput = page.get().locator(checkbox).first();
        checkboxInput.waitFor();
        if (!checkboxInput.isChecked()) {
            page.get().locator(label).first().click();
        }
        softAssertions.assertAll();
    }

    private void validarCoberturaSinEnie(String nombreCobertura) {
        String nombreSinEnie = nombreCobertura.replace("Ñ", "N").replace("ñ", "n");
        if (nombreSinEnie.equals(nombreCobertura)) {
            return;
        }

        String labelCorrecto = String.format(COBERTURA_LABEL, nombreCobertura);
        String labelSinEnie = String.format(COBERTURA_LABEL, nombreSinEnie);
        for (int intento = 0; intento < 30; intento++) {
            if (page.get().locator(labelCorrecto).first().count() > 0) {
                return;
            }
            if (page.get().locator(labelSinEnie).first().count() > 0) {
                System.out.println("ERROR FALTA LA Ñ");
                softAssertions.assertThat(false)
                        .as("ERROR FALTA LA Ñ en la cobertura: " + nombreSinEnie)
                        .isTrue();
                return;
            }
            page.get().waitForTimeout(300);
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
        softAssertions.assertThat(coberturas)
                .as("No se encontraron coberturas para completar")
                .isNotNull()
                .isNotEmpty();

        if (coberturas != null) {
            coberturas.forEach(c ->
                    softAssertions.assertThatCode(() -> {
                        seleccionarCobertura(c.getNombre());
                        ingresarSumaCobertura(c.getNombre(), c.getSuma());
                    }).as("No se pudo completar la cobertura: " + c.getNombre())
                            .doesNotThrowAnyException()
            );
        }

        softAssertions.assertAll();
    }

    public void guardarValoresAntesDeVariacion() {
        guardarValoresResumen(PRIMA_TECNICA_RESUMEN, COMISION_RESUMEN, PREMIO_RESUMEN, false);
    }

    public void guardarValoresAntesDeVariacionAuto() {
        guardarValoresResumen(PRIMA_TECNICA_AUTO__RESUMEN, COMISION_AUTO_RESUMEN, PREMIO_AUTO_RESUMEN, true);
    }

    private void guardarValoresResumen(String locatorPrima, String locatorComision, String locatorPremio, boolean esAuto) {
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        comisionAntes = auto_getElementTextOrValue(COMISION_CAMPO);
        extraPrimaAntes = auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO);
        primaTecnicaResumen = esperarValorResumenValido(locatorPrima, "Prima tecnica", esAuto);
        comisionResumen = esperarValorResumenValido(locatorComision, "Comisión", esAuto);
        premioResumen = esperarValorResumenValido(locatorPremio, "Premio", esAuto);
    }

    public void validarCambioVariacion(Integer variacion) {
        double comisionBase = parseNumeroMonetario(comisionAntes, "Comisión antes de variación");
        double extraPrimaBase = parseNumeroMonetario(extraPrimaAntes, "Extra prima variable antes de variación");

        auto_setTextToInput(INPUT_VARIACION, String.valueOf(variacion));
        auto_pressKey(INPUT_VARIACION, "Enter");

        page.get().waitForTimeout(2000);

        String comisionDespues = auto_getElementTextOrValue(COMISION_CAMPO);
        String extraPrimaDespues = auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO);
        double comisionActual = parseNumeroMonetario(comisionDespues, "Comisión después de variación");
        double extraPrimaActual = parseNumeroMonetario(extraPrimaDespues, "Extra prima variable después de variación");

        softAssertions.assertThat(comisionDespues)
                .as("La comisión debe cambiar al modificar La variación")
                .isNotEqualTo(comisionAntes);

        softAssertions.assertThat(extraPrimaDespues)
                .as("La extra prima variable debe cambiar al modificar La variación")
                .isNotEqualTo(extraPrimaAntes);

        softAssertions.assertThat(comisionActual)
                .as("La comisión debe sumar los puntos de variación al valor base")
                .isEqualTo(comisionBase + variacion);

        softAssertions.assertThat(extraPrimaActual)
                .as("La extra prima variable debe sumar los puntos de variación al valor base")
                .isEqualTo(extraPrimaBase + variacion);
        softAssertions.assertAll();
    }

    public void validarVariacionPersistida(Integer variacionEsperada) {
        page.get().waitForTimeout(1000);

        auto_waitForElementVisibility(INPUT_VARIACION);

        String variacionActual = auto_getElementTextOrValue(INPUT_VARIACION);
        String esperado = String.valueOf(variacionEsperada).trim();

        softAssertions.assertThat(variacionActual == null ? "" : variacionActual.trim())
                .as("La variación debe persistir luego de editar cotización")
                .isEqualTo(esperado);
        softAssertions.assertAll();
    }

    public void validarSubaYBajaDeComisionYExtraPrima(Integer variacionBase) {
        validarSubaYBajaDeComisionYExtraPrimaPorLocators(
                variacionBase,
                PRIMA_TECNICA_RESUMEN,
                COMISION_RESUMEN,
                PREMIO_RESUMEN,
                false
        );
    }

    public void validarSubaYBajaDeComisionYExtraPrimaAuto(Integer variacionBase) {
        validarSubaYBajaDeComisionYExtraPrimaPorLocators(
                variacionBase,
                PRIMA_TECNICA_AUTO__RESUMEN,
                COMISION_AUTO_RESUMEN,
                PREMIO_AUTO_RESUMEN,
                true
        );
    }

    private void validarSubaYBajaDeComisionYExtraPrimaPorLocators(
            Integer variacionBase,
            String locatorPrima,
            String locatorComision,
            String locatorPremio,
            boolean esAuto
    ) {
        auto_waitForElementVisibility(INPUT_VARIACION);
        page.get().waitForTimeout(1000);
        auto_waitForElementVisibility(COMISION_CAMPO);
        auto_waitForElementVisibility(EXTRA_PRIMA_VARIABLE_CAMPO);
        guardarValoresResumen(locatorPrima, locatorComision, locatorPremio, esAuto);

        double comisionBase = parseNumeroMonetario(auto_getElementTextOrValue(COMISION_CAMPO), "Comisión base");
        double extraBase = parseNumeroMonetario(auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO), "Extra prima base");
        double comisionResumenBase = parseNumeroMonetario(comisionResumen, "Comisión resumen base");
        double premioResumenBase = parseNumeroMonetario(premioResumen, "Premio resumen base");

        int variacionMasUno = variacionBase + 1;
        auto_setTextToInput(INPUT_VARIACION, String.valueOf(variacionMasUno));
        auto_pressKey(INPUT_VARIACION, "Enter");
        clickBotonRecotizar();

        double comisionMasUno = parseNumeroMonetario(auto_getElementTextOrValue(COMISION_CAMPO), "Comisión +1");
        double extraMasUno = parseNumeroMonetario(auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO), "Extra prima +1");
        String primaResumenMasUno = esperarValorResumenValido(locatorPrima, "Prima tecnica +1", esAuto);
        String comisionResumenMasUnoTexto = esperarValorResumenValido(locatorComision, "Comisión +1", esAuto);
        String premioResumenMasUnoTexto = esperarValorResumenValido(locatorPremio, "Premio +1", esAuto);
        double comisionResumenMasUno = parseNumeroMonetario(comisionResumenMasUnoTexto, "Comisión resumen +1");
        double premioResumenMasUno = parseNumeroMonetario(premioResumenMasUnoTexto, "Premio resumen +1");

        softAssertions.assertThat(comisionMasUno)
                .as("La comisión debe sumar los puntos de variación al valor base")
                .isEqualTo(comisionBase + variacionMasUno);
        softAssertions.assertThat(extraMasUno)
                .as("La extra prima variable debe sumar los puntos de variación al valor base")
                .isEqualTo(extraBase + variacionMasUno);
        softAssertions.assertThat(primaResumenMasUno)
                .as("La prima tecnica del resumen debe mantenerse sin cambios al subir la variación")
                .isEqualTo(primaTecnicaResumen);
        softAssertions.assertThat(comisionResumenMasUno)
                .as("La comisión del resumen debe subir al aumentar 1 punto La variación")
                .isGreaterThan(comisionResumenBase);
        softAssertions.assertThat(premioResumenMasUno)
                .as("El premio del resumen debe subir al aumentar 1 punto La variación")
                .isGreaterThan(premioResumenBase);

        auto_setTextToInput(INPUT_VARIACION, String.valueOf(variacionBase));
        auto_pressKey(INPUT_VARIACION, "Enter");
        clickBotonRecotizar();

        double comisionRestablecida = parseNumeroMonetario(auto_getElementTextOrValue(COMISION_CAMPO), "Comisión restablecida");
        double extraRestablecida = parseNumeroMonetario(auto_getElementTextOrValue(EXTRA_PRIMA_VARIABLE_CAMPO), "Extra prima restablecida");
        String primaResumenRestablecida = esperarValorResumenValido(locatorPrima, "Prima tecnica restablecida", esAuto);
        double comisionResumenRestablecida = parseNumeroMonetario(esperarValorResumenValido(locatorComision, "Comisión restablecida", esAuto), "Comisión resumen restablecida");
        double premioResumenRestablecido = parseNumeroMonetario(esperarValorResumenValido(locatorPremio, "Premio restablecido", esAuto), "Premio resumen restablecido");

        softAssertions.assertThat(comisionRestablecida)
                .as("La comisión debe volver al valor base más la variación seteada")
                .isEqualTo(comisionBase + variacionBase);
        softAssertions.assertThat(extraRestablecida)
                .as("La extra prima variable debe volver al valor base más la variación seteada")
                .isEqualTo(extraBase + variacionBase);
        softAssertions.assertThat(primaResumenRestablecida)
                .as("La prima tecnica del resumen debe mantenerse sin cambios al bajar la variación")
                .isEqualTo(primaTecnicaResumen);
        softAssertions.assertThat(comisionResumenRestablecida)
                .as("La comisión del resumen debe bajar al volver 1 punto La variación")
                .isLessThan(comisionResumenMasUno);
        softAssertions.assertThat(premioResumenRestablecido)
                .as("El premio del resumen debe bajar al volver 1 punto La variación")
                .isLessThan(premioResumenMasUno);
        softAssertions.assertAll();
    }

    public void validarResumenActualizado() {
        validarResumenActualizadoPorLocators(PRIMA_TECNICA_RESUMEN, COMISION_RESUMEN, PREMIO_RESUMEN, false);
    }

    public void validarResumenActualizadoAuto() {
        validarResumenActualizadoPorLocators(PRIMA_TECNICA_AUTO__RESUMEN, COMISION_AUTO_RESUMEN, PREMIO_AUTO_RESUMEN, true);
    }

    private void validarResumenActualizadoPorLocators(String locatorPrima, String locatorComision, String locatorPremio, boolean esAuto) {
        auto_waitForElementInvisibilityIfPresent(".ant-spin-spinning");
        esperarResumenVisible(locatorPrima, "Prima", esAuto);
        esperarResumenVisible(locatorComision, "Comisi", esAuto);
        esperarResumenVisible(locatorPremio, "Premio", esAuto);

        String primaTecnicaActual = esperarValorResumenValido(locatorPrima, "Prima tecnica", esAuto);
        String comisionActual = esperarValorResumenValido(locatorComision, "Comisión", esAuto);
        String premioActual = esperarValorResumenValido(locatorPremio, "Premio", esAuto);

        softAssertions.assertThat(primaTecnicaActual)
                .as("La prima tecnica del resumen debe mantenerse sin cambios")
                .isEqualTo(primaTecnicaResumen);

        softAssertions.assertThat(comisionActual)
                .as("La comisión del resumen debe actualizarse")
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

    private String esperarValorResumenValido(String locator, String campo, boolean esAuto) {
        esperarResumenVisible(locator, campo, esAuto);
        String ultimoValor = "";
        String patronValido = "(?i)^(?!recotizar$|cotizar$|emitir$).*[0-9].*$";

        for (int i = 0; i < 75; i++) {
            String valor = esAuto
                    ? getTextoOValor(localizarValorResumenAutoSeleccionado(campo))
                    : auto_getElementTextOrValue(locator);
            ultimoValor = valor == null ? "" : valor.trim();
            if (ultimoValor.matches(patronValido)) return ultimoValor;
            page.get().waitForTimeout(200);
        }
        softAssertions.assertThat(ultimoValor)
                .as("No se obtuvo un valor valido para " + campo + ". Ultimo valor leido: " + ultimoValor)
                .matches(patronValido);
        return ultimoValor;
    }

    private void esperarResumenVisible(String locator, String campo, boolean esAuto) {
        if (!esAuto) {
            auto_waitForElementVisibility(locator);
            return;
        }
        softAssertions.assertThatCode(() -> localizarValorResumenAutoSeleccionado(campo).waitFor())
                .as("No se encontro el valor de " + campo + " en la card de cobertura seleccionada")
                .doesNotThrowAnyException();
        softAssertions.assertAll();
    }

    private Locator localizarValorResumenAutoSeleccionado(String campo) {
        String locator = obtenerLocatorResumenAutoSeleccionado(campo);
        return page.get().locator(locator).first();
    }

    private String obtenerLocatorResumenAutoSeleccionado(String campo) {
        if (campo.contains("Prima")) return PRIMA_AUTO_SELECCIONADA_RESUMEN;
        if (campo.contains("Comisi")) return COMISION_AUTO_SELECCIONADA_RESUMEN;
        return PREMIO_AUTO_SELECCIONADA_RESUMEN;
    }

    private String getTextoOValor(Locator locator) {
        Object valor = locator.evaluate("e => (e instanceof HTMLInputElement || e instanceof HTMLTextAreaElement || e instanceof HTMLSelectElement) ? e.value : e.textContent");
        return valor == null ? "" : valor.toString().trim();
    }

    private double parseNumeroMonetario(String valorOriginal, String campo) {
        String valor = valorOriginal == null ? "" : valorOriginal.trim();
        String limpio = valor.replaceAll("[^0-9,.-]", "");

        if (limpio.isEmpty() || limpio.equals("-") || limpio.equals(",") || limpio.equals(".")) {
            throw new RuntimeException("No se pudo parsear el campo " + campo + ". Valor original: " + valorOriginal);
        }

        int ultimaComa = limpio.lastIndexOf(',');
        int ultimoPunto = limpio.lastIndexOf('.');
        if (ultimaComa > ultimoPunto) {
            limpio = limpio.replace(".", "");
            limpio = limpio.replace(",", ".");
        } else if (ultimoPunto > ultimaComa) {
            limpio = limpio.replace(",", "");
        } else {
            limpio = limpio.replace(",", "");
        }

        try {
            return Double.parseDouble(limpio);
        } catch (NumberFormatException e) {
            throw new RuntimeException("No se pudo parsear el campo " + campo + ". Valor original: " + valorOriginal, e);
        }
    }

    public void seleccionarPlan(String plan) {
        String planSelect = resolverSelectVisible(PLAN_SELECT, PLAN_ROBO_SELECT);
        auto_setClickElement(planSelect);
        auto_setClickElement(String.format(SELECT_OPCION, plan));
    }
}


