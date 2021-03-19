package by.it.arekhava.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            String className = e.getClass().getName();
            String taskName = by.it.arekhava.jd01_13.TaskA.class.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                String name = element.getClassName();
                if(name.equals(taskName)){
                    int numberLine = element.getLineNumber();
                    System.out.printf(""+
                            "  name: %s\n" +
                            " class: %s\n" +
                            "  line: %d\n", className, taskName, numberLine);
                    break;
                }
            }

        }
    }
}

