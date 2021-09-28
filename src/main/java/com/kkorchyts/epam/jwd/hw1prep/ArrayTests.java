package com.kkorchyts.epam.jwd.hw1prep;

import java.util.Random;

import static com.kkorchyts.epam.jwd.utils.ScannerUtils.getInteger;

public class ArrayTests {

    private static void showArray(int[] array) {
        showArray(array, "There is entered array:");
    }

    private static void showArray(int[] array, String message) {
        showArray(array, message, false, false);
    }

    private static void showArray(int[] array, String message, boolean onlyElements, boolean inOneLine) {
        System.out.print(message);
        String format = onlyElements ? "| %2$3d " : "| array[%3d]=%5d ";
        if (!inOneLine) {
            System.out.println();
            format += "\n";
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf(format, i, array[i]);
        }
        if (inOneLine) {
            System.out.println();
        }
    }

    public static int[] createArray() {
        int arrayVolume = getInteger("Enter array volume, please: ", vol -> vol > 0);
        return new int[arrayVolume];
    }

    static class ArrayCreation {
        public static void main(String[] args) {
            int[] array = createArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = getInteger(String.format("Please, enter a value of element number %d: ", i), null);
            }
            showArray(array);
        }
    }

    private static int[] createRandomlyFilledArray(int bound) {
        int[] array = createArray();
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    static class ArrayRandomInitialization {
        public static void main(String[] args) {
            int[] array = createArray();
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(3);
            }
            showArray(array);
        }
    }

    static class ArrayIndexOfZeroElements {
        public static void main(String[] args) {
            int[] array = createArray();
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(3);
            }

            int countZeroElements = 0;
            for (int j : array) {
                if (j == 0) {
                    countZeroElements++;
                }
            }

            int[] zeroElementsIndexes = new int[countZeroElements];

            int currentZeroIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    zeroElementsIndexes[currentZeroIndex++] = i;
                }
            }

            showArray(array);
            showArray(zeroElementsIndexes, "There is zero elements indexes array: ");
        }
    }

    static class Sorts {
        static int[] selectionSort(int[] array) {
            int[] resultArray = new int[array.length];
            System.arraycopy(array, 0, resultArray, 0, array.length);

            for (int i = 0; i < resultArray.length - 1; i++) {
                int minimalIndex = i;
                for (int j = i + 1; j < resultArray.length; j++) {
                    if (resultArray[minimalIndex] > resultArray[j]) {
                        minimalIndex = j;
                    }
                }
                if (minimalIndex != i) {
                    int tmp = resultArray[minimalIndex];
                    resultArray[minimalIndex] = resultArray[i];
                    resultArray[i] = tmp;
                }
                showArray(resultArray, String.format("Array after iteration %d: \t", i), true, true);
            }
            return resultArray;
        }

        static int[] bubbleSort(int[] array) {
            int[] resultArray = new int[array.length];
            System.arraycopy(array, 0, resultArray, 0, array.length);

            int tmp;
            boolean isRearrangement;
            for (int i = 0; i < resultArray.length - 1; i++) {
                isRearrangement = false;
                for (int j = 0; j < resultArray.length - i - 1; j++) {
                    if (resultArray[j] > resultArray[j + 1]) {
                        tmp = resultArray[j + 1];
                        resultArray[j + 1] = resultArray[j];
                        resultArray[j] = tmp;
                        isRearrangement = true;
                    }
                }
                showArray(resultArray, String.format("Array after iteration %d: \t", i), true, true);
                if (!isRearrangement) {
                    break;
                }
            }
            return resultArray;
        }

        public static void main(String[] args) {
            int[] array = createRandomlyFilledArray(6);
            System.out.println("   ------ Selection sort ------ ");
            showArray(array, "Initial array: \t\t\t\t", true, true);
            showArray(selectionSort(array), "Result array:\t\t\t\t", true, true);

            System.out.println("\n   ------ Bubble sort ------ ");
            showArray(array, "Initial array: \t\t\t\t", true, true);
            showArray(bubbleSort(array), "Result array:\t\t\t\t", true, true);
        }
    }

    static class MultiDimensionalArrays {

        static int[] getSumByColumn(int[][] array) {
            int maxColumn = 0;
            int[] result;
            for (int[] row: array) {
                if (maxColumn < row.length) {
                    maxColumn = row.length;
                }
            }
            result = new int[maxColumn];
            for (int[] row : array) {
                for (int i = 0; i < row.length; i++) {
                    result[i] += row[i];
                }
            }
            return result;
        }

        static int[] getSumByColumnWhereFirsBiggerThanLast(int[][] array) {
            int maxColumn = 0;
            int[][] result;
            for (int[] row: array) {
                if (maxColumn < row.length) {
                    maxColumn = row.length;
                }
            }
            result = new int[maxColumn][array.length + 1];

            for (int[] ints : array) {
                for (int j = 0; j < ints.length; j++) {
                    result[j][++result[j][0]] = ints[j];
                }
            }

            int[] finalResult = new int[result.length];
            for (int i = 0; i < result.length; i++) {
                if (result[i][1] > result[i][result[i][0]]) {
                    for (int j = 1; j < result[i].length ; j++) {
                        finalResult[i] += result[i][j];
                    }
                } else {
                    finalResult[i] = -1;
                }
            }
            return finalResult;
        }





        public static void main(String[] args) {
            int[][] mArray = new int[3][];
            for (int i = 0; i < mArray.length; i++) {
                mArray[i] = createRandomlyFilledArray(10);
            }

            int counter = 0;
            for (int[] array : mArray) {
                showArray(array, String.format("Array %d: ", counter++), true, true) ;
            }

            System.out.println("-------------------------------------------------------------------------------");
            //show sum by column
            showArray(getSumByColumn(mArray), "SumByCol:", true, true);
            // calculate sum by column if first element bigger than last one. If no - sum = -1
            showArray(getSumByColumnWhereFirsBiggerThanLast(mArray), "Sum(f>l):", true, true);
        }

    }
}
