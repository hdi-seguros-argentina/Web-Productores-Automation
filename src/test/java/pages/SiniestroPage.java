package pages;

import com.core.utility.MasterPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import models.Siniestro;
import models.SiniestroUsado;
import org.assertj.core.api.SoftAssertions;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static locators.CommonLocators.BOTON_CONTINUAR;
import static locators.CommonLocators.SELECT_OPCION;
import static locators.SiniestroLocators.*;

public class SiniestroPage extends MasterPage {

    SoftAssertions softAssertions = new SoftAssertions();

    public static final String COLOR_1 = "rgb(227, 32, 94)";

    private static final String PATH_SINIESTROS_USADOS = "src/test/resources/Datos/siniestros_usados.json";

    private String polizaVigente;

    public void seleccionDeBusqueda(String arg0) {
        page.get().waitForTimeout(500);
        auto_setClickElement(String.format(BUSQUEDA_BTN_XPATH, arg0));
    }

    public void verificaRadioBotonCorrecto(String arg0) {
        Locator check = page.get().locator(String.format(RADIO_BTN_XPATH, arg0)).first();

        softAssertions.assertThat(auto_getCssValue(check, "background-color"))
                .as("Color de background de radio-boton incorrecto")
                .isEqualTo(COLOR_1);
    }

    public void completarBusquedaPorPolizaVigente(String ramo) {
        Siniestro data = cargarPolizaDesdeJson(ramo);

        String fecha = data.getFechaLugar().getFecha();
        String hora = obtenerProximaHoraDesdeUsados(data.getPoliza(), fecha, data.getFechaLugar().getHora());
        data.getFechaLugar().setHora(hora);

        auto_setClickElement(RAMA_SELECT_XPATH);
        auto_setClickElement(String.format(SELECT_OPCION, ramo));

        auto_setTextToInput(POLIZA_INPUT_XPATH, data.getPoliza());

        auto_setTextToInput(FECHA_INPUT_XPATH, fecha);
        auto_pressKey(FECHA_INPUT_XPATH, "Enter");

        auto_setTextToInput(HORA_INPUT_XPATH, hora);
        auto_pressKey(HORA_INPUT_XPATH, "Enter");

        auto_setClickElement(BUSCAR_POLIZA_BTN_XPATH);
    }
    private void buscarPolizaConHoraValida() {
        for (int hora = 0; hora <= 23; hora++) {
            String horaFormateada = String.format("%02d:00", hora);

            auto_setTextToInput(HORA_INPUT_XPATH, horaFormateada);
            auto_pressKey(HORA_INPUT_XPATH, "Enter");

            auto_setClickElement(BUSCAR_POLIZA_BTN_XPATH);
            page.get().waitForTimeout(1500);

            if (page.get().locator(ALERTA_HORA_INCORRECTA).count() == 0) {
                return;
            }
        }

        throw new RuntimeException("No se encontró una hora válida para buscar la póliza.");
    }

    private Siniestro cargarPolizaDesdeJson(String ramo) {
        String nombreJson = switch (ramo == null ? "" : ramo.trim().toUpperCase()) {
            case "AUTOMOVILES" -> "src/test/resources/Datos/siniestro_automoviles.json";
            case "AUTOS - RESP. CIVIL" -> "src/test/resources/Datos/siniestro_autos_resp_civil.json";
            default -> throw new RuntimeException("No hay json configurado para el ramo: " + ramo);
        };

        try (Reader reader = Files.newBufferedReader(Path.of(nombreJson), StandardCharsets.UTF_8)) {
            Siniestro data = new Gson().fromJson(reader, Siniestro.class);

            if (data == null || data.getPoliza() == null || data.getPoliza().isBlank()) {
                throw new RuntimeException("No se encontró póliza guardada en: " + nombreJson);
            }

            if (data.getRama() == null || !data.getRama().trim().equalsIgnoreCase(ramo.trim())) {
                throw new RuntimeException("La póliza guardada no corresponde al ramo " + ramo + ": " + nombreJson);
            }

            return data;
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo póliza desde json: " + nombreJson, e);
        }
    }

    public void buscarYGuardarPolizaVigente() {
        buscarYGuardarPolizaVigente(null);
    }

    public void buscarYGuardarPolizaVigente(String ramo) {
        page.get().waitForTimeout(10000);
        auto_waitForElementsInvisibilities(page.get().locator(SKELETON_LISTADO_POLIZAS));

        Locator cards = page.get().locator(CARDS_POLIZAS_LISTADO);
        esperarCardsDePolizas(cards);

        for (int i = 0; i < cards.count(); i++) {
            Locator card = cards.nth(i);
            if (card.locator(ESTADO_POLIZA_VIGENTE_EN_CARD).count() > 0) {
                polizaVigente = card.locator(NUMERO_POLIZA_EN_CARD)
                        .innerText()
                        .trim();
                break;
            }
        }

        softAssertions.assertThat(polizaVigente)
                .as("No se encontró ninguna póliza vigente en el listado.")
                .isNotBlank();
        softAssertions.assertAll();

        if (ramo != null && !ramo.isBlank()) {
            guardarPolizaVigenteEnJson(ramo, polizaVigente);
        }
    }

    private void esperarCardsDePolizas(Locator cards) {
        for (int i = 0; i < 40; i++) {
            if (cards.count() > 0) {
                return;
            }
            page.get().waitForTimeout(500);
        }

        throw new RuntimeException("No se encontraron cards de pólizas en el listado.");
    }

    private void guardarPolizaVigenteEnJson(String ramo, String poliza) {
        String nombreJson = switch (ramo == null ? "" : ramo.trim().toUpperCase()) {
            case "AUTOMOVILES" -> "src/test/resources/Datos/siniestro_automoviles.json";
            case "AUTOS - RESP. CIVIL" -> "src/test/resources/Datos/siniestro_autos_resp_civil.json";
            default -> throw new RuntimeException("No hay json configurado para el ramo: " + ramo);
        };

        Siniestro data;
        try (Reader reader = Files.newBufferedReader(Path.of(nombreJson), StandardCharsets.UTF_8)) {
            data = new Gson().fromJson(reader, Siniestro.class);
        } catch (Exception e) {
            data = new Siniestro(ramo, "");
        }

        if (data == null) {
            data = new Siniestro(ramo, "");
        }

        data.setRama(ramo);
        data.setPoliza(poliza);

        try (Writer writer = new FileWriter(nombreJson)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(data, writer);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar la poliza vigente en: " + nombreJson, e);
        }
    }

    public void iniciarDenuncia() {
        clickYEsperar(BOTON_INICIAR_DENUNCIA);
        auto_waitForElementVisibility(TITULO_NUEVA_DENUNCIA);
        auto_waitForElementVisibility(String.format(TITULO_SECCION, "Datos de la Póliza"));
    }

    public void completarFechaYLugar(Siniestro.FechaLugarSiniestro data) {
        auto_waitForElementVisibility(String.format(TITULO_SECCION, "Fecha del Siniestro"));
        auto_waitForElementVisibility(String.format(TITULO_SECCION, "Lugar de Ocurrencia"));

        seleccionarEnAntSelectPorInputId("dateAndPlaceForm_provinceOccurrence", data.getProvincia());
        seleccionarLocalidadOcurrencia(data.getLocalidad());
        completarInputPorId("dateAndPlaceForm_streetOccurrence", data.getCalle());
        completarInputPorId("dateAndPlaceForm_numberLocationOccurrence", data.getAltura());
        seleccionarEnAntSelectPorInputId("dateAndPlaceForm_typeRoadOccurrence", data.getTipoCalzada());

        clickContinuarYEsperar(String.format(TITULO_SECCION, "Datos del Conductor del Vehículo Asegurado"));
    }

    public void completarConductor(Siniestro.ConductorSiniestro data) {
        limpiarNombreConductor();

        String emailId = "dateAndPlaceForm_addressEmailDriver";
        String emailLocator = String.format(INPUT_POR_ID, emailId);
        auto_waitForElementVisibility(emailLocator);

        String emailActual = auto_getInputValue(emailLocator);
        if (emailActual == null || emailActual.trim().isBlank()) {
            completarInputPorId(emailId, data.getEmail());
        }

        clickContinuarYEsperar(String.format(TITULO_SECCION, "Datos del Asegurado Contratante"));
    }

    private void limpiarNombreConductor() {
        String nombreConductorId = "dateAndPlaceForm_nameDriver";
        String nombreConductorLocator = String.format(INPUT_POR_ID, nombreConductorId);
        auto_waitForElementVisibility(nombreConductorLocator);

        String nombreActual = auto_getInputValue(nombreConductorLocator);
        String nombreLimpio = limpiarCaracteresNombre(nombreActual);

        if (!nombreLimpio.equals(nombreActual)) {
            auto_setTextToInput(nombreConductorLocator, nombreLimpio);
        }
    }

    private String limpiarCaracteresNombre(String valor) {
        if (valor == null) {
            return "";
        }

        return valor
                .replaceAll("[^\\p{L}\\s]", "")
                .replaceAll("\\s{2,}", " ")
                .trim();
    }

    public void completarAseguradoYTipoSiniestro(Siniestro.TipoSiniestro data) {
        auto_waitForElementVisibility(String.format(TITULO_SECCION, "Tipo de Siniestro"));

        seleccionarCausaDanioParcial();
        auto_waitForElementVisibility(String.format(INPUT_POR_ID, "typeClaim_detailClaim"));
        completarInputPorId("typeClaim_detailClaim", data.getDetalle());

        clickContinuarYEsperar(String.format(TITULO_SECCION_UNICO, "Datos del Propietario - Tercero 1"));
    }

    private void seleccionarCausaDanioParcial() {
        try {
            seleccionarEnAntSelectPorInputId("typeClaim_cause", "DAÑO PARCIAL");
        } catch (RuntimeException e) {
            System.out.println("ERROR FALTA LA Ñ");
            seleccionarEnAntSelectPorInputId("typeClaim_cause", "DANO PARCIAL");
        }
    }

    public void completarTercerosOtrosVehiculos(Siniestro.TerceroSiniestro data) {
        completarDatosPropietarioTercero(data);
        completarDatosConductorTercero(data);
        completarVehiculoTerceroSiEstaVisible(data.getVehiculo());

        clickContinuarYEsperar(BOTON_CONTINUAR_DENUNCIA);
    }

    private void completarDatosPropietarioTercero(Siniestro.TerceroSiniestro data) {
        completarInputSiVisible("property-data-fire-form_name-owner-driver-tab-1", data.getNombrePropietario());
        seleccionarSiVisible("property-data-fire-form_document-type-owner-driver-tab-1", data.getTipoDocumento());
        completarInputSiVisible("property-data-fire-form_number-identification-owner-driver-tab-1", data.getNumeroDocumento());
        completarInputSiVisible("property-data-fire-form_address-email-owner-driver-tab-1", data.getEmail());
        completarInputSiVisible("property-data-fire-form_address-owner-driver-tab-1", data.getDomicilio());
        seleccionarSiVisible("property-data-fire-form_province-owner-driver-tab-1", data.getProvincia());
        seleccionarSiVisible("property-data-fire-form_location-owner-driver-tab-1", data.getLocalidad());
        seleccionarSiVisible("property-data-fire-form_gender-owner-driver-tab-1", data.getGenero());
        completarInputSiVisible("property-data-fire-form_registration-number-owner-driver-tab-1", data.getRegistro());
        completarInputSiVisible("property-data-fire-form_number-phone-owner-driver-tab-1", data.getTelefono());

        seleccionarRadioSiVisible("property-data-fire-form_has-lesions-owner-tab-1", "S");
        seleccionarSiVisible("property-data-fire-form_lesion-type-owner-tab-1", data.getTipoLesion());
        seleccionarSiVisible("property-data-fire-form_transported-owner-tab-1", data.getTransportado());
    }

    private void completarDatosConductorTercero(Siniestro.TerceroSiniestro data) {
        completarInputSiVisible("property-data-fire-form_name-driver-tab-1", data.getNombrePropietario());
        seleccionarSiVisible("property-data-fire-form_document-type-driver-tab-1", data.getTipoDocumento());
        completarInputSiVisible("property-data-fire-form_number-identification-driver-tab-1", data.getNumeroDocumento());
        completarInputSiVisible("property-data-fire-form_address-email-driver-tab-1", data.getEmail());
        completarInputSiVisible("property-data-fire-form_address-driver-tab-1", data.getDomicilio());
        seleccionarSiVisible("property-data-fire-form_province-driver-tab-1", data.getProvincia());
        seleccionarSiVisible("property-data-fire-form_location-driver-tab-1", data.getLocalidad());
        seleccionarSiVisible("property-data-fire-form_gender-driver-tab-1", data.getGenero());
        completarInputSiVisible("property-data-fire-form_registration-number-driver-tab-1", data.getRegistro());
        completarInputSiVisible("property-data-fire-form_number-phone-driver-tab-1", data.getTelefono());
    }

    private void completarVehiculoTerceroSiEstaVisible(Siniestro.VehiculoTercero data) {
        boolean vehiculoVisible = page.get().locator(VEHICULO_TERCERO_SECCION).count() > 0
                && page.get().locator(VEHICULO_TERCERO_SECCION).first().isVisible();

        System.out.println("Vehículo de tercero visible: " + vehiculoVisible);

        if (!vehiculoVisible || data == null) {
            return;
        }

        completarInputSiVisible("property-data-fire-form_domain-vehicle-tab-1", data.getDominio());
        seleccionarSiVisible("property-data-fire-form_year-vehicle-tab-1", data.getAnio());
        seleccionarSiVisible("property-data-fire-form_brand-vehicle-tab-1", data.getMarca());
        seleccionarSiVisible("property-data-fire-form_model-vehicle-tab-1", data.getModelo());
        seleccionarSiVisible("property-data-fire-form_use-vehicle-tab-1", data.getUso());
        seleccionarSiVisible("property-data-fire-form_type-vehicle-tab-1", data.getTipo());
        completarInputSiVisible("property-data-fire-form_motor-number-vehicle-tab-1", data.getNumeroMotor());
        completarInputSiVisible("property-data-fire-form_chassis-number-vehicle-tab-1", data.getNumeroChasis());
    }

    public void finalizarDenuncia() {
        clickYEsperar(BOTON_CONTINUAR_DENUNCIA);
        clickYEsperar(BOTON_ENVIAR_DENUNCIA);
    }

    public void finalizarDenunciaConPasoIntermedio() {
        clickYEsperar(BOTON_CONTINUAR_DENUNCIA);
        clickYEsperar(BOTON_ENVIAR_DENUNCIA);
    }

    public void verificarDenunciaRegistrada(Siniestro dataAutomoviles) {
        auto_waitForElementInvisibility(".ant-spin-spinning");
        page.get().waitForTimeout(2000);

        String poliza = dataAutomoviles.getPoliza();
        String fecha = dataAutomoviles.getFechaLugar().getFecha();
        String hora = obtenerProximaHoraDesdeUsados(poliza, fecha, dataAutomoviles.getFechaLugar().getHora());
        dataAutomoviles.getFechaLugar().setHora(hora);

        if (auto_isElementVisible(MENSAJE_SINIESTRO_DUPLICADO)) {
            guardarSiniestroUsado(poliza, fecha, hora);

            String nuevaHora = obtenerProximaHoraDesdeUsados(poliza, fecha, hora);
            dataAutomoviles.getFechaLugar().setHora(nuevaHora);
            guardarSiniestroUsado(poliza, fecha, nuevaHora);

            auto_setClickElement(BOTON_NUEVA_DENUNCIA);

            seleccionDeBusqueda("Póliza");

            auto_setClickElement(RAMA_SELECT_XPATH);
            auto_setClickElement(String.format(SELECT_OPCION, dataAutomoviles.getRama()));

            auto_setTextToInput(POLIZA_INPUT_XPATH, dataAutomoviles.getPoliza());

            auto_setTextToInput(FECHA_INPUT_XPATH, fecha);
            auto_pressKey(FECHA_INPUT_XPATH, "Enter");

            auto_setTextToInput(HORA_INPUT_XPATH, nuevaHora);
            auto_pressKey(HORA_INPUT_XPATH, "Enter");

            auto_setClickElement(BUSCAR_POLIZA_BTN_XPATH);

            iniciarDenuncia();
            completarFechaYLugar(dataAutomoviles.getFechaLugar());
            completarConductor(dataAutomoviles.getConductor());
            completarAseguradoYTipoSiniestro(dataAutomoviles.getTipoSiniestro());
            completarTercerosOtrosVehiculos(dataAutomoviles.getTercero());
            finalizarDenuncia();

            auto_waitForElementInvisibility(".ant-spin-spinning");
        }

        auto_waitForElementVisibility(MENSAJE_DENUNCIA_REGISTRADA);

        guardarSiniestroUsado(
                dataAutomoviles.getPoliza(),
                dataAutomoviles.getFechaLugar().getFecha(),
                dataAutomoviles.getFechaLugar().getHora()
        );
    }

    private void clickYEsperar(String locator) {
        auto_waitForElementVisibility(locator);
        auto_setClickElement(locator);
        page.get().waitForLoadState(LoadState.NETWORKIDLE);
        esperarSpinnerSiExiste();
    }

    private void esperarSpinnerSiExiste() {
        try {
            page.get().waitForTimeout(300);
            auto_waitForElementInvisibility(".ant-spin-spinning");
        } catch (Exception ignored) {
            page.get().waitForTimeout(1000);
        }
    }

    private void completarInputPorId(String id, String valor) {
        String locator = String.format(INPUT_POR_ID, id);
        auto_waitForElementVisibility(locator);
        auto_setTextToInput(locator, valor);
        auto_pressKey(locator, "Enter");
    }

    private void completarInputSiVisible(String id, String valor) {
        if (valor == null || valor.isBlank()) {
            return;
        }

        String locator = String.format(INPUT_POR_ID, id);
        if (page.get().locator(locator).count() == 0 || !page.get().locator(locator).first().isVisible()) {
            return;
        }

        auto_setTextToInput(locator, valor);
        auto_pressKey(locator, "Enter");
    }

    private void seleccionarSiVisible(String inputId, String valor) {
        String locator = String.format(SELECT_POR_INPUT_ID, inputId);
        if (page.get().locator(locator).count() == 0 || !page.get().locator(locator).first().isVisible()) {
            return;
        }

        seleccionarEnAntSelectPorInputId(inputId, valor);
    }

    private void seleccionarLocalidadOcurrencia(String localidad) {
        String inputId = "dateAndPlaceForm_locationOccurrence";
        String selectLocator = String.format(SELECT_POR_INPUT_ID, inputId);
        String inputLocator = String.format(INPUT_POR_ID, inputId);

        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_waitForElementVisibility(selectLocator);

        for (int i = 0; i < 60; i++) {
            String clases = page.get().locator(selectLocator).first().getAttribute("class");
            String className = clases == null ? "" : clases;
            if (!className.contains("ant-select-disabled") && !className.contains("ant-select-loading")) {
                break;
            }
            page.get().waitForTimeout(250);
        }

        for (int intento = 1; intento <= 3; intento++) {
            page.get().locator(selectLocator).click();
            page.get().waitForTimeout(500);

            try {
                Locator input = page.get().locator(inputLocator).first();
                if (localidad != null && !localidad.isBlank() && input.count() > 0 && input.isEditable()) {
                    input.fill(localidad);
                    page.get().waitForTimeout(1000);
                }
            } catch (Exception ignored) {
            }

            if (localidad != null && !localidad.isBlank()
                    && clickOpcionSiExiste(String.format(SELECT_OPCION, localidad))) {
                esperarSpinnerSiExiste();
                return;
            }

            if (localidad != null && !localidad.isBlank()
                    && clickOpcionSiExiste(String.format(OPCION_SELECT_CONTIENE, localidad))) {
                esperarSpinnerSiExiste();
                return;
            }

            Locator primeraOpcion = page.get().locator(PRIMERA_OPCION_SELECT_VISIBLE).first();
            for (int j = 0; j < 20; j++) {
                if (primeraOpcion.count() > 0 && primeraOpcion.isVisible()) {
                    primeraOpcion.click();
                    esperarSpinnerSiExiste();
                    return;
                }
                page.get().waitForTimeout(250);
            }

            page.get().keyboard().press("Escape");
            page.get().waitForTimeout(1000);
        }

        throw new RuntimeException("No se pudo seleccionar opción para el campo: " + inputId);
    }

    private void seleccionarEnAntSelectPorInputId(String inputId, String valor) {
        String selectLocator = String.format(SELECT_POR_INPUT_ID, inputId);
        String inputLocator = String.format(INPUT_POR_ID, inputId);

        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_waitForElementVisibility(selectLocator);
        page.get().locator(selectLocator).click();
        page.get().waitForTimeout(300);

        if (valor != null && !valor.isBlank()) {
            try {
                Locator input = page.get().locator(inputLocator).first();
                if (input.count() > 0 && input.isEditable()) {
                    input.fill(valor);
                    page.get().waitForTimeout(500);
                }
            } catch (Exception ignored) {
            }

            if (clickOpcionSiExiste(String.format(SELECT_OPCION, valor))) {
                esperarSpinnerSiExiste();
                return;
            }

            if (clickOpcionSiExiste(String.format(OPCION_SELECT_CONTIENE, valor))) {
                esperarSpinnerSiExiste();
                return;
            }
        }

        if (!clickOpcionSiExiste(PRIMERA_OPCION_SELECT_VISIBLE)) {
            throw new RuntimeException("No se pudo seleccionar opción para el campo: " + inputId);
        }

        esperarSpinnerSiExiste();
    }

    private boolean clickOpcionSiExiste(String locator) {
        Locator opcion = page.get().locator(locator).first();
        if (opcion.count() > 0 && opcion.isVisible()) {
            opcion.click();
            return true;
        }
        return false;
    }

    private void seleccionarRadioSiVisible(String grupoId, String valor) {
        String locator = String.format(RADIO_POR_GRUPO_VALOR, grupoId, valor);
        if (page.get().locator(locator).count() == 0 || !page.get().locator(locator).first().isVisible()) {
            return;
        }

        page.get().locator(locator).first().click();
        page.get().waitForTimeout(500);
    }

    public void clickContinuarYEsperar(String tituloSiguienteSeccion) {
        auto_setClickElement(BOTON_CONTINUAR);
        auto_waitForElementInvisibility(".ant-spin-spinning");
        auto_waitForElementVisibility(tituloSiguienteSeccion);
    }

    private String obtenerProximaHoraDesdeUsados(String poliza, String fecha, String horaInicial) {
        List<SiniestroUsado> siniestrosUsados = leerSiniestrosUsados();

        return siniestrosUsados.stream()
                .filter(s -> s.getPoliza().equals(poliza) && s.getFecha().equals(fecha))
                .findFirst()
                .map(s -> LocalTime.parse(s.getHora()).plusHours(1).toString())
                .orElse(horaInicial);
    }

    private List<SiniestroUsado> leerSiniestrosUsados() {
        Gson gson = new Gson();

        try (Reader reader = Files.newBufferedReader(Path.of(PATH_SINIESTROS_USADOS), StandardCharsets.UTF_8)) {
            Type listType = new TypeToken<List<SiniestroUsado>>() {}.getType();
            List<SiniestroUsado> siniestrosUsados = gson.fromJson(reader, listType);
            return siniestrosUsados == null ? new ArrayList<>() : siniestrosUsados;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void guardarSiniestroUsado(String poliza, String fecha, String hora) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<SiniestroUsado> siniestrosUsados = leerSiniestrosUsados();

        SiniestroUsado registroExistente = siniestrosUsados.stream()
                .filter(s -> s.getPoliza().equals(poliza)
                        && s.getFecha().equals(fecha))
                .findFirst()
                .orElse(null);

        if (registroExistente != null) {
            siniestrosUsados.remove(registroExistente);
        }

        siniestrosUsados.add(new SiniestroUsado(poliza, fecha, hora));

        try (Writer writer = new FileWriter(PATH_SINIESTROS_USADOS)) {
            gson.toJson(siniestrosUsados, writer);
        } catch (Exception e) {
            throw new RuntimeException("Error guardando siniestro usado", e);
        }
    }
}
