package com.kkorchyts.epam.jwd.utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class ScannerUtils {
    static final String WRONG_VALUE_ENTERED_MESSAGE = "Please, enter the correct value!";

    public static int getInteger(String message, Predicate<Integer> predicate) {
        Scanner scanner = new Scanner(System.in);
        int result;

        do {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (predicate == null || predicate.test(result)) {
                    return result;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println(WRONG_VALUE_ENTERED_MESSAGE);
        } while (true);
    }

    public static double getDouble(String message, Predicate<Double> predicate) {
        Scanner scanner = new Scanner(System.in);
        double result;

        do {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                result = scanner.nextInt();
                if (predicate == null || predicate.test(result)) {
                    return result;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println(WRONG_VALUE_ENTERED_MESSAGE);
        } while (true);
    }

}
