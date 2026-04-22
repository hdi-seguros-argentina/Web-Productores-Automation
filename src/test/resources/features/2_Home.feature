@AUTOMATED @Home
Feature: Home

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login

  @Regression
  Scenario: Home: permite seleccionar intermediario y acceder al panel de inicio
    Given el usuario ingresa a la home
    When el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio

  @branding
  Scenario: Home: muestra header, filtros y acciones con estilos esperados
    Given el usuario ingresa a la home
    When el usuario se posiciona en la pantalla de home
    Then el usuario verifica que el header el correcto
    And el usuario verifica que el input "Nombre" es correcto
    And el usuario verifica que el input "CUIT" es correcto
    And el usuario verifica que el input "Código Interno" es correcto
    And el usuario verifica que el input "Nível" es correcto
    And el usuario verifica que el boton "Filtrar" es correcto
    And el usuario verifica que el boton "Borrar Filtros" es correcto

  @branding
  Scenario: Home: lista intermediarios y muestra acciones de búsqueda y paginado
    Given el usuario ingresa a la home
    When el usuario ingresa "Ortuondo" en el input
    Then el usuario verifica que el boton "Borrar Filtros" es correcto
    And el usuario verifica que el boton "Seleccionar" es correcto
    And el usuario verifica que el paginado de "intermediarios" es correcto

  @branding
  Scenario: Home: muestra título e íconos correctos del panel de inicio
    Given el usuario ingresa a la home
    When el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio
    And el usuario verifica que el titulo "Panel de Inicio" es correcto
    And el usuario verifica que los iconos de "Polizas Vigentes" son correcto
    And el usuario verifica que los iconos de "Siniestros Denunciados" son correcto
    And el usuario verifica que los iconos de "Cotizaciones" son correcto
    And el usuario verifica que los iconos de "Siniestros Cartera" son correcto
