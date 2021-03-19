package by.it.arekhava.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static int[][] step1(int n) {
        int[][] arr = new int[n][n];


        while (true) {

            boolean isN = false;
            boolean isNegativeN = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int randomNumber = (int) (Math.random() * (2 * n + 1)) - n;

                    if (n == randomNumber) {
                        isN = true;
                    }
                    if (-n == randomNumber) {
                        isNegativeN = true;
                    }
                    arr[i][j] = randomNumber;
                }
            }
            if (isN && isNegativeN) {
                break;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] arr = step1(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int step2(int[][] arr) {
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
