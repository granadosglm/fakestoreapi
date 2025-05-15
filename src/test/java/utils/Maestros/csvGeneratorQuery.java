package utils.Maestros;

import utils.P2P.requestP2P;
import utils.request;
import utils.requestMaestros;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class csvGeneratorQuery {
    // Encabezados del CSV
    private static String[] encabezados = {"codigoUnico", "codigoSeguridadQr", "valorCompra","idTransaccion","terminalId","propina"};

    public static void main(String[] args) {
//        datosValidos("src/test/resources/csvrequest/P2P/happyPathQR.csv",tipoQR,3);
        casoVacios("src/test/resources/csvrequest/Maestros/vaciosConsultaQR.csv");
        casoNulos("src/test/resources/csvrequest/Maestros/nulosConsultaQR.csv");
        casoTipoDato("src/test/resources/csvrequest/Maestros/tipoDatosConsultaQR.csv");
        casoCaracteresEspeciales("src/test/resources/csvrequest/Maestros/caracterespecialesConsultaQR.csv");
    }

    public static void casoCaracteresEspeciales(String ruta){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        requestMaestros dato;
        for (int i = 0; i < encabezados.length; i++) {
            dato = requestQuery.generarRequest();

            String[] atributos = obtenerAtributos(dato);
            atributos[i]=agregarCaracteresEspeciales(atributos[i]);

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }

        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de caracteres especiales generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso caracteres especiales: " + e.getMessage());
        }
    }

    public static void casoTipoDato(String ruta){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        requestMaestros dato;
        for (int i = 0; i < encabezados.length; i++) {
            dato = requestQuery.generarRequest();

            String[] atributos = obtenerAtributos(dato);
            atributos[i]=transformarTipoDato(atributos[i]);

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }

        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de tipo de dato generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso tipo de dato: " + e.getMessage());
        }
    }

    public static void casoVacios(String ruta){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        requestMaestros dato;
        for (int i = 0; i < encabezados.length; i++) {
            dato = requestQuery.generarRequest();

            String[] atributos = obtenerAtributos(dato);
            atributos[i]="";

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de Vacios generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso Vacios: " + e.getMessage());
        }
    }

    public static void casoNulos(String ruta){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        requestMaestros dato;
        for (int i = 0; i < encabezados.length; i++) {
            dato = requestQuery.generarRequest();

            String[] atributos = obtenerAtributos(dato);
            atributos[i]="null";

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso Nulos generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso Nulos: " + e.getMessage());
        }
    }

    public static String[] obtenerAtributos(requestMaestros obj){
        List<String> valores = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // Permite acceso a campos privados
            try {
                Object valor = field.get(obj);

                if (valor == null) {
                    valores.add("null");
                } else if (field.getType().equals(String.class)) {
                    valores.add("\"" + valor.toString() + "\""); // Comillas para Strings
                } else {
                    valores.add(valor.toString());
                }

            } catch (IllegalAccessException e) {
                valores.add("error");
            }
        }

        return valores.toArray(new String[0]);
    }

    public static String[] agregarComillasVacios(String[] datos){
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].isEmpty()) {
                datos[i] = "\"\"";
            }
        }
        return datos;
    }

    private static String transformarTipoDato(String dato) {
        if (dato == null) {
            return null;
        }

        if (dato.contains("\"")) {
            try {
                // Intenta convertir a número
                int numeroEquivalente = Integer.parseInt((String)dato);
                return String.valueOf(numeroEquivalente);
            } catch (NumberFormatException e) {
                // Si no es número, devuelve un número por defecto
                return "1";
            }
        } else {
            // Convierte número a texto
            return( "\"" + dato.toString() + "\"");
        }
    }

    private static String agregarCaracteresEspeciales(String dato) {
        if (dato == null) {
            return null;
        }

        if (!dato.contains("\"")) { // Si es un int, se convierte a String primero
            // Convierte número a texto
            dato = (( "\"" + dato.toString() + "\""));
        }

        if(dato.length()==2){
            return dato;
        } else if (dato.length()==3){
            String resultado = dato.substring(0, 1) + "@" + dato.substring(2);
            return resultado;
        } else {
            String resultado = dato.substring(0, 1) + "@*" + dato.substring(3);
            return resultado;
        }

    }

}
