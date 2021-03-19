package by.it.staniko.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastNames = new String[n];
        int[][] salary = new int[n][4];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next();
        }
        for (int i = 0; i < lastNames.length; i++) {
            System.out.println("Введите зарплату для " + lastNames[i]);

            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        System.out.printf("%s %s %s %s %s%n", "фамилия", "квартал 1", "квартал 2", "квартал 3", "квартал 4");
        //System.out.println();
        int amount=0;
        for (int i = 0; i < lastNames.length; i++) {
            System.out.printf("%s: ",lastNames[i]);
            int sum = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%d ", salary[i][j]);
                //    int sum = 0;
                sum += salary[i][j];
                amount+=salary[i][j];
                //System.out.println(sum);
            }
            System.out.printf("%d%n", sum);
            //System.out.println("Итого" + it );

            //System.out.println();
        }
        System.out.println("Итого " + amount );
        double average=0;
        average=amount/(n*4.0);
        System.out.printf("Средняя %.4f",average );

        //for (int i = 0; i <lastNames.length ; i++) {

        //}



    }
}
