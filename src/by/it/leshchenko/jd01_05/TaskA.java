package by.it.leshchenko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        TaskA1();
        TaskA2();
        TaskA3();
    }

    private static void TaskA1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log((a - 1.12 * x) / 4);
        double z = part1 - part2 - part3;
//        double z = cos(pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log((a - 1.12 * x) / 4);
        System.out.println(z);
    }

    private static void TaskA2() {
        double a = 1.21;
        double b = 0.371;
        double part1 = tan(pow(a + b, 2));
        double part2 = cbrt(a + 1.5);
        double part3 = a * pow(b, 5);
        double part4 = b / log(a * a);
        double z = part1 - part2 + part3 - part4;
//        double z = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log(a * a);
        System.out.println(z);
    }

    private static void TaskA3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("При a = %4.2f f = %g\n", a, f);
        }
    }
}
