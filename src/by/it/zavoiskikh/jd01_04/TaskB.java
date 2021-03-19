package by.it.zavoiskikh.jd01_04;
import java.util.Scanner;
import java.util.Arrays;
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastName = new String[n];
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            lastName[i] = scanner.next();
        }
        for (int i = 0; i < salary.length; i++) {

            System.out.println("Введите зарплату для" + " " + lastName[i]);
            for (int j = 0; j < salary[i].length; j++) {

                salary[i][j] = scanner.nextInt();
            }
            System.out.println();


        }

        int sum = 0;
        for (int i = 0; i < salary.length; i++) {

            sum=0;

            for (int j = 0; j < salary[i].length; j++) {
                sum = sum + salary[i][j];
            }

            System.out.print(sum);
            System.out.println ();

        }








        }

        }








