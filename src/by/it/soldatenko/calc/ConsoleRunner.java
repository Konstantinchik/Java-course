package by.it.soldatenko.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Language.setLocale(Locale.getDefault());



        while (!(line = scanner.nextLine()).equals("end")){
            if (line.equals("ru")) {
                Language.setLocale(new Locale("ru","RU"));
            }
            if (line.equals("be")) {
                Language.setLocale(new Locale("be","BY"));
            }
            if (line.equals("en")) {
                Language.setLocale(new Locale("en","US"));
            }

            Var result= null;
            try {
                result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
//                e.printStackTrace();
                printer.print(e);
            }
        }
    }
}

