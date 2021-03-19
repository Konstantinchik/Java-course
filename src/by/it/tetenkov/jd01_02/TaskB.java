package by.it.tetenkov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int month = scanner.nextInt();

    double a = scanner.nextInt();
    double b = scanner.nextInt();
    double c = scanner.nextInt();


    step1();
    step2(month);
    step3(a,b,c);



}
    private static void step3(double a, double b, double c){
    double d = (b * b) - (4 * a * c);
        System.out.println("вот " + d);

        if (d > 0){
            double sqrt_one = (-b + Math.sqrt(d)) / (2 * a);
            double sqrt_two = (-b - Math.sqrt(d)) / (2 * a);

            System.out.print(sqrt_one);
            System.out.print(sqrt_two);
            System.out.println();
        }
        else if (d == 0){
            double sqrt_one = -b / (2 * a);
            System.out.print(sqrt_one);
            System.out.println();
        }
        else {
            System.out.print("корней нет");
        }
    }

    private static void step2(int month) {

        switch (month){
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

    private static void step1() {
        int value = 0;
        for (int i = 0; i < 5; i++){
            for (int n = 0; n < 5; n++){
                value++;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


// в классе InOut было throw IOException. что это значит?