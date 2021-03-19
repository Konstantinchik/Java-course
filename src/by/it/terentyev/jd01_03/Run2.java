package by.it.terentyev.jd01_03;

import java.util.Arrays;

public class Run2 {
    public static void main(String[] args) {
        String line = "2 1 3 0.5 0.1 85 68 15 9 -0.5";
        double[] array=Helper.printLine(line);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
