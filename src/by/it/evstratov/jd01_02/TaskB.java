package by.it.evstratov.jd01_02;

import java.util.Scanner;

public class TaskB {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        step1();
        step2(x);
        step3(a,b,c);

    }

    private static void step3(double a, double b, double c){

        double d = b*b - 4*a*c;
        double sqrt1=0;
        double sqrt2=0;

        if(d<0){
            System.out.println("корней нет");
        }else if(d==0){
            sqrt1 = (-b + Math.sqrt(d))/(a*2);
            System.out.println(sqrt1);
        }else if(d>0){
            sqrt1 = (-b - Math.sqrt(d))/(a*2);
            sqrt2 = (-b + Math.sqrt(d))/(a*2);
            System.out.println(sqrt1);
            System.out.println(sqrt2);
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
                break;
        }

    }

    private static void step1() {

        for (int i = 1; i <= 25; i++) {
            if(i % 5 == 0){
                System.out.print(i + " ");
                System.out.println();
            }else{
                System.out.print(i + " ");
            }
        }
    }
    

}
