package by.it.arekhava.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        Step4();
        Step5();
    }
    private static void Step4() {
        double sum = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (double x = 1; x <= 6; x++) {
                sum =sum+(pow(7, a) - cos(x));
            }
                System.out.printf("For a=%2f, sum=%3e", a, sum);
                System.out.println();
        }
    }
    private static void Step5() {
        for (double x = -6; x <2 ; x=x+0.5) {
            if (x > -4 && x <= -2) {
                double betta = sin(x * x);
                double alfa=log10(abs(betta+2.74));
                {
                    System.out.println( alfa);}
            } else if (x > -2 && x < 0.4) {
                double betta = cos(x * x);

                double alfa=log10(abs(betta+2.74));
                {
                    System.out.println( alfa);}
            } else if (x == 0.4) {
                double betta = 1 / tan(x * x);

                double alfa=log10(abs(betta+2.74));
                {
                    System.out.println( alfa);}
            } else if (-6 < x && x <= -4) {
                System.out.println("вычисления не определены");
            } else if ( x < 2 && x > 0.4) {
                System.out.println("вычисления не определены");
            }
        }
    }
//"При x/2=-2,75 вычисления не определены\n" +
//                "При x/2=-2,50 вычисления не определены\n" +
//                "При x/2=-2,25 вычисления не определены\n" +
//                "При x/2=-2,00 вычисления не определены\n" +
//                "При x/2=-1,75 a = 3,****62e-01\n" +
//                "При x/2=-1,50 a = 4,****25e-01\n" +
//                "При x/2=-1,25 a = 4,****95e-01\n" +
//                "При x/2=-1,00 a = 2,****60e-01\n" +
//                "При x/2=-0,75 a = 3,****82e-01\n" +
//                "При x/2=-0,50 a = 5,****39e-01\n" +
//                "При x/2=-0,25 a = 5,****66e-01\n" +
//                "При x/2=0,00 a = 5,****16e-01\n" +
//                "При x/2=0,25 вычисления не определены\n" +
//                "При x/2=0,50 вычисления не определены\n" +
//                "При x/2=0,75 вычисления не определены");
}
