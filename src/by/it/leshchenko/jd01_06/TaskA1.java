package by.it.leshchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
//        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
//        Matcher matcher = pattern.matcher(stringBuilder);
        Matcher matcher = Pattern.compile("[а-яА-яёЁ]+").matcher(stringBuilder);
        while (matcher.find()) {
            if (matcher.group().length() >= 4) {
                stringBuilder.setCharAt(matcher.start() + 3, '#');
            }
            if (matcher.group().length() >= 7) {
                stringBuilder.setCharAt(matcher.start() + 6, '#');
            }
        }
        System.out.println(stringBuilder);
    }
}
