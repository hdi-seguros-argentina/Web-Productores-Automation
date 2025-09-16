package locators;

public class HomeLocators {
    public static final String NAME_INPUT_XPATH = "//input[@placeholder='Nombre']";
    public static final String FILTER_BTN_XPATH = "//span[text()='Filtrar']";
    public static final String SELECT_BTN_XPATH = "//strong[text()='1 / 76095']/ancestor::div[3]//button";
    public static final String CONFIRM_BTN_XPATH = "//span[text()='Confirmar']";
    public static final String PANEL_TITLE_XPATH = "//h3[text()='Panel de Inicio']";
    public static final String CONTENT_MODAL_XPATH = "//div[@class='ant-modal-content']";
    public static final String CHECKBOX_INPUT_XPATH = "//input[@type='checkbox']";
    public static final String ACEPT_BTN_XPATH = "//span[text()=' Aceptar ']";

    //Estilos
    public static final String HEADER_BAR_XPATH = "//header[@class='ant-layout-header custom-header css-uyuj90']";
    public static final String FILTER1_BTN_XPATH = "//span[text()='Filtrar']/ancestor::button";
    public static final String NAME1_INPUT_XPATH = "//input[@placeholder='%s']/ancestor::span[1]";
    public static final String CUIT1_INPUT_XPATH = "//input[@id='cuitInter']/ancestor::div[3]";
    public static final String CODE1_INPUT_XPATH = "//input[@id='codigoInter']/ancestor::div[3]";
    public static final String NIVEL1_SELECT_XPATH = "//span[text()='Nível']/ancestor::div[1]";
    public static final String BORRARFILTROS1_BTN_XPATH = "//span[text()='Borrar Filtros']/parent::*";
    public static final String SELECT1_BTN_XPATH = "//span[text()='Seleccionar']/parent::*";
    public static final String POLIZAS_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 12 and position() < 16]";
    public static final String COTIZACIONES_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 16 and position() < 20]";
    public static final String SINIESTROS_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 20 and position() < 24]";
    public static final String SINIESTROSCARTERA_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 24 and position() < 28]";
}