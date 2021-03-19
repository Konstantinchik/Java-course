package by.it.novik.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        String str;

        while (!(str = scanner.nextLine()).equals("END")) {
            try {
                double number = Double.parseDouble(str);
                list.add(number);
                double sum = 0;
                for (Double i : list) {
                    sum+=i;
                }
                if (sum <= 0) {
                    throw new ArithmeticException();
                }
                double sqrt = Math.sqrt(sum);
                System.out.println(number + ": " + sqrt);


            } catch (Exception e) {
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
        }
    }
}
