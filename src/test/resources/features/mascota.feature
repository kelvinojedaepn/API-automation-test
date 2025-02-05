@ProbarFeatureMascota
Feature: Mascota

  @testmascota01crear
  Scenario: Crear Mascota

  @consultarMascota
  Scenario: Consultar Mascota
    When consulto la tienda de mascota con  IDMASCOTA 566
    Then valido el codigo de respuesta sea 404
    And valido mensaje sea "Pet not found"
