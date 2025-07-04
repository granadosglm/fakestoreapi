package utils.P2P;

import utils.request;

import static utils.randomClass.*;


public class requestP2P {
    public static request generarQRDinamico(){
        request datos = new request(
                "0",     // codigoUnico
                elegirCanal(),      // canal
                "0",     // terminalId
                generateCode(10, "string"),     // idTransaccion
                String.valueOf(generarNumeroAleatorio(4)),                // Valor compra
                elegirTipoOperacion(),         // tipoOperacion
                elegirCondicionIva(),          // condicionIva
                generarNumeroAleatorio(3),          // iva
                generarNumeroAleatorio(2),          // baseIva
                elegirCondicionInc(),           // condicionInc
                generarNumeroAleatorio(3),          // inc
                elegirCondicionPropina(),    // condicionPropina
                generarNumeroAleatorio(3),          // propina
                "DYN",              // tipoQR
                "31123456789",     // llave
                "MSISDN",     // tipollave
                "COMPRA-ELEMENTO-"+generateCode(3, "numeric"),     // reference
                "1",            // Usos
                obtenerFechaAleatoriaFutura(),              // fechaExpiracion
                "FACT-"+generateCode(6, "numeric"),     // billingNumber
                "31"+generateCode(9, "numeric"),     // mobileNumber
                "STORE-"+generateCode(6, "string"),     // storeLabel
                "LOY-"+generateCode(6, "numeric"),     // loyaltyNumber
                "REF-POS"+generateCode(3, "string"),     // referenceLabel
                "CLIENTE-PREF-"+generateCode(4, "string"),     // customerLabel
                generateCode(1, "string"),     // additionalConsumerDataRequest
                generateCode(12, "numeric"),     // rrn
                generateCode(32, "numeric")     // autorizationNumber
        );
        return datos;
    }

    public static request generarQREstatico(){
        request datos = new request(
                "0",     // codigoUnico
                elegirCanal(),      // canal
                "0",     // terminalId
                generateCode(10, "string"),     // idTransaccion
                "0",                // Valor compra
                elegirTipoOperacion(),         // tipoOperacion
                elegirCondicionIva(),          // condicionIva
                generarNumeroAleatorio(3),          // iva
                generarNumeroAleatorio(2),          // baseIva
                elegirCondicionInc(),           // condicionInc
                generarNumeroAleatorio(3),          // inc
                elegirCondicionPropina(),    // condicionPropina
                generarNumeroAleatorio(3),          // propina
                "STA",              // tipoQR
                "31123456789",     // llave
                "MSISDN",     // tipollave
                "COMPRA-ELEMENTO-"+generateCode(3, "numeric"),     // reference
                String.valueOf(generarNumeroAleatorio(4)),            // Usos
                obtenerFechaAleatoriaFutura(),              // fechaExpiracion
                "FACT-"+generateCode(6, "numeric"),     // billingNumber
                "31"+generateCode(9, "numeric"),     // mobileNumber
                "STORE-"+generateCode(6, "string"),     // storeLabel
                "LOY-"+generateCode(6, "numeric"),     // loyaltyNumber
                "REF-POS"+generateCode(3, "string"),     // referenceLabel
                "CLIENTE-PREF-"+generateCode(4, "string"),     // customerLabel
                generateCode(1, "string"),     // additionalConsumerDataRequest
                generateCode(12, "numeric"),     // rrn
                generateCode(32, "numeric")     // autorizationNumber
        );
        return datos;
    }

    public static request generarQRHibrido(){
        request datos = new request(
                "0",     // codigoUnico
                elegirCanal(),      // canal
                "0",     // terminalId
                generateCode(10, "string"),     // idTransaccion
                String.valueOf(generarNumeroAleatorio(4)),                // Valor compra
                elegirTipoOperacion(),         // tipoOperacion
                elegirCondicionIva(),          // condicionIva
                generarNumeroAleatorio(3),          // iva
                generarNumeroAleatorio(2),          // baseIva
                elegirCondicionInc(),           // condicionInc
                generarNumeroAleatorio(3),          // inc
                elegirCondicionPropina(),    // condicionPropina
                generarNumeroAleatorio(3),          // propina
                "STA",              // tipoQR
                "31123456789",     // llave
                "MSISDN",     // tipollave
                "COMPRA-ELEMENTO-"+generateCode(3, "numeric"),     // reference
                String.valueOf(generarNumeroAleatorio(4)),            // Usos
                obtenerFechaAleatoriaFutura(),              // fechaExpiracion
                "FACT-"+generateCode(6, "numeric"),     // billingNumber
                "31"+generateCode(9, "numeric"),     // mobileNumber
                "STORE-"+generateCode(6, "string"),     // storeLabel
                "LOY-"+generateCode(6, "numeric"),     // loyaltyNumber
                "REF-POS"+generateCode(3, "string"),     // referenceLabel
                "CLIENTE-PREF-"+generateCode(4, "string"),     // customerLabel
                generateCode(1, "string"),     // additionalConsumerDataRequest
                generateCode(12, "numeric"),     // rrn
                generateCode(32, "numeric")     // autorizationNumber
        );
        return datos;
    }
}
