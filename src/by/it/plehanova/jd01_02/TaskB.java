package by.it.plehanova.jd01_02;

/*В классе TaskB (пакет by.it.familiya.jd01_02) создайте Scanner и методы:

static void step1()
static void step2(int month)
static void step3(double a, double b, double c)

вызовите их один раз из метода main. Эти методы решают такие задачи:

1. step1() выводит числа от 1 до 25 в виде матрицы N x N слева направо и
сверху вниз (т.е. N = 5). После каждого числа один пробел.

2. В main ввести с консоли через объект типа Scanner число от 1 до 12 и с
ним вызвать метод step2(int month), который выводит на консоль русское
название месяца строчными буквами, соответствующего этому числу через
switch. Сообщить об ошибке “нет такого месяца” для некорректных чисел
во вводе (это должна быть default – ветка для switch).

3. Рассчитайте и выведите корни (или один корень) квадратного уравнения.
Если корня нет, то нужно вывести сообщение “корней нет”.
Параметры (a b c) уравнения нужно вводить в main через тот же Scanner и
затем передавать в метод step3(double a, double b, double c).
Для извлечения D используйте метод Math.sqrt(дискриминант)*/

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        step1();

        int numberOfMonth;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца >>");
        numberOfMonth = scanner.nextInt();

        step2(numberOfMonth);

        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();

        step3(a, b, c);
    }

    private static void step1() {
        for (int i = 1; i <= 25; i++) {
            if ((i - 1) % 5 == 0) {
                System.out.println();
            }
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    private static void step2(int month) {
        switch (month) {
            case (1): {
                System.out.println("январь");
                break;
            }
            case (2): {
                System.out.println("февраль");
                break;
            }
            case (3): {
                System.out.println("март");
                break;
            }
            case (4): {
                System.out.println("апрель");
                break;
            }
            case (5): {
                System.out.println("май");
                break;
            }
            case (6): {
                System.out.println("июнь");
                break;
            }
            case (7): {
                System.out.println("июль");
                break;
            }
            case (8): {
                System.out.println("август");
                break;
            }
            case (9): {
                System.out.println("сентябрь");
                break;
            }
            case (10): {
                System.out.println("октябрь");
                break;
            }
            case (11): {
                System.out.println("ноябрь");
                break;
            }
            case (12): {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }
        }
        System.out.println();
    }

    private static void step3(double a, double b, double c) {
        double x1;
        double x2;
        double d;

        d = b * b - 4 * a * c;

        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            System.out.printf("x1 = %.2f  x2 = %.2f", x1, x2);

        } else if (d == 0) {
            x1 = -b / (2 * a);

            System.out.println(x1);

        } else {
            System.out.println("корней нет");
        }

    }

}
