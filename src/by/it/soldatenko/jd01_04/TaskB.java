package by.it.soldatenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int n =3;
        System.out.println(n);
        String[] lastName = new String[n];
        for (int i = 0; i < n; i++) {
            lastName[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
//       String[] lastName = {"пп","аа","ss"};
//       int [][] salary = {{10,20,30,40},{20,30,40,50},{30,40,50,60}};
        int [] sumYearSalary = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                sumYearSalary[i] = sumYearSalary[i] + salary[i][j];
            }
        }
        System.out.printf("%-10S%-10S%-10S%-10S%-10S%-5S","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s: %-10d%-10d%-10d%-10d%-10d",lastName[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3],sumYearSalary[i]);
            System.out.println();


        }
        for (int i = 0; i < n; i++) {
            total = total + sumYearSalary[i];
        }
        double middleSalary = (double) total/(n*4);
        System.out.printf("%-10s%-10d", "Итого",total);
        System.out.println();
        System.out.printf("%-10s%-10f", "Средняя",middleSalary);
    }
}
