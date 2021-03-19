package by.it.plehanova.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser pars = new Parser();
        Printer printer = new Printer();
        RepoVar.loadVariables();
        String expression;
        while (true) {
            expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            } else if (expression.equals("printvar")) {
                Var.printVar();

            } else if (expression.equals("sortvar")) {
                Var.sortVar();

            } else {
                try {
                    Var result = pars.calc(expression);
                    printer.print(result);

                } catch (CalcException e) {
                    //e.printStackTrace();
                    printer.printErr(e);
                }
            }
        }
    }
}
