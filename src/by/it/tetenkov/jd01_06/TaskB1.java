package by.it.tetenkov.jd01_06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class TaskB1 {


    private static String[] words = {};
    private static String consonantsRussian = "цкнгшщзхфвпрлджбтмсч"; // соглаcные
    private static String[] vowelsWords = {};
    private static String vowelsRussian = "аоуэиыеёяюй"; // гласные


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();

            int last = words.length;
            words = Arrays.copyOf(words, last + 1);
            words[last] = word;

        }

        filter(words);

    }

    private static void filter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (consonantsRussian.indexOf(Character.toLowerCase(words[i].charAt(0))) != -1 && vowelsRussian.indexOf(Character.toLowerCase(words[i].charAt(words[i].length() - 1))) != -1) {
                String word = words[i];
                int last = vowelsWords.length;
                vowelsWords = Arrays.copyOf(vowelsWords, last + 1);
                vowelsWords[last] = word;

            }

        }

        for (int i = 0; i < vowelsWords.length; i++) {
            System.out.print(vowelsWords[i]);
            System.out.println();
        }
    }
}


