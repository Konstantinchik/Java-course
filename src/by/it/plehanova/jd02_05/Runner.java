package by.it.plehanova.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Language language = Language.INSTANCE;

/*        if (args.length == 2) {
            language.setLocale(new Locale(args[0], args[1]));
        }*/

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, language.getLocale());

        Scanner scanner= new Scanner(System.in);
        while (!scanner.hasNext("end")){
            String lang = scanner.next();
            if(lang.equals("ru")){
                language.setLocale(new Locale("ru", "RU"));
                System.out.printf("%s, %s %s!\n", language.get(Messages.HELLO), language.get(User.FIRST_NAME), language.get(User.LAST_NAME));
                System.out.println(language.get(Messages.QUESTION));
                System.out.println(dateFormat.format(date));
            }else if(lang.equals("be")){
                language.setLocale(new Locale("be", "BY"));
                System.out.printf("%s, %s %s!\n", language.get(Messages.HELLO), language.get(User.FIRST_NAME), language.get(User.LAST_NAME));
                System.out.println(language.get(Messages.QUESTION));
                System.out.println(dateFormat.format(date));
            }else{
                language.setLocale(Locale.ENGLISH);
                System.out.printf("%s, %s %s!\n", language.get(Messages.HELLO), language.get(User.FIRST_NAME), language.get(User.LAST_NAME));
                System.out.println(language.get(Messages.QUESTION));
                System.out.println(dateFormat.format(date));
            }
        }

    }
}
