package by.it.kglushchenko.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double value = 0.0, sum = 0.0, Sq = 0.0;

        String inputString;
        //while (!((inputString = scanner.nextLine().trim()).equals("END"))) {
        while (!(inputString = scanner.nextLine()).equals("END")) {
            try {
                value = Double.valueOf(inputString);
                System.out.println(value);  // test

                sum += value;

                if (sum <= 0) {
                    throw new ArithmeticException();
                }

                Sq = Math.sqrt(sum);
                System.out.println(value + " Sqrt sum" + Sq);

            } catch (NumberFormatException | ArithmeticException e) {
                String name = e.getClass().getName();
                String nameA = by.it.kglushchenko.jd01_13.TaskB.class.getName();
                StackTraceElement[] stackTraceElements = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(nameA)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s\n " +
                                "class: %s\n " +
                                " line: %d\n", name, className, lineNumber);
                        break;
                    }

                }
            }
        }
    }
}
