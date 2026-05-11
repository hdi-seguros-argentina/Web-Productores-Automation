@NUEVACOTIZACION
Feature: Cotizador Autos

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Emision de AUTOMOVILES RC en retome
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona AUTOMOVILES desde el json
    And el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json
    And el usuario realiza la cotización de AUTOMOVILES RC
    And el usuario guarda la cotización
    And el usuario emite la cotización de AUTOMOVILES
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador
  Scenario: Persistencia de variación en retome de AUTOMOVILES RC
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona AUTOMOVILES desde el json
    And el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json
    And el usuario realiza la cotización de AUTOMOVILES RC
    And el usuario guarda la cotización
    And el usuario envia la cotización de AUTOMOVILES
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONRETOME @regresion @Cotizador @variacion
  Scenario: Variación en retome de AUTOMOVILES RC
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona AUTOMOVILES desde el json
    And el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json
    And el usuario realiza la cotización de AUTOMOVILES RC
    And el usuario guarda la cotización
    And el usuario emite la cotización de AUTOMOVILES validando variación de comisión
    Then el usuario verifica el envío de la cotización

  @AUTOMATED @COTIZACIONNUEVA @regresion @Cotizador
  Scenario: Nueva Cotización de AUTOMOVILES RC
    When el usuario ingresa al menu de "Nueva Cotizacion" en "Cotizador"
    And el usuario selecciona AUTOMOVILES desde el json
    And el usuario selecciona PRODUCTO AUTOMOVILES RC desde el json
    And el usuario realiza la cotización de AUTOMOVILES RC
    And el usuario envia la cotización de AUTOMOVILES sin guardar
    Then el usuario verifica el envío de la cotización



