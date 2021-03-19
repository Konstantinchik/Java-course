package by.it.evstratov.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {

    private static final String MATRIX_TXT = "matrix.txt";

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    private static int[][] getInts() {
        int[][] array = new int[6][4];
        for (int[] ints : array) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = -15 + (int) (Math.random() * 31);
            }
        }
        array[0][0] = -15;
        array[0][1] = 15;
        return array;
    }

    public static void main(String[] args) {

        int[][] array = getInts();

        try (PrintWriter out = new PrintWriter(getPath(TaskA.class) + MATRIX_TXT)) {
            for (int[] row : array) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.lines(Paths.get(getPath(TaskA.class) + MATRIX_TXT))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
