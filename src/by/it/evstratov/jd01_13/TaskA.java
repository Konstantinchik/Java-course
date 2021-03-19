package by.it.evstratov.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {

        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }catch (NumberFormatException | NullPointerException e){
            System.out.println("catch");
            String name = e.getClass().getName();
            String nameA = TaskA.class.getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                String className = stackTraceElement.getClassName();
                if(className.equals(nameA)){
                    int num = stackTraceElement.getLineNumber();
                    System.out.printf(" name: %s\n class: %s\n line: %d\n", name, className, num);
                    break;
                }

            }


        }
    }

}
