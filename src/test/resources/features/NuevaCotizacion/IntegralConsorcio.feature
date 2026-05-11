@NUEVACOTIZACION
Feature: Cotizador Integral comercio

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Emision de INTEGRAL CONSORCIO WEB en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INTEGRAL DE CONSORCIO desde el json
    And el usuario selecciona INTEGRAL DE CONSORCIO WEB desde el json
    And el usuario realiza la cotización de INTEGRAL DE CONSORCIO
    And el usuario guarda la cotización
    And el usuario emite la cotización de INTEGRAL DE CONSORCIO
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Persistencia de variación en retome de INTEGRAL CONSORCIO WEB
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INTEGRAL DE CONSORCIO desde el json
    And el usuario selecciona INTEGRAL DE CONSORCIO WEB desde el json
    And el usuario realiza la cotización de INTEGRAL DE CONSORCIO
    And el usuario guarda la cotización
    And el usuario envia la cotización de INTEGRAL DE CONSORCIO
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion
  Scenario: Variación en retome de INTEGRAL CONSORCIO WEB
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INTEGRAL DE CONSORCIO desde el json
    And el usuario selecciona INTEGRAL DE CONSORCIO WEB desde el json
    And el usuario realiza la cotización de INTEGRAL DE CONSORCIO
    And el usuario guarda la cotización
    And el usuario emite la cotización de INTEGRAL DE CONSORCIO validando variación de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Nueva Cotización de INTEGRAL CONSORCIO WEB
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona INTEGRAL DE CONSORCIO desde el json
    And el usuario selecciona INTEGRAL DE CONSORCIO WEB desde el json
    And el usuario realiza la cotización de INTEGRAL DE CONSORCIO
    And el usuario envia la cotización de INTEGRAL DE CONSORCIO sin guardar
    Then el usuario verifica el envío de la cotización





