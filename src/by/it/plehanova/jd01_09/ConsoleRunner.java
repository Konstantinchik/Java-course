package by.it.plehanova.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser pars = new Parser();
        Printer printer = new Printer();

        String expression;
        while (true) {
            expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            Var result = pars.calc(expression);
            printer.print(result);
        }
    }
}
