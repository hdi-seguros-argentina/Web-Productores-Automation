Feature: Cotizador Integral comercio

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACION @regresion @Cotizador @Noe
  Scenario: Nueva cotizacion de INTEGRAL DE COMERCIO WEB
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    And el usuario selecciona INTEGRAL DE CONSORCIO desde el json
    And el usuario selecciona INTEGRAL DE CONSORCIO WEB desde el json
    And el usuario realiza la cotizacion de INTEGRAL DE CONSORCIO
    And el usuario guarda la cotizacion
    And el usuario envia la cotizacion de INTEGRAL DE CONSORCIO
    Then el usuario verifica el envio de la cotizacion

  Scenario: Cotizacion guardada de INCENDIO VIVIENDAS
    When el usuario ingresa al menu de "Cotizaciones Guardadas" en "Cotizador"
    And el usuario envia la cotizacion de INTEGRAL DE CONSORCIO
    Then el usuario verifica el envio de la cotizacion
