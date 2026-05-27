package pages;
import com.core.utility.MasterPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import models.Siniestro;
import org.assertj.core.api.SoftAssertions;

import java.io.FileWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static locators.ProduccionLocators.*;
public class ProduccionPage extends MasterPage {

    SoftAssertions softAssertions = new SoftAssertions();
    private static String ultimoRamoSeleccionado;

    public static final String COLOR_BLANCO        = "rgb(255, 255, 255)";
    public static final String COLOR_1             = "rgb(227, 32, 94)";     //Magenta1
    public static final String COLOR_4             = "rgb(252, 232, 239)";   //Magenta3
    public static final String COLOR_5             = "rgb(255, 233, 233)";   //Magenta4
    public static final String COLOR_3             = "rgb(0, 91, 187)";      //Azul
    public static final String COLOR_TRANSPARENTE  = "rgba(0, 0, 0, 0)";
    public static final String FUENTE_BASE         = "Montserrat, sans-serif";

    public void ingresaListadoPolizas() {
        auto_setClickElement(PRODUCCION_MENU_XPATH);
        auto_setClickElement(LISTADOPOLIZAS_MENU_XPATH);
        esperarListadoPolizasDisponible();
    }

    public void validarIconosAccesoDirecto() {
        page.get().waitForTimeout(1000);
        List<Locator> iconos = page.get().locator(ACCESODIRECTO_ICONS_XPATH).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as("Color de icono en posición [" + i + "] incorrecto")
                    .isEqualTo(COLOR_1);
        }
        softAssertions.assertAll();
    }

    public void seleccionRamo(String arg0){
        ultimoRamoSeleccionado = arg0;
        auto_waitForElementVisibility(RAMO_DESPLEGABLE_XPATH);
        auto_setClickElement(RAMO_DESPLEGABLE_XPATH);
        auto_waitForElementVisibility(String.format(RAMO_DESPLEGABLE1_XPATH, arg0));
        auto_setClickElement(String.format(RAMO_DESPLEGABLE1_XPATH, arg0));
    }

    public static String getUltimoRamoSeleccionado() {
        return ultimoRamoSeleccionado;
    }

    public void seleccionTipoBusquedaRamoNumeroPoliza() {
        auto_waitForElementVisibility(RAMO_NUMERO_POLIZA_RADIO_XPATH);
        auto_setClickElement(RAMO_NUMERO_POLIZA_RADIO_XPATH);
    }

    public void ingresoNumeroPoliza(String arg0){
        auto_setClickElement(NUMERPOLIZA_INPUT1_XPATH);
        auto_setTextToInput(NUMERPOLIZA_INPUT1_XPATH, arg0);
        page.get().waitForTimeout(1000);
    }

    public void seleccionFecha(String arg0){
        auto_setClickElement(FECHA_DESPLEGABLE_XPATH);
        auto_setTextToInput(FECHA_DESPLEGABLE1_XPATH, arg0);
    }

    public void clickBoton(String arg0){
        auto_waitForElementVisibility(String.format(GENERIC_BOTON_XPATH, arg0));
        page.get().waitForTimeout(1000);
        auto_setClickElement(String.format(GENERIC_BOTON_XPATH, arg0));
    }

    public void verificaBotonPoliza(){
        page.get().waitForTimeout(500);
        Locator boton = page.get().locator(POLIZA_BTN_XPATH).first();

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Poliza incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Poliza incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Poliza incorrecto")
                .isEqualTo(COLOR_4);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Poliza incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void verificaBotonPolizaActivo(){
        Locator boton = page.get().locator(POLIZA_BTN_XPATH).first();
        boton.click();
        page.get().waitForTimeout(500);

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón Poliza Activo incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón Poliza Activo incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón Poliza Activo incorrecto")
                .isEqualTo(COLOR_5);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón Poliza Activo incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void verificaIconoInfo(){
        Locator boton = page.get().locator(INFO_BTN_XPATH).first();
        boton.click();
        page.get().waitForTimeout(1000);

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto botón info incorrecto")
                .isEqualTo(COLOR_3);

        softAssertions.assertThat(auto_getCssValue(boton, "border-color"))
                .as("Borde botón info incorrecto")
                .isEqualTo(COLOR_3);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background botón info incorrecto")
                .isEqualTo(COLOR_TRANSPARENTE);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente botón info incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void verificaPanel(String args){
        Locator boton = page.get().locator(String.format(POLIZA_PANEL_XPATH, args)).first();
        boton.click();
        page.get().waitForTimeout(1000);

        softAssertions.assertThat(auto_getCssValue(boton, "color"))
                .as("Color de texto panel derecho incorrecto")
                .isEqualTo(COLOR_1);

        softAssertions.assertThat(auto_getCssValue(boton, "background-color"))
                .as("Background panel derecho incorrecto")
                .isEqualTo(COLOR_TRANSPARENTE);

        softAssertions.assertThat(auto_getCssValue(boton, "font-family"))
                .as("Fuente panel derecho incorrecta")
                .contains(FUENTE_BASE);
        softAssertions.assertAll();
    }

    public void ingresarAWeb(String arg0, String arg1){
        auto_setClickElement(String.format(GENERIC_MENU_XPATH, arg1));
        auto_setClickElement(String.format(GENERIC_SUBMENU_XPATH, arg0));
    }

    public void guardarPolizaVigenteDelRamoEnJson(String ramo) {
        ingresaListadoPolizas();
        seleccionTipoBusquedaRamoNumeroPoliza();
        seleccionRamo(ramo);
        clickConReintento(BOTON_FILTRAR);
        esperarPolizasVigentesDisponibles();

        List<ElementHandle> cardsVigentes = page.get().locator(CARD_POLIZA_VIGENTE_XPATH).elementHandles();
        String poliza = "";
        for (ElementHandle card : cardsVigentes) {
            String textoCard = card.textContent() == null ? "" : card.textContent().toUpperCase();
            if (!textoCard.contains(ramo.toUpperCase())) {
                continue;
            }
            ElementHandle polizaHandle = card.querySelector(CARD_POLIZA_NUMERO_RELATIVE_XPATH);
            if (polizaHandle != null) {
                poliza = polizaHandle.textContent().trim();
                if (!poliza.isEmpty()) {
                    break;
                }
            }
        }

        if (poliza.isEmpty()) {
            throw new RuntimeException("No se encontro una poliza vigente para el ramo: " + ramo);
        }

        String nombreJson = obtenerNombreJsonSiniestro(ramo);
        String rutaJson = "src/test/resources/Datos/" + nombreJson;
        Siniestro data = cargarSiniestroExistente(rutaJson, ramo);
        data.setRama(ramo);
        data.setPoliza(poliza);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(rutaJson)) {
            gson.toJson(data, writer);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar el json de poliza vigente: " + nombreJson, e);
        }
    }

    private Siniestro cargarSiniestroExistente(String rutaJson, String ramo) {
        try (FileReader reader = new FileReader(rutaJson)) {
            Siniestro data = new Gson().fromJson(reader, Siniestro.class);
            return data == null ? new Siniestro(ramo, "") : data;
        } catch (Exception e) {
            return new Siniestro(ramo, "");
        }
    }

    private String obtenerNombreJsonSiniestro(String ramo) {
        String ramoNormalizado = ramo == null ? "" : ramo.trim().toUpperCase();
        return switch (ramoNormalizado) {
            case "AUTOMOVILES" -> "siniestro_automoviles.json";
            case "AUTOS - RESP. CIVIL" -> "siniestro_autos_resp_civil.json";
            default -> throw new RuntimeException("No hay json configurado para el ramo: " + ramo);
        };
    }

    private void esperarListadoPolizasDisponible() {
        auto_waitForLoadStates(LoadState.DOMCONTENTLOADED);
        auto_waitForElementVisibility(TITULO_LISTADO_POLIZAS_XPATH);
        auto_waitForElementVisibility(BOTON_FILTRAR);
    }

    public void esperarQueAparezcaListadoPolizas() {
        page.get().waitForTimeout(5000);
        auto_waitForElementVisibility(CARD_POLIZA_LISTADO_XPATH);
        auto_verifyVisibility(CARD_POLIZA_LISTADO_XPATH);
    }

    public void esperarPolizasVigentesDisponibles() {
        page.get().waitForTimeout(5000);
        auto_waitForElementVisibility(CARD_POLIZA_LISTADO_XPATH);
        auto_verifyVisibility(CARD_POLIZA_LISTADO_XPATH);
    }

    public void seleccionarAccesoDirecto(String accesoDirecto) {
        auto_waitForElementVisibility(String.format(ACCESO_DIRECTO_CARD_XPATH, accesoDirecto));
        auto_setClickElement(String.format(ACCESO_DIRECTO_CARD_XPATH, accesoDirecto));
        esperarPolizasVigentesDisponibles();
    }

    public void validarListadoProximasAVencer() {
        esperarPolizasVigentesDisponibles();

        Locator cardsVigentes = page.get().locator(POLICY_CARD_VIGENTE_XPATH);
        int cantidadVigentes = cardsVigentes.count();
        softAssertions.assertThat(cantidadVigentes)
                .as("El acceso directo de próximas a vencer no devolvió pólizas vigentes.")
                .isGreaterThan(0);

        for (int i = 0; i < cantidadVigentes; i++) {
            softAssertions.assertThat(cardsVigentes.nth(i).textContent())
                    .as("La póliza visible en posición [%s] no está Vigente.", i)
                    .contains("Vigente");
        }

        Locator proximasAVencer = page.get().locator(POLICY_CARD_PROXIMA_A_VENCER_XPATH);
        softAssertions.assertThat(proximasAVencer.count())
                .as("El listado debería mostrar al menos una póliza marcada como Próxima a vencer.")
                .isGreaterThan(0);
    }

    public void validarEncabezadoDetallePoliza() {
        auto_verifyVisibility(DETALLE_POLIZA_NUMERO_BTN_XPATH);
        auto_verifyVisibility(DETALLE_POLIZA_RAMO_DESCRIPCION_XPATH);
        auto_verifyVisibility(DETALLE_POLIZA_ESTADO_VIGENTE_XPATH);
    }

    public void abrirTabDetallePoliza(String tab) {
        auto_waitForElementVisibility(String.format(DETALLE_TAB_XPATH, tab));
        auto_setClickElement(String.format(DETALLE_TAB_XPATH, tab));
        page.get().waitForTimeout(500);
    }

    public void validarSeccionesPrincipalesTab(String tab) {
        switch (tab) {
            case "Principal" -> validarDetallePrincipal();
            case "Asegurado" -> validarDetalleAsegurado();
            case "Bienes" -> validarDetalleBienes();
            case "Cuotas" -> validarDetalleCuotas();
            case "Siniestros" -> validarDetalleSiniestros();
            case "Documentos" -> validarDetalleDocumentos();
            case "PDF Anteriores" -> validarDetallePdfAnteriores();
            default -> throw new IllegalArgumentException("Tab no soportado para detalle de póliza: " + tab);
        }
    }

    public void validarDetallePrincipal() {
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Datos generales"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Póliza Nueva"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Vigencia de la póliza"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "F. Emisión"));
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Comisiones"));
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Premio"));
    }

    public void validarDetalleAsegurado() {
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Datos personales"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Nombre"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Documento"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Condición Fiscal"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "CUIT"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Dirección"));
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Canales de comunicación"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Correo electrónico"));
    }

    public void validarDetalleBienes() {
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Listado de Bienes Asegurados"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Filtrar por:"));
        auto_verifyVisibility(DETALLE_PATENTE_INPUT_XPATH);
        abrirPrimerBienAsegurado();
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Datos generales"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Coberturas y cláusulas"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Bonificaciones y recargos"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Factores multiplicativos"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Accesorios"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Nómina de conductores"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Carta de daños"));
        auto_verifyVisibility(String.format(DETALLE_COLLAPSE_SECCION_XPATH, "Información adicional"));
    }

    public void validarDetalleCuotas() {
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Método de Pago"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Forma de pago"));
        auto_verifyVisibility(String.format(DETALLE_SECCION_CONTIENE_XPATH, "Cuotas del endoso"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Detalle de cuotas"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Cuota"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Vencimiento"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Importe"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Estado"));
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Saldo Total"));
    }

    public void validarDetalleSiniestros() {
        auto_verifyVisibility(String.format(DETALLE_SECCION_CONTIENE_XPATH, "Siniestros"));
    }

    public void validarDetalleDocumentos() {
        auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Solicitar certificados, constancias y/o póliza digital"));
        auto_verifyVisibility(DOCUMENTOS_SELECT_XPATH);
        auto_verifyVisibility(DOCUMENTOS_PLACEHOLDER_XPATH);
    }

    public void validarDetallePdfAnteriores() {
        auto_verifyVisibility(String.format(DETALLE_SECCION_XPATH, "Pólizas anteriores"));

        Locator polizasAnteriores = page.get().locator(PDF_ANTERIORES_CARD_XPATH);
        int cantidadPolizasAnteriores = polizasAnteriores.count();

        if (cantidadPolizasAnteriores > 0) {
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Rama"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Póliza"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Supl"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Artículo"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Superpóliza"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "SuplSpol"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Tipo"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Fecha Emisión"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Vigencia desde"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Vigencia hasta"));
            auto_verifyVisibility(String.format(DETALLE_LABEL_VISIBLE_XPATH, "Documento"));
        }
    }

    public void abrirPrimerBienAsegurado() {
        auto_verifyVisibility(DETALLE_BIEN_ASEGURADO_XPATH);
        if (auto_isElementVisible(DETALLE_BIEN_ASEGURADO_XPATH)) {
            auto_setClickElement(DETALLE_BIEN_ASEGURADO_XPATH);
        }
    }

    public void descargarYValidarDocumentoPoliza(String opcionDocumento) throws Exception {
        Path carpetaDescargas = Paths.get("target", "downloads", "produccion");
        Path archivoDescargado = carpetaDescargas.resolve("documento-poliza.pdf");

        Files.createDirectories(carpetaDescargas);
        Files.deleteIfExists(archivoDescargado);

        auto_setClickElement(DOCUMENTOS_SELECT_XPATH);
        auto_setClickElement(String.format(DOCUMENTOS_OPCION_XPATH, opcionDocumento));
        auto_waitForElementVisibility(DOCUMENTOS_DESCARGAR_BTN_XPATH);

        Download download = page.get().waitForDownload(() -> auto_setClickElement(DOCUMENTOS_DESCARGAR_BTN_XPATH));
        download.saveAs(archivoDescargado);

        softAssertions.assertThat(Files.exists(archivoDescargado))
                .as("No se guardó la descarga del documento: " + opcionDocumento)
                .isTrue();
        softAssertions.assertThat(Files.size(archivoDescargado))
                .as("La descarga quedó vacía para el documento: " + opcionDocumento)
                .isGreaterThan(0);
        softAssertions.assertAll();
        Files.deleteIfExists(archivoDescargado);
    }
}
