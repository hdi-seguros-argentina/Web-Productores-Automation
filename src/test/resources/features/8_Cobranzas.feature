@AUTOMATED @Cobranzas
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
  Scenario: Cobranzas > Preliquidación inicial: muestra encabezado y acción Continuar
    When el usuario ingresa al menu de "Preliquidacion" en "Cobranzas"
    Then el usuario verifica que el titulo "Preliquidación" es correcto
    Then el usuario verifica que el subtitulo "Generación de preliquidación" es correcto
    And el usuario verifica que el boton "Continuar" es correcto

  @branding
  Scenario Outline: Cobranzas > Preliquidación inicial: alterna radio-botones "<boton>"
    When el usuario ingresa al menu de "Preliquidacion" en "Cobranzas"
    And el usuario selecciona "<boton>"
    Then el usuario verifica que el radio-boton "<boton>" es correcto
    And el usuario verifica que el boton "Continuar" es correcto
    Examples:
      | boton |
      | SI    |
      | NO    |

  @branding
  Scenario: Cobranzas > Preliquidación incluyendo cuotas con débito automático: muestra filtros, resumen y paginado
    When el usuario ingresa al menu de "Preliquidacion" en "Cobranzas"
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
  Scenario: Cobranzas > Preliquidación excluyendo cuotas con débito automático: muestra filtros, resumen y paginado
    When el usuario ingresa al menu de "Preliquidacion" en "Cobranzas"
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
  Scenario: Cobranzas > Preliquidaciones guardadas y enviadas: muestra encabezado principal
    When el usuario ingresa al menu de "Preliquidaciones guardadas y enviadas" en "Cobranzas"
    Then el usuario verifica que el subtitulo "Preliquidaciones guardadas y enviadas" es correcto

  @branding
  Scenario: Cobranzas > Preliquidaciones Guardadas: valida estructura de componentes

  @branding
  Scenario: Cobranzas > Preliquidaciones Enviadas: valida estructura de componentes

  @branding
  Scenario: Cobranzas > Pólizas con Deuda Vencida: muestra título y paginado
    When el usuario ingresa al menu de "Polizas con Deuda Vencida" en "Cobranzas"
    Then el usuario verifica que el titulo "Polizas con Deuda Vencida" es correcto
    And el usuario verifica que el paginado de "polizas" es correcto

  @branding
  Scenario: Cobranzas > Rechazo de Débitos Automáticos: muestra título de pantalla
    When el usuario ingresa al menu de "Rechazo de debitos automaticos" en "Cobranzas"
    Then el usuario verifica que el titulo "Rechazo de debitos automaticos" es correcto
