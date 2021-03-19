package by.it.novik.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        step1(n);

    }

    private static int[ ][ ]step1(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int a = (int)(Math.random()*(n+n+1)) -n;
                arr[i][j] = a;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr;
    }





}





