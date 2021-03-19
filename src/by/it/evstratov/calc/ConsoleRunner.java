package by.it.evstratov.calc;

import by.it.evstratov.calc.language.Lang;
import by.it.evstratov.calc.language.Language;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static Language lang = Language.INSTANCE;

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        RepoVar.loadVariables();

        for (;;) {
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }else if(expression.equals("printvar")){
                Var.printVar();
            }else if(expression.equals("sortvar")){
                Var.sortVar();
            }else if(expression.equals(Lang.RU)){
                lang.setLocale(new Locale("ru","RU"));
            }else if(expression.equals(Lang.BE)){
                lang.setLocale(new Locale("be","BY"));
            }else if(expression.equals(Lang.EN)){
                lang.setLocale(new Locale("en","EN"));
            }else{
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

}
