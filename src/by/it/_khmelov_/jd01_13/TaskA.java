package by.it._khmelov_.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            String name = e.getClass().getName();
            String nameA = TaskA.class.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.equals(nameA)) {
                    int number = stackTraceElement.getLineNumber();
                    System.out.printf("" +
                            "  name: %s\n" +
                            " class: %s\n" +
                            "  line: %d\n", name, className, number);
                    break;
                }
            }
        }
    }
}
