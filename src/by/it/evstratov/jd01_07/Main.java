package by.it.evstratov.jd01_07;

public class Main {

    public static void main(String[] args) {

        String array = "{{1.0, 2.2, 4.5}, {0.4, 7.1, 1.5}}";
        Var var1 = new Matrix(array);

        System.out.println(var1.toString());

    }

}
