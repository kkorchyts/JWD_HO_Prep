package com.kkorchyts.epam.jwd.hw1prep;

import java.util.Scanner;
import static com.kkorchyts.epam.jwd.util.ScannerUtil.getInteger;

public class ScannerTests {
    public static void main(String[] args) {
        int menu;
        Scanner scanner = new Scanner(System.in);

        do {
            menu = scanner.nextInt();
        } while (menu <= 0);

        System.out.println("menu = " + menu);
    }

    static class TestLoop {

        public static int getIntFromScanner() {
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Hey guy! Please? enter next number!");
            }
            return scanner.nextInt();
        }

        public static void main(String[] args) {
            int startPoint = getIntFromScanner();
            int endPoint = getIntFromScanner();
            int temp;
            if (startPoint > endPoint) {
                int tmp = startPoint;
                startPoint = endPoint;
                endPoint = tmp;
            }

            for (int i = startPoint; i <= endPoint; i++) {
                System.out.println(i);
            }
        }
    }

    static class TestLoopWhileNotZero {
        public static void main(String[] args) {

            int i;
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.print(" > ");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Hey boy, enter only numbers, please!");
                    continue;
                }

                i = scanner.nextInt();
                if (i == 0) {
                    System.out.println("Bye boy!");
                    break;
                }
                System.out.printf("Hey boy, you've entered %d. If you want to exit enter 0, please!\n", i);
            } while (true);
        }
    }

    static class TestSwitch{
        public static void main(String[] args) {
            int year = getInteger("Enter a year: ", y -> y > 0);
            int month = getInteger("Enter a month: ", m -> m > 0 && m < 13);

            System.out.println(year);
            System.out.println(month);

            int numberOfDays = 0;

            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    numberOfDays = 31;
                    break;
                case 2:
                    numberOfDays = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    numberOfDays = 30;
                    break;
            }

            System.out.printf("Number of day = %d", numberOfDays);

        }
    }
}
