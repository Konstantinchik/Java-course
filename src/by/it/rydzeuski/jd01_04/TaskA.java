package by.it.rydzeuski.jd01_04;


import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[]args){
        printMulTable();
    }
     static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);

            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"v",5);
        double first=array[0];
        double last=array[array.length-1];
        Helper.sort(array);
        InOut.printArray(array,"v",4);
        for (double v : array) {
            if (first == v)
                System.out.printf("Index of first element=%d\n,i");
            break;

        }

        System.out.printf("Index of last element=%d\n,Arrays.binarySearch(array, last)");
    }
    }

