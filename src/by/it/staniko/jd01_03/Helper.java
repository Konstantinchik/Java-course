package by.it.staniko.jd01_03;

class Helper {
    public static double findMin(double[] array) {
        double min = array[0];

        if (array.length == 0) {
            min = Double.MIN_VALUE;
        } else {
            //double min = array[0];
            for (double m : array) {
                if (m < min) min = m;
            }

        }
        return min;
    }

//System.out.println();

    static double findMax(double[] array) {
        double max = array[0];
        if (array.length == 0) {
            max = Double.MAX_VALUE;
        } else {
            //double max = array[0];
            for (double m : array) {
                if (m > max) max = m;
            }


        }
        return max;
    }

    static void sort(double[] array) {
        boolean swap;
        //double array[];
        double last = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }

            }
            last--;
        }
        while (swap);
        //System.out.println(array);
        printArray(array);
        //return array;
    }

    static void printArray(double[] array) {
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] newmatrix = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newmatrix[i] = newmatrix[i] + matrix[i][j] * vector[j];
                //double[]array=new double[i];
                //array[i]=newmatrix[i];

            }
        }
        return newmatrix;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] newmatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newmatrix[i][j] = newmatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return newmatrix;
    }

    static void arrayPrint2d(double[][] newmatrix, String name) {
        for (int i = 0; i <newmatrix.length ; i++) {
            for (int j = 0; j < newmatrix[0].length ; j++) {
                System.out.printf("%2.2f",newmatrix[i][j]);
            }
        }
        System.out.println();
    }
}