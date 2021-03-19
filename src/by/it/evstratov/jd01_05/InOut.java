package by.it.evstratov.jd01_05;

import java.util.Arrays;

class InOut {

    /**
     *
     * @param line - String array data
     * @return
     */

    static double[] getArray(String line){

        String strArray[] = line.trim().split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    static void printArray(double[] arr){

        for (double v : arr) {
            System.out.print(v+" ");
        }
        System.out.println("");

    }

    static void printArray(double[] arr, String name, int columnCount){

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.5f", name,i, arr[i]);
            if((i+1)%columnCount==0 || i+1== arr.length){
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {

        String line = "100 20 12 45 32 41 2 344 1 34 3";
        printArray(getArray(line));

    }


}
