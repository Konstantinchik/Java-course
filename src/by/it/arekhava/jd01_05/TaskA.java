package by.it.arekhava.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }




    private static void step1(){



        double a=756.13;
        double x=0.3;

        double part1=cos(pow (x*x+PI/6.0,5));
        double part2=sqrt(x*pow(a,3));
        double part3=log(abs((a-1.12*x)/4.0));
        double z=part1-part2-part3;
        System.out.printf("For x=%f, z=%f, a=%f/n", a,x,z);


    }

    private static void step2() {
        double a=1.21;
        double b=0.371;

        double part1=tan(pow (a+b, 2.0));
        double part2=pow(a+1.5, 1/3.0);
        double part3=a*pow (b,5);
        double part4=b/log(a*a);
        double z=part1-part2+part3-part4;
        System.out.printf("For a=%f, b=%f, z=%f/n", a,b,z);

    }
    private static void step3() {
        double x=12.1;
        double a=-5;
        for (a = -5; a <=12 ; a=a+3.75) {
            double z=pow(E,a*x)-3.45*a;
            System.out.printf("For a=%f,  z=%f/n", a, z);

        }

    }
}
