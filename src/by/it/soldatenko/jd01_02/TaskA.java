package by.it.soldatenko.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }


    static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        double midlleArr = (double) sum / arr.length;
        for (int j : arr) {
            if (j < midlleArr) {
                System.out.println(j);
            }

        }


    }

    static void step3(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] <= min) {
                System.out.print(i + " ");
            }
        }

    }
}

