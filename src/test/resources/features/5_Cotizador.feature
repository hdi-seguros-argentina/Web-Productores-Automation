@AUTOMATED
Feature: Cotizador

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Verificar inputs y botón en la pantalla Nueva Cotización
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    Then el usuario verifica que el titulo "Nueva Cotización" es correcto
    And el usuario verifica que el input "Seleccione un grupo" es correcto
    And el usuario selecciona "ACCIDENTES PERSONALES" en grupo
    And el usuario verifica que el input "ACCIDENTES PERSONALES COLECTIV" es correcto
    And el usuario verifica que el boton "Iniciar Cotización" es correcto

  @branding
  Scenario: Verificar inputs, botones y paginado en Cotizaciones Guardadas
    When el usuario ingresa al menu de "Cotizaciones Guardadas" en "Cotizador"
    Then el usuario verifica que el titulo "Cotizaciones Guardadas" es correcto
    And el usuario verifica que el input "Apellido y Nombre" es correcto
    And el usuario verifica que el input "Articulo" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Operación" es correcto
    And el usuario verifica que el input "Número de Cotización" es correcto
    And el usuario verifica que el input "Estado" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el paginado de "cotizaciones" es correcto