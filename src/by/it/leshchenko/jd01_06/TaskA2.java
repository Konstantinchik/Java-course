package by.it.leshchenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = new String[0];
    private static int[] count = new int[0];

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Matcher matcher = Pattern.compile("[а-яА-яёЁ]+").matcher(stringBuilder);
        while (matcher.find()) {
            String word = matcher.group();
            int position = position(word);
            if (position >= 0) {
                count[position]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + count[i]);
        }
    }

    private static int position(String word) {
        int position = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                position = i;
            }
        }
        return position;
    }
}