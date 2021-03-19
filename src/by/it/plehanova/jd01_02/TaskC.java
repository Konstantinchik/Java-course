package by.it.plehanova.jd01_02;

/*В классе TaskC (пакет by.it.familiya.jd01_02) один раз введите с консоли n
через объект типа Scanner - размерность матрицы arr [n] [n] и вызовите из
метода main статические методы step1 step2 step3 с указанной сигнатурой:

1. Задать значения элементов матрицы в интервале значений от -n до n с
помощью генератора случайных чисел. Числа целые. Тип int.
Пока в матрице нет чисел n и -n генерацию следует повторять, иначе
вывести матрицу в консоль, а затем, вернуть полученную матрицу.
Сигнатура int[ ][ ] step1(int n).

2. Найти, вывести и вернуть сумму элементов исходной матрицы arr,
расположенных между первым и вторым положительными элементами
каждой строки. Сигнатура int step2(int[ ][ ] arr).

3. Найти максимальный элемент(ы) в матрице и удалить из исходной
матрицы все строки и столбцы, его содержащие. Вывести в консоль и
вернуть полученную матрицу. Сигнатура int[ ][ ] step3(int[ ][ ] arr).*/

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        step1(n);

        int[][] arr = step1(n);
        step2(arr);
        System.out.println();

        int[][] mas = step1(n);
        step3(mas);

    }

    private static int[][] step1(int n) {

        int[][] mas = new int[n][n];
        Random rand = new Random();

        while (true) {
            //заполняем массив рандомно числами от -n до n
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    mas[i][j] = rand.nextInt(n + n + 1) - n;
                }
            }
            int min = mas[0][0];
            int max = mas[0][0];

            //находим max и min числа в массиве
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    min = Math.min(mas[i][j], min);
                    max = Math.max(mas[i][j], max);
                }
            }
            //сравниваем min с -n и max с n, если равны - выходим из бесконечного цикла, выводим массив
            if (min == -n && max == n) {
                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas.length; j++) {
                        System.out.printf("%3d", mas[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
                return mas;
            }
        }
    }

    private static int step2(int[][] arr) {
        int sum;
        int totalSum = 0;
        int count;
        int index;

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr.length; j++) {   //перебираем строку массива
                if (arr[i][j] >= 0) {                     //и находим первое положительное число
                    count = 0;
                    index = ++j;
                    //проверяем есть ли второе положительное число
                    while (index < arr.length) {
                        if (arr[i][index] >= 0) {
                            count++;
                        }
                        index++;
                    }
                /* если второе положительное число есть - запускаем цикл для счёта суммы до тех пор
                  пока следующее число не будет положительным */
                    if (count > 0) {
                        while (j < arr.length) {
                            if (arr[i][j] < 0) {
                                sum += arr[i][j];
                            } else {
                                break;
                            }
                            j++;
                        }
                    }
                    break;
                }
            }
            System.out.println(sum);
            totalSum += sum;
        }
        return totalSum;
    }

    private static int[][] step3(int arr[][]) {

        int max = arr[0][0];

        //находим max число в массиве
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        //находим ячейки со значением max
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    arr[i][j] = max + 1;
                    //заменяем колонки и строки со значением max на значение max+1
                    for (int k = 0; k < arr[i].length; k++) {
                        if (arr[i][k] == max) {
                            continue;
                        }
                        arr[i][k] = max + 1;
                    }
                    for (int l = 0; l < arr.length; l++) {
                        if (arr[l][j] == max) {
                            continue;
                        }
                        arr[l][j] = max + 1;
                    }
                }
            }
        }
        int countString = 0;
        int countColumn = 0;
        //считаем количество строк
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[j][i] != max + 1) {
                    countString++;
                }
            }
            if (countString != 0) {
                break;
            }
        }
        //считаем количество колонок
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != max + 1) {
                    countColumn++;
                }
            }
            if (countColumn != 0) {
                break;
            }
        }

        int[][] mas = new int[countString][countColumn];

        if (countString == 0 && countColumn == 0) {
            System.out.println("Матрица не содержит элементов");

        } else {
            int k = 0;
            int m = 0;
            //заполняем новый массив оставшимися элементами
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != (max + 1)) {
                        mas[k][m] = arr[i][j];
                        m++;

                        if (m == countColumn) {
                            m = 0;
                            k++;
                        }
                    }
                }
            }
        }
        for (int[] array : mas) {
            for (int element : array) {
                System.out.printf("%3d", element);
            }
            System.out.println();
        }
        return mas;
    }
}
