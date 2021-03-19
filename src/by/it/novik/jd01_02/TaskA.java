package by.it.novik.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Введите 10 чисел: ");
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas [i]=scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }




    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 0; i< mas.length; i++) {
            if (mas[i]>max) max = mas[i];
            if (mas[i]<min) min = mas[i];
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {
        double sum =0;
        for(int i=0; i<mas.length; i++) {
            sum=sum+mas[i];
        }
        double sred = sum/mas.length;
        for(int i=0; i<mas.length; i++) {
            if (mas[i]<sred) System.out.println(mas[i]);
        }

    }


    private static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 0; i< mas.length; i++) {
            if (mas[i]<min) min = mas[i];
        }
        for (int i = mas.length-1; i>=0 ; i--) {
            if(mas[i]==min) System.out.print(i + " ");
            
        }


        



    }



}
