package locators;

public class SiniestroLocators {
    public static final String BUSQUEDA_BTN_XPATH = "(//span[normalize-space()='%s']/parent::*/span)[1]";
    public static final String RADIO_BTN_XPATH = "//*[normalize-space()='%s']/ancestor::label//span//span";
    public static final String RAMA_SELECT_XPATH = "//input[@id='branchComplaint']";
    public static final String POLIZA_INPUT_XPATH = "//input[@placeholder='Póliza' or @placeholder='Número de póliza']";
    public static final String FECHA_INPUT_XPATH = "//input[@placeholder='Seleccionar fecha']";
    public static final String HORA_INPUT_XPATH = "//input[@placeholder='Seleccionar hora']";
    public static final String BUSCAR_POLIZA_BTN_XPATH = "//*[normalize-space()='Buscar Póliza']/ancestor::button";
    public static final String ALERTA_HORA_INCORRECTA = "//div[contains(@class,'ant-message-notice-content') and contains(.,'SIN0007')]";
    public static final String CARDS_POLIZAS_LISTADO = "//div[@data-testid='basic-card' and contains(@class,'policy-card')]";
    public static final String ESTADO_POLIZA_VIGENTE_EN_CARD = "//span[contains(@class,'ant-tag') and normalize-space(.)='Vigente']";
    public static final String NUMERO_POLIZA_EN_CARD = "//span[normalize-space(.)='Póliza']/ancestor::div[contains(@class,'ant-col')][1]//strong";
    public static final String SKELETON_LISTADO_POLIZAS = "//div[contains(@class,'ant-skeleton-active')]";
    public static final String BOTON_INICIAR_DENUNCIA = "//button[.//span[normalize-space()='Iniciar Denuncia']]";
    public static final String TITULO_NUEVA_DENUNCIA = "//h3[normalize-space()='Nueva Denuncia']";
    public static final String TITULO_SECCION = "//h3[normalize-space()='%s']";
    public static final String TITULO_SECCION_UNICO = "(//h3[normalize-space()='%s'])[last()]";
    public static final String BOTON_CONTINUAR_DENUNCIA = "//button[.//span[normalize-space()='Continuar']]";
    public static final String BOTON_ENVIAR_DENUNCIA = "//button[.//span[normalize-space()='Enviar']]";
    public static final String MENSAJE_DENUNCIA_REGISTRADA = "//h3[contains(normalize-space(),'Hemos registrado su denuncia. Número de siniestro:') or contains(normalize-space(),'Hemos registrado su denuncia. NÃºmero de siniestro:')]";
    public static final String SELECT_POR_INPUT_ID = "//input[@id='%s']/ancestor::div[contains(@class,'ant-select')][1]";
    public static final String INPUT_POR_ID = "//*[@id='%s']";
    public static final String RADIO_POR_GRUPO_VALOR = "//*[@id='%s']//input[@value='%s']/ancestor::label[1]";
    public static final String VEHICULO_TERCERO_SECCION = "//h3[normalize-space()='Datos del Vehículo - Tercero 1' or normalize-space()='Datos del VehÃ­culo - Tercero 1']";
    public static final String OPCION_SELECT_CONTIENE = "//div[contains(@class,'ant-select-item-option-content') and contains(normalize-space(),'%s')]";
    public static final String PRIMERA_OPCION_SELECT_VISIBLE = "(//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'ant-select-dropdown-hidden'))]//div[contains(@class,'ant-select-item-option') and not(contains(@class,'ant-select-item-option-disabled'))]//div[contains(@class,'ant-select-item-option-content')])[1]";
    public static final String MENSAJE_SINIESTRO_DUPLICADO = "//span[contains(normalize-space(),'SIN0074') or contains(normalize-space(),'Siniestro duplicado') or contains(normalize-space(),'misma fecha y hora')]";
    public static final String BOTON_NUEVA_DENUNCIA = "//span[text()='Nueva denuncia']";
}
