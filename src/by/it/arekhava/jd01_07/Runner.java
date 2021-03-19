package by.it.arekhava.jd01_07;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.sql.SQLOutput;

public class Runner {
    public static void main(String[] args) {
        Var v1=new Scalar(3.14);
        Var v2=new Scalar ( "12.5");
        Var v3=new Scalar (new Scalar (3.7));
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
        System.out.println();
        Var v4=new Vector(new double[] {1.9,2.78,4.90});
        Var v5=new Vector ("{2.45, 4.78, 8.90}");
        Var v6=new Vector(new double[] {2.8,2.78,4.90});
        System.out.println(v4.toString());
        System.out.println(v5.toString());
        System.out.println(v6.toString());
    }

}
