package by.it.leshchenko.jd01_03;

public class Runner {

    public static void main(String[] args) {
        String s = "23 54 5 547 25 79 23 7 235 34";
        double[] array = InOut.getArray(s);
        InOut.printArray(array);
        InOut.printArray(array, "TEST", 3);
        double[] d = {5.0, 6.0, 7.0, 8.0, 9.0, 0.0, 1.0, 0.1, 0.2, -0.2, -0.1, 3.0, 4.0};
        System.out.println(Helper.findMin(d));
        System.out.println(Helper.findMax(d));
        Helper.sort(d);
        double[][] matrix1 = {{1,2,3},{4,5,6}};
        double[][] matrix2 = {{1,2},{3,4},{5,6}};
        double[] vector = {1,2,3};
        double[] mul1 = Helper.mul(matrix1, vector);
        double[][] mul2 = Helper.mul(matrix1, matrix2);

    }
}
