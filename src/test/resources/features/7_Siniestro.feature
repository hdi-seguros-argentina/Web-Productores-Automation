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
  Scenario: Componentes de Listado de Siniestros
    When el usuario ingresa al menu de "Listado de Siniestros" en "Siniestros"
    Then el usuario verifica que el titulo "Listado de Siniestros" es correcto
    And el usuario verifica que el input "Bien Siniestrado" es correcto
    And el usuario verifica que el input "Poliza" es correcto
    And el usuario verifica que el input "Siniestro" es correcto
    And el usuario verifica que el input "Asegurado" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Siniestro más reciente primero" es correcto

  @branding
  Scenario Outline: Componentes de Nueva Denuncia
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    And el usuario selecciona "<boton>"
    And el usuario verifica que el radio-boton "<boton>" es correcto
    And el usuario verifica que el boton "Buscar Póliza" es correcto
    Examples:
      | boton   |
      | Patente |
      | Póliza  |

  @branding
  Scenario: Componentes de Nueva Denuncia
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    Then el usuario verifica que el titulo "Nueva Denuncia" es correcto
    Then el usuario verifica que el subtitulo "Búsqueda de la Póliza" es correcto
    And el usuario selecciona "Patente"
    And el usuario verifica que el input "Patente" es correcto
    And el usuario verifica que el input "Seleccionar fecha" es correcto
    And el usuario verifica que el input "Seleccionar hora" es correcto
    And el usuario verifica que el boton "Buscar Póliza" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto


  @branding
  Scenario: Componentes de Nueva Denuncia
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    Then el usuario verifica que el titulo "Nueva Denuncia" es correcto
    Then el usuario verifica que el subtitulo "Búsqueda de la Póliza" es correcto
    And el usuario selecciona "Póliza"
    And el usuario verifica que el input "Rama" es correcto
    And el usuario verifica que el input "Póliza" es correcto
    And el usuario verifica que el input "Seleccionar fecha" es correcto
    And el usuario verifica que el input "Seleccionar hora" es correcto
    And el usuario verifica que el boton "Buscar Póliza" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto