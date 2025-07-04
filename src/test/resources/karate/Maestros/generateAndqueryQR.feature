Feature: Ejecutar Endpoint para generar QR y luego consultar un QR validando datos de respuesta

  Background:
    * def csvDataGenerate = karate.read('classpath:csvrequest/P2M/happyPathQRDinamico.csv')
    * def bodyQRGenerate = read('classpath:jsonrequest/requestQR.json')
    * def bodyQRQuery = read('classpath:jsonrequest/queryQR.json')
    * def responseQRQuery = read('classpath:jsonresponse/queryQRResponse.json')
    * header x-api-key = apiKey
    * header Content-Type = contentType

    * def FileWriter = Java.type('java.io.FileWriter')
    * def BufferedWriter = Java.type('java.io.BufferedWriter')

    * def fileRequest = new FileWriter('QR-requests.txt', true)
    * def bwRequest = new BufferedWriter(fileRequest)

    * def fileResponse = new FileWriter('QR-generados.txt', true)
    * def bwResponse = new BufferedWriter(fileResponse)


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
    * set bodyQRGenerate.tipoLlave = row.tipoLlave
    * set bodyQRGenerate.reference = row.reference
    * set bodyQRGenerate.Usos = row.Usos
    * set bodyQRGenerate.fechaExpiracion = row.fechaExpiracion

    * set bodyQRGenerate.billingNumber = row.billingNumber
    * set bodyQRGenerate.mobileNumber = row.mobileNumber
    * set bodyQRGenerate.storeLabel = row.storeLabel
    * set bodyQRGenerate.loyaltyNumber = row.loyaltyNumber
    * set bodyQRGenerate.referenceLabel = row.referenceLabel
    * set bodyQRGenerate.customerLabel = row.customerLabel
    * set bodyQRGenerate.additionalConsumerDataRequest = row.additionalConsumerDataRequest
    * set bodyQRGenerate.rrn = row.rrn
    * set bodyQRGenerate.numeroAutorizacion = row.numeroAutorizacion

    # Campos para consultar
    * set bodyQRQuery.codigoUnico = row.codigoUnico
    * set bodyQRQuery.valorCompra = row.valorCompra
    * set bodyQRQuery.idTransaccion = row.idTransaccion
    * set bodyQRQuery.terminalId = row.terminalId
    * set bodyQRQuery.propina = parseInt(row.propina)

    # guardado de datos
#    * karate.write(bodyQRGenerate, 'qr-requests.txt')
    * eval bwRequest.write(JSON.stringify(bodyQRGenerate) + '\n')
    * eval bwRequest.flush()

    Given url baseUrl
    And path 'generator-qr'
    And header Content-Type = 'application/json'
    And request bodyQRGenerate
    When method post
    Then status 200
    * set bodyQRQuery.codigoSeguridadQr = response.codigoSeguridadQr
    * set bodyQRQuery.idQr = response.codigoSeguridadQr
#    * karate.write(response.codigoSeguridadQr, 'QR-generados.txt')
    * eval bwResponse.write(response.codigoSeguridadQr + '\n')
    * eval bwResponse.flush()
    Given url baseUrl
    And path 'master-qr/validarQR'
    And header Content-Type = 'application/json'
    And request bodyQRQuery
    When method post
    Then status 200
    And match response == responseQRQuery

    #* eval sleep(2000)

    Examples:
      | __row |
      | 0     |
      | 1     |
      | 2     |
#      | 3     |
#      | 4     |
#      | 5     |
#      | 6     |
#      | 7     |
#      | 8     |
#      | 9     |
#      | 10    |
#      | 11    |
#      | 12    |
#      | 13    |
#      | 14    |
#      | 15    |
#      | 16    |
#      | 17    |
#      | 18    |
#      | 19    |

