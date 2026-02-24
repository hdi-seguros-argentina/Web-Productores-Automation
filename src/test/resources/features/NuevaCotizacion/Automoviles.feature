@AUTOMATED
Feature: Cotizador Autos

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @regresion @Cotizador
  Scenario: Nueva cotizacion de Automoviles
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    And el usuario selecciona AUTOMOVILES desde el json
    And el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json
    And el usuario inicia la cotizacion
    And el usuario busca el cliente de AUTOMOVILES desde el json
    And el usuario completa los datos del vehiculo desde el json
    And el usuario completa el codigo de la cobertura desde el json
    And el usuario guarda la cotizacion de AUTOMOVILES
    And el usuario emite la cotizacion de AUTOMOVILES desde el json
    And el usuario agrega los datos del automovil desde el json
    And el usuario guarda y envia la poliza
    Then el usuario verifica el envio de la poliza


  @regresion @Cotizador
  Scenario: Cotizacion guardada de Automoviles
    When el usuario ingresa al menu de "Cotizaciones Guardadas" en "Cotizador"
    And el usuario emite la cotizacion de AUTOMOVILES desde el json
    And el usuario agrega los datos del automovil desde el json
    And el usuario guarda y envia la poliza
    Then el usuario verifica el envio de la poliza
