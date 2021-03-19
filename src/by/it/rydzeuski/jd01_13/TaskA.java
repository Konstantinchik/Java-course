package by.it.rydzeuski.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");

        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String nameA = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf("name: %s\n" +
                            "class: %s|n" +
                            "line: %d\n",name,nameA,number);
                    break;
                }

            }
        }
    }
}

