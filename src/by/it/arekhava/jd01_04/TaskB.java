package by.it.arekhava.jd01_04;


import java.math.BigDecimal;
import java.util.Scanner;

public class TaskB {


    public static void main(String[] args) {
        Scanner scan=new Scanner (System.in);
        int n = scan.nextInt();
        String[] lastNames=new String[n];

        for (int i = 0; i <lastNames.length; i++) {
            lastNames[i]=scan.next();
        }

        int[][] salary= new int[n][4];

        for (int i = 0; i < lastNames.length; i++) {
            String currentLastName = lastNames[i];
            System.out.println("Введите зарплату для " + currentLastName);

            for (int j = 0; j < 4; j++) {
                int inputSalary = scan.nextInt();
                salary[i][j] = inputSalary;
            }
        }

        System.out.println("Фамилия  Квартал1  Квартал2 Квартал3 Квартал4  Итог ");

        int total = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            System.out.print(lastNames[i] + ": ");
            for (int j = 0; j < 4; j++) {
                int currentSalary = salary[i][j];
                sum += currentSalary;
                System.out.print(currentSalary + "    ");
            }
            total+=sum;
            System.out.println(sum);
        }
        System.out.println("Итого " + total);
        double averageSalary = ((double)total)/(n * 4);
        System.out.printf("Средняя %.4f", averageSalary);
    }
}
