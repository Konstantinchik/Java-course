package by.it.leshchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final char[] con = new char[]{'б', 'в', 'г', 'д', 'ж', 'з', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'};
    private static final char[] vow = new char[]{'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'};

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Matcher matcher = Pattern.compile("[а-яА-яёЁ]+").matcher(stringBuilder);
        while (matcher.find()) {
            checkWord(matcher.group());
        }
    }

    private static void checkWord(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        for (char c : con) {
            if (first == c) {
                for (char value : vow) {
                    if (last == value) {
                        System.out.println(word);
                    }
                }
            }
        }
    }
}
