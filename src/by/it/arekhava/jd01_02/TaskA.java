package by.it.arekhava.jd01_02;

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


    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int number : arr) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.println(min + " " + max);


    }

    private static void step2(int[] arr) {
        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        double mid = (double) sum / arr.length;
        for (double number : arr) {
            if (number < mid) {
                System.out.print((double) number + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int number : arr) {
            if (number > min) {
                min = number;
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == min){
                    System.out.print(i + " ");
                }

            }

            System.out.println();
        }
    }
}