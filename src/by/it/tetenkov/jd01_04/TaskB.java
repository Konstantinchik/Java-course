package by.it.tetenkov.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] lastnames = new String[n];
        for (int i = 0; i < lastnames.length; i++) {
            lastnames[i] = scanner.next();
        }

        int[][] salaries = new int[n][4];
        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Ввведите зарплату сотрудника " + lastnames[i] + ": ");
            for (int j = 0; j < salaries[0].length; j++) {
                salaries[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        int greatsum = 0;

        for (int i = 0; i < salaries.length; i++) {
            int kv_sum = 0;
            System.out.printf("%s: ", lastnames[i]);
            for (int j = 0; j < salaries[0].length; j++) {

                System.out.printf("%d ", salaries[i][j]);
                kv_sum += salaries[i][j];

            }
            System.out.printf("%d ", kv_sum);
            System.out.println();
            greatsum += kv_sum;
        }

        double avg = (double) greatsum / ((double) salaries.length * (double) salaries[0].length);
        System.out.printf("Итого %s", greatsum);
        System.out.println();
        System.out.printf("Cредняя %.4f", avg);
        System.out.println();

    }

}
