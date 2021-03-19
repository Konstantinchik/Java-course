package by.it._khmelov_.jd01_03;


public class Runner {
    public static void main(String[] args) {
        String line="100 2 4 6 80 10 24 44 50";
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",2);
    }
}
