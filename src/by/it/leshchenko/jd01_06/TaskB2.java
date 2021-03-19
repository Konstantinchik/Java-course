package by.it.leshchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder(Poem.text.replace("...", " "));
        Pattern pattern = Pattern.compile("[^.!]+");
        Matcher matcher = pattern.matcher(stringBuilder);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        matcher.reset();
        String[] lines = new String[count];
        int[] lengths = new int[count];
        int i = 0;
        while (matcher.find()) {
            lines[i] = matcher.group().replaceAll("[\\p{Punct}\\p{Blank}\\s]+", " ").trim();
            lengths[i] = lines[i].length();
            i++;
        }
        sort(lines, lengths, 0, lines.length - 1);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void sort(String[] lines, int[] lengths, int first, int last) {
        if (first < last) {
            int value = lengths[first];
            int j = first;
            for (int i = first + 1; i <= last; i++) {
                if (lengths[i] <= value) {
                    j++;
                    int temp_int = lengths[i];
                    lengths[i] = lengths[j];
                    lengths[j] = temp_int;
                    String temp_str = lines[i];
                    lines[i] = lines[j];
                    lines[j] = temp_str;
                }
            }
            int temp_int = lengths[first];
            lengths[first] = lengths[j];
            lengths[j] = temp_int;
            String temp_str = lines[first];
            lines[first] = lines[j];
            lines[j] = temp_str;

            sort(lines, lengths, first, j - 1);
            sort(lines, lengths, j + 1, last);
        }
    }
}
