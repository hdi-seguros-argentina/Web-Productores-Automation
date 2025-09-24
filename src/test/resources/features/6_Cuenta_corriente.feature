@AUTOMATED
Feature: Cuenta Corriente

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Componentes de Cobranzas
    When el usuario ingresa al menu de "Facturas pendientes" en "Cuenta Corriente"
    Then el usuario verifica que el titulo "Presentación Factura Comisiones" es correcto


  @branding
  Scenario: Componentes de Cobranzas
    When el usuario ingresa al menu de "Detalle de retenciones" en "Cuenta Corriente"
    Then el usuario verifica que el titulo "Detalle de Retenciones" es correcto


  @branding
  Scenario: Componentes de Cobranzas
    When el usuario ingresa al menu de "Saldo de Cuenta Corriente" en "Cuenta Corriente"
    Then el usuario verifica que el titulo "Saldo de Cuenta Corriente" es correcto

