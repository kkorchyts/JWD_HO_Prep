package com.kkorchyts.epam.jwd.utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class ScannerUtils {
    public static int genIntValue(String message, Predicate<Integer> predicate) {
        Scanner scanner = new Scanner(System.in);
        int year;

        do {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (predicate == null || predicate.test(year)) {
                    return year;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Please, enter the correct value!");
        } while (true);
    }
}
