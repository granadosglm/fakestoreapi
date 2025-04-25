package utils.P2M;

import utils.request;

import static utils.randomClass.*;


public class requestP2M {
    public static request generarQRDinamico(){
        request datos = new request(
                generateCode(15, "string"),     // codigoUnico
                elegirCanal(),      // canal
                generateCode(25, "string"),     // terminalId
                generateCode(25, "string"),     // idTransaccion
                "0",                // Valor compra
                elegirTipoOperacion(),         // tipoOperacion
                elegirCondicionIva(),          // condicionIva
                generarNumeroAleatorio(10),          // iva
                generarNumeroAleatorio(10),          // baseIva
                elegirCondicionInc(),           // condicionInc
                generarNumeroAleatorio(10),          // inc
                elegirCondicionPropina(),    // condicionPropina
                generarNumeroAleatorio(10),          // propina
                "DIN",              // tipoQR
                generateCode(25, "string"),     // llave
                generateCode(10, "string"),     // tipollave
                obtenerFechaAleatoriaFutura(),              // fechaDeVencimiento
                generateCode(25, "string"),     // referencia
                generarNumeroAleatorio(4)            // usos
        );
        return datos;
    }

    public static request generarQREstatico(){
        request datos = new request(
                generateCode(15, "string"),     // codigoUnico
                elegirCanal(),      // canal
                generateCode(25, "string"),     // terminalId
                generateCode(25, "string"),     // idTransaccion
                "0",                // Valor compra
                elegirTipoOperacion(),         // tipoOperacion
                elegirCondicionIva(),          // condicionIva
                generarNumeroAleatorio(10),          // iva
                generarNumeroAleatorio(10),          // baseIva
                elegirCondicionInc(),           // condicionInc
                generarNumeroAleatorio(10),          // inc
                elegirCondicionPropina(),    // condicionPropina
                generarNumeroAleatorio(10),          // propina
                "STA",              // tipoQR
                generateCode(25, "string"),     // llave
                generateCode(10, "string"),     // tipollave
                obtenerFechaAleatoriaFutura(),              // fechaDeVencimiento
                generateCode(25, "string"),     // referencia
                generarNumeroAleatorio(4)            // usos
        );
        return datos;
    }

    public static request generarQRHibrido(){
        request datos = new request(
                generateCode(15, "string"),     // codigoUnico
                elegirCanal(),      // canal
                generateCode(25, "string"),     // terminalId
                generateCode(25, "string"),     // idTransaccion
                String.valueOf(generarNumeroAleatorio(13)),          // Valor compra
                elegirTipoOperacion(),         // tipoOperacion
                elegirCondicionIva(),          // condicionIva
                generarNumeroAleatorio(10),          // iva
                generarNumeroAleatorio(10),          // baseIva
                elegirCondicionInc(),           // condicionInc
                generarNumeroAleatorio(10),          // inc
                elegirCondicionPropina(),    // condicionPropina
                generarNumeroAleatorio(10),          // propina
                "DIN",              // tipoQR
                generateCode(25, "string"),     // llave
                generateCode(10, "string"),     // tipollave
                obtenerFechaAleatoriaFutura(),              // fechaDeVencimiento
                generateCode(25, "string"),     // referencia
                generarNumeroAleatorio(4)            // usos
        );
        return datos;
    }
}
