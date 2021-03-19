package by.it.arekhava.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        String line="100 3 4 6 2 80 90 40";
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",2);
    }
}
