package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.CotizacionAutomoviles;
import models.Vehiculo;
import org.assertj.core.api.SoftAssertions;

import java.io.FileWriter;

import static locators.AutomovilesLocators.*;
import static locators.CommonLocators.*;

public class AutomovilesPage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();

    public void completarDatosVehiculo(Vehiculo vehiculo) {
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Año Vehículo"));
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getAnio()));

        page.get().waitForTimeout(2000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Marca"));
        auto_setTextToInput(MARCA_INPUT_SELECT, vehiculo.getMarca());
        auto_pressKey(MARCA_INPUT_SELECT, "Enter");

        page.get().waitForTimeout(2500);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Modelo"));
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getModelo()));

        page.get().waitForTimeout(2000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Versión"));
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getVersion()));
    }

    public void seleccionarCobertura(String cobertura) {
        String radioXpath = String.format(RADIO_COBERTURA, cobertura);
        auto_waitForElementVisibility(radioXpath);
        auto_setClickElement(radioXpath);
        auto_waitForElementVisibility(String.format(RADIO_COBERTURA_SELECCIONADA, cobertura));
    }

    public void seleccionarFormaPago(String formaPago) {
        seleccionarAntSelectSiNoEstaSeleccionado(FORMA_PAGO_AUTO_SELECT, FORMA_PAGO_AUTO_VALOR_ACTUAL, formaPago);
    }

    public void completarDatosTecnicos(CotizacionAutomoviles data) {
        seleccionarAntSelectSiNoEstaSeleccionado(USO_SELECT, USO_VALOR_ACTUAL, data.getUso());

        auto_setTextToInput(PATENTE_INPUT, data.getDatosTecnicos().getPatente());
        auto_setTextToInput(MOTOR_INPUT, data.getDatosTecnicos().getNumeroMotor());
        auto_setTextToInput(CHASIS_INPUT, data.getDatosTecnicos().getNumeroChasis());
    }

    public void actualizarPatente(String patente) {
        auto_waitForElementVisibility(PATENTE_INPUT);
        auto_setTextToInput(PATENTE_INPUT, patente);
        for (int i = 0; i < 20; i++) {
            if (patente.equalsIgnoreCase(auto_getInputValue(PATENTE_INPUT))) {
                return;
            }
            page.get().waitForTimeout(200);
        }
        softAssertions.assertThat(auto_getInputValue(PATENTE_INPUT))
                .as("La patente actualizada debe quedar cargada antes de reenviar")
                .isEqualToIgnoringCase(patente);
        softAssertions.assertAll();
    }

    public void seleccionarTipoInspeccion(String tipoInspeccion) {
        seleccionarAntSelectSiNoEstaSeleccionado(TIPO_INSPECCION_SELECT, TIPO_INSPECCION_VALOR_ACTUAL, tipoInspeccion);
    }

    public String incrementarPatente(String patente) {
        String prefijo = patente.substring(0, 5);
        char letra1 = patente.charAt(5);
        char letra2 = patente.charAt(6);
        if (letra2 < 'Z') {
            letra2++;
        } else {
            letra2 = 'A';
            letra1++;
        }
        return prefijo + letra1 + letra2;
    }

    public void guardarJsonActualizado(CotizacionAutomoviles dataAutomoviles, String rutaJson) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        softAssertions.assertThatCode(() -> {
                    try (FileWriter writer = new FileWriter(rutaJson)) {
                        gson.toJson(dataAutomoviles, writer);
                    }
                })
                .as("No se pudo guardar el JSON actualizado de automoviles en la ruta: " + rutaJson)
                .doesNotThrowAnyException();
        softAssertions.assertAll();
    }

    private void seleccionarAntSelectSiNoEstaSeleccionado(String select, String valorActualLocator, String valor) {
        auto_waitForElementVisibility(select);
        String valorActual = auto_getElementTextOrValue(valorActualLocator);
        if (valorActual != null && valorActual.trim().equalsIgnoreCase(valor)) {
            softAssertions.assertThat(valorActual.trim())
                    .as("El valor ya seleccionado debe coincidir con el esperado")
                    .isEqualToIgnoringCase(valor);
            softAssertions.assertAll();
            return;
        }
        auto_setClickElement(select);
        auto_setClickElement(String.format(SELECT_OPCION, valor));
        auto_waitForElementVisibility(valorActualLocator);

        String valorSeleccionado = auto_getElementTextOrValue(valorActualLocator);
        softAssertions.assertThat(valorSeleccionado == null ? "" : valorSeleccionado.trim())
                .as("No se pudo seleccionar el valor esperado: " + valor)
                .isEqualToIgnoringCase(valor);
        softAssertions.assertAll();
    }
}
