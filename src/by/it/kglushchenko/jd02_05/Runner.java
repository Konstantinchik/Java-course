package by.it.kglushchenko.jd02_05;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Date date = new Date();
        //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale());
        Locale locale;
        //Locale.setDefault(Locale.ENGLISH);
        //if (args.length == 2) {
        //    locale = new Locale(args[0], args[1]);
        //} else {
        //    locale = new Locale("be", "BY");
        //}
        Locale.setDefault(Locale.US);
        //lang.setLocale(locale);
        LocalDate now = LocalDate.now();

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String language = scanner.next();
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale());
            switch (language) {
                case "ru" : lang.setLocale(new Locale("ru", "RU"));
                    dateFormat = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale()); break;
                case "be" : lang.setLocale(new Locale("be", "BY"));
                    dateFormat = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale()); break;
                case "en" : lang.setLocale(new Locale("en", "US"));
                    dateFormat = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale()); break;
            }

            System.out.println(lang.get(Messages.WELCOME));
            System.out.println(lang.get(Messages.QUESTION));
            System.out.println(lang.get(User.FIRST_NAME));
            System.out.println(lang.get(User.LAST_NAME));
            System.out.println(dateFormat.format(date));
        }
    }
}

