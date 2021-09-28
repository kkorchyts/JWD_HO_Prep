package com.kkorchyts.epam.jwd.hw1prep;

public class StringTests {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "JAVA";
        System.out.println("Длина строки: " + str1.length());
        System.out.println("Возвращение символа по индексу: " + str1.charAt(0));

        System.out.println("Сравнение строк не лексикографическое равенство: " + str1.equals(str2));

        System.out.println("Сравнение строк <> 1: " + str1.compareTo(str2));
        System.out.println("Сравнение строк <> 2: " + str2.compareTo(str1));
        System.out.println("Сравнение строк <> 3: " + "Java".compareTo(str1));
        System.out.println("Сравнение без учета регистра символов: " + str1.compareToIgnoreCase(str2));

        System.out.println("Проверка строки на \"пустоту\": " + str1.isEmpty());

        System.out.println("Приведение символов строки к верхнему регистру: " + str1.toUpperCase());

        System.out.println("Приведение символов строки к нижнему регистру: " + str1.toLowerCase());

        System.out.println("=====================================");
        str1 = new String("Java");
        str2 = "Java";
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));

        System.out.println("=====================================");
        str1 = "Java";
        str2 = "Java";

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));

        System.out.println("=====================================");
        str1 = "Java16";
        final String temp = "16";
        str2 = "Java" + temp;
        str2 = str2.intern();
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));


        System.out.println("=====================================");
        str1 = "Java16";
        String temp1 = "16";
        str2 = "Java" + temp1;
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));
    }
}
