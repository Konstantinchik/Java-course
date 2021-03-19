package by.it.novik.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner scanner =new Scanner(System.in);
        System.out.print("Введите число от 1 до 12 ");
        int month = scanner.nextInt();
        step2(month);
        System.out.print("Введите первый коэффициент ");
        double a = scanner.nextDouble();
        System.out.print("Введите второй коэффициент ");
        double b = scanner.nextDouble();
        System.out.print("Введите третий коэффициент ");
        double c = scanner.nextDouble();
        step3( a, b, c);
    }

    private static void step1() {
        for (int i = 0; i <=25 ; i++) {
            System.out.print(i+" ");
            if (i % 5 == 0) System.out.println();
        }
    }

    private static void step2(int month) {
        String mes;
        switch (month) {
            case 1:  mes = "январь";break;
            case 2:  mes = "февраль";break;
            case 3:  mes = "март";break;
            case 4:  mes = "апрель";break;
            case 5:  mes = "май";break;
            case 6:  mes = "июнь";break;
            case 7:  mes = "июль";break;
            case 8:  mes = "август";break;
            case 9:  mes = "сентябрь";break;
            case 10: mes = "октябрь";break;
            case 11: mes = "ноябрь";break;
            case 12: mes = "декабрь";break;
            default: mes = "нет такого месяца";break;
        }
        System.out.println(mes);

    }

    private static void step3(double a, double b, double c) {
        double disk=(Math.pow(b, 2))-(4*a*c);
        if (disk>0) {
            double x1=(-b+Math.sqrt(disk))/(2*a);
            double x2=(-b-Math.sqrt(disk))/(2*a);
            System.out.println("у уравнения два корня. x1 = "+ x1 + ". x2 = " + x2);
        } else if (disk==0) {
            double x1=-b/(2*a);
            System.out.println("корень один и равен "+x1);
        } else {
            System.out.println("корней нет");
        }
    }



}




