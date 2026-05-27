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

  @SINIESTRO
  Scenario: Siniestros > Nuevo Siniestro > AUTOMOVILES: completa denuncia de siniestro
    When el usuario ingresa al menu de "Listado de Polizas" en "Produccion"
    And el usuario espera que aparezca el listado de polizas
    And el usuario selecciona el radio Ramo y Numero de Poliza
    And el usuario selecciona "AUTOMOVILES" en Ramo
    And el usuario hace clic en el boton "Filtrar"
    And el usuario busca una poliza vigente
    And el usuario ingresa al menu de "Nueva denuncia" en "Siniestros"
    And el usuario selecciona "Póliza"
    And el usuario completa la busqueda de póliza vigente del ramo "AUTOMOVILES"
    And el usuario genera un siniestro de AUTOMOVILES
    Then el usuario verifica que la denuncia fue registrada correctamente
