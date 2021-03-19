package by.it.kglushchenko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] arg){
        step1();

        double a,b,c;
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        step2(month);

        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        step3(a, b, c);
    }

    private static void step1(){

        for (int i = 0; i <= 25; i++) {
            System.out.print(i + " ");
            if(i%5 == 0) System.out.println();
        }
        //
    }

    private static void step2(int month){
        String sMonth;
        switch(month){
            case 1: sMonth = "январь";
                break;
            case 2: sMonth = "февраль";
                    break;
            case 3: sMonth = "март";
                break;
            case 4: sMonth = "апрель";
                break;
            case 5: sMonth = "май";
                break;
            case 6: sMonth = "июнь";
                break;
            case 7: sMonth = "июль";
                break;
            case 8: sMonth = "август";
                break;
            case 9: sMonth = "сентябрь";
                break;
            case 10: sMonth = "октябрь";
                break;
            case 11: sMonth = "ноябрь";
                break;
            case 12: sMonth = "декабрь";
                break;

            default: sMonth = "нет такого месяца";
        }
        System.out.println(sMonth);
    }

    private static void step3(double a, double b, double c) {
        double disc = b * b - 4 * a * c;
        if (disc < 0) {
                  System.out.println("корней нет");
        } else if(disc==0){
            double x = -b / ( 2 * a );
            System.out.println(x);
        } else {
            double x1 = (-b + Math.sqrt(disc) / (2*a));
            double x2 = (-b - Math.sqrt(disc) / (2*a));
            System.out.println(x1 + " " + x2);
        }
    }
}
