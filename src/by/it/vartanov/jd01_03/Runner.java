package by.it.vartanov.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
       String line = "1 2 3 4 5 6 7 8 9 10";
       double [] array = InOut.getArray(line);
       System.out.println(Arrays.toString (array));
        InOut.printArray(array);
        InOut.printArray (array, "A", 2);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);


    }


}
