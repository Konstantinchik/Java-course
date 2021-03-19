package by.it.bogunov.jd01_03;



public class Runner {
    public static void main(String[] args) {
        String line="100 2 4 6 90 23 44 51";
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",2);

    }
}
