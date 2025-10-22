@AUTOMATED
Feature: Emision

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Verificar tabs, botones y paginado en Endosos Aumento de Suma
    When el usuario ingresa al menu de "Endosos Aumento de Suma" en "Emision"
    And el usuario verifica que el boton "Aceptar" es correcto
    And el usuario verifica que el boton "Cancelar" es correcto
    And el usuario hace clic en el boton "Aceptar"
    Then el usuario verifica que el titulo "Endosos" es correcto
    And el usuario verifica que la tab "Endoso de Aumento de Suma de Ascensores y Calderas" es correcta
    And el usuario verifica que la tab "Endoso de Aumento de Vehículos" es correcta
    And el usuario verifica que el boton "Procesar Selección" es correcto
    And el usuario verifica que el paginado de "endosos" es correcto

  @branding
  Scenario: Verificar título y botón Aceptar en Transporte de Mercaderías
    When el usuario ingresa al menu de "Transporte Mercaderías" en "Emision"
    Then el usuario verifica que el titulo "Transporte Mercaderías" es correcto
    And el usuario verifica que el boton "Aceptar" es correcto