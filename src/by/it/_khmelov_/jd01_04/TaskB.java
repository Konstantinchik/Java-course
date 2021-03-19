package by.it._khmelov_.jd01_04;

import java.util.Scanner;

@SuppressWarnings("MismatchedReadAndWriteOfArray")
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] lastNames = new String[count];
        int[][] salary = new int[count][4];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next();
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("Укажите зарпалату для %s\n", lastNames[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int total=0;
        //etc
        //etc
        //etc
        //etc
        //etc
    }
}
