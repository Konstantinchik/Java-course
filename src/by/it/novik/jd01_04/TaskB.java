package by.it.novik.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество людей: ");
        int a=scanner.nextInt();

        String[] surname = new String[a];
        for (int i = 0; i < a; i++) {
            System.out.print("Введите фамилию: ");
            String names = scanner.next();
            surname[i] = names;
            }

        int[][] arrr = new int[a][4];
        for (int i = 0; i < a; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < 4; j++) {
                int pay = scanner.nextInt();
                arrr[i][j]=pay;
            }
        }

        int[]summ = new int[4];
        for (int i = 0; i < arrr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arrr[i].length; j++) {
                sum += arrr[i][j];
            }
            summ[i] = sum;
        }

        int sumv=0;
        for (int i=0; i<arrr.length; i++) {
            for (int j = 0; j < arrr[i].length; j++) {
                sumv=sumv+arrr[i][j];
            }
        }

        double length = a*4;
        double average=sumv/length;

        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------");


        for (int i = 0; i < a; i++) {
                System.out.printf("%-12s%-10d%-10d%-10d%-10d%-10d%n", surname[i], arrr[i][0], arrr[i][1], arrr[i][2], arrr[i][3], summ[i]);
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10d%n", "Итого", sumv);
        System.out.printf("%-10s%-10.4f\n", "Средняя", average);

    }
}
