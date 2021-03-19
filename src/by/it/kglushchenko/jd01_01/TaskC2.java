package by.it.kglushchenko.jd01_01;

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
import java.util.Scanner;

class TaskC2 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner num = new Scanner(System.in);
        a = num.nextInt();
        b = num.nextInt();
        c = a + b;
        System.out.printf("DEC:%d+%d=%d\n",a,b,c);
        System.out.println("BIN:"+Integer.toString(a,2)+"+"+Integer.toString(b,2)+"="+ Integer.toString(c,2));
        System.out.printf("HEX:%x+%x=%x\n",a,b,c);
        System.out.printf("OCT:%o+%o=%o\n",a,b,c);

    }



}
