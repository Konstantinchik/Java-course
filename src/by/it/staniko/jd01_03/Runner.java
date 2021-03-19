package by.it.staniko.jd01_03;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        String line ="10 20 30 40 25 11";
        double[] array=InOut.getArray(line);
        double[][] matrix = {
            {12,11,24},
            {25,14,2}
        };
        double[] vector = {1,2,3};
        double[][] matrixLeft ={
                {5,121,24},
                {25,4,12}
        };
        double[][] matrixRight ={
                {1,1,4},
                {5,4,2}
        }; ;

        //double min= Helper.findMin(array);
        //System.out.println(Arrays.toString(array));
        InOut.printArray(array);
        InOut.printArray(array,"A",3);

        Helper.findMin(array);
        Helper.findMax(array);
        System.out.println("max =" + Helper.findMin(array));
        System.out.println("max =" + Helper.findMax(array));

        Helper.sort(array);
        //System.out.println(Helper.sort(array));


        Helper.mul(matrix,vector);
        InOut.printArray(Helper.mul(matrix,vector));

        Helper.mul(matrixLeft,matrixRight);
        String newmatrix = null;
        Helper.arrayPrint2d(Helper.mul(matrixLeft, matrixRight),newmatrix);
        //System.out.println(Helper.mul(newmatrix));
    }

}
