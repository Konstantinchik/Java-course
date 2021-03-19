package by.it.leshchenko.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        step2(array);
        step3(array);
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        boolean plus = false;
        boolean minus = false;
        while (!plus && !minus) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
                    if (array[i][j] == n) {
                        plus = true;
                    }
                    if (array[i][j] == -n) {
                        minus = true;
                    }
                }
            }
            int index = 0;
            if (plus && minus) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(array[i][j] + " ");
                        index++;
                    }
                    System.out.println();
                }
                break;
            } else {
                plus = false;
                minus = false;
            }
        }
        return array;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        for (int[] item1 : arr) {
            boolean positive = false;
            for (int item2 : item1) {
                if (item2 > 0 && !positive) {
                    positive = true;
                } else if (item2 <= 0 && positive) {
                    sum += item2;
                } else if (item2 > 0 && positive) {
                    break;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        // Определяем максимальное значение в исходной матрице
        int max = arr[0][0];
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }

        // Определяем индексы столбцов, которые нужно удалить
        boolean[] rows = new boolean[arr[0].length];
        boolean[] cols = new boolean[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    rows[i] = true; // Если TRUE, то строку удаляем из матрицы
                    cols[j] = true; // Если TRUE, то столбец удаляем из матрицы
                }
            }
        }

        // Считаем количество строк в новой матрице
        int rows_num = 0;
        for (boolean row : rows) {
            if (!row) {
                rows_num++;
            }
        }
        // Считаем количество столбцов в новой матрице
        int cols_num = 0;
        for (boolean col : cols) {
            if (!col) {
                cols_num++;
            }
        }

        // Создаем новую матрицу по новым параметрам и выводим на экран
        int[][] result = new int[rows_num][cols_num];
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!rows[i]) {
                int c = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!cols[j]) {
                        result[r][c] = arr[i][j];
                        System.out.print(result[r][c] + " ");
                        c++;
                    }
                }
                System.out.println();
                r++;
            }
        }

        return result;
    }
}
