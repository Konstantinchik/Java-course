package by.it.tetenkov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

        buildOneDimArray(line);


    }



    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double fisrt_value = array[0];
        double last_value = array[array.length - 1];
        InOut.printArray(array,"V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        System.out.println("Index of first element=" + binarySearch(array, fisrt_value));
        System.out.println("Index of last element=" + binarySearch(array, last_value));

    }

    static int binarySearch(double[] array, double key) {
        int min = 0;
        int max = array.length;

        int low = min;
        int high = max -1;


        while (low <= high){
            int mid = (low + high) / 2;
            double array_index = array[mid];

            if (array_index < key){
                low = mid + 1;
            }
            else if (array_index > key){
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
