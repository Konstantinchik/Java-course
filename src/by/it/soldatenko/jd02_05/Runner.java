package by.it.soldatenko.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Language lang = Language.ISTANCE;
        String s = "";
        Locale.setDefault(Locale.US);
        lang.setLocale(new Locale("en"));
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.print(lang.get(User.FIRST_NAME) + " ");
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(df.format(new Date()));

        while (true) {
            s = scanner.nextLine();
            if(s.equals("end"))
                break;

            if (s.equals("ru")) {
                Locale l = new Locale("ru", "RU");
                lang.setLocale(l);
                df = DateFormat.getDateInstance(DateFormat.MEDIUM, l);
            }
            if (s.equals("be")) {
                Locale l = new Locale("be", "BY");
                lang.setLocale(l);
                df = DateFormat.getDateInstance(DateFormat.MEDIUM, l);
            }
            if (s.equals("en")) {
                Locale l = new Locale("en","US");
                lang.setLocale(l);
                df = DateFormat.getDateInstance(DateFormat.MEDIUM,l);
            }

            System.out.println(lang.get(Messages.WELCOME));
            System.out.println(lang.get(Messages.QUESTION));
            System.out.print(lang.get(User.FIRST_NAME) + " ");
            System.out.println(lang.get(User.LAST_NAME));
            System.out.println(df.format(new Date()));
        }
    }
}
