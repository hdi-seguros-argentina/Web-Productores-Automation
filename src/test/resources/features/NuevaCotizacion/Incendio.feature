@NUEVACOTIZACION
Feature: Cotizador Incendio

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Cotizador > Nueva Cotización > INCENDIO VIVIENDAS: permite emitir cotización en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INCENDIO WEB desde el json
    And el usuario selecciona INCENDIO VIVIENDAS desde el json
    And el usuario realiza la cotización de INCENDIO VIVIENDAS
    And el usuario guarda la cotización
    And el usuario emite la cotización de INCENDIO VIVIENDAS
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Cotizador > Nueva Cotización > INCENDIO VIVIENDAS: persiste variación en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INCENDIO WEB desde el json
    And el usuario selecciona INCENDIO VIVIENDAS desde el json
    And el usuario realiza la cotización de INCENDIO VIVIENDAS
    And el usuario modifica la variación de INCENDIO VIVIENDAS desde el json
    And el usuario guarda la cotización
    And el usuario envia la cotización de INCENDIO VIVIENDAS
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion
  Scenario: Cotizador > Nueva Cotización > INCENDIO VIVIENDAS: permite variar cotización en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INCENDIO WEB desde el json
    And el usuario selecciona INCENDIO VIVIENDAS desde el json
    And el usuario realiza la cotización de INCENDIO VIVIENDAS
    And el usuario guarda la cotización
    And el usuario emite la cotización de INCENDIO VIVIENDAS validando variación de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Cotizador > Nueva Cotización > INCENDIO VIVIENDAS: permite generar nueva cotización
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INCENDIO WEB desde el json
    And el usuario selecciona INCENDIO VIVIENDAS desde el json
    And el usuario realiza la cotización de INCENDIO VIVIENDAS
    And el usuario envia la cotización de INCENDIO VIVIENDAS sin guardar
    Then el usuario verifica el envío de la cotización





