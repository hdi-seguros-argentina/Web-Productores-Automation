package locators;

public class GenericLocators {
    //INPUT
    public static final String GENERIC_INPUT_XPATH = "(//*[text()='%s']/parent::*)[1]";
    public static final String GENERIC1_INPUT_XPATH = "//*[@placeholder='%s']/parent::*";
    public static final String GENERIC2_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::div[3]";
    public static final String GENERIC3_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::span[1]";
    public static final String GENERIC4_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::div[2]";
    public static final String GENERIC5_INPUT_XPATH = "//*[text()='%s']/ancestor::div[1]";



    //BUTTON
    public static final String LOGIN_BTN1_XPATH = "//*[text()='%s']//ancestor::button";
    public static final String FILTER1_BTN_XPATH = "//*[text()='%s']/ancestor::button";
    public static final String GENERIC_BTN_XPATH = "(//*[text()='%s']/parent::*)[1]";
    public static final String BORRARFILTROS1_BTN_XPATH = "//span[text()='%s']/parent::*";
    public static final String ACCIONES_BTN_XPATH = "//span[text()='%s']/parent::*";


    //TAB
    public static final String SUPERIOR_TAB_XPATH = "//div[text()='%s']";
    public static final String LATERAL_TAB_XPATH = "//h4[text()='%s']";

    //ICONOS
    public static final String POLIZAS_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 12 and position() < 16]";
    public static final String SINIESTROS_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 20 and position() < 24]";
    public static final String COTIZACIONES_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 16 and position() < 20]";
    public static final String SINIESTROSCARTERA_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 24 and position() < 28]";

}