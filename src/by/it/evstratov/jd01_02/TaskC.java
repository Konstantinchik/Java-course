package by.it.evstratov.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = step1(n);

        //step2(arr);
        step3(arr);

    }

    private static int[][] step1(int n) {

        int[][] matrix = new int[n][n];
        boolean isMinusN = false;
        boolean isPlusN = false;

        while (true){

            int[][] matrixTmp = new int[n][n];
            for (int i = 0; i < matrixTmp.length; i++) {
                for (int j = 0; j < matrixTmp.length; j++) {
                    int random = (int) (Math.random()*(n+n+1)) - n;
                    matrixTmp[i][j] = random;
                    if(random==n){
                        isPlusN = true;
                    }
                    if(random==-n){
                        isMinusN = true;
                    }
                }
            }
            if(isMinusN && isPlusN){
                matrix=matrixTmp;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println();
                }
                break;
            }
        }

        return matrix;

    }

    private static int step2(int[][] arr){

        int[][] matrix = arr;
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            int sumTmp = 0;
            boolean isStarted = false;
            for (int j = 0;  j< matrix.length; j++) {

                int value = matrix[i][j];

                if(value >= 0 && isStarted){
                    isStarted = false;
                    sum+=sumTmp;
                    break;
                }else if(value < 0 && isStarted){
                    sumTmp+=value;
                }else if(value >= 0 && !isStarted){
                    isStarted = true;
                }

            }
        }

        System.out.println(sum);
        return sum;

    }

    private static int[][] step3(int[][] arr){

        int max = 0;
        int deleted;
        int [][] result;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] >= max){
                    max = arr[i][j];
                }
            }
        }

        deleted = max+1;
        int resultRow = arr.length;
        int resultCol = arr.length;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if(arr[i][j] == max){

                    for (int k = 0; k < arr.length; k++) {
                        if(arr[i][k] != max){
                            arr[i][k] = deleted;
                        }
                        if(arr[k][j] != max){
                            arr[k][j] = deleted;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if(arr[i][j] == max || arr[i][j]==deleted){
                    arr[i][j]=deleted;
                }
            }
        }

        int countRow=arr.length;
        int countCol=arr.length;
        for (int i = 0; i < arr.length; i++) {
            int countRowTmp=0;
            int countColTmp=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] == deleted){
                    countRowTmp++;
                }
                if(arr[j][i] == deleted){
                    countColTmp++;
                }
            }
            if(countRowTmp== arr.length){
                //System.out.println("Надо удалить строк - "+countRowTmp);
                countRow--;
            }
            if(countColTmp== arr.length){
                //System.out.println("Надо удалить стобцов - "+countRowTmp);
                countCol--;
            }
        }
        result = new int[countRow][countCol];

        System.out.println(countRow+":"+countCol);

        int row = 0;
        int col = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] != deleted && arr[i][j] != max){
                    result[row][col] = arr[i][j];
                    col++;
                }
            }
            if(col>0){
                row++;
                col=0;
            }
        }



        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

        return result;

    }


}
