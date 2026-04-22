@AUTOMATED @Siniestros
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
  Scenario: Siniestros > Listado de Siniestros: muestra filtros y paginado
    When el usuario ingresa al menu de "Listado de Siniestros" en "Siniestros"
    Then el usuario verifica que el titulo "Listado de Siniestros" es correcto
    And el usuario verifica que el input "Bien Siniestrado" es correcto
    And el usuario verifica que el input "Siniestro" es correcto
    And el usuario verifica que el input "Asegurado" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Siniestro más reciente primero" es correcto
    And el usuario verifica que el paginado de "siniestros" es correcto

  @branding
  Scenario Outline: Siniestros > Nueva Denuncia: alterna radio-botones "<boton>" y mantiene acciones
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    And el usuario selecciona "<boton>"
    And el usuario verifica que el radio-boton "<boton>" es correcto
    And el usuario verifica que el boton "Buscar Póliza" es correcto
    Examples:
      | boton   |
      | Patente |
      | Póliza  |

  @branding
  Scenario: Siniestros > Nueva Denuncia por Patente: muestra campos y acciones requeridas
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
  Scenario: Siniestros > Nueva Denuncia por Póliza: muestra campos y acciones requeridas
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    Then el usuario verifica que el titulo "Nueva Denuncia" es correcto
    Then el usuario verifica que el subtitulo "Búsqueda de la Póliza" es correcto
    And el usuario selecciona "Póliza"
    And el usuario verifica que el input "Rama" es correcto
    And el usuario verifica que el input "Seleccionar fecha" es correcto
    And el usuario verifica que el input "Seleccionar hora" es correcto
    And el usuario verifica que el boton "Buscar Póliza" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto
