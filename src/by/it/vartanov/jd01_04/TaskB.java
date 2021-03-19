package by.it.vartanov.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] lastNames = new String[n];
        for(int i=0; i < lastNames.length; i++){
            lastNames[i]= sc.next(); // вводим фамилии
        }

        int[][] salary = new int[n][4];
        int[] sumsalary = new int[n];
        int totalsalary=0;

        for(int i=0; i < lastNames.length; i++){
            System.out.println("Введите зарплату для "+lastNames[i]);

            for(int j=0; j < 4; j++){
                String str = sc.next();
                String[] numbers = str.split(" ");
                for(int k=0; k< numbers.length; k++) {
                    salary[i][j] = Integer.parseInt(numbers[k]);
                }
            }
        }

        // Проверяем зарплату - работает
        /*
        for(int i=0; i < lastNames.length; i++) {
            for (int j = 0; j < 4; j++) {

                System.out.print(salary[i][j] + " ");

            }
            System.out.println();
        }*/

       //
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n","Фамилия", "Квартал1", "Квартал2", "Квартал3","Квартал4","Итого");
        System.out.println("-------------------------------------------------------");
        //int sum=0;
        for(int i=0; i < lastNames.length; i++) {
            int sum=0;
            for(int k=0; k < 4; k++ ){
                sum+=salary[i][k];
            }
            sumsalary[i] = sum;
            totalsalary += sum;
            System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5d%n", lastNames[i], salary[i][0],  salary[i][1],  salary[i][2],  salary[i][3], sum);
        }
        System.out.println("-------------------------------------------------------");
       //
        System.out.printf("%-9s%-10d%n","Итого", totalsalary);
        System.out.printf("%-9s%-10.5f%n","Средняя", ((double)totalsalary/(n*4)));
        System.out.println("-------------------------------------------------------");
    }
}
