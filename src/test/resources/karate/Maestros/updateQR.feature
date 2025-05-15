Feature: Ejecutar Endpoint para actualizar un QR y validar datos de respuesta

  Background:
    * url baseUrl
    * def csvData = karate.read('classpath:csvrequest/Maestros/happyPathQR.csv')
    * def bodyQR = read('classpath:jsonrequest/queryQR.json')

  Scenario Outline: Petición POST genera el codigo QR estatico
    #* def sleep = function(pause){ java.lang.Thread.sleep(pause)}
    #* def authResponse = call read('classpath:auth/generateAccessToken.feature')
    #* def token = authResponse.access_token
    * def row = csvData[<__row>]
    * set bodyQR.codigoUnico = row.codigoUnico
    * set bodyQR.codigoSeguridadQr = row.codigoSeguridadQr
    * set bodyQR.valorCompra = row.valorCompra
    * set bodyQR.idTransaccion = row.idTransaccion
    * set bodyQR.terminalId = row.terminalId
    * set bodyQR.propina = parseInt(row.propina)

    Given path 'actualizar'
    And request bodyQR
    When method get
    Then status 200
    And Match response ==
    #* eval sleep(2000)

    Examples:
      | __row |
      | 0     |
    #  | 1     |
    #  | 2     |

