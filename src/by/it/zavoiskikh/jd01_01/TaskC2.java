package by.it.zavoiskikh.jd01_01;

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
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = num1 + num2;
        System.out.println("DEC:" + num1 + "+" + num2 + "=" + num3);

        System.out.println("BIN:" +Integer.toBinaryString(num1)+"+"+Integer.toBinaryString(num2)+"="+Integer.toBinaryString(num3));
        System.out.println("HEX:" +Integer.toHexString(num1)+"+"+Integer.toHexString(num2)+"="+Integer.toHexString(num3));
        System.out.println("OCT:" +Integer.toOctalString(num1)+"+"+Integer.toOctalString(num2)+"="+Integer.toOctalString(num3));
    }
}



