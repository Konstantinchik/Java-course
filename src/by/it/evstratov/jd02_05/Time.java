package by.it.evstratov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {

    static public String getTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        String time = dateFormat.format(new Date());
        return time;
    }
}
