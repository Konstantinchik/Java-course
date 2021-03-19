package by.it.leshchenko.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("\n");
        String[] lines = pattern.split(stringBuilder);
        int max = 0;
        for (String line : lines) {
            max = Math.max(max, line.length());
        }

        for (String line : lines) {
            int count = 1;
            int pointer = 0;
            StringBuilder str = new StringBuilder(line);
            while (str.length() < max) {
                int index = str.indexOf(" ", pointer);
                if (index != -1) {
                    pointer = index + count;
                    str.insert(pointer, ' ');
                    pointer++;
                } else {
                    count++;
                    pointer = 0;
                }
            }
            System.out.println(str);
        }
    }
}