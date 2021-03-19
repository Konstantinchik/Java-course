package by.it.rydzeuski.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser=new Parser();
        RepoVar.loadToVars();

        for (;;){
            String expression=sc.nextLine();
            if (expression.equals("end")){
                break;
            }
            try {
               Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
