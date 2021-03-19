package by.it.rydzeuski.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser=new Parser();
        for (;;){
            String expression=sc.nextLine();
            if (expression.equals("end")){
                break;
            }
            Var result=parser.calc(expression);
            printer.print(result);
        }

    }
}
