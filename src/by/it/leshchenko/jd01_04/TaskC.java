package by.it.leshchenko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        TaskA.printMulTable();
        Scanner scanner = new Scanner(System.in);
        buildOneDimArray(scanner.nextLine());
//        double[] testArray = new double[]{5.0, 4.0, 6.0, 3.0, 7.0, 2.0, 8.0, 1.0, 9.0};
//        mergeSort(testArray);
//        System.out.println(Arrays.toString(testArray));
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));
    }

    private static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            double value = array[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (array[i] <= value) {
                    j++;
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            double temp = array[left];
            array[left] = array[j];
            array[j] = temp;

            mergeSort(array, left, j - 1);
            mergeSort(array, j + 1, right);
        }
    }

//    private static void mergeSort(double[] array) {
//        merge(mergeSort(array), mergeSort(array))
//    }
//
//    private static void mergeSort(double[] array, int left, int right) {
//        if (left < right) {
//            int mid = (left + right) >> 1;
//        }
//    }
//
//    private static double[] merge(double[] part1, double[] part2) {
//        int length = part1.length + part2.length;
//        double[] result = new double[length];
//        int i = 0;
//        int j = 0;
//        for (int k = 0; k < length; k++) {
//            if (j == part2.length) {
//                result[k] = part1[i];
//            } else if (i == part1.length) {
//                result[k] = part2[j];
//            } else if (part1[i] < part2[j]) {
//                result[k] = part1[i];
//                i++;
//            } else {
//                result[k] = part2[j];
//                j++;
//            }
//        }
//        return result;
//    }

    static int binarySearch(double[] array, double value) {
        int index = -1; // Объявляем индекс, который будет возвращаться в return
        int first = 0;
        int last = array.length - 1;

        while (first <= last) {
            index = (first + last) >> 1; // Находим средний индекс между имеющимися first и last
            double indexValue = array[index]; // Получаем значение элемента со средним индексом

            if (indexValue < value) { // Если значение элемента меньше, чем искомое
                first = index + 1;
            } else if (indexValue > value) {  // Если значение элемента больше, чем искомое
                last = index - 1;
            } else if (indexValue == value) { // Если значение элемента равно искомому
                break;
            }
        }
        return index;
    }
}










