Feature: Ejecutar Endpoint para crear una transacción aprobada con firma y validando distintos datos de respuesta

  Background:
    * url baseUrl
    * def csvData = karate.read('classpath:csvrequest/P2P/happyPathQRestatico.csv')
    * def bodyQR = read('classpath:jsonrequest/requestQR.json')

  Scenario Outline: Petición POST genera el codigo QR estatico
    #* def sleep = function(pause){ java.lang.Thread.sleep(pause)}
    #* def authResponse = call read('classpath:auth/generateAccessToken.feature')
    #* def token = authResponse.access_token
    * def row = csvData[<__row>]
    * set bodyQR.codigoUnico = row.codigoUnico
    * set bodyQR.canal = row.canal
    * set bodyQR.terminalId = row.terminalId
    * set bodyQR.idTransaccion = row.idTransaccion
    * set bodyQR.valorCompra = row.valorCompra
    * set bodyQR.tipoOperacion = row.tipoOperacion

    * set bodyQR.condicionIva = row.condicionIva
    * set bodyQR.iva = parseInt(row.iva)
    * set bodyQR.baseIva = parseInt(row.baseIva)
    * set bodyQR.condicionInc = row.condicionInc
    * set bodyQR.inc = parseInt(row.inc)
    * set bodyQR.condicionPropina = row.condicionPropina
    * set bodyQR.propina = parseInt(row.propina)

    * set bodyQR.tipoQR = row.tipoQR
    * set bodyQR.llave = row.llave
    * set bodyQR.tipollave = row.tipollave
    * set bodyQR.fechaDeVencimiento = row.fechaDeVencimiento
    * set bodyQR.referencia = row.referencia
    * set bodyQR.usos = parseInt(row.usos)

    Given path 'generar'
    And request bodyQR
    When method post
    Then status 200
    #* eval sleep(2000)

    Examples:
      | __row |
      | 0     |
      | 1     |
      | 2     |

