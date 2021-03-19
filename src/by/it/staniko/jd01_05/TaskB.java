package by.it.staniko.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1(){
        double y=0;
        double result;

        for (double a = 0; a <=2 ;a=a+0.2) {
            for (int x = 1; x <=6 ; x++) {
                result=pow(7,a)-cos(x);
                y+=result ;
//                System.out.printf("For a=%f,x=%d y=%f",a,x,y);

            }
            System.out.printf("For a=%1.2f,y=%f%n",a,y);

        }

    }

    private static void step2(){
        double b=0;
        double a=0;//log(abs(b+2.74));
        for (double x = -5.5; x < 2;x= x+0.5) {
            if (x/2>-2 && x/2<=-1 ){
                b=sin(pow(x,2));
                a=log10(abs(b+2.74));
                System.out.printf("For x/2=%.2f a=%g%n",x/2,a);
            }
            else if (x/2>-1 && x/2<0.2 ){
                b=cos(pow(x,2));
                a=log10(abs(b+2.74));
                System.out.printf("For x/2=%.2f a=%g%n",x/2,a);
            }
            else if (x/2==0.2 ){
                b=1/tan(pow(x,2));
                a=log10(abs(b+2.74));
                System.out.printf("For x/2=%.2f a=%g%n",x/2,a);
            }
            else System.out.printf("For x/2=%.2f вычисления не определены%n",x/2,a);
            //double a=log(abs(b+2.74));
           // System.out.printf("For x/2=%f, b=%f a=%g",x,b,a);
        }
    }
}

