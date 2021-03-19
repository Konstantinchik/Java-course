package by.it.kglushchenko.jd01_08;

import org.hamcrest.SelfDescribing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
    // J01-03

    /**
     * Процедура чтения одной строки с консоли
     *
     * @return Возвращает строку с консоли
     * @throws java.io.IOException;
     */
    public static String consoleReadLine() throws IOException {
        InputStreamReader iStreamReader = new InputStreamReader(System.in);
        BufferedReader line = new BufferedReader(iStreamReader);
        String out = line.readLine();
        return out;
    } // consoleReadLine()

    /**
     * @return на выходе массив таких чисел
     * @Param line - строка разделенная пробелами
     */
    public static int[] stringLineToArray(String line) {
        line = line.trim();                                 // Удаляем пробелы и в начале и в конце
        String[] elemString = line.split(" ");        // Преобразование строки в массив
        int count = elemString.length;                      // Найдем длину массива
        int[] arr = new int[count];                         // Создали массив для чисел
        for (int i = 0; i < count; i++) {                      // Заполнили массив
            arr[i] = Integer.parseInt(elemString[i]);       //
        }
        return arr;
    } // stringLineToArray()

    /**
     * @param arr  входной массив
     * @param cols число столбцов для вывода
     * @name имя на экране
     */
    public static void arrayPrint(int[] arr, String name, int cols) {
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);                         // Печатаем имя массива
            System.out.printf("[% -3d]=%-4d ", i, arr[i]);   // Печатаем значения
            col++;
            if ((0 == col % cols) || (arr.length - 1 == i)) {           // Если конец колонки или конец массива
                System.out.println();                       // Тогда напечатаем перевод строки
            }
        }
    }

    public static void arrayPrint(double[] arr, String name, int cols) {
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);                         // Печатаем имя массива
            System.out.printf("[% -3d]=%-9.4f ", i, arr[i]);   // Печатаем значения
            col++;
            if ((0 == col % cols) || (arr.length - 1 == i)) {           // Если конец колонки или конец массива
                System.out.println();                       // Тогда напечатаем перевод строки
            }
        }
    }

    //  final String bin = String.format("%4s",Integer.toBinaryString()).replace(' ','0');

    /**
     * Поиск максимума для массива INT
     *
     * @param arr - одномерный массив
     * @return максимум или Integer.MAX_VALUE если массив пустой
     */
    public static int maxIntArray(int[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            int max = arr[0];
            for (int m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    /**
     * Поиск минимума для массива INT
     *
     * @param arr - одномерный массив
     * @return минимум или Integer.MIN_VALUE если массив пустой
     */
    public static int minIntArray(int[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            int min = arr[0];
            for (int m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    /**
     * @param array       - исходный массив
     * @param upDirection - напрвление сортировки
     */
    public static void sortInArray(int[] array, boolean upDirection) {
        for (int start = 0; start < array.length - 1; start++) {
            int least = start;
            for (int j = start + 1; j < array.length; j++) {
                if ((upDirection && array[j] < array[least]) || (!upDirection && array[j] > array[least])){
                    least = j;
                }
            }
            int tmp = array[start];
            array[start]=array[least];
            array[least]=tmp;
        }
    }

    // Умножение матрицы на вектор
    /**
     *  Умножение матрицы на вектор
     */
    public static double[] arrayMulVector(double[][] x, double[] y){
        double[] z = new double[x.length];
        for(int i=0; i < x.length; i++){
            for(int j=0; j < y.length; j++){
                z[i]=z[i]+x[i][j]*y[j];
            }
        }
        return z;
    }// arrayMulVector()



}
