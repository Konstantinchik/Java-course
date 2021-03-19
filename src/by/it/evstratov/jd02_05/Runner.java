package by.it.evstratov.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);

        Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.nextLine()).equals("end")){
            switch (str){
                case Lang.RU:
                    lang.setLocale(new Locale("ru","RU"));
                    break;
                case Lang.BE: lang.setLocale(new Locale("be","BY"));
                    break;
                case Lang.EN: lang.setLocale(new Locale("en","EN"));
                    break;
                default:
                    lang.setLocale(Locale.ENGLISH);
            }
            System.out.println(Time.getTime(lang.getLocale()) + " : " + lang.get(Messages.WELCOME));
            System.out.println(Time.getTime(lang.getLocale()) + " : " + lang.get(Messages.QUESTION));
            System.out.println(Time.getTime(lang.getLocale()) + " : " + lang.get(User.FIRST_NAME));
            System.out.println(Time.getTime(lang.getLocale()) + " : " + lang.get(User.LAST_NAME));
        }
    }

}
