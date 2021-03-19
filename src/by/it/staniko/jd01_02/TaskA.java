package by.it.staniko.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);

    }


    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }

            if (value > max) {
                max = value;
            }


        }
        System.out.print(min + " " + max);

        System.out.println();
    }

    private static void step2(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        double arg = (double) sum / arr.length;
        for (int value : arr) {
            if (value < arg) {
                System.out.print(value + " ");

            }

        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]==min) {
                System.out.print(i + " ");
            }
        }
    System.out.println();
    }

    }
}
