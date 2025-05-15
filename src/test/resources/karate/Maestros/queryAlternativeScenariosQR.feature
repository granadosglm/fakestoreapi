Feature: Ejecutar Endpoint para consultar un QR y validar datos de respuesta

  Background:
    * url baseUrl
    * def csvDataNull = karate.read('classpath:csvrequest/Maestros/nulosConsultaQR.csv')
    * def csvDataEmpty = karate.read('classpath:csvrequest/Maestros/vaciosConsultaQR.csv')
    * def csvDataSpecialCharacter = karate.read('classpath:csvrequest/Maestros/caracterespecialesConsultaQR.csv')
    * def csvDataDataType = karate.read('classpath:csvrequest/Maestros/tipoDatosConsultaQR.csv')
    * def bodyQR = read('classpath:jsonrequest/queryQR.json')
    * def responseQR = read('classpath:jsonresponse/queryQRErrorResponse.json')

  @query_fields_data_type
  Scenario Outline: Petición GET con campos vacios para consultar QR
    * def row = csvDataDataType[<__row>]
    * set bodyQR.codigoUnico = row.codigoUnico
    * set bodyQR.codigoSeguridadQr = row.codigoSeguridadQr
    * set bodyQR.valorCompra = row.valorCompra
    * set bodyQR.idTransaccion = row.idTransaccion
    * set bodyQR.terminalId = row.terminalId
    * set bodyQR.propina = row.propina === '' ? '' : parseInt(row.propina)

    Given path 'consultar'
    And request bodyQR
    When method get
    Then status <status>
    And match response == responseQR
  #* eval sleep(2000)

    Examples:
      | __row | status|
      | 0     |400    |
      | 1     |400    |
      | 2     |  400     |
      | 3     |  400     |
      | 4     |  400     |
      | 5     |  400     |

  @query_fields_with_special_character
  Scenario Outline: Petición GET con campos vacios para consultar QR
    * def row = csvDataSpecialCharacter[<__row>]
    * set bodyQR.codigoUnico = row.codigoUnico
    * set bodyQR.codigoSeguridadQr = row.codigoSeguridadQr
    * set bodyQR.valorCompra = row.valorCompra
    * set bodyQR.idTransaccion = row.idTransaccion
    * set bodyQR.terminalId = row.terminalId
    * set bodyQR.propina = row.propina === '' ? '' : parseInt(row.propina)

    Given path 'consultar'
    And request bodyQR
    When method get
    Then status <status>
    And match response == responseQR
  #* eval sleep(2000)

    Examples:
      | __row | status|
      | 0     |400    |
      | 1     |400    |
      | 2     |  400     |
      | 3     |  400     |
      | 4     |  400     |
      | 5     |  400     |

  @query_empty_fields
  Scenario Outline: Petición GET con campos vacios para consultar QR
    * def row = csvDataEmpty[<__row>]
    * set bodyQR.codigoUnico = row.codigoUnico
    * set bodyQR.codigoSeguridadQr = row.codigoSeguridadQr
    * set bodyQR.valorCompra = row.valorCompra
    * set bodyQR.idTransaccion = row.idTransaccion
    * set bodyQR.terminalId = row.terminalId
    * set bodyQR.propina = row.propina === '' ? '' : parseInt(row.propina)

    Given path 'consultar'
    And request bodyQR
    When method get
    Then status <status>
    And match response == responseQR
  #* eval sleep(2000)

    Examples:
      | __row | status|
      | 0     |400    |
      | 1     |400    |
      | 2     |  400     |
      | 3     |  400     |
      | 4     |  400     |
      | 5     |  400     |

  @query_null_fields
  Scenario Outline: Petición POST genera el codigo QR estatico
    * def row = csvDataNull[<__row>]
    * set bodyQR.codigoUnico = 'null' ? null : row.codigoUnico
    * set bodyQR.codigoSeguridadQr = 'null' ? null : row.codigoSeguridadQr
    * set bodyQR.valorCompra = 'null' ? null : row.valorCompra
    * set bodyQR.idTransaccion = 'null' ? null : row.idTransaccion
    * set bodyQR.terminalId = 'null' ? null : row.terminalId
    * set bodyQR.propina = 'null' ? null : parseInt(row.propina)

    Given path 'consultar'
    And request bodyQR
    When method get
    Then status <status>
    And match response == responseQR
    #* eval sleep(2000)

    Examples:
      | __row | status|
      | 0     |400    |
      | 1     |400    |
      | 2     |  400     |
      | 3     |  400     |
      | 4     |  400     |
      | 5     |  400     |