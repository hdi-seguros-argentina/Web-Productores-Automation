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
  Scenario: Persistencia de variación en retome de ACCIDENTES PERSONALES COLECTIV
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario realiza la cotización de ACCIDENTES PERSONALES COLECTIV
    And el usuario guarda la cotización
    And el usuario envia la cotización de ACCIDENTES PERSONALES COLECTIV con persistencia de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Nueva Cotización de ACCIDENTES PERSONALES COLECTIV con retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario realiza la cotización de ACCIDENTES PERSONALES COLECTIV
    And el usuario guarda la cotización
    And el usuario emite la cotización de ACCIDENTES PERSONALES COLECTIV
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion @Noe
  Scenario: Variación en retome de ACCIDENTES PERSONALES COLECTIV
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario realiza la cotización de ACCIDENTES PERSONALES COLECTIV
    And el usuario guarda la cotización
    And el usuario emite la cotización de ACCIDENTES PERSONALES COLECTIV validando variación de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Nueva Cotización de ACCIDENTES PERSONALES COLECTIV
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona ACCIDENTES desde el json
    And el usuario selecciona ACCIDENTES PERSONALES COLECTIV desde el json
    And el usuario realiza la cotización de ACCIDENTES PERSONALES COLECTIV
    And el usuario envia la cotización de ACCIDENTES PERSONALES COLECTIV sin guardar
    Then el usuario verifica el envío de la cotización



