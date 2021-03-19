package by.it.evstratov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    private static void buildOneDimArray(String s) {

        double[] array = InOut.getArray(s);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array,"V",5);
        mergeSort(array);
        InOut.printArray(array,"V",4);

        System.out.printf("Index of first element=%d \n", TaskC.binarySearch(array, first));
        System.out.printf("Index of last element=%d \n", TaskC.binarySearch(array, last));
        
    }

    static void mergeSort(double[ ] array, int left, int right){

        int l = left;
        int r = right;

        while (l < r){
            int m = partition(array, l, r);
            mergeSort(array, l, m);
            l = m + 1;
        }

    }

    static void mergeSort(double[ ] array){
        mergeSort(array, 0, array.length);
    }

    private static int partition(double[ ] array, int left, int right){

        double x = array[left];
        int j = left;

        for (int i = left+1; i < right; i++) {
            if(array[i]<=x){
                j = j + 1;
                double tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        double tmp = array[j];
        array[j] = array[left];
        array[left] = tmp;
        
        return j;

    }

    static int binarySearch(double[ ] array, double value){

        int result = -1;
        int left = 0;
        int right = array.length;

        while (left <= right){
            int m = (left + right) / 2;
            if(array[m] == value){
                result = m;
                break;
            }else if(array[m] > value){
                right = m - 1;
            }else{
                left = m + 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }

}
