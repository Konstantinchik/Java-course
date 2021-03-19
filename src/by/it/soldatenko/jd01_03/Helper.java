package by.it.soldatenko.jd01_03;

import java.util.Random;

class Helper {
    static double findMin(double[] arr) {
        double min = Integer.MAX_VALUE;
        if (arr.length !=0) {
            for (double v : arr) {
                if (v < min) {
                    min = v;
                }
            }
        }
        return min;
    }
    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        if ( arr.length!=0) {
            for (double v : arr) {
                if (v > max) {
                    max = v;
                }
            }
        }
        return max;
    }
    static void sort(double[ ] arr){
        double n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        }

    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] mul = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] = mul[i] + matrix[i][j]*vector[j];
            }
        }
        return mul;

    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for(int i = 0; i < matrixLeft.length; i++) {
            for(int j = 0; j < matrixRight[0].length; j++) {
                for(int k = 0; k < matrixLeft[0].length; k++) {
                    mul[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }

        return mul;
    }
}
