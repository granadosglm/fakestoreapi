package utils.P2M;

import utils.request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utils.randomClass.*;


public class requestP2M {
    public static request generarQRDinamico(){
        String[] comercio = elegirComercio();
        String fechaHoy = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        request datos = new request(
                "10000016",//comercio[1],     // codigoUnico
                "POS",//elegirCanal(),      // canal
                comercio[0],     // terminalId
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
                fechaHoy,              // fechaExpiracion
                "FACT-"+generateCode(6, "numeric"),     // billingNumber
                "31"+generateCode(9, "numeric"),     // mobileNumber
                "STORE-"+generateCode(6, "string"),     // storeLabel
                "LOY-"+generateCode(6, "numeric"),     // loyaltyNumber
                "REF-POS"+generateCode(3, "string"),     // referenceLabel
                "CLIENTE-PREF-"+generateCode(4, "string"),     // customerLabel
                elegiradditionalConsumerDataRequest(),     // additionalConsumerDataRequest
                generateCode(12, "numeric"),     // rrn
                generateCode(32, "numeric")     // numeroAutorizacion
        );
        return datos;
    }

    public static request generarQREstatico(){
        String[] comercio = elegirComercio();
        request datos = new request(
                comercio[1],     // codigoUnico
                elegirCanal(),      // canal
                comercio[0],     // terminalId
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
                elegiradditionalConsumerDataRequest(),     // additionalConsumerDataRequest
                generateCode(12, "numeric"),     // rrn
                generateCode(32, "numeric")     // numeroAutorizacion
        );
        return datos;
    }

    public static request generarQRHibrido(){
        String[] comercio = elegirComercio();
        request datos = new request(
                comercio[1],     // codigoUnico
                elegirCanal(),      // canal
                comercio[0],     // terminalId
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
                elegiradditionalConsumerDataRequest(),     // additionalConsumerDataRequest
                generateCode(12, "numeric"),     // rrn
                generateCode(32, "numeric")     // numeroAutorizacion
        );
        return datos;
    }
}
