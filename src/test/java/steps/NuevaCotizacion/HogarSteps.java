package steps.NuevaCotizacion;

import Utils.JsonLoader;
import io.cucumber.java.en.And;
import models.Cobertura;
import models.CotizacionHogar;
import pages.NuevaCotizacion.HogarPage;

import java.util.Map;

public class HogarSteps {
    private HogarPage hogarPage = new HogarPage();

    private CotizacionHogar dataHogar =
            JsonLoader.load(
                    "Datos/cotizacion_hogar.json",
                    CotizacionHogar.class
            );

    @And("el usuario selecciona HOGAR desde el json")
    public void elUsuarioSeleccionaLaRamaDesdeElJson() {
        hogarPage.seleccionarRamaHogar(dataHogar.getRama());
    }

    @And("el usuario selecciona COMBINADO FAMILIAR desde el json")
    public void elUsuarioSeleccionaElArticuloDesdeElJson() {
        hogarPage.seleccionarArticuloAcc(dataHogar.getArticulo());
    }

    @And("el usuario busca el cliente de HOGAR desde el json")
    public void elUsuarioBuscaElClienteDesdeElJson() {
        hogarPage.buscarClienteAcc(dataHogar.getCliente());
    }

    @And("el usuario completa los datos del plan de HOGAR desde el json")
    public void elUsuarioCompletaLosDatosDelPlanDesdeElJson() {

        hogarPage.seleccionarPlan(dataHogar.getPlan());

        hogarPage.seleccionarProvincia(
                dataHogar.getDatosDelBien().getProvincia()
        );

        hogarPage.seleccionarLocalidad(
                dataHogar.getDatosDelBien().getLocalidad()
        );

        hogarPage.seleccionarTipoVivienda(
                dataHogar.getDatosDelBien().getTipoVivienda()
        );
    }

    @And("el usuario completa la cobertura de HOGAR desde el json")
    public void elUsuarioCompletaLaCoberturaDesdeElJson() {

        dataHogar.getCobertura().forEach((nombreCobertura, suma) -> {
            hogarPage.seleccionarCobertura(nombreCobertura);
            hogarPage.ingresarSumaCobertura(nombreCobertura, suma);
        });
    }

    @And("el usuario cotiza y guarda la cotizacion de HOGAR")
    public void elUsuarioCotizaYGuardaLaCotizacion() {
        hogarPage.cotizar();
        hogarPage.guardarCotizacion();
    }

    @And("el usuario emite la cotizacion de HOGAR desde el json")
    public void elUsuarioEmiteLaPolizaDesdeElJson() {
        hogarPage.editarCotizacion();

        hogarPage.emitir();

        //hogarPage.seleccionarNacionalidadHogar(dataHogar.getEmision().getNacionalidad()
        //);

        hogarPage.ingresarNumeroTarjetaHogar(dataHogar.getEmision().getTarjeta().getNumero()
        );

        hogarPage.ingresarVencimientoHogar(dataHogar.getEmision().getTarjeta().getVencimiento()
        );

        hogarPage.ingresarDomicilioHogar(dataHogar.getEmision().getDomicilio()
        );
    }
}