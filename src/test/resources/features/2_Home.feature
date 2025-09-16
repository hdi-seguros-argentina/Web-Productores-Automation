@AUTOMATED
Feature: Home

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    Then el usuario verifica que se logueo correctamente

  @Regression
  Scenario: Home - Buscar intermediario
    Given el usuario ingresa a la home
    When el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Componentes de Home
    Given el usuario ingresa a la home
    When el usuario se posiciona en la pantalla de home
    Then el usuario verifica que el header el correcto
    Then el usuario verifica que los input Nombre son correctos
    Then el usuario verifica que los input Cuit son correctos
    Then el usuario verifica que los input Codigo Interno son correctos
    Then el usuario verifica que los input Nivel son correctos
    Then el usuario verifica que el boton filtrar es correcto
    Then el usuario verifica que el boton borrar filtros es correcto
    Then el usuario verifica que el boton seleccionar es correcto

  @branding
  Scenario: Componentes de Panel de inicio
    Given el usuario ingresa a la home
    When el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio
    And el usuario verifica que los iconos son correcto