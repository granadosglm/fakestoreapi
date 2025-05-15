Feature: Ejecutar Endpoint para consultar un QR y validar datos de respuesta

  Background:
    * url baseUrl
    * def csvData = karate.read('classpath:csvrequest/Maestros/happyPathQR.csv')
    * def bodyQR = read('classpath:jsonrequest/queryQR.json')
    * def responseQR = read('classpath:jsonresponse/queryQRResponse.json')

  @queryQR_happy_path
  Scenario Outline: Petición POST genera el codigo QR estatico
    * def row = csvData[<__row>]
    * set bodyQR.codigoUnico = row.codigoUnico
    * set bodyQR.codigoSeguridadQr = row.codigoSeguridadQr
    * set bodyQR.valorCompra = row.valorCompra
    * set bodyQR.idTransaccion = row.idTransaccion
    * set bodyQR.terminalId = row.terminalId
    * set bodyQR.propina = parseInt(row.propina)

    Given path 'consultar'
    And request bodyQR
    When method get
    Then status 200
    And match response == responseQR
    #* eval sleep(2000)

    Examples:
      | __row |
      | 0     |



