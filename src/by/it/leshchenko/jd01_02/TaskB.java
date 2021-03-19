package by.it.leshchenko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();
        step2(scanner.nextInt());
        step3(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
    }

    private static void step1() {
        int n = 5; // количество строк и столбцов в матрице
        int number = 1; // стартовое число
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println("корней нет");
        } else if (d == 0) {
            System.out.println(-b / (2 * a));
        } else if (d > 0) {
            System.out.print((-b + Math.sqrt(d)) / (2 * a));
            System.out.print(" ");
            System.out.println((-b - Math.sqrt(d)) / (2 * a));
        }
    }
}
