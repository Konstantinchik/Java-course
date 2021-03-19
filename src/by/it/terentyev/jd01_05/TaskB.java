package by.it.terentyev.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();


    }

    private static void step1() {

            double y = 0;
            double a;
        for (a = 0; a<=2; a=a+0.2) {
            for (double x = 1; x <= 6; x++) {

                   y= y+(pow(7, a)-cos(x));

                    }
                 System.out.println("При а = "+a+" Сумма y = "+y);
            y = 0;
        }



    }


    private static void step2() {
        double a;
        double b;
        for (double x = -6; x < 2; x=x+0.5) {
            double xi = x / 2;
            if (-2 < xi && xi <= -1) {
                b=sin(x*x);
                a=log10(abs(b+2.74));
                System.out.println(a);
            }
            else if (-1 < xi && xi < 0.2) {
                b=cos(x*x);
                a=log10(abs(b+2.74));
                System.out.println(a);
            }
            else if (xi == 0.2) {
                b = cos(x * x) / sin(x * x);
                a=log10(abs(b+2.74));
                System.out.println(a);
            }
            else System.out.println("не допустимое значение");



        }
    }
}
