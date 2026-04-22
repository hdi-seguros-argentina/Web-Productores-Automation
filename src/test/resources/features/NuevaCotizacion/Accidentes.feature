@NUEVACOTIZACION
Feature: Cotizador AP

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Nueva cotizacion con retome de ACCIDENTES PERSONALES COLECTIV
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario realiza la cotizacion de ACCIDENTES PERSONALES COLECTIV
    And el usuario guarda la cotizacion
    And el usuario envia la cotizacion de ACCIDENTES PERSONALES COLECTIV
    Then el usuario verifica el envio de la cotizacion

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Nueva cotizacion de ACCIDENTES PERSONALES COLECTIV
    When el usuario ingresa al menu de "Nueva Cotización" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario realiza la cotizacion de ACCIDENTES PERSONALES COLECTIV
    And el usuario envia la cotizacion de ACCIDENTES PERSONALES COLECTIV sin guardar
    Then el usuario verifica el envio de la cotizacion
