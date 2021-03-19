package by.it.soldatenko.jd01_13;

import java.util.Scanner;

import static java.lang.Double.isNaN;

public class TaskB {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        try {
            for (; ; ) {
                String s = scanner.nextLine();
                if (s.equals(("END"))) {
                    break;
                }
                double result = Double.parseDouble(s);

                if (isNaN(Math.sqrt(result + sum))) {
                    throw new ArithmeticException();
                }
                double resSqrt = Math.sqrt(result + sum);
                System.out.println(result);
                System.out.println(resSqrt);
                sum = sum + result;

            }
        }catch (NumberFormatException | ArithmeticException e){
            String name = e.getClass().getName();
            String simpleName = TaskB.class.getName();
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
