package by.it.soldatenko.jd01_02;


import java.util.Random;
import java.util.Scanner;

public class TaskC{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
//        int[][] arr = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step1(n);
        step2(arr);
        step3(arr);
    }
    public static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        int count1 = 0;
        int count2 = 0;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.round(Math.random() * 2 * n) - n);
//                    arr[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
                    if (arr[i][j] == n) {count1=1; }
                    if (arr[i][j] == -n) {count2=1; }
                }
            }
        }while (count1 + count2 !=2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();}
        return arr; }

        public static int step2(int[][] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                int j1 =0;
                int j2 = 0;
                int count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] > 0) {
                        if (count == 0) {
                            j1 = j; count = 1;
                        }
                        else{
                            j2 = j;  break;
                        }
                    }
                }
                for (int j = j1 +1; j < j2; j++) {
                    sum = sum + arr[i][j];
                }
            }
            return sum;
        }
        public static int[][] step3(int[][] arr){
            int count_i = 0;
            int count_j = 0;
            int[] i_i = new int[arr.length];
            int[] j_j = new int[arr.length];
            int max = Integer.MIN_VALUE;
            int low = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j]>max){
                        max = arr[i][j];
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if ( arr[i][j] == max){
                        i_i[i] = 1;
                        j_j[j] = 1;
                    }else {i_i[i] = 0;
                    j_j[j] = 0;}
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (i_i[i]==0){
                    count_i++;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (j_j[j]==0){
                    count_j++;
                }
            }
            int resultList[] = new int[count_i*count_j];
            int y = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                 if(i_i[i] != 1 & j_j[j] !=1  ) {
                     resultList[y] = arr[i][j];
                     y++;
//                     System.out.print(arr[i][j] + " ");
                 }
                }
//                System.out.println();
            }
            y=0;
            int [][] arrRes = new int[count_i][count_j];
            for (int i = 0; i < count_i; i++) {
                for (int j = 0; j < count_j; j++) {
                        arrRes[i][j] = resultList[y] ;
                        y++;
                        System.out.print(arrRes[i][j] + " ");
                }
                System.out.println();
            }
            return arrRes;
        }
}
