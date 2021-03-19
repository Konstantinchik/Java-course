package by.it.tetenkov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(12);
        Var var2 = new Scalar("14");
        Var var3 = new Scalar((Scalar) var1);

        //B1
        double[] values = {1, 2, 3, 4, 5};
        Var var4 = new Vector(values);
        //B2
        Var var5 = new Vector((Vector) var4);
        //B3
        String strValues = "1.0, 2.0, 3.0";
        Var var6 = new Vector(strValues);

        System.out.println(var4.toString());
        System.out.println(var5.toString());
        System.out.println(var6.toString());
    }
}
