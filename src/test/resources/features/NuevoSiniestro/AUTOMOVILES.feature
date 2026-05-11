@NUEVOSINIESTRO
@AUTOMATED @Siniestros
Feature: Nuevo Siniestro Automoviles

  Background:
    Given el usuario ingresa a la web
    When el usuario ingresa usuario
    And el usuario ingresa contraseña
    And el usuario hace click en el boton de login
    And el usuario ingresa a la home
    And el usuario selecciona un intermediario
    Then el usuario verifica que el sistema muestra el panel de inicio


  Scenario: Nuevo Siniestro Automoviles - flujo completo
    And el usuario obtiene una póliza vigente del ramo "AUTOMOVILES"
    When el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    And el usuario selecciona "Póliza"
    And el usuario completa la busqueda de póliza vigente del ramo "AUTOMOVILES"



