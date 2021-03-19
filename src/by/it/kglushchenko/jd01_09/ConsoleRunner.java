package by.it.kglushchenko.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        do{
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }
            Var result = parser.calc(expression);
            printer.print(result);
        }while (true);
    }
}
