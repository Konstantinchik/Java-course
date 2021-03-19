package by.it.leshchenko.jd01_05;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        Task6();
        Task7();
    }

    private static void Task6() {
        // Формируем стартовый массив
        int n = (int) (Math.random() * (20 + 1)) + 20; // 20-40 элементов
        double[] arrayA = new double[n];
        double start = 5.33;
        double stop = 9;
        double step = (stop - start) / (n - 1);
        for (int i = 0; i < n; i++) {
            arrayA[i] = Math.cbrt(start * start + 4.5);
            start += step;
        }

        // Выводим стартовый массив
        System.out.println("Массив A[]");
        for (int i = 0, l = arrayA.length; i < l; i++) {
            System.out.printf("A[%3d] = %f    ", i, arrayA[i]);
            if ((i + 1) % 5 == 0 || i == l - 1) {
                System.out.println();
            }
        }
        System.out.println();

        // Формируем массив из элементов > 3.5
        int count = 0;
        for (double v : arrayA) {
            if (3.5 < v) {
                count++;
            }
        }
        double[] arrayB = new double[count];
        count = 0;
        for (double v : arrayA) {
            if (3.5 < v) {
                arrayB[count] = v;
                count++;
            }
        }

        Arrays.sort(arrayB);

        // Выводим массив из элементов > 3.5
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0, l = arrayB.length; i < l; i++) {
            System.out.printf("B[%3d] = %f    ", i, arrayB[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void Task7() {

        // Формируем одномерный массив A со значениями от 103 до 450
        int[] arrayA = new int[31];
        for (int i = 0, l = arrayA.length; i < l; i++) {
            arrayA[i] = (int) (Math.random() * (450 - 103 + 1)) + 103;
        }

        // Формируем массив B
        int count = 0;
        for (int i = 0, l = arrayA.length; i < l; i++) {
            if (arrayA[i] / 10 > i) {
                count++;
            }
        }
        int[] arrayB = new int[count];
        count = 0;
        for (int i = 0, l = arrayA.length; i < l; i++) {
            if (arrayA[i] / 10 > i) {
                arrayB[count] = arrayA[i];
                count++;
            }
        }

        int cols = 5; // Количество колонок в выводимых таблицах A и B
        String s = "═══════════";

        // Выводим массив A по строкам
        System.out.println("Массив A");
        System.out.print("╔");
        for (int j = 0; j < cols - 1; j++) {
            System.out.print(s + "╦");
        }
        System.out.println(s + "╗");
        for (int i = 0, l = arrayA.length; i < l; i++) {
            System.out.printf("║ A[%2d]=%3d ", i, arrayA[i]);
            if ((i + 1) % cols == 0) {
                System.out.println("║");
                System.out.print("╠");
                for (int j = 0; j < cols - 1; j++) {
                    System.out.print(s + "╬");
                }
                System.out.println(s + "╣");
            }
        }
        for (int i = arrayA.length; i % cols > 0; i++) {
            System.out.printf("║%11s", "");
        }
        System.out.println("║");
        System.out.print("╚");
        for (int j = 0; j < cols - 1; j++) {
            System.out.print(s + "╩");
        }
        System.out.println(s + "╝");

        // Выводим массив B по столбцам
        int rows;
        int length = arrayB.length;
        if (length % cols == 0) {
            rows = length / cols;
        } else {
            rows = length / cols + 1;
        }

        System.out.println("Массив B");
        System.out.print("╔");
        for (int j = 0; j < cols - 1; j++) {
            System.out.print(s + "╦");
        }
        System.out.println(s + "╗");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = j * rows + i;
                if (index < length) {
                    System.out.printf("║ B[%2d]=%3d ", index, arrayB[index]);
                } else {
                    System.out.printf("║%11s", "");
                }
            }
            System.out.println("║");
            if (i < rows - 1) {
                System.out.print("╠");
                for (int j = 0; j < cols - 1; j++) {
                    System.out.print(s + "╬");
                }
                System.out.println(s + "╣");
            }
        }
        System.out.print("╚");
        for (int j = 0; j < cols - 1; j++) {
            System.out.print(s + "╩");
        }
        System.out.println(s + "╝");
    }
}
