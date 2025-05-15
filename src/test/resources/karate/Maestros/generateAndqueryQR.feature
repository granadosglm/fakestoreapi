Feature: Ejecutar Endpoint para generar QR y luego consultar un QR validando datos de respuesta

  Background:
    * url baseUrl
    * def csvDataGenerate = karate.read('classpath:csvrequest/P2P/happyPathQRestatico.csv')
    * def bodyQRGenerate = read('classpath:jsonrequest/requestQR.json')
    * def bodyQRQuery = read('classpath:jsonrequest/queryQR.json')
    * def responseQRQuery = read('classpath:jsonresponse/queryQRResponse.json')

  @generate_and_queryQR_happy_path
  Scenario Outline: Petición POST genera el codigo QR estatico y lo consulta
    # Campos para generar
    * def row = csvDataGenerate[<__row>]
    * set bodyQRGenerate.codigoUnico = row.codigoUnico
    * set bodyQRGenerate.canal = row.canal
    * set bodyQRGenerate.terminalId = row.terminalId
    * set bodyQRGenerate.idTransaccion = row.idTransaccion
    * set bodyQRGenerate.valorCompra = row.valorCompra
    * set bodyQRGenerate.tipoOperacion = row.tipoOperacion

    * set bodyQRGenerate.condicionIva = row.condicionIva
    * set bodyQRGenerate.iva = parseInt(row.iva)
    * set bodyQRGenerate.baseIva = parseInt(row.baseIva)
    * set bodyQRGenerate.condicionInc = row.condicionInc
    * set bodyQRGenerate.inc = parseInt(row.inc)
    * set bodyQRGenerate.condicionPropina = row.condicionPropina
    * set bodyQRGenerate.propina = parseInt(row.propina)

    * set bodyQRGenerate.tipoQR = row.tipoQR
    * set bodyQRGenerate.llave = row.llave
    * set bodyQRGenerate.tipollave = row.tipollave
    * set bodyQRGenerate.fechaDeVencimiento = row.fechaDeVencimiento
    * set bodyQRGenerate.referencia = row.referencia
    * set bodyQRGenerate.usos = parseInt(row.usos)

    # Campos para consultar
    * set bodyQRQuery.codigoUnico = row.codigoUnico
    * set bodyQRQuery.valorCompra = row.valorCompra
    * set bodyQRQuery.idTransaccion = row.idTransaccion
    * set bodyQRQuery.terminalId = row.terminalId
    * set bodyQRQuery.propina = parseInt(row.propina)

    Given path 'generar'
    And request bodyQRGenerate
    When method post
    Then status 200
    * set bodyQRQuery.codigoSeguridadQr = response.codigoSeguridadQr
    Given path 'consultar'
    And request bodyQRQuery
    When method get
    Then status 200
    And match response == responseQRQuery
    #* eval sleep(2000)

    Examples:
      | __row |
      | 0     |
    #  | 1     |
    #  | 2     |

