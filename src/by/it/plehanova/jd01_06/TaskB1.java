package by.it.plehanova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] consonant = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
    private static char[] vowel = {'а', 'о', 'у', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};

    private static void wordPattern(String word) {
        String lowerCase = word.toLowerCase();
        char first = lowerCase.charAt(0);
        char last = lowerCase.charAt(word.length() - 1);

        for (int i = 0; i < consonant.length; i++) {
            if (first == consonant[i]) {
                for (int j = 0; j < vowel.length; j++) {
                    if (last == vowel[j]) {
                        System.out.println(word);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            wordPattern(word);
        }
    }
}
