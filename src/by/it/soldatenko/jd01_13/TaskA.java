package by.it.soldatenko.jd01_13;

import com.sun.security.jgss.GSSUtil;

import java.util.HashMap;

public class TaskA {


    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e){
            String name = e.getClass().getName();
            String simpleName = TaskA.class.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if(className.equals(simpleName)){
                    int number = stackTraceElement.getLineNumber();
                    System.out.printf(
                            " name: %s\n"+
                            " class: %s\n"+
                            " line: %s\n" , name,className,number);
                    break;
                }
            }
        }

    }

}