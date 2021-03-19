package by.it.plehanova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        double sum = 0;

        for (double a = 0; a < 3; a += 0.2) {
            for (int x = 1; x < 7; x++) {
                sum = sum + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%4.2f Сумма y = %g\n", a, sum);
        }
        System.out.println();
    }

    private static void step2() {
        double a;
        double b;

        char ch = 'ɑ';

        for (double x = -5.5; x < 2; x += 0.5) {

            System.out.printf("При x/2=%5.2f ", x/2);
            if (x/2 > -2 && x/2 <= -1) {
                b = sin(x * x);

            } else if (x/2 > -1 && x/2 < 0.2) {
                b = cos(x * x);

            } else if (x/2 == 0.2) {
                b = 1 / tan(x * x);

            } else {
                System.out.println(" Значение b не найдено");
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.printf(" %c = %e\n", ch, a);
        }
    }
}
