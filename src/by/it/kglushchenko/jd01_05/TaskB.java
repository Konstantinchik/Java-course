package by.it.kglushchenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        step1();
        step2();
    }

    static void step1() {
        double y = 0;
        double a = 0;
        double da = 0.2;
        int x;

        //(S x=1 -> 6)
        for (x = 1; x <= 6; x++) {

            // ( 0 <= a <= 10 )
            //for (int i = 0; i <= 10; i++) {
            y += (pow(7, a) - cos(x));
            a += da;
            System.out.println(y);
            //}
        }
    }

    static void step2() {
        double beta = 0;
        double alfa =0;


        for (double x = -5.999999999999999; x < 2; x+=0.5) {
            if (x / 2 > (-2) && (x / 2) <= (-1)) {
                beta = sin(pow(x, 2));
                alfa = log(abs(beta+0.27));
                System.out.println("x = "+x);
                System.out.println("beta = "+beta);
                System.out.println("alfa = "+ alfa);
            } else if (x / 2 > (-1) && (x / 2) < 0.2){
                beta = cos(pow(x, 2));
                alfa = log(abs(beta+0.27));
                System.out.println("x = "+x);
                System.out.println("beta = "+beta);
                System.out.println("alfa = "+ alfa);
            } else if (round(x / 2) == 0.2){
                beta = 1/tan(pow(x, 2));
                alfa = log(abs(beta+0.27));
                System.out.println("x = "+x);
                System.out.println("beta = "+beta);
                System.out.println("alfa = "+ alfa);
            }
        }
    }
}
