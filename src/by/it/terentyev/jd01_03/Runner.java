package by.it.terentyev.jd01_03;

//import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String line = "80 2 3 4 5 8 9 7 45 6";
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",2);
    }

}
