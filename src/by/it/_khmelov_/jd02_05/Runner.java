package by.it._khmelov_.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        if (args.length == 2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }

        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
    }
}
