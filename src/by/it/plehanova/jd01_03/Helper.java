package by.it.plehanova.jd01_03;

/*  B. Реализуйте статические методы для поиска минимального и максимального значения в
    одномерном массиве для типа double. Реализуйте статические методы для сортировки по
    возрастанию одномерных массивов типа double. Разместите эти методы в классе
    by.it.familiya.jd01_03.Helper.

       Сигнатуры:
       static double findMin(double[ ] arr)
       static double findMax(double[ ] arr)
       static void sort(double[ ] arr)

    C. Реализуйте умножение матрицы на вектор, матрицы на матрицу для типа double. Разместите
    статические методы в классе by.it.familiya.jd01_03.Helper.

        Сигнатуры:
        static double[ ] mul(double[ ][ ] matrix, double[ ] vector)
        static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight)
*/

import java.util.Random;

class Helper {
    /**
     * @param array - double array[] data
     * @return the smallest number of array
     */
    static double findMin(double[] array) {
        double min = array[0];

        for (double value : array) {
            min = Math.min(min, value);
        }
        return min;
    }

    /**
     * @param array - double array[] data
     * @return the largest number of array
     */
    static double findMax(double[] array) {
        double max = array[0];

        for (double value : array) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * @param array - double array[] data
     */
    static void sort(double[] array) {

        double temp;
        boolean check;
        int count = array.length - 1;

        do {
            check = false;

            for (int i = 0; i < count; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    check = true;
                }

            }
            count--;
        } while (check);
    }

    /**
     * @param array - empty double array[][] with size
     * @return an array generated with random double numbers
     */
    static double[][] initArray(double[][] array) {

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextDouble() * 6;
            }
        }
        return array;
    }

    /**
     *
     * @param array - double[][] array data
     * @param indexOfColumn - array column index
     * @return the vector of array
     */
    static double[] vectorArray(double[][] array, int indexOfColumn) {

        double[] vector = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            vector[i] = array[i][indexOfColumn];
        }
        return vector;
    }

    /**
     *
     * @param matrix - double[][] array
     * @param vector - double[] vector of array
     * @return the result array - vector multiplication
     */
    static double[] mul(double[][] matrix, double[] vector) {

        double[] result = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    /**
     *
     * @param matrixLeft - double[][] data first array
     * @param matrixRight - double[][] data second array
     * @return the result of first array - second array miltiplication
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {

        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int m = 0; m < matrixRight.length; m++)
                    resultMatrix[i][j] = resultMatrix[i][j] + matrixLeft[i][m] * matrixRight[m][j];
            }
        }
        return resultMatrix;
    }

}
