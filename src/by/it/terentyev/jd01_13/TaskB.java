package by.it.terentyev.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        try {
            List<Double> realNumber = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            double summ = 0;
            for (; ; ) {

                String string = scanner.next();
                if (string.equals("END")) {
                    break;
                }
                Double value = Double.valueOf(string);
                realNumber.add(value);
                summ += value;
                double sqrt = Math.sqrt(summ);
                System.out.println(value);
                System.out.println(sqrt);
            }
            System.out.println(realNumber);
        } catch (NumberFormatException e) {
            String name = e.getClass().getName();
            String nameA = TaskA.class.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.equals(nameA)) {
                    int number = stackTraceElement.getLineNumber();
                    System.out.printf("" +
                            " name: %s\n" +
                            " class %s\n" +
                            " line: %d\n", name, className, number);
                    break;
                }

            }

        }
    }
}
