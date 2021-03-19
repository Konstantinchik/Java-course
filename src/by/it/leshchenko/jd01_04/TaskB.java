package by.it.leshchenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        // Ввод данных
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastnames = new String[n]; // Создаём массив с фамилиями
        for (int i = 0; i < n; i++) {
            lastnames[i] = scanner.next();
        }
        int[][] salaries = new int[n][4]; // Создаём массив с зарплатами
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите зарплату для %s\n", lastnames[i]);
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = scanner.nextInt();
            }
        }

        // Вывод таблицы
        int sums = 0;
        String separator = "------------------------------------------------------------";
        System.out.println(separator);
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(separator);

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += salaries[i][j];
            }
            sums += sum;
            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d\n", lastnames[i], salaries[i][0], salaries[i][1], salaries[i][2], salaries[i][3], sum);
        }

        System.out.println(separator);
        System.out.printf("%-10s%-10d\n", "Итого", sums);
        double average = (double) sums / n / 4;
        System.out.printf("%-10s%-10.4f\n", "Средняя", average);
    }
}
