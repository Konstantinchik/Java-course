package by.it.evstratov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {


        TaskA.printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }

    private static void buildOneDimArray(String s) {

        double[] array = InOut.getArray(s);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if(first==array[i]){
                System.out.printf("Index of first element=%d \n",i);
                break;
            }

        }
        System.out.printf("Index of last element=%d \n",Arrays.binarySearch(array, last));
    }


    private static void printMulTable() {

        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i,j,j*i);
            }
            System.out.println("");

        }

    }

}
