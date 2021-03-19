package by.it.tetenkov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA<fori> {
    static  void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMulTable();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double fisrt_value = array[0];
        double last_value = array[array.length - 1];
        InOut.printArray(array,"V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        System.out.println("Index of first element=" + Arrays.binarySearch(array, fisrt_value));
        System.out.println("Index of last element=" + Arrays.binarySearch(array, last_value));

    }
}
