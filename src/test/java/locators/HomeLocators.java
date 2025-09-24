package locators;

public class HomeLocators {
    public static final String GENERIC_TITULO_XPATH = "(//*[text()='%s'])[1]";
    public static final String NAME_INPUT_XPATH = "//input[@placeholder='Nombre']";
    public static final String FILTER_BTN_XPATH = "//span[text()='Filtrar']";
    public static final String SELECT_BTN_XPATH = "//strong[text()='1 / 76095']/ancestor::div[3]//button";
    public static final String CONFIRM_BTN_XPATH = "//span[text()='Confirmar']";
    public static final String PANEL_TITLE_XPATH = "//h3[text()='Panel de Inicio']";
    public static final String CONTENT_MODAL_XPATH = "//div[@class='ant-modal-content']";
    public static final String CHECKBOX_INPUT_XPATH = "//input[@type='checkbox']";
    public static final String ACEPT_BTN_XPATH = "//span[text()=' Aceptar ']";

    //Estilos
    public static final String HEADER_BAR_XPATH = "//header[contains(@class,'ant-layout-header')]";
}