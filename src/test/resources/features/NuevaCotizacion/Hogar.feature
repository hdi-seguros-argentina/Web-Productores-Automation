@AUTOMATED
Feature: Cotizador Hogar

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @regresion @Cotizador
  Scenario: Nueva cotizacion de Hogar
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    And el usuario selecciona HOGAR desde el json
    And el usuario selecciona COMBINADO FAMILIAR desde el json
    And el usuario inicia la cotizacion
    And el usuario busca el cliente de HOGAR desde el json
    And el usuario completa los datos del plan de HOGAR desde el json
    And el usuario completa la cobertura de HOGAR desde el json
    And el usuario cotiza y guarda la cotizacion de HOGAR
    And el usuario emite la cotizacion de HOGAR desde el json
    And el usuario guarda y envia la poliza
    Then el usuario verifica el envio de la poliza

  @regresion @Cotizador
  Scenario: Cotizacion guardada de HOGAR
    When el usuario ingresa al menu de "Cotizaciones Guardadas" en "Cotizador"
    And el usuario emite la cotizacion de HOGAR desde el json
    And el usuario guarda y envia la poliza
    Then el usuario verifica el envio de la poliza
