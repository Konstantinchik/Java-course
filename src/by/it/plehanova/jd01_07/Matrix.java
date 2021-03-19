package by.it.plehanova.jd01_07;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] matrix;

    Matrix(double[][] value) {
        this.matrix = copyArray(value);
    }

    Matrix(String strMatrix) {
        this.matrix = copyArray(numberOfString(strMatrix));
    }

    Matrix(Matrix matrix) {
        this.matrix = copyArray(matrix.matrix);
    }

    private static double[][] numberOfString(String str) {

        str.replace("[{]+|[}]$", "");
        String[] number = str.split("},");

        String[][] multiNumber = new String[number.length][];

        for (int i = 0; i < number.length; i++) {
            multiNumber[i] = number[i].replaceAll("[^0-9\\.]+", " ").trim().split(" ");
        }

        double[][] matrix = new double[multiNumber.length][multiNumber[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < multiNumber[i].length; j++) {
                matrix[i][j] = Double.parseDouble(multiNumber[i][j]);
            }
        }
        return matrix;
    }

    private static double[][] copyArray(double[][] array) {
        double[][] copy = new double[array.length][];
        for (int i = 0; i < array.length; i++) {
            copy[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return copy;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] element : matrix) {
            sb.append(delimiter).append("{");
            delimiter = "";
            for (int j = 0; j < element.length; j++) {
                sb.append(delimiter).append(element[j]);
                delimiter = ", ";
            }
            sb.append("}");
        }
        sb.append("}");

        return sb.toString();
    }
}
