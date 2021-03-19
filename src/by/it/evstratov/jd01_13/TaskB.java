package by.it.evstratov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;
        ArrayList<Double> doubleArrayList = new ArrayList<>();

        while (!(str = scanner.nextLine()).equals("END")){

            double num = 0d;
            try{
                num = Double.parseDouble(str);
                doubleArrayList.add(num);
                double sum = 0;
                for (Double aDouble : doubleArrayList) {
                    sum+=aDouble;
                }
                if(sum <= 0){
                    throw new ArithmeticException();
                }
                double sqrt = Math.sqrt(sum);
                System.out.println(num+":"+sqrt);

            }catch (NumberFormatException | ArithmeticException e){
                System.out.println("catch");
                String name = e.getClass().getName();
                String nameA = TaskB.class.getName();
                StackTraceElement[] stackTraceElements = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    String className = stackTraceElement.getClassName();
                    if(className.equals(nameA)){
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s\n class: %s\n line: %d\n", name, className, lineNumber);
                        break;
                    }

                }
            }

        }

    }

}
