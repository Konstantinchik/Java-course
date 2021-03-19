package by.it.plehanova.jd01_04;

/*С1. Повторите полностью в этом классе задание A2 (скопируйте в TaskC готовый
    метод static void buildOneDimArray(String line) и вызовите его из main, но
    сортировку переделайте (т.е. замените) из пузырьковой в более быструю
    сортировку слиянием с O-сложностью не выше, чем O(n log n).

      Метод для сортировки должен находиться в классе TaskC и иметь сигнатуру:
    static void mergeSort(double[ ] array)

     Подсказки: удобно предусмотреть также наличие второй копии этого метода для
    возможности рекурсивного вызова, например, с такой сигнатурой
    private static void mergeSort(double[ ] array, int left, int right)
    метод для слияния двух массивов разработайте самостоятельно, его сигнатура
    может быть, например, вот такой
    private static double[ ] merge(double[ ] part1, double[ ] part2)

    С2. Также при повторе задания A2 выполните вычисление новых (после
    сортировки) индексов первого и последнего элемента исходного массива с
    помощью собственного алгоритма двоичного (бинарного) поиска, который
    должен находиться в классе TaskC и иметь сигнатуру:
    static int binarySearch(double[ ] array, double value)
 */

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        buildOneDimArray(line);

    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];

        mergeSort(array);

        InOut.printArray(array, "V", 4);

        int indexOfFirst = binarySearch(array, first);
        int indexOfLast = binarySearch(array, last);

        System.out.printf("Index of first element=%d\n", indexOfFirst);
        System.out.printf("Index of last element=%d\n", indexOfLast);
    }
    static void mergeSort(double[] array) {

        double[] buffer = new double[array.length];
        buffer = mergeSort(array, 0, buffer.length);

        System.arraycopy(buffer, 0, array,0, array.length);
    }

    private static double[] mergeSort(double[] array, int left, int right) {

        if (array.length < 2) {
            return array;
        }
        int average = array.length / 2;

        double[] arr1 = new double[average];
        double[] arr2 = new double[array.length - arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = array[i + average];
        }
        arr1 = mergeSort(arr1, 0, average);
        arr2 = mergeSort(arr2, average + 1, array.length - 1);
        array = merge(arr1, arr2);

        return array;
    }


    private static double[] merge(double[] part1, double[] part2) {
        int indexPart1 = 0;
        int indexPart2 = 0;

        double[] array = new double[part1.length + part2.length];

        for (int i = 0; i < array.length; i++) {
            System.out.println();
            if (indexPart1 == part1.length) {
                array[i] = part2[indexPart2];
                indexPart2++;

            } else if (indexPart2 == part2.length) {
                array[i] = part1[indexPart1];
                indexPart1++;

            } else if (part1[indexPart1] < part2[indexPart2]) {
                array[i] = part1[indexPart1];
                indexPart1++;


            } else {
                array[i] = part2[indexPart2];
                indexPart2++;
            }
        }
        return array;
    }

    static int binarySearch(double[] array, double value) {

        int left = 0;
        int right = array.length - 1;
        int index = -1;
        int average;

        while (left <= right) {
            average = (left + right) / 2;
            if (value == array[average]) {
                index = average;
                break;
            } else if (value > array[average]) {
                left = average + 1;
            } else {
                right = average - 1;
            }
        }
        if (index == -1) {
            System.out.println("Элемент в массиве не найден");
        }
        return index;
    }


}
