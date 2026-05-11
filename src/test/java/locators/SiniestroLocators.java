package locators;

public class SiniestroLocators {
    public static final String BUSQUEDA_BTN_XPATH = "(//span[text()='%s']/parent::*/span)[1]";
    public static final String RADIO_BTN_XPATH = "//*[text()='%s']/ancestor::label//span//span";
    public static final String RAMA_SELECT_XPATH = "//input[@id='branchComplaint']";
    public static final String POLIZA_INPUT_XPATH = "//input[@placeholder='Póliza' or @placeholder='Poliza' or @placeholder='Número de póliza']";
    public static final String FECHA_INPUT_XPATH = "//input[@placeholder='Seleccionar fecha']";
    public static final String HORA_INPUT_XPATH = "//input[@placeholder='Seleccionar hora']";
    public static final String BUSCAR_POLIZA_BTN_XPATH = "//*[text()='Buscar Póliza']/ancestor::button";
}

