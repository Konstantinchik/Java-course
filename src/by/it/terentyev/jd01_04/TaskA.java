package by.it.terentyev.jd01_04;

import java.util.Arrays;
import java.util.Scanner;


public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значения для массива: ");
        String lineArray = sc.nextLine();
        buildOneDimArray(lineArray);
            }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == stop) {
                System.out.println("Index of last element=" + i);
                break;
            }

        }

//            1 формирует из строки line массив вещественных чисел,
//            (можно скопировать для этого класс InOut, написанный в jd01_03 Задание A)
//            2 выводит в 5 колонок этот массив с названием V и индексами (тоже InOut),
//    например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
//            3 сортирует этот массив по возрастанию (см. Helper.sort в jd01_03 Задание B)
//            4 еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
//            5 выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
//              исходного массива и печатает их в виде:
//    Index of first element=2
//    Index of last element=7
    }
}


