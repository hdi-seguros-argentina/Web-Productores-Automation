package locators;

public class LoginLocators {
    public static final String HOME_TITLE_XPATH = "//img[@class='ant-image-img css-bixahu']"; //cambiar
    public static final String USUARIO_INPUT_XPATH = "//input[@id='login_username']";
    public static final String PASSWORD_INPUT_XPATH = "//input[@id='login_password']";
    public static final String LOGIN_BTN_XPATH = "//span[text()='Iniciar sesión']";
    public static final String HOME3_TITLE_XPATH = "//img[@class='ant-image-img css-uyuj90']"; //cambiar
    public static final String HOME2_TITLE_XPATH = "//img[@alt='HDI Seguros']"; //cambiar

    //Validacion de estilo
    public static final String USUARIO1_INPUT_XPATH = "//input[@id='login_username']/parent::*";
    public static final String PASSWORD1_INPUT_XPATH = "//input[@id='login_password']/parent::*";
    public static final String PASS_BTN1_XPATH = "//span[text()='¿Olvidaste tu contraseña?']";
    public static final String LOGIN_BTN1_XPATH = "//span[text()='Iniciar sesión']//ancestor::button";


}