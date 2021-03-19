package by.it.evstratov.jd01_03;

class Helper {

    public static void main(String[] args) {

        double[] array = {1.3,0.3,4.5,7.1,3.3,91.3,3};
        Helper.findMin(array);
        double max = Helper.findMax(array);
        Helper.sort(array);

    }

    private static void sort(double[] array) {

        boolean swap = false;
        int last = array.length-1;

        do{
            swap = false;
            for (int i = 0; i < last; i++) {
                if(array[i]>array[i+1]){
                    double tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    swap = true;
                }
            }
        }while (swap);

    }

    private static double findMax(double[] array) {

        double max = array[0];
        if(array.length==0){
            max = Double.MAX_VALUE;
        }else{
            for (double value : array) {
                if(value > max){
                    max = value;
                }
            }
        }
        return max;

    }

    static double findMin(double[] array) {

        double min = array[0];
        if(array.length==0){
            min = Double.MIN_VALUE;
        }else{
            for (double value : array) {
                if(value < min){
                    min = value;
                }
            }
        }
        return min;
    }

    static double[] mul(double[][] matrix, double[] vector){

        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;

    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){

        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;

    }

}
