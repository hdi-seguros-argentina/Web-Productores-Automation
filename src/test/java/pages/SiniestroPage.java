package pages;

import com.core.utility.MasterPage;
import com.google.gson.Gson;
import com.microsoft.playwright.Locator;
import models.SiniestroPolizaData;
import org.assertj.core.api.SoftAssertions;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static locators.CommonLocators.SELECT_OPCION;
import static locators.SiniestroLocators.*;

public class SiniestroPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta1
    public void seleccionDeBusqueda(String arg0) {
        page.get().waitForTimeout(500);
        auto_setClickElement(String.format(BUSQUEDA_BTN_XPATH, arg0));
    }

    public void verificaRadioBotonCorrecto(String arg0){
        Locator check = page.get().locator(String.format(RADIO_BTN_XPATH, arg0)).first();
        softAssertions.assertThat(auto_getCssValue(check, "background-color"))
                .as("Color de background de radio-boton incorrecto")
                .isEqualTo(COLOR_1);
    }

    public void completarBusquedaPorPolizaVigente(String ramo) {
        SiniestroPolizaData data = cargarPolizaDesdeJson(ramo);

        auto_setClickElement(RAMA_SELECT_XPATH);
        auto_setClickElement(String.format(SELECT_OPCION, ramo));

        auto_setTextToInput(POLIZA_INPUT_XPATH, data.getPoliza());

        String fechaHoy = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        auto_setTextToInput(FECHA_INPUT_XPATH, fechaHoy);
        auto_pressKey(FECHA_INPUT_XPATH, "Enter");

        auto_setTextToInput(HORA_INPUT_XPATH, "17:00");
        auto_pressKey(HORA_INPUT_XPATH, "Enter");

        auto_setClickElement(BUSCAR_POLIZA_BTN_XPATH);
    }

    private SiniestroPolizaData cargarPolizaDesdeJson(String ramo) {
        String nombreJson = switch (ramo == null ? "" : ramo.trim().toUpperCase()) {
            case "AUTOMOVILES" -> "src/test/resources/Datos/siniestro_automoviles.json";
            case "AUTOS - RESP. CIVIL" -> "src/test/resources/Datos/siniestro_autos_resp_civil.json";
            default -> throw new RuntimeException("No hay json configurado para el ramo: " + ramo);
        };

        try (Reader reader = new FileReader(nombreJson)) {
            SiniestroPolizaData data = new Gson().fromJson(reader, SiniestroPolizaData.class);
            if (data == null || data.getPoliza() == null || data.getPoliza().isBlank()) {
                throw new RuntimeException("No se encontró póliza guardada en: " + nombreJson);
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo póliza desde json: " + nombreJson, e);
        }
    }
}

