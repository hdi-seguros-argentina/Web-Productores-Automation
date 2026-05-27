package locators;

public class AutomovilesLocators {
    public static final String RADIO_COBERTURA = "//div[contains(@id,'car-coverages-form')]//input[@value='%s']";
    public static final String RADIO_COBERTURA_SELECCIONADA = "//div[contains(@id,'car-coverages-form')]//input[@value='%s']/ancestor::label[1]//span[contains(@class,'ant-radio-checked')]";
    public static final String USO_SELECT = "//label[normalize-space()='Uso']/following::div[contains(@class,'ant-select')][1]";
    public static final String USO_VALOR_ACTUAL = "//label[normalize-space()='Uso']/following::div[contains(@class,'ant-select')][1]//*[contains(@class,'ant-select-selection-item') or contains(@class,'ant-select-selection-placeholder')][1]";
    public static final String PATENTE_INPUT = "//input[contains(@id,'vehicle-info-section-form_patent')]";
    public static final String MOTOR_INPUT = "//input[contains(@id,'vehicle-info-section-form_engineNumber')]";
    public static final String CHASIS_INPUT = "//input[contains(@id,'vehicle-info-section-form_chassisNumber')]";
    public static final String FORMA_PAGO_AUTO_SELECT = "//input[@id='car-coverages-form_paymentMethod']/ancestor::div[contains(@class,'ant-select')][1]";
    public static final String FORMA_PAGO_AUTO_VALOR_ACTUAL = "//input[@id='car-coverages-form_paymentMethod']/ancestor::div[contains(@class,'ant-select')][1]//*[contains(@class,'ant-select-selection-item') or contains(@class,'ant-select-selection-placeholder')][1]";
    public static final String TIPO_INSPECCION_SELECT = "//input[@id='vehicle-info-section-form_typeInspection-tab-1']/ancestor::div[contains(@class,'ant-select')][1]";
    public static final String TIPO_INSPECCION_VALOR_ACTUAL = "//input[@id='vehicle-info-section-form_typeInspection-tab-1']/ancestor::div[contains(@class,'ant-select')][1]//*[contains(@class,'ant-select-selection-item') or contains(@class,'ant-select-selection-placeholder')][1]";
    public static final String PRIMA_AUTO_SELECCIONADA_RESUMEN = "//span[contains(@class,'ant-radio-checked')]/ancestor::div[contains(@class,'ant-card')][1]//span[contains(normalize-space(),'Prima')]/ancestor::div[2]/div[2]/div";
    public static final String COMISION_AUTO_SELECCIONADA_RESUMEN = "//span[contains(@class,'ant-radio-checked')]/ancestor::div[contains(@class,'ant-card')][1]//span[contains(normalize-space(),'Comisi')]/ancestor::div[2]/div[2]/div";
    public static final String PREMIO_AUTO_SELECCIONADA_RESUMEN = "//span[contains(@class,'ant-radio-checked')]/ancestor::div[contains(@class,'ant-card')][1]//span[contains(normalize-space(),'Premio')]/ancestor::div[2]/div[2]/div";
    public static final String CONDUCTOR_MENOR_30_RADIO_MYWAY = "//div[@id='property-data-car_A001-tab-1']//input[@value='%s']/ancestor::label[1]";
    public static final String HIJOS_MENORES_RADIO_MYWAY = "//div[@id='property-data-car_A002-tab-1']//input[@value='%s']/ancestor::label[1]";
    public static final String GUARDA_GARAGE_RADIO_MYWAY = "//div[@id='property-data-car_A003-tab-1']//input[@value='%s']/ancestor::label[1]";
}
