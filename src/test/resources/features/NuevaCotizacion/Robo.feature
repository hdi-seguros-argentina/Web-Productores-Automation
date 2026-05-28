@NUEVACOTIZACION
Feature: Cotizador Robo

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @COTIZACIONRETOMECOMPLETA
  Scenario: Cotizador > Nueva Cotización > ROBO WEB: permite emitir cotización en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ROBO desde el json
    And el usuario selecciona ROBO WEB desde el json
    And el usuario realiza la cotización de ROBO WEB
    And el usuario guarda la cotización
    And el usuario emite la cotización de ROBO WEB
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion
  Scenario: Cotizador > Nueva Cotización > ROBO WEB: persiste variación en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ROBO desde el json
    And el usuario selecciona ROBO WEB desde el json
    And el usuario realiza la cotización de ROBO WEB
    And el usuario modifica la variación de ROBO WEB desde el json
    And el usuario guarda la cotización
    And el usuario envia la cotización de ROBO WEB
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion
  Scenario: Cotizador > Nueva Cotización > ROBO WEB: permite variar cotización en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ROBO desde el json
    And el usuario selecciona ROBO WEB desde el json
    And el usuario realiza la cotización de ROBO WEB
    And el usuario guarda la cotización
    And el usuario emite la cotización de ROBO WEB validando variación de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Cotizador > Nueva Cotización > ROBO WEB: permite generar nueva cotización
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ROBO desde el json
    And el usuario selecciona ROBO WEB desde el json
    And el usuario realiza la cotización de ROBO WEB
    And el usuario envia la cotización de ROBO WEB sin guardar
    Then el usuario verifica el envío de la cotización





