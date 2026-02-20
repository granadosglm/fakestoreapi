Feature: Products management

  Background:
    * url baseUrl

  Scenario: Get all products
    Given path 'products'
    When method get
    Then status 200
    And print 'Products', response
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'

  Scenario: Add a new product succesfully
    * def JsonFileGenerator = Java.type('utils.JsonFileGenerator')
    * def body = JsonFileGenerator.createProduct()

    Given path 'products'
    And request body
    When method post
    Then status 201
    And print 'Product created', response
    And match response.title == body.title
    And match response.price == body.price
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'

  Scenario: Fail to Add a new product with invalid data

    Given path 'products'
    When method post
    Then status 400
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'

  Scenario: Get a single product
    Given path 'products/1'
    When method get
    Then status 200
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'
    And print 'Single product', response

  Scenario: Update a product succesfully
    * def bodyUpdateProduct = read('classpath:jsonrequest/updateProduct.json')

    Given path 'products/1'
    And request bodyUpdateProduct
    When method put
    Then status 200
    And match response.title == '#string'
    And match response.price == '#number'
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'

  Scenario: Fail to update a product with invalid data

    Given path 'products/1'
    When method put
    Then status 400
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'

  Scenario: Delete a product successfully
    Given path 'products/1'
    When method delete
    Then status 200
    And assert responseTime < 1000
    And match header Content-Type contains 'application/json'


