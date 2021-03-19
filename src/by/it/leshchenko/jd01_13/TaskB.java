package by.it.leshchenko.jd01_13;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        while (true) {
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("end")) {
                break;
            }
            double number;
            try {
                number = Double.parseDouble(s);
                sum += number;
                if (number < 0) {
                    throw new ArithmeticException();
                }
                System.out.printf("%f %f\n", number, sqrt(sum));
            } catch (NumberFormatException | ArithmeticException e) {
                String name = e.getClass().getName();
                String className = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String lineName = element.getClassName();
                    if (lineName.equals(className)) {
                        int line = element.getLineNumber();
                        System.out.printf("" +
                                "name: %s\n" +
                                "class: %s\n" +
                                "line: %d\n", name, className, line);
                    }
                }
            }
        }
    }
}
