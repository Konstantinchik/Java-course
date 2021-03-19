package by.it.rydzeuski.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskA {
    private static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] array = new int[6][4];
        String fn = generate(array);
        writeArray(array, fn);
    }
    private static void writeArray(int[][] array, String fn) {
        printWrite(array, fn);
        fileLine(fn);
    }
    private static void fileLine(String fn) {
        try {
            Files.lines(Paths.get(fn)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printWrite(int[][] array, String fn) {
        try (PrintWriter out = new PrintWriter(fn)) {
            for (int[] row : array) {
                Arrays.stream(row).forEach(element -> out.printf("%3d ", element));
                out.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private static String generate(int[][] array) {
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + (int) (Math.random() * 31);

            }

        }
        array[0][0] = -15;
        array[1][1] = 15;

        return getPath(TaskA.class) + MATRIX_TXT;
    }

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);

        return src + path;
    }
}
