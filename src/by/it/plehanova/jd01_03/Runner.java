package by.it.plehanova.jd01_03;

import java.util.Scanner;

class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        double[] array = InOut.getArray(line);

        InOut.printArray(array);
        InOut.printArray(array, "Array", 3);

        double min = Helper.findMin(array);
        double max = Helper.findMax(array);

        System.out.println("min = " + min + "\n" + "max = " + max + "\n");

        Helper.sort(array);
        InOut.printArray(array, "Sort array", 5);

        double[][] arrayMatrixOne = new double[3][5];
        double[][] arrayMatrixTwo = new double[5][4];

        Helper.initArray(arrayMatrixOne);
        Helper.initArray(arrayMatrixTwo);

        double[] vector = Helper.vectorArray(arrayMatrixTwo, 0);

        InOut.printMultiArray(arrayMatrixOne, "Matrix 1");
        InOut.printMultiArray(arrayMatrixTwo, "Matrix 2");
        InOut.printArray(vector, "Vector", 5);

        double[] resMulVector = Helper.mul(arrayMatrixOne, vector);
        double[][] resMulMatrix = Helper.mul(arrayMatrixOne, arrayMatrixTwo);

        InOut.printArray(resMulVector, "Multipl Vector", 5);
        InOut.printMultiArray(resMulMatrix, "Multipl Matrix");


    }
}
