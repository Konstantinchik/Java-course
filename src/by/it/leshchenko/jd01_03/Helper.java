package by.it.leshchenko.jd01_03;

class Helper {
    static double findMin(double[] arr) {
        double min;
        if (arr.length != 0) {
            min = arr[0];
            for (int i = 1, arrLength = arr.length; i < arrLength; i++) {
                double v = arr[i];
                min = Math.min(min, v);
            }
        } else {
            min = Double.MIN_VALUE;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max;
        if (arr.length != 0) {
            max = arr[0];
            for (int i = 1, arrLength = arr.length; i < arrLength; i++) {
                double v = arr[i];
                max = Math.max(max, v);
            }
        } else {
            max = Double.MAX_VALUE;
        }
        return max;
    }

    static void sort(double[] arr) {
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
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

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }

        return result;
    }
}
