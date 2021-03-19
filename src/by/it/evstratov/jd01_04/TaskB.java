package by.it.evstratov.jd01_04;


import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countPeople = scanner.nextInt();
        String[] arraySecondNamesPeople = new String[countPeople];
        for (int i = 0; i < countPeople; i++) {
            arraySecondNamesPeople[i] = scanner.next();
        }

        int[][] salaries = new int[arraySecondNamesPeople.length][4];
        for (int i = 0; i < arraySecondNamesPeople.length; i++) {
            System.out.printf("Введите зарплату для %s\n", arraySecondNamesPeople[i]);
            for (int j = 0; j <4; j++) {
                salaries[i][j] = scanner.nextInt();
            }
        }
        //System.out.println("Фамилия Квартал1 Квартал2 Квартал3 Квартал4 Итого");
        System.out.printf("%8s %-7s %-7s %-7s %-7s %-7s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        int totalPayments = 0;
        int allSalaries = 0;
        for (int i = 0; i < salaries.length; i++) {
            int sum = 0;
            for (int j = 0; j < salaries[0].length; j++) {
                sum += salaries[i][j];
                allSalaries++;
            }
            System.out.printf("%7s: %-8d %-8d %-8d %-8d %-8d\n", arraySecondNamesPeople[i], salaries[i][0], salaries[i][1], salaries[i][2], salaries[i][3], sum);
            totalPayments += sum;
        }
        double averageSalary = (double) totalPayments/(double) allSalaries;
        System.out.printf("%-8s %-7d\n", "Итого", totalPayments);
        System.out.printf("%-8s %-7.4f", "Средняя", averageSalary);

    }

}
