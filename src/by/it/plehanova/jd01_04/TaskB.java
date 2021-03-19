package by.it.plehanova.jd01_04;

/*B1. Введите с консоли число людей n (nextInt() в сканере).
     Затем введите одномерный массив их фамилий (next() в сканере).
     Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
         Зарплаты имеют тип int.
         Нужно для каждой фамилии выводить подсказку
         После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
        сканере).

     Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
    итогом за год в последней колонке.
    
B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую
квартальную зарплату с точностью как минимум до 4-го знака .

 */

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число сотрудников >>");
        int numberOfPerson = scanner.nextInt();

        String[] lastNames = new String[numberOfPerson];

        System.out.println("Введите фамилии сотрудников");
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next();
        }

        int[][] salary = new int[numberOfPerson][4];

        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + lastNames[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scanner.nextInt();

            }
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s %-10s%-10s%-10s%-10s%-5s\n", " Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("---------------------------------------------------------");

        int sumPersonSalary;
        int sumTotal = 0;
        double average;

        for (int i = 0; i < salary.length; i++) {
            sumPersonSalary = 0;
            System.out.printf("%8s:  ", lastNames[i]);

            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sumPersonSalary += salary[i][j];
            }
            sumTotal += sumPersonSalary;
            System.out.printf("%-5d\n", sumPersonSalary);
        }
        System.out.println("---------------------------------------------------------");

        average = sumTotal / (numberOfPerson * 4.0);
        System.out.printf("%8s  % -10d\n%8s  % -9f", "Итого", sumTotal, "Средняя", average);
    }
}
