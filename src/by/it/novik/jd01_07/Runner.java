package by.it.novik.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var s1=new Scalar(3.1415);
        Var s2=new Scalar("3.1415");
        Var s3=new Scalar(new Scalar(3.1415));

        Var v1=new Vector(new double[]{1,2,4});
        Var v3=new Vector("{1,2,4}");

        Var m1=new Matrix(new double[][]{{1,2},{3,4}});


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(v1);
        System.out.println(v3);
        System.out.println(m1);
    }
}
