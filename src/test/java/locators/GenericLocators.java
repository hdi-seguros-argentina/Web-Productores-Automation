package locators;

import com.microsoft.playwright.Locator;

public class GenericLocators {
    //INPUT
    public static final String GENERIC_INPUT_XPATH = "(//*[normalize-space()='%s']/parent::*)[1]";
    public static final String GENERIC1_INPUT_XPATH = "//*[@placeholder='%s']/parent::*";
    public static final String GENERIC2_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::div[3]";
    public static final String GENERIC3_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::span[1]";
    public static final String GENERIC4_INPUT_XPATH = "//*[@placeholder='%s']/ancestor::div[2]";
    public static final String GENERIC5_INPUT_XPATH = "//*[normalize-space()='%s']/ancestor::div[1]";
    public static final String ARTICULO_SELECT_XPATH = "//input[@id='article']/ancestor::div[contains(@class,'ant-select-selector')][1]";


    //BUTTON
    public static final String GENERIC_BTN_XPATH = "//*[normalize-space()='%s']/ancestor::button";

    //TAB
    public static final String SUPERIOR_TAB_XPATH = "//div[normalize-space()='%s']";
    public static final String LATERAL_TAB_XPATH = "//h4[normalize-space()='%s']";

    //ICONOS
    public static final String POLIZAS_ICONS_XPATH = "(//span[normalize-space()='Pólizas vigentes']/following::div[contains(@class,'home-icons-render__icon-card')])[position() <= 4]//*[name()='path']";
    public static final String SINIESTROS_ICONS_XPATH = "(//span[normalize-space()='Siniestros denunciados']/following::div[contains(@class,'home-icons-render__icon-card')])[position() <= 4]//*[name()='path']";
    public static final String COTIZACIONES_ICONS_XPATH = "(//span[normalize-space()='% Cotizaciones web']/following::div[contains(@class,'home-icons-render__icon-card')])[position() <= 4]//*[name()='path']";
    public static final String SINIESTROSCARTERA_ICONS_XPATH = "(//span[normalize-space()='% Siniestros denunciados vs Cartera vigente']/following::div[contains(@class,'home-icons-render__icon-card')])[position() <= 4]//*[name()='path']";

    //PAGINADO
    public static final String PAGINADO_TOTAL_XPATH = "//li[contains(text(), '%s')]";
    public static final String PAGINADO_PAGINA_ACTIVA_XPATH = "//li[contains(@class, 'ant-pagination-item-active')]";
    public static final String PAGINADO_SELECTOR_XPATH = "//span[contains(text(), ' / page') or contains(text(), ' / página')]";
    public static final String PAGINADO_FLECHA_ANTERIOR_XPATH = "//li[contains(@class, 'ant-pagination-prev')]";
    public static final String PAGINADO_FLECHA_SIGUIENTE_XPATH = "//li[contains(@class, 'ant-pagination-next')]";
    public static final String PAGINADO_SELECTOR_ITEM_XPATH = "//span[contains(text(), ' / page') or contains(text(), ' / página')]";
    public static final String ACEPTAR_BTN_XPATH = "(//*[normalize-space()='Aceptar'])[1]";
    public static final String HOME_MODAL_ACEPTAR_BTN_XPATH = "//div[contains(@class,'ant-modal-content')]//button[.//span[normalize-space()='Aceptar']]";
}
