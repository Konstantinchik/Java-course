package by.it.soldatenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step1() {
        double a = 0;
        double hi = 2;
        double deltaA = 0.2;
        double y = 0;
        while (a <= hi) {
            for (int x = 1; x < 7; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("For a=%f y =%f\n", a, y);

            a = a + deltaA;

        }

    }

    private static void step2() {
        double hi = 2;
        double x = -6;
        double deltaX = 0.5;
        while (x <= hi) {
            if ((x / 2) > -2 && (x / 2) <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("For x/2=%f a =%f\n", (x / 2), a);
            }
            if ((x / 2) > -1 && (x / 2) < 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("For x/2=%f a =%f\n", (x / 2), a);
            }
            if ((x / 2) == 0.2) {
                double b = cos(x * x);
                double a = atan(abs(b + 2.74));
                System.out.printf("For x/2=%f a =%f\n", (x / 2), a);
            }


            x = x + deltaX;

        }
    }
}
