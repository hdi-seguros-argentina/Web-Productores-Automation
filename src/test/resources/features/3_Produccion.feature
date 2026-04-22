@AUTOMATED @Produccion
Feature: Produccion

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Producción > Listado de Pólizas: muestra filtros y acciones principales
    When el usuario ingresa al menu de Listado de polizas en Produccion
    Then el usuario verifica que el titulo "Listado de Pólizas" es correcto
    And el usuario verifica que el input "Productor" es correcto
    And el usuario verifica que el input "Fecha inicial" es correcto
    And el usuario verifica que el input "Estado" es correcto
    And el usuario verifica que el input "Más reciente primero" es correcto
    Then el usuario verifica que el boton "Filtrar" es correcto
    Then el usuario verifica que el boton "Borrar Filtros" es correcto

  @branding
  Scenario: Producción > Listado de Pólizas: muestra íconos de acceso directo
    When el usuario ingresa al menu de Listado de polizas en Produccion
    Then el usuario verifica que los iconos de acceso directo son correctos

  @branding
  Scenario: Producción > Listado de Pólizas: muestra botón Acciones y paginado operativo
    When el usuario ingresa al menu de Listado de polizas en Produccion
    Then el usuario verifica que el boton "Acciones" es correcto
    And el usuario verifica que el paginado de "pólizas" es correcto

  @branding
  Scenario: Producción > Listado de Pólizas: permite abrir el detalle de una póliza
    When el usuario ingresa al menu de Listado de polizas en Produccion
    And el usuario selecciona el radio Ramo y Numero de Poliza
    And el usuario selecciona "ACC. PERSONALES COL." en Ramo
    And el usuario selecciona "240431" en Número de póliza
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en el boton "Acciones"
    And el usuario hace clic en el boton "Ver póliza"
    Then el usuario verifica que el boton de Poliza es correcto
    And el usuario verifica que el icono de info es correcto

  @branding
  Scenario: Producción > Detalle de Póliza: muestra tabs y títulos de secciones
    When el usuario ingresa al menu de Listado de polizas en Produccion
    And el usuario selecciona el radio Ramo y Numero de Poliza
    And el usuario selecciona "ACC. PERSONALES COL." en Ramo
    And el usuario selecciona "240431" en Número de póliza
    And el usuario hace clic en el boton "Filtrar"
    And el usuario hace clic en el boton "Acciones"
    And el usuario hace clic en el boton "Ver póliza"
    Then el usuario verifica que la tab "Principal" es correcta
    And el usuario verifica que la tab "Datos generales" es correcta
    And el usuario verifica que la tab "Comisiones" es correcta
    And el usuario verifica que la tab "Premio" es correcta
    And el usuario verifica que el titulo "Datos generales" es correcto
    And el usuario verifica que el titulo "Comisiones" es correcto
    And el usuario verifica que el titulo "Premio" es correcto


  @branding
  Scenario: Producción > Total de Producción: muestra acciones y paginado
    When el usuario ingresa al menu de "Total de Produccion" en "Produccion"
    Then el usuario verifica que el titulo "Total de Producción" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el paginado de "Registros" es correcto

  @branding
  Scenario: Producción > Libros Rubricados: muestra filtros y paginado
    When el usuario ingresa al menu de "Libros Rubricados" en "Produccion"
    Then el usuario verifica que el titulo "Libros Rubricados" es correcto
    Then el usuario verifica que el input "Año" es correcto
    And el usuario verifica que el input "Mes" es correcto
    And el usuario verifica que el input "Quincena" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el paginado de "quincenas" es correcto
