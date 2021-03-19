package by.it.plehanova.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {

        step1();
        step2();
        step3();

    }

    private static void step1() {

        double a = 756.13;
        double x = 0.3;

        double z;

        z = cos(Math.pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z);

    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;

        double y;

        y = tan(pow((a + b), 2));
        y = y - cbrt(a + 1.5);
        y = y + a * pow(b, 5);
        y = y - b / log(a * a);

        System.out.println(y);
    }

    private static void step3() {

        double x = 12.1;
        double f;

        for (double a = -5; a < 13; a += 3.75) {
            f = exp(a * x) - 3.45 * a;
            System.out.printf("%s=%5.2f %s=%g\n", "a", a, "f", f);

        }

    }
}
