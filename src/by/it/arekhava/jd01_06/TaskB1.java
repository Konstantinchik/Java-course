package by.it.arekhava.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\b[БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ]+[а-яА-ЯёЁ]{0,}[ауоыиэяюёе]+\\b");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}


