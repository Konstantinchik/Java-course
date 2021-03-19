package by.it.terentyev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите колличество людей: ");
        int n = sc.nextInt();
        String[] lastNames = new String[n];
        for (int i = 0; i < n; i++) {
            lastNames[i] = sc.next();
        }

        int[][] salary = new int[n][4];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + lastNames[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 54; i++)
            System.out.print("-");
        System.out.println();
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        for (int i = 0; i < 54; i++)
            System.out.print("-");
        System.out.println();
        int allSumSalary = 0;
        for (int i = 0; i < n; i++) {
            int sumSalary = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            allSumSalary = allSumSalary + sumSalary;
            System.out.printf("%-8s:%-10d%-10d%-10d%-10d%-5d%n", lastNames[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], sumSalary);
        }
        double midSalary = (double) allSumSalary / n / 4;
        for (int i = 0; i < 54; i++) System.out.print("-");
        System.out.println();
        System.out.printf("%-9s%-10d%n", "Итого", allSumSalary);
        System.out.printf("%-9s%-10.6f", "Средняя", midSalary);
    }
}

