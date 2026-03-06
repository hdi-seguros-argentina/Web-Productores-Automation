package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.CotizacionAutomoviles;
import models.Vehiculo;

import java.io.FileWriter;

import static locators.CommonLocators.*;

public class AutomovilesPage extends MasterPage {

    public void completarDatosVehiculo(Vehiculo vehiculo) {
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Año Vehículo"));
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getAnio()));

        page.get().waitForTimeout(2000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Marca"));
        auto_setTextToInput(MARCA_INPUT_SELECT, vehiculo.getMarca());
        auto_pressKey(MARCA_INPUT_SELECT, "Enter");

        page.get().waitForTimeout(2000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Modelo"));
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getModelo()));

        page.get().waitForTimeout(2000);
        auto_setClickElement(String.format(SELECT_DESPLEGABLE, "Versión"));
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getVersion()));
    }

    public void seleccionarCobertura(String cobertura) {
        auto_setClickElement(String.format(RADIO_COBERTURA, cobertura));
    }

    public void completarDatosTecnicos(CotizacionAutomoviles data) {
        auto_setClickElement(USO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, data.getUso()));

        auto_setTextToInput(PATENTE_INPUT, data.getDatosTecnicos().getPatente());
        auto_setTextToInput(MOTOR_INPUT, data.getDatosTecnicos().getNumeroMotor());
        auto_setTextToInput(CHASIS_INPUT, data.getDatosTecnicos().getNumeroChasis());
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

    public void guardarJsonActualizado(CotizacionAutomoviles dataAutomoviles) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/Datos/Cotizacion_autos.json")) {
            gson.toJson(dataAutomoviles, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}