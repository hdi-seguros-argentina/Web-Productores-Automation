package locators;

public class CommonLocators {
    public static final String RAMA_SELECT="//*[text()='Seleccione un grupo']/ancestor::div[contains(@class,'ant-select')]";
    public static final String ARTICULO_SELECT="(//div[contains(@class,'ant-select-selector')])[3]";
    public static final String SELECT_OPCION="//div[contains(@class,'ant-select-item-option-content') and text()='%s']";
    public static final String BOTON_INICIAR_COTIZACION="//button[.//span[text()='Iniciar Cotizaci贸n']]";
    public static final String BOTON_BUSCAR_CLIENTE="//button[.//span[text()='Buscar cliente']]";
    public static final String RESULTADO_CLIENTE="//td[contains(text(),'%s')]";
    public static final String BOTON_CONTINUAR="//button[.//span[text()='Continuar']]";
    public static final String PLAN_SELECT="//h3[normalize-space()='Planes']/following::div[contains(@class,'ant-select')][1]";
    public static final String ACTIVIDAD_SELECT="//label[text()='Actividad']/following::div[contains(@class,'ant-select')][1]";
    public static final String INPUT_CANTIDAD="//input[@id='activities-form_quantity']";
    public static final String BOTON_AGREGAR="//button[.//span[text()='Agregar']]";
    public static final String INPUT_COBERTURA_MUERTE="//span[text()='MUERTE']/following::input[1]";
    public static final String BOTON_COTIZAR="//button[.//span[text()='Cotizar']]";
    public static final String BOTON_GUARDAR_COTIZACION="//button[.//span[text()='Guardar Cotizaci贸n']]";
    public static final String BOTON_LAPIZ_EDITAR="(//tr[.//td[contains(text(),'COTIZACION SALVADA')]]//button)[1]";
    public static final String TITULO_NUEVACOTIZACION_XPATH="//h3[text()='Nueva Cotizaci贸n']";
    public static final String BOTON_RECOTIZAR="//button[.//span[text()='Recotizar']]";
    public static final String BOTON_EMITIR="//button[.//span[text()='Emitir']]";
    public static final String NACIONALIDAD_SELECT="//label[text()='Nacionalidad']/following::div[contains(@class,'ant-select')][1]";
    public static final String NACIONALIDAD_INPUT_SELECT="//input[@id='client-data-form_nationality']";
    public static final String TARJETA_CREDITO_SELECT="//input[@id='payment-method-form_companyCreditCard']/ancestor::div[contains(@class,'ant-select')][1] | //label[contains(normalize-space(),'Tarjeta de') and (contains(normalize-space(),'Cr閐ito') or contains(normalize-space(),'Credito'))]/following::div[contains(@class,'ant-select')][1]";
    public static final String INPUT_TARJETA="//label[text()='N煤mero de Tarjeta']/following::input[1]";
    public static final String TARJETA_CREDITO_OPCION_VISA="//div[contains(@class,'ant-select-item-option-content') and normalize-space()='VISA ARGENTINA SA']";
    public static final String INPUT_VENCIMIENTO="//label[text()='Vencimiento']/following::input[1]";
    public static final String BOTON_AGREGAR_PERSONA="//button[.//span[text()='Agregar Persona']]";
    public static final String INPUT_APELLIDO_NOMBRE="(//input[@placeholder='Apellido y nombre'])[2]";
    public static final String TIPO_DOCUMENTO_SELECT="(//input[contains(@id,'_documentType')])[2]";
    public static final String INPUT_NUMERO_DOCUMENTO="(//input[contains(@id,'_documentNumber')])[2]";
    public static final String INPUT_CUIL="(//input[contains(@id,'_cuil')])[2]";
    public static final String INPUT_FECHA_NACIMIENTO="//input[contains(@id,'_birthdayDate')]";
    public static final String GENERO_SELECT="(//label[text()='G茅nero']/following::div[contains(@class,'ant-select')][1])[2]";
    public static final String NACIONALIDAD_PERSONA_SELECT2="(//input[contains(@class,'ant-select-selection-search-input') and contains(@id,'nationality')])[2]";
    public static final String BOTON_GUARDAR="//button[.//span[text()='Guardar']]";
    public static final String BOTON_ENVIAR="//button[.//span[text()='Enviar']]";
    public static final String POLIZA_ENVIO_TITULO = "//h3[contains(.,'Cotizaci贸n') and contains(.,'enviada correctamente')]";
    public static final String POLIZA_ENVIO_TEXTO = "//span[contains(.,'Se ha enviado un correo electr贸nico')]";
    public static final String POLIZA_ENVIO_BOTON_ACEPTAR = "//button[.//span[normalize-space()='Aceptar']]";

    // Vehiculo
    public static final String SELECT_DESPLEGABLE = "//label[normalize-space()='%s']/following::div[contains(@class,'ant-select')][1]";
    public static final String MARCA_INPUT_SELECT = "//div[contains(@class,'ant-select-open')]//input[contains(@class,'ant-select-selection-search-input')]";
    // Cobertura
    public static final String RADIO_COBERTURA = "//div[contains(@id,'car-coverages-form')]//input[@value='%s']";

    // Datos automovil
    public static final String USO_SELECT = "//label[normalize-space()='Uso']/following::div[contains(@class,'ant-select')][1]";
    public static final String PATENTE_INPUT = "//input[contains(@id,'vehicle-info-section-form_patent')]";
    public static final String MOTOR_INPUT = "//input[contains(@id,'vehicle-info-section-form_engineNumber')]";
    public static final String CHASIS_INPUT = "//input[contains(@id,'vehicle-info-section-form_chassisNumber')]";

    // Datos del bien
    public static final String TIPO_VIVIENDA_SELECT = "//input[contains(@id,'property-data-home-form_type-housing')]";
    public static final String INPUT_DOMICILIO = "//input[@id='activity-form-1_propertyDataAddress1']";
    public static final String COBERTURA_CHECKBOX = "//span[normalize-space()='%s']/ancestor::label[1]//input[@type='checkbox']";
    public static final String COBERTURA_INPUT = "//span[normalize-space()='%s']/following::input[@role='spinbutton'][1]";

    // Informacion contacto
    public static final String INPUT_NOMBRE_APELLIDO_CONTACTO = "//input[@id='contact-data-form-1_fullNameContact1']";
    public static final String INPUT_TELEFONO_CONTACTO = "//input[@id='contact-data-form-1_phoneNumberContact1']";
    public static final String INPUT_EMAIL_CONTACTO = "//input[@id='contact-data-form-1_emailContact1']";
    public static final String INPUT_HORA_DESDE = "//input[@id='contact-data-form-1_hoursForContact1']";
    public static final String INPUT_HORA_HASTA = "(//input[@date-range='end'])[2]";
    public static final String BOTON_ACEPTAR_HORA = "//button[.//span[text()='Aceptar']]";

    // Variacion y resumen de cotizacion (todas las ramas)
    public static final String INPUT_VARIACION = "//input[contains(@id,'variation')]";
    public static final String COMISION_CAMPO = "//input[contains(@id,'commission')]";
    public static final String EXTRA_PRIMA_VARIABLE_CAMPO = "//input[contains(@id,'extraVariable')]";
    public static final String PRIMA_TECNICA_RESUMEN = "//span[contains(normalize-space(),'Prima')]/ancestor::div[contains(@class,'ant-col')][1]//div[contains(@class,'ant-row')][2]//*[self::span or self::div or self::b][1]";
    public static final String PRIMA_TECNICA_AUTO__RESUMEN = "//span[contains(normalize-space(),'Prima')]/ancestor::div[2]/div[2]/div";
    public static final String COMISION_RESUMEN = "//span[contains(normalize-space(),'Comisi')]/ancestor::div[contains(@class,'ant-col')][1]//div[contains(@class,'ant-row')][2]//*[self::span or self::div or self::b][1]";
    public static final String COMISION_AUTO_RESUMEN = "//span[contains(normalize-space(),'Comisi')]/ancestor::div[2]/div[2]/div";
    public static final String PREMIO_RESUMEN = "//span[contains(normalize-space(),'Premio')]/ancestor::div[contains(@class,'ant-col')][1]//div[contains(@class,'ant-row')][2]//*[self::span or self::div or self::b][1]";
    public static final String PREMIO_AUTO_RESUMEN = "//span[contains(normalize-space(),'Premio')]/ancestor::div[2]/div[2]/div";
}
