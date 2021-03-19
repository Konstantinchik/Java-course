package by.it.evstratov.jd01_02;

import java.util.Scanner;

public class TaskA {

    private static void step1(int[] arr) {

        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            if(value>max){
                max=value;
            }
            min = min>value ? value:min;
            System.out.println(min+" "+max);
        }

    }
    static void step2(int[ ] arr){

        double sum=0;
        for (int i : arr) {
            sum+=i;
        }
        double avr = sum/ arr.length;
        for (int value : arr) {
            if(value<avr){
                System.out.print(value+" ");
            }
            System.out.println();
        }

    }
    static void step3(int[ ] arr){

        int min = arr[0];

        for (int value : arr) {
            min = min>value ? value:min;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i]==min){
                System.out.print(i+" ");
            }
        }
        System.out.println();


    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=scanner.nextInt();
        }

        step1(arr);
        step2(arr);
        step3(arr);

    }


}
