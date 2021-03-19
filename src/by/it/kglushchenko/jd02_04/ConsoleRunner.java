package by.it.kglushchenko.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        RepoVar.loadVariables();
        do{
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }
            // добавляем printvar
            if(expression.equals("printvar")){
                // Выводим весь Map

            }
            // добавляем sortvar
            if(expression.equals("sortvar")){
                // Выводим весь Map

            }

            Var result = parser.calc(expression); // exception
            printer.print(result);
        }while (true);
    }
}
