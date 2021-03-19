package by.it.staniko.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Var var1=new Scalar(12);
        Var var2=new Scalar("14");
        Var var3=new Scalar((Scalar)var1);

        double[] vecValue={1, 2, 3, 4};
        Vector var4=new Vector(vecValue);
        Vector var5=new Vector((Vector)var4);
        Vector var6 = new Vector("{1.0,2.0,4.0}");

        double[][] matrixValue={{1, 2},{ 3, 4}};
        Matrix var7=new Matrix(matrixValue);
        Matrix var8=new Matrix((Matrix) var7);
     //   Matrix var9 = new Matrix("{{1.0,2.0},{4.0,6.0}}");


        System.out.println(var1.toString());
        System.out.println(var2.toString());
        System.out.println(var3.toString());
        System.out.println(var4.toString());
        System.out.println(var5.toString());
        System.out.println(var6.toString());
        System.out.println(var7.toString());
        System.out.println(var8.toString());

    }
}
