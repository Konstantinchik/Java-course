package by.it.leshchenko.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int item : arr) {
            if (item < min) {
                min = item;
            }
            if (item > max) {
                max = item;
            }
        }
        System.out.print(min + " " + max);
        System.out.println();
    }

    private static void step2(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        double sr = (double) sum / arr.length;
        for (int item : arr) {
            if (item < sr) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int item : arr) {
            if (item < min) {
                min = item;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
