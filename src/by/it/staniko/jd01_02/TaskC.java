package by.it.staniko.jd01_02;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class TaskC {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        step1(n);
    }

    private static void step1(int n) {

        //int[][] a = new int[5][5];
        int max, min;
        Random rnd = new Random();
        int[][] arr = new int[n][n];
        int i = 0;
        int j = 0;
/*
        if (arr[i][j] == Integer.parseInt(null)){
            System.out.println();

        }
        else {

            System.out.println(arr[i][j]+" ");
        }
*/
        for (i = 0; i < arr.length; i++) {
            for ( j=0;j < arr[i].length;j++) {
                arr[i][j]=rnd.nextInt(n) + 1;
            }
        }
        for (i=0;i < arr.length;i++,System.out.println()) {
            for (j=0;j < arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }

        }
        System.out.println();

    }



}


