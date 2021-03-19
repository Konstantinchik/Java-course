package by.it.soldatenko.jd01_05;

import static java.lang.Math.*;


public class TaskA {
    public static void main(String[] args) {
        Step1();
        Step2();
        Step3();
    }

    private static void Step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow((x * x + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.printf("For x=%f a =%f z=%f\n", a, x, z);
    }

    private static void Step2() {
        double a = 1.21;
        double b = 0.371;
        double one_3 = (double) 1 / 3;
        double y = tan((a + b) * (a + b)) - pow((a + 1.5), one_3) + a * pow(b, 5) - (b / (log(a * a)));
        System.out.printf("For x=%f a =%f z=%f\n", a, b, y);
    }

    private static void Step3() {
        double x = 12.1;
        double deltaA = 3.75;
        double hi = 12;
        double a = -5;
        while (a <= hi) {
            double f = pow(E, a * x) - 3.45 * a;
            System.out.printf("For a=%f f =%f\n", a, f);
            a = a + deltaA;

        }

    }


}
