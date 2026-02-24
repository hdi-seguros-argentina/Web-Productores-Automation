package steps.NuevaCotizacion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cucumber.java.en.And;
import models.CotizacionAutomoviles;
import pages.NuevaCotizacion.AutomovilesPage;
import Utils.JsonLoader;

import java.io.FileWriter;

public class AutomovilesSteps {

    private AutomovilesPage automovilesPage = new AutomovilesPage();

    private CotizacionAutomoviles dataAutomoviles =
            JsonLoader.load("Datos/Cotizacion_autos.json",
                    CotizacionAutomoviles.class);

    @And("el usuario selecciona AUTOMOVILES desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        automovilesPage.seleccionarRamaVeh(dataAutomoviles.getRama());
    }

    @And("el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        automovilesPage.seleccionarArticuloVeh(dataAutomoviles.getArticulo());
    }

    @And("el usuario busca el cliente de AUTOMOVILES desde el json")
    public void elUsuarioBuscaElClienteDesdeElJson() {
        automovilesPage.buscarClienteVeh(dataAutomoviles.getCliente());
    }
    @And("el usuario completa los datos del vehiculo desde el json")
    public void completarVehiculo() {
        automovilesPage.completarDatosVehiculo(dataAutomoviles.getVehiculo());
    }

    @And("el usuario completa el codigo de la cobertura desde el json")
    public void completarCobertura() {
        automovilesPage.seleccionarCobertura(
                dataAutomoviles.getVehiculo().getCoberturas()
        );
    }

    @And("el usuario guarda la cotizacion de AUTOMOVILES")
    public void elUsuarioCotizaYGuardaLaCotizacion() {
        automovilesPage.guardarCotizacion();
    }

    @And("el usuario emite la cotizacion de AUTOMOVILES desde el json")
    public void elUsuarioEmiteLaPolizaDesdeElJson() {
        automovilesPage.editarCotizacion();

        automovilesPage.emitir();

        automovilesPage.seleccionarNacionalidadVeh(dataAutomoviles.getEmision().getNacionalidad()
        );

        automovilesPage.ingresarNumeroTarjetaVeh(dataAutomoviles.getEmision().getTarjeta().getNumero()
        );

        automovilesPage.ingresarVencimientoVeh(dataAutomoviles.getEmision().getTarjeta().getVencimiento()
        );
    }

    @And("el usuario agrega los datos del automovil desde el json")
    public void completarDatosFinales() {

        String patenteOriginal = dataAutomoviles.getDatosTecnicos().getPatente();
        String patenteNueva = incrementarPatente(patenteOriginal);

        dataAutomoviles.getDatosTecnicos().setPatente(patenteNueva);

        automovilesPage.completarDatosTecnicos(dataAutomoviles);

        guardarJsonActualizado();
    }

    private String incrementarPatente(String patente) {
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

    private void guardarJsonActualizado() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/Datos/Cotizacion_autos.json")) {
            gson.toJson(dataAutomoviles, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}