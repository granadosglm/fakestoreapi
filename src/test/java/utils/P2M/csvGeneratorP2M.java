package utils.P2M;

import utils.request;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class csvGeneratorP2M {

    // Encabezados del CSV
    private static String[] encabezados = {"codigoUnico", "canal", "terminalId","idTransaccion","valorCompra","tipoOperacion",
            "condicionIva","iva","baseIva","condicionInc","inc","condicionPropina","propina",
            "tipoQR","llave","tipollave","fechaDeVencimiento","referencia","usos"};

    public static void main(String[] args) {
        String[] tiposQR = {"estatico","dinamico","hibrido"};

        for (String tipoQR: tiposQR){
            datosValidos("src/test/resources/csvrequest/P2M/happyPathQR.csv",tipoQR,3);
            casoVacios("src/test/resources/csvrequest/P2M/vaciosQR.csv",tipoQR);
            casoNulos("src/test/resources/csvrequest/P2M/nulosQR.csv",tipoQR);
            casoTipoDato("src/test/resources/csvrequest/P2M/tipoDatosQR.csv",tipoQR);
            casoCaracteresEspeciales("src/test/resources/csvrequest/P2M/caracterespecialesQR.csv",tipoQR);
        }
    }

    public static void datosValidos(String ruta, String tipoQR, int n){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        request dato;
        for (int i = 0; i < n; i++) {
            switch (tipoQR) {
                case "estatico":
                    dato = requestP2M.generarQREstatico();
                    break;
                case "dinamico":
                    dato = requestP2M.generarQRDinamico();
                    break;
                case "hibrido":
                    dato = requestP2M.generarQRHibrido();
                default:
                    dato = requestP2M.generarQREstatico();
                    break;
            }

            String[] atributos = obtenerAtributos(dato);
            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }
        ruta=ruta.replace(".csv",tipoQR+".csv");
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso Happy Path generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso Happy Path: " + e.getMessage());
        }
    }

    public static void casoVacios(String ruta, String tipoQR){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        request dato;
        for (int i = 0; i < encabezados.length; i++) {
            switch (tipoQR) {
                case "estatico":
                    dato = requestP2M.generarQREstatico();
                    break;
                case "dinamico":
                    dato = requestP2M.generarQRDinamico();
                    break;
                case "hibrido":
                    dato = requestP2M.generarQRHibrido();
                default:
                    dato = requestP2M.generarQREstatico();
                    break;
            }

            String[] atributos = obtenerAtributos(dato);
            atributos[i]="";

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }
        ruta=ruta.replace(".csv",tipoQR+".csv");
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de Vacios generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso Vacios: " + e.getMessage());
        }
    }

    public static void casoNulos(String ruta, String tipoQR){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        request dato;
        for (int i = 0; i < encabezados.length; i++) {
            switch (tipoQR) {
                case "estatico":
                    dato = requestP2M.generarQREstatico();
                    break;
                case "dinamico":
                    dato = requestP2M.generarQRDinamico();
                    break;
                case "hibrido":
                    dato = requestP2M.generarQRHibrido();
                default:
                    dato = requestP2M.generarQREstatico();
                    break;
            }

            String[] atributos = obtenerAtributos(dato);
            atributos[i]="null";

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }

        ruta=ruta.replace(".csv",tipoQR+".csv");
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de nulos generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso nulos: " + e.getMessage());
        }
    }

    public static void casoTipoDato(String ruta, String tipoQR){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        request dato;
        for (int i = 0; i < encabezados.length; i++) {
            switch (tipoQR) {
                case "estatico":
                    dato = requestP2M.generarQREstatico();
                    break;
                case "dinamico":
                    dato = requestP2M.generarQRDinamico();
                    break;
                case "hibrido":
                    dato = requestP2M.generarQRHibrido();
                default:
                    dato = requestP2M.generarQREstatico();
                    break;
            }

            String[] atributos = obtenerAtributos(dato);
            atributos[i]=transformarTipoDato(atributos[i]);

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }

        ruta=ruta.replace(".csv",tipoQR+".csv");
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de tipo de dato generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso tipo de dato: " + e.getMessage());
        }
    }

    public static void casoCaracteresEspeciales(String ruta, String tipoQR){
        List<String> datosCSV = new ArrayList<>();
        datosCSV.add(String.join(",", encabezados));

        request dato;
        for (int i = 0; i < encabezados.length; i++) {
            switch (tipoQR) {
                case "estatico":
                    dato = requestP2M.generarQREstatico();
                    break;
                case "dinamico":
                    dato = requestP2M.generarQRDinamico();
                    break;
                case "hibrido":
                    dato = requestP2M.generarQRHibrido();
                default:
                    dato = requestP2M.generarQREstatico();
                    break;
            }

            String[] atributos = obtenerAtributos(dato);
            atributos[i]=agregarCaracteresEspeciales(atributos[i]);

            datosCSV.add(String.join(",", agregarComillasVacios(atributos)));
        }

        ruta=ruta.replace(".csv",tipoQR+".csv");
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String linea : datosCSV) {
                writer.write(linea + "\n");
            }
            System.out.println("Caso de caracteres especiales generado exitosamente: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV de caso caracteres especiales: " + e.getMessage());
        }
    }

    public static String[] obtenerAtributos(request obj){
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
