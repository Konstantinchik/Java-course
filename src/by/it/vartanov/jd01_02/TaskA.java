package by.it.vartanov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[10];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step3(int[] arr)
    {
        int min = arr[0];
        for (int value : arr)
        {
            if (value < min) {
                min = value;
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i] == min)
            {
                System.out.print(i + " ");
            }
        }
    }

    private static void step2(int[] arr)
    {
        double avg = 0;
        int k = 0;
        for (int i : arr)
        {
            avg+=i;
        }
        avg = avg / arr.length;
        System.out.println(avg);
        for (int i : arr)
        {
            if (i < avg) {
                System.out.println(i);
            }
        }
    }




    private static void step1(int[] arr)
    {
        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }

        System.out.println(min + " " + max);
    }


}
