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
  Scenario: Componentes de Presentación Factura Comisiones
    When el usuario ingresa al menu de "Facturas pendientes" en "Cuenta Corriente"
    Then el usuario verifica que el titulo "Presentación Factura Comisiones" es correcto
    And el usuario verifica que el input "76095 - ORTUONDO FERNANDO MARCIO" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Estado" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto

  @branding
  Scenario: Componentes de Detalle de Retenciones
    When el usuario ingresa al menu de "Detalle de retenciones" en "Cuenta Corriente"
    Then el usuario verifica que el titulo "Detalle de Retenciones" es correcto
    And el usuario verifica que el input "ORTUONDO FERNANDO MARCIO (1-76095)" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto

  @branding
  Scenario: Componentes de Detalle de Retenciones
    When el usuario ingresa al menu de "Detalle de retenciones" en "Cuenta Corriente"
    And el usuario selecciona "16/08/2024" en Fecha
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en la casilla de seleccion
    And el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el boton "Procesar Selección" es correcto
    And el usuario valida que el check es correcto


  @branding
  Scenario: Componentes de Saldo de Cuenta Corriente
    When el usuario ingresa al menu de "Saldo de Cuenta Corriente" en "Cuenta Corriente"
    Then el usuario verifica que el titulo "Saldo de Cuenta Corriente" es correcto
    And el usuario verifica que el input "ORTUONDO FERNANDO MARCIO (1-76095)" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto