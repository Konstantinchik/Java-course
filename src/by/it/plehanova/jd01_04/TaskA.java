package by.it.plehanova.jd01_04;

/*A1. Создайте в пакете by.it.familiya.jd01_04 класс TaskA и напишите в нем метод
static void printMulTable() для вывода на консоль таблицы умножения в следующем виде (с
учетом пробелов):

A2. Напишите также метод static void buildOneDimArray(String line), который:
     формирует из строки line массив вещественных чисел,
(можно скопировать для этого класс InOut, написанный в jd01_03 Задание A)
     выводит в 5 колонок этот массив с названием V и индексами (тоже InOut),
например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
     сортирует этот массив по возрастанию (см. Helper.sort в jd01_03 Задание B)
     еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
     выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
исходного массива и печатает их в виде:
        Index of first element=2
        Index of last element=7

A3. В основном методе public static void main(String[ ] args) класса TaskA
        вызовите printMulTable
        прочитайте с консоли строку из чисел, введенных через пробел (nextLine() в scanner-е)
        вызовите buildOneDimArray с этой строкой в качестве аргумента
 */

import java.util.Arrays;
import java.util.Scanner;


public class TaskA {
    public static void main(String[] args) {

        printMulTable();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        buildOneDimArray(line);
    }

    static void printMulTable() {

        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];

        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        int indexOfFirst = Arrays.binarySearch(array, first);
        int indexOfLast = Arrays.binarySearch(array, last);

        System.out.printf("Index of first element=%d\n", indexOfFirst);
        System.out.printf("Index of last element=%d\n", indexOfLast);

    }


}
