package by.it.staniko.jd01_04;

import by.it.staniko.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String line =scanner.nextLine();
        buildOneDimArray(line);

    }

    static void printMulTable(){
        for (int i = 2; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%d*%d=%-2d ",i,j,i*j);

            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        Helper.sort(array);
        InOut.printArray(array, "V", 4);
//        double first = array[0];
  //      double last = array[array.length - 1];


        //int indexOfFirst = Arrays.binarySearch(array, first);
//        System.out.printf("Index of first element=%d\n",indexOfFirst);
        //int indexOfLast = Arrays.binarySearch(array, last);

        System.out.printf("Index of first element=%d\n", Arrays.binarySearch(array, first));
        System.out.printf("Index of last element=%d\n", Arrays.binarySearch(array, last));
    }



    }
