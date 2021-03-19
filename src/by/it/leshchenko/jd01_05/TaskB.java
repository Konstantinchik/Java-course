package by.it.leshchenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        TaskB1();
        TaskB2();
    }

    private static void TaskB1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a = %.2f сумма y = %e\n", a, y);
        }
    }

    private static void TaskB2() {
        double step = 0.5;
        for (double x = -6 + step; x < 2; x += step) {
            double b;
            if (-2 < x / 2 && x / 2 <= -1) {
                b = sin(x * x);
            } else if (-1 < x / 2 && x / 2 <= 0.2) {
                b = cos(x * x);
            } else if (x / 2 == 0.2) {
                b = tanh(x * x);
            } else {
                System.out.printf("При x/2=%.2f вычисления не определены\n", x / 2);
                continue;
            }
            double a = log10(b + 2.74);
            System.out.printf("При x/2=%.2f a = %e\n", x / 2, a);
        }
    }
}
