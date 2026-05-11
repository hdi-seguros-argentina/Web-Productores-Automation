@NUEVACOTIZACION
Feature: Cotizador Hogar

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Emision de COMBINADO FAMILIAR en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona HOGAR desde el json
    And el usuario selecciona COMBINADO FAMILIAR desde el json
    And el usuario realiza la cotización de COMBINADO FAMILIAR
    And el usuario guarda la cotización
    And el usuario emite la cotización de COMBINADO FAMILIAR
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Persistencia de variación en retome de COMBINADO FAMILIAR
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona HOGAR desde el json
    And el usuario selecciona COMBINADO FAMILIAR desde el json
    And el usuario realiza la cotización de COMBINADO FAMILIAR
    And el usuario guarda la cotización
    And el usuario envia la cotización de COMBINADO FAMILIAR
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion
  Scenario: Variación en retome de COMBINADO FAMILIAR
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona HOGAR desde el json
    And el usuario selecciona COMBINADO FAMILIAR desde el json
    And el usuario realiza la cotización de COMBINADO FAMILIAR
    And el usuario guarda la cotización
    And el usuario emite la cotización de COMBINADO FAMILIAR validando variación de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Nueva Cotización de COMBINADO FAMILIAR
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona HOGAR desde el json
    And el usuario selecciona COMBINADO FAMILIAR desde el json
    And el usuario realiza la cotización de COMBINADO FAMILIAR
    And el usuario envia la cotización de COMBINADO FAMILIAR sin guardar
    Then el usuario verifica el envío de la cotización





