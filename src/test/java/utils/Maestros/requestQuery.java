package utils.Maestros;

import utils.request;
import utils.requestMaestros;

import static utils.randomClass.*;

public class requestQuery {
    public static requestMaestros generarRequest(){
        requestMaestros datos = new requestMaestros(
                String.valueOf(generarNumeroAleatorio(10)), // codigoUnico
                generateCode(23, "string"),            // codigoSeguridadQr
                String.valueOf(generarNumeroAleatorio(6)),  // valorCompra
                String.valueOf(generarNumeroAleatorio(10)), // idTransaccion
                String.valueOf(generarNumeroAleatorio(10)), // terminalId
                generarNumeroAleatorio(10),                 // propina
                ""                                                 // idQr
        );
//        datos.setIdQr(datos.getCodigoSeguridadQr());
        datos.setCodigoSeguridadQr("T92Yhm0sUyo8Ge5SJp1TeqsB");
        datos.setIdQr(datos.getCodigoSeguridadQr());
        return datos;
    }
}
