package by.it.bogunov.jd01_04;

import by.it.bogunov.jd01_03.InOut;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
    }

    static void printMulTable() {
        for (int i = 2; i < 10 ; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);



    }
}
