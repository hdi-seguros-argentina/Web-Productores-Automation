@AUTOMATED
Feature: Siniestros

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
    When el usuario ingresa al menu de "Listado de Siniestros" en "Siniestros"
    Then el usuario verifica que el titulo "Listado de Siniestros" es correcto


  @branding
  Scenario: Componentes de Cobranzas
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    Then el usuario verifica que el titulo "Nueva Denuncia" es correcto
    Then el usuario verifica que el subtitulo "Búsqueda de la Póliza" es correcto

