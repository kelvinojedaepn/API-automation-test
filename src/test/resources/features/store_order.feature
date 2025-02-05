Feature: Gestión de pedidos en PetStore

  # Escenario 1: Creación de Order
  @crearPedido
  Scenario: Creación de Order
    Given la URL base es "https://petstore.swagger.io/v2"
    And los datos del pedido son:
      | petId | quantity | shipDate                | status   | complete |
      | 1234  | 2        | 2025-02-05T02:25:08.822Z | placed   | true     |
    When hago una solicitud POST a "/store/order" con los datos del pedido
    Then el código de respuesta es 200
    And el body del response contiene el petId 1234
    And el body del response contiene la cantidad 2

  # Escenario 2: Consulta de Order
  @consultarPedido
  Scenario Outline: Consulta de Order
    Given la URL base es "https://petstore.swagger.io/v2"
    When hago una solicitud GET a "/store/order/<orderId>"
    Then el código de respuesta es 200
    And el body del response contiene el petId <petId>
    And el body del response contiene la cantidad <quantity>

    Examples:
      | orderId | petId | quantity |
      | 101     | 10    | 8        |
      | 102     | 11    | 5        |