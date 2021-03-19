package by.it.plehanova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        int words = 0;
        int marks = 0;
        try (BufferedReader fileRead = new BufferedReader(new FileReader(path + "TaskB.txt"))) {
            Pattern pattern = Pattern.compile("([а-яА-яёЁ]+)|([^а-яА-яёЁ\\s]+)");
            while (fileRead.ready()) {
                String line = fileRead.readLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        words++;
                    }
                    if (matcher.group(2) != null) {
                        marks++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("words=" + words + " punctuation marks=" + marks);

        try (BufferedWriter fileWrite = new BufferedWriter(new FileWriter(path + "resultTaskB.txt"))) {
            fileWrite.write("words=" + words + " punctuation marks=" + marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }
}
