package by.it.kglushchenko.jd01_02;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0; i< arr.length; i++){
            arr[i]= scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);

    }
    private static void step1(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int value : arr){
            if(value>max){
                max=value;
            }
            min = min > value ? value : min;
        }
        System.out.println(min+ " "+ max);
    }

    private static void step2(int[] arr){
        double sum = 0;
        for(int value : arr){
                sum+=value;
            }
            double avg = sum/arr.length;
            for(int value : arr) {
                if (value < avg) {
                    System.out.print(value+" ");
                }
            }
        System.out.println();
    }

    private static void step3(int[] arr){
        int min = arr[0]; // 12340677089
        for(int value : arr){
             min = Math.min(min, value);
        }
        for(int i = arr.length - 1; i >=0; i--){
            if(arr[i]==min){
                System.out.print(i+ " ");
            }
        }
        System.out.println();
    }
}
