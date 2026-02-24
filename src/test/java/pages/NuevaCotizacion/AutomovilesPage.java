package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import models.CotizacionAutomoviles;
import models.Vehiculo;
import static locators.CotizadorNuevaCotizacionLocators.*;

public class AutomovilesPage extends MasterPage {
    public void seleccionarRamaVeh(String rama) {
        auto_setClickElement(RAMA_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, rama));
    }

    public void seleccionarArticuloVeh(String articulo) {
        auto_setClickElement(ARTICULO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, articulo));
    }

    public void buscarClienteVeh(String cliente) {
        auto_setClickElement(BOTON_BUSCAR_CLIENTE);
        auto_setClickElement(String.format(RESULTADO_CLIENTE, cliente));

        auto_setClickElement(BOTON_CONTINUAR);
    }

    public void completarDatosVehiculo(Vehiculo vehiculo) {
        auto_setClickElement(ANIO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getAnio()));

        page.get().waitForTimeout(1500);
        auto_setClickElement(MARCA_SELECT);
        auto_setTextToInput(MARCA_INPUT_SELECT, vehiculo.getMarca());
        auto_pressKey(MARCA_INPUT_SELECT, "Enter");

        page.get().waitForTimeout(2000);
        auto_setClickElement(MODELO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getModelo()));

        page.get().waitForTimeout(1500);
        auto_setClickElement(VERSION_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, vehiculo.getVersion()));

        auto_setClickElement(BOTON_COTIZAR);
    }

    public void seleccionarCobertura(String cobertura) {
        auto_setClickElement(String.format(RADIO_COBERTURA, cobertura));
    }

    public void seleccionarNacionalidadVeh(String nacionalidad) {
        auto_setClickElement(NACIONALIDAD_SELECT);
        auto_setTextToInput(NACIONALIDAD_INPUT_SELECT, nacionalidad);
        auto_pressKey(NACIONALIDAD_INPUT_SELECT, "Enter");
    }

    public void ingresarNumeroTarjetaVeh(String numero) {
        auto_typeSequentially(INPUT_TARJETA, numero);
        auto_pressKey(INPUT_TARJETA, "Enter");
    }

    public void ingresarVencimientoVeh(String vencimiento) {
        auto_setTextToInput(INPUT_VENCIMIENTO, vencimiento);
    }

    public void completarDatosTecnicos(CotizacionAutomoviles data) {
        auto_setClickElement(USO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, data.getUso()));

        auto_setTextToInput(PATENTE_INPUT, data.getDatosTecnicos().getPatente());
        auto_setTextToInput(MOTOR_INPUT, data.getDatosTecnicos().getNumeroMotor());
        auto_setTextToInput(CHASIS_INPUT, data.getDatosTecnicos().getNumeroChasis());
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
}