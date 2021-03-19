package by.it.zavoiskikh.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i<mas.length; i++) {
            mas [i] = scanner.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);
    }


    public static void step1(int[] mas) {
        int min = mas [0];
        int max = mas [0];
        for (int element : mas) {
            if (element < min) min = element;
            if (element > max) max = element;
        }

            System.out.println(min + " " + max);
        }


    public static void step2(int[] mas) {
        double avg = 0;
        for (int element: mas)  {
            avg = avg + element;
        }
        avg = avg / mas.length;

        for (int element : mas) {
            if (avg > element)

            System.out.print(element + " ");
        }
        System.out.println ();
    }

    public static void step3(int[] mas) {
        int min = mas [0];
        for (int element : mas) {
            if (element < min) min = element;
        }
        for (int i = mas.length-1; i>=0; i--) {
            if (mas [i] == min)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}











