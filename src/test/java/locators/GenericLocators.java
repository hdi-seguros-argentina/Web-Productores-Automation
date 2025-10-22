package locators;

import com.microsoft.playwright.Locator;

public class GenericLocators {
    //INPUT
    public static final String GENERIC_INPUT_XPATH = "(//*[text()='%s']/parent::*)[1]";
    public static final String GENERIC1_INPUT_XPATH = "//*[@placeholder='%s']/parent::*";
    public static final String GENERIC2_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::div[3]";
    public static final String GENERIC3_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::span[1]";
    public static final String GENERIC4_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::div[2]";
    public static final String GENERIC5_INPUT_XPATH = "//*[text()='%s']/ancestor::div[1]";


    //BUTTON
    public static final String GENERIC_BTN_XPATH = "//*[text()='%s']/ancestor::button";

    //TAB
    public static final String SUPERIOR_TAB_XPATH = "//div[text()='%s']";
    public static final String LATERAL_TAB_XPATH = "//h4[text()='%s']";

    //ICONOS
    public static final String POLIZAS_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 12 and position() < 16]";
    public static final String SINIESTROS_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 20 and position() < 24]";
    public static final String COTIZACIONES_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 16 and position() < 20]";
    public static final String SINIESTROSCARTERA_ICONS_XPATH = "(//span[contains(@class,'anticon')])[position() >= 24 and position() < 28]";

    //PAGINADO
    public static final String PAGINADO_TOTAL_XPATH = "//li[contains(text(), '%s')]";
    public static final String PAGINADO_PAGINA_ACTIVA_XPATH = "//li[contains(@class, 'ant-pagination-item-active')]";
    public static final String PAGINADO_SELECTOR_XPATH = "//span[contains(text(), ' / page') or contains(text(), ' / página')]";
    public static final String PAGINADO_FLECHA_ANTERIOR_XPATH = "//li[contains(@class, 'ant-pagination-prev')]";
    public static final String PAGINADO_FLECHA_SIGUIENTE_XPATH = "//li[contains(@class, 'ant-pagination-next')]";
    public static final String PAGINADO_SELECTOR_ITEM_XPATH = "//span[contains(text(), ' / page') or contains(text(), ' / página')]";
}