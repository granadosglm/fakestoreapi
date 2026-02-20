package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public final class RandomClass {

    private static final Random RANDOM = new Random();

    private static final String NUMERIC = "0123456789";
    private static final String ALPHABETIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHANUMERIC = ALPHABETIC + NUMERIC;

    public static String generateCode(int length, String type) {

        String characters = switch (type.toLowerCase()) {
            case "numeric" -> NUMERIC;
            case "string" -> ALPHABETIC;
            default -> ALPHANUMERIC;
        };

        StringBuilder code = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            code.append(characters.charAt(RANDOM.nextInt(characters.length())));
        }

        return code.toString();
    }

    public static long generateRandomNumber(int digits) {
        if (digits <= 0) throw new IllegalArgumentException("Digits must be greater than 0");

        StringBuilder number = new StringBuilder(digits);
        number.append(RANDOM.nextInt(9) + 1); // First digit (1-9)

        for (int i = 1; i < digits; i++) {
            number.append(RANDOM.nextInt(10));
        }

        return Long.parseLong(number.toString());
    }

    public static String generateEightDigitNumberWithDecimals() {
        int wholeNumber = 10_000_000 + RANDOM.nextInt(90_000_000);
        double value = wholeNumber / 100.0;
        return String.format("%.2f", value);
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String getRandomFutureDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate oneYearLater = today.plusYears(1);

        long minDay = tomorrow.toEpochDay();
        long maxDay = oneYearLater.toEpochDay();

        long randomDay = minDay + RANDOM.nextInt((int) (maxDay - minDay + 1));

        return LocalDate.ofEpochDay(randomDay)
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}