package by.it.terentyev.jd01_01;

import java.util.Scanner;

import static java.lang.Integer.*;

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
        Scanner sc;
        sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int p = i + j;
        String bi = toBinaryString(i);
        String bj = toBinaryString(j);
        String bp = toBinaryString(p);
        System.out.println("DEC:" + i + "+" + j + "=" + p);
        System.out.println("BIN:" + bi + "+" + bj + "=" + bp);
        System.out.println("HEX:" + toHexString(i) + "+" + toHexString(j) + "=" + toHexString(p));
        System.out.println("OCT:" + toOctalString(i) + "+" + toOctalString(j) + "=" + toOctalString(p));
    }
}
