package by.it.rydzeuski.jd01_01;

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


class TaskC2{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        int j=sc.nextInt();
        System.out.printf("DEC:%d+%d=%d\n",i,j,i+j);
        System.out.printf("BIN:%+%=%\n",i,j,i+j);
        System.out.printf("HEX:%x+%x=%x\n",i,j,i+j);
        System.out.printf("OCT:%o+%o=%o\n",i,j,i+j);
    }

}