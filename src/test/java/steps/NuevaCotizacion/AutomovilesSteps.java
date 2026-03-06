package steps.NuevaCotizacion;

import io.cucumber.java.en.And;
import models.CotizacionAutomoviles;
import pages.CommonPage;
import pages.NuevaCotizacion.AutomovilesPage;
import Utils.JsonLoader;
public class AutomovilesSteps {
    AutomovilesPage automovilesPage = new AutomovilesPage();
    CommonPage commonPage = new CommonPage();

    CotizacionAutomoviles dataAutomoviles =
            JsonLoader.load("Datos/Cotizacion_autos.json",
                    CotizacionAutomoviles.class);

    @And("el usuario selecciona AUTOMOVILES desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        commonPage.seleccionarRama(dataAutomoviles.getRama());
    }

    @And("el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        commonPage.seleccionarArticulo(dataAutomoviles.getArticulo());
    }

    @And("el usuario realiza la cotizacion de AUTOMOVILES RC")
    public void elUsuarioRealizaLaCotizacionDeAUTOMOVILESRC() {
        commonPage.clickIniciarCotizacion();

        commonPage.buscarCliente(dataAutomoviles.getCliente());
        commonPage.clickBotonContinuar();

        automovilesPage.completarDatosVehiculo(dataAutomoviles.getVehiculo());
        commonPage.clickBotonCotizar();

        automovilesPage.seleccionarCobertura(dataAutomoviles.getVehiculo().getCoberturas());
    }

    @And("el usuario envia la cotizacion de AUTOMOVILES")
    public void elUsuarioEnviaLaCotizacionDeAUTOMOVILES() {
        commonPage.clickEditarCotizacion();
        commonPage.clickBotonEmitir();

        commonPage.seleccionarNacionalidad(dataAutomoviles.getEmision().getNacionalidad());
        commonPage.ingresarNumeroTarjeta(dataAutomoviles.getEmision().getTarjeta().getNumero());
        commonPage.ingresarVencimiento(dataAutomoviles.getEmision().getTarjeta().getVencimiento());

        String patenteOriginal = dataAutomoviles.getDatosTecnicos().getPatente();
        String patenteNueva = automovilesPage.incrementarPatente(patenteOriginal);

        dataAutomoviles.getDatosTecnicos().setPatente(patenteNueva);
        automovilesPage.completarDatosTecnicos(dataAutomoviles);
        automovilesPage.guardarJsonActualizado(dataAutomoviles);

        commonPage.clickBotonEnviar();
    }
}