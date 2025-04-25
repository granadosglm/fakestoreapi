package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class randomClass {

    private static final Random random = new Random();

    // Generar un string de números, letras o alfanumérico
    public static String generateCode(int length, String type) {
        String characters;

        switch (type) {
            case "numeric":
                characters = "0123456789";
                break;
            case "string":
                characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                break;
            default:
                characters = "ABCDEFGHIJKLMNO-PQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-0123456789";
                break;
        }

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }

        return code.toString();
    }


    // Generar un número aleatorio de n digitos
    public static long generarNumeroAleatorio(int digitos) {
        if (digitos <= 0) return 0;

        StringBuilder numero = new StringBuilder();
        numero.append(random.nextInt(9) + 1); // Primer dígito (1-9)

        for (int i = 1; i < digitos; i++) {
            numero.append(random.nextInt(10)); // Dígitos restantes (0-9)
        }

        return Long.parseLong(numero.toString());
    }


    // Generar un número aleatorio de 8 digitos con dos decimales
    public static String generarNumeroAleatorio8DigitosConDecimales() {
        int numeroEntero = 10000000 + random.nextInt(90000000);
        double numeroConDecimales = numeroEntero / 100.0;
        return String.format("%.2f", numeroConDecimales);
    }

    // Fecha actual en formato AAAA-MM-DD
    public static String obtenerFechaActual() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    // Fecha aleatoria futura en formato AAAA-MM-DD
    public static String obtenerFechaAleatoriaFutura() {
        LocalDate hoy = LocalDate.now();
        LocalDate manana = hoy.plusDays(1);
        LocalDate unAnioDespues = hoy.plusYears(1);

        long minDay = manana.toEpochDay();
        long maxDay = unAnioDespues.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay + 1));

        return LocalDate.ofEpochDay(randomDay).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String elegirCanal(){
        String[] canales = {"POS","MPOS","APP","IM","ECOMM"};
        Random random = new Random();

        return canales[random.nextInt(canales.length)];
    }

    public static String elegirTipoOperacion(){
        String[] operaciones = {"ANULACION","COMPRA"};
        Random random = new Random();

        return operaciones[random.nextInt(operaciones.length)];
    }

    public static String elegirCondicionIva(){
        String[] condicionesIva = {"01","02","03"};
        Random random = new Random();

        return condicionesIva[random.nextInt(condicionesIva.length)];
    }

    public static String elegirCondicionInc(){
        String[] condicionesInc = {"01","02","03"};
        Random random = new Random();

        return condicionesInc[random.nextInt(condicionesInc.length)];
    }

    public static String elegirCondicionPropina(){
        String[] condicionesPropina = {"01","02","03"};
        Random random = new Random();

        return condicionesPropina[random.nextInt(condicionesPropina.length)];
    }
}

