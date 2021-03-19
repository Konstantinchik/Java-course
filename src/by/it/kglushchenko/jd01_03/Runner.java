package by.it.kglushchenko.jd01_03;

public class Runner {
    public static void main(String[] arg){
        String line = "1 100 2 7 45 10 0 8 89 32";
        double[] array= InOut.getArray(line);

        InOut.printArray(array);

        InOut.printArray(array, "A",2 );


        Helper.findMin(array);


        Helper.findMax(array);


        Helper.sort(array);

        double[][] matr = new double[2][2];
        matr[0][0] = 5;
        matr[0][1] = 0;
        matr[1][0] = 1;
        matr[1][1] = 8;

        double[] vect = new double[2];
        vect = new double[]{7, 9};

        double[][] matrl = new double[2][2];
        matr[0][0] = 5;
        matr[0][1] = 0;
        matr[1][0] = 1;
        matr[1][1] = 8;

        double[][] matrr = new double[2][2];
        matr[0][0] = 7;
        matr[0][1] = 11;
        matr[1][0] = 20;
        matr[1][1] = 10;

        Helper.mul(matr, vect);

        Helper.mul(matrl, matrr);

    }
}
