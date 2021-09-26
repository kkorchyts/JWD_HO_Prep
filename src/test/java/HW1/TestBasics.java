package HW1;

import org.junit.jupiter.api.Test;

public class TestBasics {

    @Test
    void TypeLimitsTest() {
        byte byteValue = Byte.MAX_VALUE;
        System.out.println(byteValue);  // 127
        System.out.println(++byteValue); // 128

        short shortValue = Short.MAX_VALUE;
        System.out.println(shortValue);
        System.out.println(++shortValue);

        int intValue = Integer.MAX_VALUE;
        System.out.println(intValue);
        System.out.println(++intValue);

        long longValue = Long.MAX_VALUE;
        System.out.println(longValue);
        System.out.println(++longValue);
    }

    @Test
    void testOperationsWitIntegerVariables() {
        int x;
        int y;

        int comp;
        int quot;

        x = 14;
        y = 3;
        comp = x * y;
        quot = x / y;
        System.out.println("comp = " + comp);
        System.out.println("quot = " + quot);
    }

    @Test
    void testOperationsWitRealVariables() {
        double x;
        double y;

        double comp;
        double quot;

        x = 14;
        y = 3;
        comp = x * y;
        quot = x / y;
        System.out.println("comp = " + comp);
        System.out.println("quot = " + quot);

        x = 2.0;
        y = 1.1;

        System.out.println("2.0 - 1.1 = " + (x - y));

    }

    @Test
    void testCalculateHrsMin() {
        int sec = 9102;

        if ((sec > 86400) || (sec < 0)) {
            System.out.println("Wrong number of seconds!");
            return;
        }

        int currentHour = sec / 3600;
        int currentMin = (sec - currentHour * 3600) / 60;
        int currentSec = (sec - currentHour * 3600 - currentMin * 60);

        System.out.println("H:m:S = " + currentHour + ":" + currentMin + ":" + currentSec);
    }

    @Test
    void testLiterals() {
        int a = 07;
        long aLong = 07L;
        int b = 0b10;
        int c = a + b;
        int d = 0xff;
        double dbl = 0.2;
        float f = 0.2F;

        System.out.println(a + " + " + b + " = " + c);
        System.out.println("это \127 \t \uFFFF \r \123 \f \156 \b \155");
    }

    @Test
    void testMath() {
        int a = 145;
        System.out.println("Math.sqrt(145) = " + Math.sqrt(145));
        System.out.println("Math.cos(3.1415) = " + Math.cos(3.1415));
        System.out.println("Math.sin(3.1415) = " + Math.sin(3.1415));
        System.out.println("Math.cos(Math.PI) = " + Math.cos(Math.PI));
        System.out.println("Math.sin(Math.PI) = " + Math.sin(Math.PI));
        System.out.println("Math.log(Math.E) = " + Math.log(Math.E));
        System.out.println("Math.log1p(Math.E - 1) = " + Math.log1p(Math.E - 1));
    }

    @Test
    void testDivOnZero() {
        int aI = 4, bI = 0;
        try {
            System.out.println("aI/bI=" + (aI / bI));
        } catch (ArithmeticException e) {
            System.out.println("Probably there is a division by zero! Be careful!");
        }
        double aD = 4;
        double bD = 0;
        System.out.println("aD/bD=" + (aD / bD));

        System.out.println(6 / 2 * (2 + 1));
    }

    @Test
    void testCasting() {
        double aD = 96968678655748879789678685969696858585879766.575886583424546462345463758796773;
        float aF = (float) aD;
        System.out.println(aF);

        int aI = (int) aD;
        System.out.println(aI);

        aD = -96968678655748879789678685969696858585879766.575886583424546462345463758796773;
        aF = (float) aD;
        System.out.println(aF);

        aD = 9.6968678655748879789678685969696858585879766e-20;
        aI = (int) aD;
        System.out.println(aI);

        aF = (float) aD;
        System.out.println(aI);
    }

    @Test
    void testIf() {
        int a = 14, b = 12, c = -1, d = 9;
        int count = 0;

        if (a % 2 == 0) {
            count++;
        }
        if (b % 2 == 0) {
            count++;
        }
        if (c % 2 == 0) {
            count++;
        }
        if (d % 2 == 0) {
            count++;
        }

        if (count > 2) {
            System.out.println("There are more than 2 even numbers in the list!");
        } else {
            System.out.println("There are less than 2 even numbers in the list!");
        }

        int flag = 1;

        if ((count > 2) && (flag++ > 0)) {
            System.out.println("ok!");
        }

        System.out.println("flag (after ((count > 2) && (flag++ > 0))) = " + flag);

        if ((count > 2) & (flag++ > 0)) {
            System.out.println("ok!");
        }

        System.out.println("flag (after ((count > 2) & (flag++ > 0))) = " + flag);
    }

    @Test
    void testSumBetweenTwoNumbers() {
        int from = 15;
        int to = 13;

        if (from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }
        int sum = from;
        for (int i = from + 1; i <= to; ) {
            sum += i++;
        }
        System.out.printf("Sum between %d and %d = %d", from, to, sum);
    }

    private static double f(double x) {
        return Math.sin(x);
    }

    @Test
    void testShowTableOfFunctionResults() {
        double from = 0;
        double to = Math.PI;
        double step = 0.1;
        for (double i = from; i <= to; i += step) {
            System.out.printf("|\tsin(%,5.3f)\t|\t%5.3f\t|\n", i, f(i));
        }
    }
}
