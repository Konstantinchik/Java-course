package by.it.leshchenko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String FILENAME_IN = "TaskB.txt";
    public static final String FILENAME_OUT = "resultTaskB.txt";

    public static void main(String[] args) {
        String result = countWordsPunkts(TaskA.getPath(TaskB.class) + FILENAME_IN);
        printToFile(result, TaskA.getPath(TaskB.class) + FILENAME_OUT);
    }

    static void printToFile(String text, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String countWordsPunkts(String filename) {
        String result = "";
        try (final BufferedReader reader = new BufferedReader(
                new FileReader(filename)
        )) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                stringBuilder.append(reader.readLine()).append(" ");
            }
            int words = 0;
            Matcher matcherWords = Pattern.compile("[а-яА-ЯёЁ]+").matcher(stringBuilder);
            while (matcherWords.find()) {
                words++;
            }
            int punkts = 0;
            Matcher matcherPunkt = Pattern.compile("[\\p{Punct}]")
                    .matcher(stringBuilder.toString().replace("...", "."));
            while (matcherPunkt.find()) {
                punkts++;
            }
            result = "words=" + words + ", punctuation marks=" + punkts;
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
