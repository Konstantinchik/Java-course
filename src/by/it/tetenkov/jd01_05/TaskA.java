package by.it.tetenkov.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        stepone();
        steptwo();
        stepthree();
    }

    private static void stepthree() {
        double x = 12.1;
        double a = -5.0;

        for (int i = -5; a < 12; i += 3.75) {
            double part1 = pow(E, a * x);
            double part2 = 3.45 * a;
            double f = part1 - part2;
            System.out.printf("При a= %.2f f=%f\n", a, f);

            a += 3.75;


        }


    }

    private static void steptwo() {

        double a = 1.21, b = 0.371;

        double part1 = tan((pow(a,2)) + (2 * a * b) + (pow(b,2)));
        double part2 = cbrt(a + 1.5);
        double part4 = a * (pow(b, 5));
        double part3 = b / ((log(pow(a, 2))));

        double y = part1 - part2 + part4 - part3;
        System.out.printf("For a=%f b=%f y=%f", a, b, y);
        System.out.println();

    }

    private static void stepone() {
        double a = 756.13;
        double x = 0.3;

        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.printf("For x=%f a=%f z=%f\n", a, x, z);


    }
}
