package by.it.arekhava.jd01_04;

public class Helper {
    public static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double a: arr) {
                if (min > a) min = a;
            }
            return min;

        }
    }


    public static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double a: arr)
            {
                if (max < a) max = a;
            }
            return max;

        }

    }
    public static void sort(double[] arr) {

        boolean swap;
        int last= arr.length-1;
        do{
            swap=false;
            for (int j = 0; j < last; j++) {
                if (arr[j]>arr[j+1]) {
                    double buffer=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=buffer;
                    swap=true;
                }

            }
            last--;
        }
        while (swap);


    }
    public static double[] mul(double[][]matrix, double[]vector){
        double[]fin=new double[matrix.length];
        for (int i=0; i<matrix.length; i++)
        for (int j=0; j< vector.length; j++)
            fin[i]=fin[i]+matrix[i][j]*vector[j];
        return fin;

    }
    public static double[][] mul(double[][]matrixLeft, double[][]matrixRight){
        double[][]fin=new double[matrixLeft.length][matrixRight[0].length];
        for (int i=0; i<matrixLeft.length; i++)
            for (int j=0; j< matrixRight[0].length; j++)
                for (int k=0; k<matrixRight.length; k++)
                fin[i][j]=fin[i][j]+matrixLeft[i][k]*matrixRight[k][j];
        return fin;
    }
}


