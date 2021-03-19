package by.it._khmelov_.jd01_02;

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
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            min = Math.min(min, value);
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value; //sum=sum+x;
        }
        double avg = (double) sum / arr.length;
        for (int value : arr) {
            if (value < avg) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];//1 2 3 4 5 6 7 0 9 0
        for (int value : arr) {
            min = Math.min(min, value);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]==min){
                System.out.print(i+" ");
            }
        }
        System.out.println(); //9 8
    }


}
