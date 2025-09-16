@AUTOMATED
Feature: Produccion

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario verifica que se logueo correctamente
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Componentes de Listado de Polizas
    When el usuario ingresa al menu de Listado de polizas en Produccion
    Then el usuario verifica que los input Asegurado son correctos
    And el usuario verifica que los input Ramo son correctos
    And el usuario verifica que los input Numero de poliza son correctos
    And el usuario verifica que los input Productor son correctos
    And el usuario verifica que los input Fecha son correctos
    And el usuario verifica que los input Estado son correctos
    And el usuario verifica que los input Antiguedad son correctos
    And el usuario verifica que el boton filtrar es correcto
    And el usuario verifica que el boton borrar filtros en Listado de polizas es correcto


  @branding
  Scenario: Componentes de Listado de polizas - Accesos directos
    When el usuario ingresa al menu de Listado de polizas en Produccion
    Then el usuario verifica que los iconos de acceso directo son correctos

  @branding
  Scenario: Componentes de Listado de polizas - Listado
    When el usuario ingresa al menu de Listado de polizas en Produccion
    Then el usuario verifica que el boton Acciones es correcto

  @test
  Scenario: Componentes de Polizas - Detalle
    When el usuario ingresa al menu de Listado de polizas en Produccion
    And el usuario selecciona "ACC. PERSONALES COL." en Ramo
    And el usuario selecciona "240431" en Número de póliza
    And el usuario selecciona "16/08/2024" en Fecha
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en el boton "Acciones"
    And el usuario hace clic en el boton "Ver póliza"
    Then el usuario verifica que el boton de Poliza es correcto
    And el usuario verifica que el icono de info es correcto
    And el usuario verifica que el boton "Acciones" es correcto

  @test
  Scenario: Componentes de Polizas - Tab Principal
    When el usuario ingresa al menu de Listado de polizas en Produccion
    And el usuario selecciona "ACC. PERSONALES COL." en Ramo
    And el usuario selecciona "240431" en Número de póliza
    And el usuario selecciona "16/08/2024" en Fecha
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en el boton "Acciones"
    And el usuario hace clic en el boton "Ver póliza"
    And el usuario verifica que el tab "Principal" es correcto
    And el usuario verifica que el tab "Asegurado" es correcto
    And el usuario verifica que el tab "Bienas" es correcto
    And el usuario verifica que el tab "Cuotas" es correcto
    And el usuario verifica que el tab "Sinistros" es correcto
    And el usuario verifica que el tab "Documentos" es correcto
    And el usuario verifica que el tab "A y B Nómina" es correcto
    And el usuario verifica que el tab "PDF Anteriores" es correcto
    And el usuario verifica que el tab "Datos generales" del panel de contenido es correcto
    And el usuario verifica que el tab "Comisiones" del panel de contenido es correcto
    And el usuario verifica que el tab "Premio" del panel de contenido es correcto
    And el usuario verifica que el titulo "Datos Generales" es correcto
    And el usuario verifica que el titulo "Comisiones" es correcto
    And el usuario verifica que el titulo "Premio" es correcto

  @test
  Scenario: Componentes de Polizas - Tab Principal
    When el usuario ingresa al menu de Listado de polizas en Produccion
    And el usuario selecciona "ACC. PERSONALES COL." en Ramo
    And el usuario selecciona "240431" en Número de póliza
    And el usuario selecciona "16/08/2024" en Fecha
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en el boton "Acciones"
    And el usuario hace clic en el boton "Ver póliza"
    And el usuario verifica que el tab "Asegurado" es correcto
    And el usuario verifica que el tab "Bienas" es correcto
    And el usuario verifica que el tab "Cuotas" es correcto
    And el usuario verifica que el tab "Sinistros" es correcto
    And el usuario verifica que el tab "Documentos" es correcto
    And el usuario verifica que el tab "A y B Nómina" es correcto
    And el usuario verifica que el tab "PDF Anteriores" es correcto
