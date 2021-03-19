package by.it.novik.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for(double a=0; a<=2;a=a+0.2) {
            double y = pow(7,a)*6;
            for (int x = 1; x <=6; x++) {
                y=y-cos(x);
            }
            System.out.printf("При а =%6.2f y=%g\n", a, y);
        }
    }

    private static void step2() {
        for (double x=-5.5; x<2 ; x=x+0.5) {
            if (((x/2)>-2)&&((x/2)<=-1)){
                double a = sin(pow(x,2));
                a=a+2.74;
                a=abs(a);
                a=log10(a);
                System.out.printf("При x/2 =%5.2f a=%f\n", x/2, a);
            }else if (((x/2)>-1)&&((x/2)<0.2)){
                double a=log10(abs(cos(pow(x,2))+2.74));
                System.out.printf("При x/2 =%5.2f a=%f\n", x/2, a);
            }else if ((x/2)==0.2){
                double a=log(abs(1/(tan(x*x))+2.74));
                System.out.printf("При x/2 =%5.2f a=%f\n", x/2, a);
            }else{
                System.out.printf("При x/2 =%5.2f вычисления не определены\n", x/2);
            }
        }
    }
}
