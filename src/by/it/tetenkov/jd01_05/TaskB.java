package by.it.tetenkov.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        stepOne();
        System.out.println();
        stepTwo();
    }

    private static void stepTwo() {

        double x = -6.0;
        double a = 0;

        for (x = -5.5; x < 2; x += 0.5) {
            if (-2 < x / 2 && x / 2 <= -1) {
                a = log10(abs(sin(pow(x, 2)) + 2.74));
                System.out.printf("При x/2=%f a=%f\n", x / 2, a);
            } else if (-1 < x / 2 && x / 2 < 0.2) {
                a = log10(abs(cos(pow(x, 2)) + 2.74));
                System.out.printf("При x/2=%f a=%f\n", x / 2, a);
            } else if (x / 2 == 2) {
                a = log10(abs(1 / tan(pow(x, 2)) + 2.74));
                System.out.printf("При x/2=%f a=%f\n", x / 2, a);
            } else {
                System.out.printf("При x/2=%f вычисления не определены\n", x / 2);
            }

        }
    }

    private static void stepOne() {
        double a = 0;
        double x = 1;
        double y = 0;

        for (a = 0; a <= 2; a += 0.2) {
            for (x = 1; x < 7; x += 1) {
                y += pow(7, a) - cos(x);

            }
            System.out.printf("При a = %f Сумма y = %f\n", a, y);
        }

    }
}
