package com.kkorchyts.epam.jwd.hw2prep;

import com.kkorchyts.epam.jwd.util.ScannerUtil;

import java.util.function.Predicate;

public class Calculator {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void runTask2EvaluateExpression() {
        System.out.println(" --- Task 2: evaluate expression --- ");
        Predicate<Double> predicate = i -> i >= 0;
        double a = ScannerUtil.getDouble("Please, enter a (positive number): ", predicate);
        double b = ScannerUtil.getDouble("Please, enter b (positive number): ", predicate);
        double c = ScannerUtil.getDouble("Please, enter c (positive number): ", predicate);

        double exp = (b + Math.sqrt(b*b + 4 * a * c)) /  (2 * a) - a * a * a * c + 1 / (b * b);

        System.out.printf("Expression (b + sqrt(b^2+4ac))/2a - a^3 + b^-2 = %f\n", exp);
        System.out.println(" ------ ");
    }

    public static void runTask3CalculateHypotenuse() {
        System.out.println(" --- Task 3: evaluate calculate hypotenuse --- ");
        Predicate<Double> predicate = i -> i >= 0;
        double cathetusA = ScannerUtil.getDouble("Please, enter leg a: " , null);
        double cathetusB = ScannerUtil.getDouble("Please, enter leg b: ", null);
        double hypotenuse = Math.sqrt(cathetusA * cathetusA + cathetusB * cathetusB);

        System.out.printf("Hypotenuse of triangle (cathetuses a = %f and b = %f hypotenuse) - %f\n", cathetusA, cathetusB, hypotenuse);
        System.out.println(" ------ ");
    }



    ///////////////////////////////////////////////////////////////////////////
    public static boolean validPointInRegion(Point p) {
        boolean result = false;
        if (p.getX() >= -2 && p.getX() <= 2 && p.getY() >= 0 && p.getY() <= 4) {
            if (p.getX() >= -4 && p.getX() <= 4 && p.getY() <= 0 && p.getY() >= -3) {
                result = true;
            }
        }
        return result;
    }

    public static Point readPoint() {

        Point p = new Point(ScannerUtil.getInteger("Please, enter x: " , null),
                ScannerUtil.getInteger("Please, enter y: " , null));


        int x = ScannerUtil.getInteger("Please, enter x: " , null);
        int y = ScannerUtil.getInteger("Please, enter y: " , null);

        Point point = new Point(x, y);

        return point;

    }

    public static void runTask4CheckIfPointInRegion() {
        System.out.println(" --- Task 4: Check if point is in a region --- ");

        Point p = readPoint();

        if (validPointInRegion(p)) {
            System.out.println("Point is in the region");
        } else {
            System.out.println("Point isn't in the region");
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void runTask5Exponentiation() {
        System.out.println(" --- Task 5: exponentiation --- ");

        double[] array =  new double[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = ScannerUtil.getDouble(String.format("Please, enter element №%d: ", i), null);
        }

        int pow;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                System.out.println(String.format("Number %f is positive, is' ^2 = %f\n", array[i], Math.pow(array[i], 2)));
            } else{
                System.out.println(String.format("Number %f is negative, is' ^4 = %f\n", array[i], Math.pow(array[i], 4)));
            }
        }

        System.out.println(" ------ ");
    }

    public static void runTask6findMinAndMaxAmong3Numbers() {
        System.out.println(" --- Task 6: find min and max among 3 numbers  --- ");

        double[] array =  new double[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = ScannerUtil.getDouble(String.format("Please, enter element №%d: ", i), null);
        }

        double min = array[0];
        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println(String.format("Min = %f; max = %f", min, max));

        System.out.println(" ------ ");
    }

    private static double f7(double arg) {
        return Math.sin(arg) * Math.sin(arg) - Math.cos(arg) * Math.cos(arg);
    }

    public static void runTask7EvaluateFunctionFromAToB() {
        System.out.println(" --- Task 7: Evaluate function from a to b with step  --- ");

        double from = ScannerUtil.getDouble("Please, enter a: ", null);
        double to = ScannerUtil.getDouble("Please, enter b: ", b -> b > from );
        double step = ScannerUtil.getDouble("Please, enter h: ", h -> h < to - from );
        int countOfIterations = (to - from) % step == 0 ? (int)((to - from) / step) - 1: (int)((to - from) / step) ;
        double[][] result = new double[countOfIterations + 2][2];
        result[0][0] = from;
        result[0][1] = f7(from);
        for (int i = 0; i < countOfIterations ; i++) {
            result[i + 1][0] = (i + 1) * step;
            result[i + 1][1] = f7((i + 1)  * step);
        }
        result[countOfIterations + 1][0] = to;
        result[countOfIterations + 1][1] = f7(to);

        for (int i = 0; i < result.length; i++) {
            System.out.printf("f(%f) = %f\n", result[i][0], result[i][1]);
        }
        System.out.println(" ------ ");
    }

    public static void runTask8EvaluateSumIfMultiple() {
        System.out.println(" --- Task 8: Evaluate sum of elements which multiple by K  --- ");
        int arraySize = ScannerUtil.getInteger("Please, enter array size: ", size -> size > 0);
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = ScannerUtil.getInteger(String.format("Please, enter element №%d: ", i), size -> size > 0);
        }

        int divider = ScannerUtil.getInteger("Please, enter divider k: ", k -> k > 0);
        int sum = 0;

        for (int i: array) {
            if (i % divider == 0 ) {
                sum += i;
            }
        }

        System.out.printf(" Sum of elements = %d \n%n", sum);
        System.out.println(" ------ ");
    }

    public static void runTask9UniteArrays() {
        System.out.println(" --- Task 9: Unite 2 arrays  --- ");
        int firstArraySize = ScannerUtil.getInteger("Please, enter first array size: ", size -> size > 0);
        int[] firstArray = new int[firstArraySize];

        for (int i = 0; i < firstArraySize; i++) {
            firstArray[i] = ScannerUtil.getInteger(String.format("Please, enter element №%d: ", i), size -> size > 0);
        }

        int secondArraySize = ScannerUtil.getInteger("Please, enter second array size: ", size -> size > 0);
        int[] secondArray = new int[secondArraySize];

        for (int i = 0; i < secondArraySize; i++) {
            secondArray[i] = ScannerUtil.getInteger(String.format("Please, enter element №%d: ", i), size -> size > 0);
        }


        int divider = ScannerUtil.getInteger("Please, enter divider k: ", k -> k >= 0 && k < firstArraySize);

        int[] result = new int[firstArraySize + secondArraySize];

        for (int i = 0; i <= divider; i++) {
            result[i] = firstArray[i];
        }

        for (int i = 0; i < secondArraySize; i++) {
            result[divider + i + 1] = secondArray[i];
        }

        for (int i = divider + 1; i < firstArraySize; i++) {
            result[secondArraySize + i] = firstArray[i];
        }

        for (int i: result) {
            System.out.println(i);
        }

        System.out.println(" ------ ");
    }

    public static void runTask10FormArray() {
        System.out.println(" --- Task 10: Form array by pattern  --- ");
        int n = ScannerUtil.getInteger("Please, enter array size: ", size -> size > 0);
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    array[i][j] = n - j;
                }
            }
        }

        for (int[] i: array) {
            for (int j: i ) {
                System.out.printf("| %d |", j);
            }
            System.out.println();
        }

        System.out.println(" ------ ");
    }


    public static void main(String[] args) {
        //runTask2EvaluateExpression();
        //runTask3CalculateHypotenuse();
        //runTask4CheckIfPointInRegion();
        // runTask5Exponentiation();
        // runTask6findMinAndMaxAmong3Numbers();
        // runTask7EvaluateFunctionFromAToB();
        // runTask9UniteArrays();
        //

        do {
            runTask10FormArray();


        } while (true);
    }
}
