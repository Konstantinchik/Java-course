package by.it.plehanova.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[\n]+");

        int maxLength = 0;

        String[] sentence = pattern.split(text);

        for (int i = 0; i < sentence.length; i++) {
            maxLength = Math.max(maxLength, sentence[i].length());
        }

        for (int i = 0; i < sentence.length; i++) {
            StringBuilder words = new StringBuilder(sentence[i]);

            int position = 0;
            while (words.length() < maxLength) {
                int index = words.indexOf(" ", position);

                if (index == -1) {
                    position = 0;
                    continue;
                }
                position = index + 1;
                if (words.charAt(position) == ' ') {
                    continue;
                }
                words = words.insert(index, " ");
                position++;
            }
            System.out.println(words);
        }
    }
}
