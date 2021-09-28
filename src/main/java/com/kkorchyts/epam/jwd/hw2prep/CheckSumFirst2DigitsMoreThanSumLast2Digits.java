package com.kkorchyts.epam.jwd.hw2prep;

import com.kkorchyts.epam.jwd.utils.ScannerUtils;

public class CheckSumFirst2DigitsMoreThanSumLast2Digits {
    protected static int[] getOnlyDigitsFromNumber(int number) {
        int[] result = new int[String.valueOf(Math.abs(number)).length()];
        int counter = result.length - 1;
        do {
            result[counter--] = number % 10;
            number /= 10;
        } while (number > 0);
        return result;
    }

    protected static int getElementSum(int[] array, int start, int count) {
        int result = 0;
        for (int i = start; i < start + count; i++) {
            result += array[i];
        }
        return result;
    }

    protected static boolean CheckIfSumFirst2DigitsMoreThanSumLast2Digits(int number) {
        int[] digits = getOnlyDigitsFromNumber(number);
        int sumOfFirst2Elements = getElementSum(digits, 0, 2);
        int sumOfLast2Elements = getElementSum(digits, digits.length - 2, 2);
        return sumOfFirst2Elements > sumOfLast2Elements;
    }


    public static void main(String[] args) {
        int number;
        boolean checkIfSumFirst2DigitsMoreThanSumLast2Digits;
        do {
            number = ScannerUtils.getInteger("Enter four digits positive number", val -> val > 1000 && val < 9999);
            checkIfSumFirst2DigitsMoreThanSumLast2Digits = CheckIfSumFirst2DigitsMoreThanSumLast2Digits(number);
            System.out.println(checkIfSumFirst2DigitsMoreThanSumLast2Digits);
        } while (number != 9999);
    }
}
