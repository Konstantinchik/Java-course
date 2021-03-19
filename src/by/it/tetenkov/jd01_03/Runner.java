package by.it.tetenkov.jd01_03;

import java.util.Arrays;



public class Runner {
    public static void main(String[] args) {
        String line = "1 100 3 4 5 6 24";
        double[] array = InOut.getArray(line);

        InOut.printArray(array);
        InOut.printArray(array, "A", 2);

        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));

        Helper.sort(array);

        double [][] matrix1 = new double[3][4];
        double [][] matrix_two = new double[4][5];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = (double) Math.round(Math.random() * 10);
                System.out.printf("%.2f ", matrix1[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n");

        for (int i = 0; i < matrix_two.length; i++) {
            for (int j = 0; j < matrix_two[0].length; j++) {
                matrix_two[i][j] = (double) Math.round(Math.random() * 10);
                System.out.printf("%.2f ", matrix_two[i][j]);
            }
            System.out.println("");
        }


        double[] vector = new double[matrix_two.length];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = matrix_two[i][0];
            System.out.printf("%.2f ", vector[i]);
        }


        Helper.mul(matrix1, vector);
        Helper.mul(matrix1, matrix_two);




        // System.out.println(Arrays.toString(Helper.mul(matrix, vector)));

    }
}
