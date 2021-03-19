package by.it.novik.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int i = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int c = scanner.nextInt();

        System.out.println("DEC:" + i + "+" + c + "=" + (i + c));
        System.out.println("BIN:" + Integer.toBinaryString(i) + "+" + Integer.toBinaryString(c) + "=" + Integer.toBinaryString((i + c)));
        System.out.println("HEX:" + Integer.toHexString(i) + "+" + Integer.toHexString(c) + "=" + Integer.toHexString((i + c)));
        System.out.println("OCT:" + Integer.toOctalString(i) + "+" + Integer.toOctalString(c) + "=" + Integer.toOctalString((i + c)));
    }
}
