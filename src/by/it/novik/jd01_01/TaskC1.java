package by.it.novik.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int i=scanner.nextInt();
        System.out.print("Введите второе число: ");
        int c=scanner.nextInt();

        System.out.println("Sum = " + (i+c));
    }




}
