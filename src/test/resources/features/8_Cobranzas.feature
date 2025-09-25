@AUTOMATED
Feature: Cobranzas

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Componentes de Preliquidación
    When el usuario ingresa al menu de "Preliquidación" en "Cobranzas"
    Then el usuario verifica que el titulo "Preliquidación" es correcto
    Then el usuario verifica que el subtitulo "Generación de preliquidación" es correcto


  @branding
  Scenario: Componentes de Preliquidaciones guardadas y enviadas
    When el usuario ingresa al menu de "Preliquidaciones guardadas y enviadas" en "Cobranzas"
    Then el usuario verifica que el subtitulo "Preliquidaciones Enviadas y Guardadas" es correcto


  @branding
  Scenario: Componentes de Pólizas con Deuda Vencida
    When el usuario ingresa al menu de "Pólizas con Deuda Vencida" en "Cobranzas"
    Then el usuario verifica que el titulo "Pólizas con Deuda Vencida" es correcto


  @branding
  Scenario: Componentes de Rechazo de débitos automáticos
    When el usuario ingresa al menu de "Rechazo de débitos automáticos" en "Cobranzas"
    Then el usuario verifica que el titulo "Rechazos de débitos automaticos" es correcto