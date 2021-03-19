package by.it.tetenkov.jd01_02;

import java.util.Scanner;



public class TaskA {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  scanner.nextInt();
        }

        step1(arr);
        step2(arr);
        step3(arr);
    }




    private static void step1(int[] arr) {
        int min = arr[0];
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println(min + " " + max);

    }

    private static void step2(int[] arr) {
        double avg = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];


        }
        avg = (double) sum / arr.length;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < avg){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];

        for(int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }

        System.out.print(min);

        for(int i = arr.length - 1; i >= 0; i--){
            if (min == arr[i]){
                System.out.print(i + " ");
            }
        }

        System.out.println();


    }


}
