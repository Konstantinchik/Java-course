package by.it.arekhava.jd01_01.jd01_01;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

import static java.lang.Math.*;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
class TaskC3<weightMars> {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();

        System.out.println(getWeight(weight));
    }

    public static double getWeight(int weight) {

        double gravityMars = 3.86;
        double gravityEarth = 9.81;
        double marsWeight;

        marsWeight = weight * gravityMars / gravityEarth;

        int digit;
        double number;

        digit = (int) (marsWeight * 1000 % 10);

        if (digit < 5) {
            number = (int) (marsWeight * 100) / 100.0;
        } else {
            number = ((int) (marsWeight * 100 + 1)) / 100.0;
        }

        return number;
    }
}