package by.it._khmelov_.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        RepoVar.loadVariables();
        for (; ; ) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                //e.printStackTrace();
                printer.printErr(e);
            }
        }
    }
}
