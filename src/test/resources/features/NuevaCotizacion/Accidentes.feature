@AUTOMATED
Feature: Cotizador AP

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @regresion @Cotizador @Noe
  Scenario: Nueva cotizacion de Accidentes personales
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario inicia la cotizacion
    And el usuario busca el cliente de ACCIDENTES desde el json
    And el usuario completa los datos del plan desde el json
    And el usuario completa la cobertura desde el json
    And el usuario cotiza y guarda la cotizacion de ACCIDENTES
    And el usuario emite la cotizacion de ACCIDENTES desde el json
    And el usuario agrega las personas desde el json
    And el usuario guarda y envia la poliza
    Then el usuario verifica el envio de la poliza

  @regresion @Cotizador
  Scenario: Cotizacion guardada de Accidentes personales
    When el usuario ingresa al menu de "Cotizaciones Guardadas" en "Cotizador"
    And el usuario emite la cotizacion de ACCIDENTES desde el json
    And el usuario agrega las personas desde el json
    And el usuario guarda y envia la poliza
    Then el usuario verifica el envio de la poliza
