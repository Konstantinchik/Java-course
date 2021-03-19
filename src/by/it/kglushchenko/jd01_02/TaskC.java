package by.it.kglushchenko.jd01_02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class TaskC {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] mat;
    mat = step1(n);
    int[][] mat1 = new int[n][n];

    // Делаем копию начальной матрицы
    for(int j=0; j<mat.length; j ++){
        for(int i=0; i<mat.length; i ++){
            mat1[i][j] = mat[i][j];
        }
    }

    step3(mat1);

}

    private static int[][] step1(int n){
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = -n + (int)(Math.random()*n*10);
                arr[i][j] = Math.abs(num) <= n ? num : n;
            }
        } // Сгенерировали матрицу

        // Выводим матрицу в консоль
        for(int j=0; j < n; j++){
            for(int i=0; i < n; i++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        return arr;
    }

    private static int step2(int[][] arr){
        int sum=0;

        for (int j=0; j < arr.length; j++) {
            int c=0; // counter 2 digits in line
            for (int i=0; i < arr.length; i++) {

                if(arr[i][j] >= 0){
                    c += 1;
                    sum += arr[i][j];
                    if(c==2) {
                        break;
                    }
                } else {
                    if(c!=0) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        // Выводим найденную сумму
        System.out.println(sum);
        // Возвращаем найденную сумму
        return  sum;
    }

    private static int[][] step3(int[][] arr){

        int old_dim = arr.length;
        Integer[] num;
        num = new Integer[arr.length];

        int max = Collections.max(Arrays.asList(num));

        int new_dim = old_dim - 1; // Предпорожим 1 элемент - MAX
        int[][] ret = new int[new_dim][new_dim];

        for(int j=0; j<old_dim; j++ ){
            for(int i=0; i<old_dim; i++){
                if(i!=max){
                    ret[i][j]=arr[i][j];
                }
            }
        }



        return ret;
    }
}
