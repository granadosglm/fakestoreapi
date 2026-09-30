Feature: User test methods

  Background:
    * url baseUrl
    * def dataReq = karate.read('../jsonrequest/userInfo.json')

  Scenario: Create new user
    Given path '/users'
    And request dataReq
    When method POST
    Then status 201

  Scenario: delete user
    Given path '/users', dataReq.id
    When method DELETE
    Then status 200

  Scenario: Create new user without id
    * remove dataReq.id
    Given path '/users'
    And request dataReq
    When method POST
    Then status 201

  Scenario: Create new user with wrong request
    Given path '/users'
    * remove dataReq.username
    * remove dataReq.password
    And request dataReq
    When method POST
    Then status 400

  Scenario: get user
    Given path '/users', dataReq.id
    When method GET
    Then status 200
    * match response.username == dataReq.username
    * match response.password == dataReq.password
    * match response.email == dataReq.email
    * match response.id == dataReq.id

  Scenario: update user
    Given path '/users', dataReq.id
    * set dataReq.username = "PruebaUpdate"
    And request dataReq
    When method PUT
    Then status 200
    * match response.username == "PruebaUpdate"


  Scenario: delete user with wrong id
    Given path '/users', "x"
    When method DELETE
    Then status 400

  Scenario: E2E usuario
    Given path '/users'
    And request dataReq
    When method POST
    Then status 201
    * def userId = response.id

  # Obtener usuario   ->   Aca falla por el servicio ya que no trae la informacion devuelve null
    Given path '/users/' + userId
    When method GET
    Then status 200
    * match response.username == dataReq.username
    * match response.password == dataReq.password
    * match response.id == userId

  # Actualizar usuario
    * set dataReq.password = "passE2E"
    Given path '/users/' + userId
    And request dataReq
    When method PUT
    Then status 200
    * match response.password == 'passE2E2'
    * match response.id == userId

  # Eliminar usuario
    Given path '/users/' + userId
    When method DELETE
    Then status 200