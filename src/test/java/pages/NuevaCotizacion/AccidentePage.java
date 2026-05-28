package pages.NuevaCotizacion;

import com.core.utility.MasterPage;
import models.Persona;

import static locators.CommonLocators.*;

public class AccidentePage extends MasterPage {

    public void seleccionarActividad(String actividad) {
        page.get().waitForTimeout(2500);
        auto_setClickElement(ACTIVIDAD_SELECT);
        auto_waitForElementVisibility(String.format(SELECT_OPCION, actividad));
        auto_setClickElement(String.format(SELECT_OPCION, actividad));
    }

    public void ingresarCantidad(int cantidad) {
        page.get().waitForTimeout(1000);
        auto_setTextToInput(INPUT_CANTIDAD, String.valueOf(cantidad));
        auto_setClickElement(BOTON_AGREGAR);
        page.get().waitForTimeout(1000);
        auto_setClickElement(BOTON_CONTINUAR);
        page.get().waitForTimeout(1000);
    }

    public void agregarPersona(Persona persona) {
        auto_setClickElement(BOTON_AGREGAR_PERSONA);

        auto_setTextToInput(INPUT_APELLIDO_NOMBRE, persona.getApellidoYNombre());

        auto_setClickElement(TIPO_DOCUMENTO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, persona.getTipoDocumento()));

        auto_setTextToInput(INPUT_NUMERO_DOCUMENTO, persona.getNumeroDocumento());

        auto_setTextToInput(INPUT_CUIL, persona.getCuil());

        auto_setTextToInput(INPUT_FECHA_NACIMIENTO, persona.getFechaNacimiento());
        auto_pressKey(INPUT_FECHA_NACIMIENTO, "Enter");

        auto_setTextToInput(NACIONALIDAD_PERSONA_SELECT2, persona.getNacionalidad());
        auto_pressKey(NACIONALIDAD_PERSONA_SELECT2, "Enter");

        auto_setClickElement(GENERO_SELECT);
        auto_setClickElement(String.format(SELECT_OPCION, persona.getGenero()));
    }

}

