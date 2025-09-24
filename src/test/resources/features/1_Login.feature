@AUTOMATED
Feature: Login

  @Regression
  Scenario: Login
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    Then el usuario verifica que se logueo correctamente

  @branding
  Scenario: Componentes de Login
    Given el usuario ingresa a la web
    When el usuario se posiciona en la pantalla de login
    Then el usuario verifica que el logo es correcto
    Then el usuario verifica que el input "Usuario" es correcto
    Then el usuario verifica que el input "Contraseña" es correcto
    Then el usuario verifica que el boton "Iniciar sesión" es correcto
    Then el usuario verifica que el boton "¿Olvidaste tu contraseña?" es correcto
