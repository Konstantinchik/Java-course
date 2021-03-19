package by.it.zavoiskikh.jd01_05;

public class TaskB {

    public static void main(String[] args) {
        calcB1();
    }

    public static void calcB1() {
        double sum = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (double x = 1; x < 7; x++) {

                sum = sum + Math.pow(7, a) - Math.cos(x);
            }
                System.out.printf ("При a=%6.2f Сумма y=%10.10f\n", a,sum);
            }



        }


    }
