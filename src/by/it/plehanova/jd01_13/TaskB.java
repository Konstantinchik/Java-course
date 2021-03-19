package by.it.plehanova.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        double sum = 0;
        double sqrt;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(str);
                sum += number;
                if (sum < 0) {
                    throw new ArithmeticException();
                }
                sqrt = Math.sqrt(sum);
                System.out.printf("number = %.3f\nsqrt = %.4f\n", number, sqrt);

            } catch (NumberFormatException | ArithmeticException e) {
                String className = e.getClass().getName();
                String taskName = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String name = element.getClassName();
                    if (name.equals(taskName)) {
                        int numberLine = element.getLineNumber();
                        System.out.printf("" +
                                "  name: %s\n" +
                                " class: %s\n" +
                                "  line: %d\n", className, taskName, numberLine);
                        break;
                    }
                }
            }

            //System.out.println("ERROR: impossible to extract square root");
        }


    }
}
