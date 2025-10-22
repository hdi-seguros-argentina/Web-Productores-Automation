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
  Scenario: Verificar título y botón en la pantalla Preliquidación inicial
    When el usuario ingresa al menu de "Preliquidación" en "Cobranzas"
    Then el usuario verifica que el titulo "Preliquidación" es correcto
    Then el usuario verifica que el subtitulo "Generación de preliquidación" es correcto
    And el usuario verifica que el boton "Continuar" es correcto

  @branding
  Scenario Outline: Verificar radio-botones dinámicos "<boton>" en Preliquidación inicial
    When el usuario ingresa al menu de "Preliquidación" en "Cobranzas"
    And el usuario selecciona "<boton>"
    Then el usuario verifica que el radio-boton "<boton>" es correcto
    And el usuario verifica que el boton "Continuar" es correcto
    Examples:
      | boton |
      | SI    |
      | NO    |

  @branding
  Scenario: Verificar inputs, botones y paginado en Preliquidación con selección "SI"
    When el usuario ingresa al menu de "Preliquidación" en "Cobranzas"
    And el usuario selecciona "SI"
    And el usuario hace clic en el boton "Continuar"
    And el usuario ingresa a la pantalla de "Preliquidación"
    Then el usuario verifica que el titulo "Preliquidación" es correcto
    And el usuario verifica que el subtitulo "Listado de Pólizas" es correcto
    And el usuario verifica que step "Principal" está activo en el stepper
    And el usuario verifica que el input "Rama" es correcto
    And el usuario verifica que el input "Asegurado" es correcto
    And el usuario verifica que el input "Póliza" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el subtitulo "Resumen" es correcto
    And el usuario verifica que el boton "Continuar" es correcto
    And el usuario verifica que el paginado de "cuotas" es correcto

  @branding
  Scenario: Verificar inputs, botones y paginado en Preliquidación con selección "NO"
    When el usuario ingresa al menu de "Preliquidación" en "Cobranzas"
    And el usuario selecciona "NO"
    And el usuario hace clic en el boton "Continuar"
    And el usuario ingresa a la pantalla de "Preliquidación"
    Then el usuario verifica que el titulo "Preliquidación" es correcto
    And el usuario verifica que el subtitulo "Listado de Pólizas" es correcto
    And el usuario verifica que step "Principal" está activo en el stepper
    And el usuario verifica que el input "Rama" es correcto
    And el usuario verifica que el input "Asegurado" es correcto
    And el usuario verifica que el input "Póliza" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el subtitulo "Resumen" es correcto
    And el usuario verifica que el boton "Continuar" es correcto
    And el usuario verifica que el paginado de "cuotas" es correcto

  @branding
  Scenario: Verificar título y tab en Preliquidaciones Guardadas y Enviadas
    When el usuario ingresa al menu de "Preliquidaciones guardadas y enviadas." en "Cobranzas"
    Then el usuario verifica que el subtitulo "Preliquidaciones guardadas y enviadas." es correcto

  @branding
  Scenario: Verificar componentes en la sección Preliquidaciones Guardadas

  @branding
  Scenario: Verificar componentes en la sección Preliquidaciones Enviadas

  @branding
  Scenario: Verificar paginado en la pantalla Pólizas con Deuda Vencida
    When el usuario ingresa al menu de "Pólizas con Deuda Vencida" en "Cobranzas"
    Then el usuario verifica que el titulo "Pólizas con Deuda Vencida" es correcto
    And el usuario verifica que el paginado de "polizas" es correcto

  @branding
  Scenario: Verificar título en la pantalla Rechazo de Débitos Automáticos
    When el usuario ingresa al menu de "Rechazo de débitos automáticos" en "Cobranzas"
    Then el usuario verifica que el titulo "Rechazos de débitos automaticos" es correcto