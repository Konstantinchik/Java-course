package by.it.zavoiskikh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class TaskA2 {


    private static String[] w = {};
    private static int[] count = {};

    private static int definePos(String word) {
        for (int i = 0; i < w.length; i++) {
            if (w[i].equals(word))
                return i;
            }
            return -1;

        }


    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[a-яA-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int Position = definePos(word);
            if (Position >= 0) {
                count[Position]++;
            } else {
                int last = w.length;
                w = Arrays.copyOf(w, last + 1);
                w[last] = word;
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;

            }

            for (int i = 0; i < w.length; i++) {
                System.out.println(w[i] + "=" + count[i]);
            }

        }
    }
}
