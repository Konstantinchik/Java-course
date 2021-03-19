package by.it.evstratov.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {

        double y = 0;

        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7,a) - cos(x);
            }
            System.out.println(y);
        }

    }

    private static void step2(){

        for (double x = -5.5; x < 2; x = x + 0.5) {
            double alpha;
            double beta;
            if(x/2.0 > -2 && x/2.0 <= -1){
                System.out.println(x/2);
                beta = sin(x*x);
                alpha = log10(abs(beta+2.74));
                System.out.println("При x/2 = "+(x/2)+" alfa = "+alpha+", beta = "+beta);
            }else if(x/2.0 > -1 && x/2.0 < 0.2){
                beta = cos(x*x);
                alpha = log10(abs(beta+2.74));
                System.out.println("При x/2 = "+(x/2)+" alfa = "+alpha+", beta = "+beta);
            }else if(x/2.0 == 0.2){
                beta = 1/(tan(x*x));
                alpha = log10(abs(beta+2.74));
                System.out.println("При x/2 = "+(x/2)+" alfa = "+alpha+", beta = "+beta);
            }else {
                System.out.println("Вычисления не определены");
            }

        }

    }


}
