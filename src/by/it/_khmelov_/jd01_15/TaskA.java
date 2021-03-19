package by.it._khmelov_.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        String fn = getPath(TaskA.class) + MATRIX_TXT;
        int[][] array = generate();
        writeArray(fn, array);
        showArray(fn);
    }

    private static void showArray(String fn) {
        try {
            Files.lines(Paths.get(fn))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeArray(String fn, int[][] array) {
        try (PrintWriter out = new PrintWriter(fn)
        ) {
            for (int[] row : array) {
                Arrays.stream(row).forEach(element -> out.printf("%3d ", element));
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] generate() {
        int[][] array = new int[6][4];
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + (int) (Math.random() * 31);
            }
        }
        array[0][0] = -15;
        array[1][1] = 15;
        return array;
    }

    @SuppressWarnings("SameParameterValue")
    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }
}
