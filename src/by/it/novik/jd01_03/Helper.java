package by.it.novik.jd01_03;
import java.util.Arrays;


public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
        return min;
    }

    static double findMax(double[ ] arr){
        double max = arr[0] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
        return max;
    }

    static void sort(double[ ] arr){
        System.out.print("\nSorted: \n");
        Arrays.sort(arr);
        for(int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }

    }
}
