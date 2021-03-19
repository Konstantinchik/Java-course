package by.it.vartanov.jd01_04;

import java.util.Arrays;

class Helper {
    static double findMin(double[] Arr){
//
        if(Arr.length==0){
            return Integer.MIN_VALUE;
        }
        else
        {
            double min = Arr[0];
            for(double m : Arr){
                if(min>m){
                    min=m;
                }
            }
            return min;
        }
        //
    }

    static double findMax(double[] Arr){
        if(Arr.length==0){
            return Integer.MAX_VALUE;
        }
        else
        {
            double max = Arr[0];
            for(double m : Arr){
                if(max<m){
                    max=m;
                }
            }
            return max;
        }
    }

    static void sort(double[] Arr){

        Arrays.sort(Arr);
    }

    static double[] mul(double[][] matrix, double[] vector){
        double[] newVec = new double[matrix.length];
        for(int i=0; i < matrix.length; i ++){
            for(int j=0; j < vector.length; j++){
                newVec[i] = newVec[i] + matrix[i][j] * vector[j];
            }
        }
        return newVec;
    }


    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] newVec = new double[matrixLeft.length][matrixRight[0].length];
        for(int i=0; i < matrixLeft.length; i ++){
            for(int j=0; j < matrixRight[0].length; j++){
                for(int k=0; k < matrixRight.length; k++){
                    newVec[i][j] = newVec[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return newVec;
    }
}
