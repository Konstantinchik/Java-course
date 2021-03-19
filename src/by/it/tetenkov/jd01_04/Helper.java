package by.it.tetenkov.jd01_04;

import java.util.Arrays;

class Helper {
    static double findMin(double[] array) {
        double a = array[0];
        for (int i = 0; i < array.length; i++) {
            if (a > array[i]){
                a = array[i];
            }
        }

        return a;
    }

    public static double findMax(double[] array) {
        double a = 0;
        for (int i = 0; i < array.length; i++) {
            if (a < array[i]){
                a = array[i];
            }
        }

        return a;
    }

        static void sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]) {
                    double x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

     static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

     static double[][] mul(double[][] matrix, double[][] matrix_two){
        double[][] result = new double[matrix.length][matrix_two[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix_two[0].length; j++) {
                for (int k = 0; k < matrix_two.length; k++) {
                    result[i][j] = result[i][j] + matrix[i][k] * matrix_two[k][j];
                }

            }

        }
        return result;
    }
}
