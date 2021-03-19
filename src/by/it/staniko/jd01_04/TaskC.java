package by.it.staniko.jd01_04;

import by.it.staniko.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.copyOfRange;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
        //binarySearch();
       // double[] newarray = new double[0];
        //mergeSort(newarray);
    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        System.out.printf("Index of first element=%d\n", binarySearch(array, first));
        System.out.printf("Index of last element=%d\n", binarySearch(array, last));
    }


/*
    static void mergeSort(double[] array) {
        double first = array[0];
        double last = array[array.length - 1];

        do {

            int a = Arrays.binarySearch(array, first);
            int b = Arrays.binarySearch(array, last);
            int medium = (int) (Math.floor(a + b) / 2);

            double[] newArray = copyOfRange(array, 0, medium);
            array = newArray;
        }
        while (array.length > 1);
    }*/

    static int binarySearch(double[] array, double value){
        int a=0;
        int b= array.length-1;
        int index=-1;

         do {
            int mean=(a+b)/2;
            if (value == array[mean]) {
                index=mean;
                break;
            }
            else if ( value < array[mean]){
                b=mean-1;
            }
            else if (value > array[mean]){
                a=mean+1;
            }
        }
         while (a<=b);

        return index;
    }
}