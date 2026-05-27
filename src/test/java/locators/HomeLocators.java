package locators;

public class HomeLocators {
    public static final String GENERIC_TITULO_XPATH = "(//*[normalize-space()='%s'])[1]";
    public static final String NAME_INPUT_XPATH = "//input[@placeholder='Nombre']";
    public static final String FILTER_BTN_XPATH = "//span[text()='Filtrar']";
    public static final String SELECT_BTN_XPATH = "//strong[text()='1 / 76095']/ancestor::div[3]//button";
    public static final String CONFIRM_BTN_XPATH = "//span[text()='Confirmar']";
    public static final String PANEL_TITLE_XPATH = "//h3[text()='Panel de Inicio']";
    public static final String PANEL_BREADCRUMB_XPATH = "//span[contains(@class,'breadcrum-links') and normalize-space()='Panel de Inicio']";
    public static final String SOPORTE_IT_XPATH = "//span[contains(@class,'home-dashboard__text-support') and contains(normalize-space(),'Ante cualquier duda en IT')]";
    public static final String CARTERA_VIGENTE_TITULO_XPATH = "//span[normalize-space()='Cartera Vigente']";
    public static final String CARTERA_VIGENTE_GRAFICO_XPATH = "//span[normalize-space()='Cartera Vigente']/following::*[name()='path' and contains(@class,'recharts-sector')][1]";
    public static final String PRODUCCION_VIGENTE_TITULO_XPATH = "//span[contains(normalize-space(),'Producci') and contains(normalize-space(),'Vigente')]";
    public static final String PRODUCCION_VIGENTE_GRAFICO_XPATH = "//span[contains(normalize-space(),'Producci') and contains(normalize-space(),'Vigente')]/following::*[name()='rect'][1]";
    public static final String POLIZAS_VIGENTES_SECCION_XPATH = "//*[normalize-space()='Pólizas vigentes']";
    public static final String COTIZACIONES_WEB_SECCION_XPATH = "//span[contains(normalize-space(), 'Cotizaciones web')]";
    public static final String SINIESTROS_DENUNCIADOS_SECCION_XPATH = "//*[normalize-space()='Siniestros denunciados']";
    public static final String SINIESTROS_CARTERA_SECCION_XPATH = "//span[contains(normalize-space(), 'Siniestros denunciados vs Cartera vigente')]";
    public static final String AUTOS_INDICADOR_XPATH = "(//span[normalize-space()='Autos'])[1]";
    public static final String HOGAR_INDICADOR_XPATH = "(//span[normalize-space()='Hogar'])[1]";
    public static final String VIDA_INDICADOR_XPATH = "(//span[normalize-space()='Vida'])[1]";
    public static final String RESTO_INDICADOR_XPATH = "(//*[normalize-space()='Resto'])[1]";
    public static final String CONTENT_MODAL_XPATH = "//div[@class='ant-modal-content']";
    public static final String CHECKBOX_INPUT_XPATH = "//input[@type='checkbox']";
    public static final String ACEPT_BTN_XPATH = "//span[text()=' Aceptar ']";

    //Estilos
    public static final String HEADER_BAR_XPATH = "//header[contains(@class,'ant-layout-header')]";
}
