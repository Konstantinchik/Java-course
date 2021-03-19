package by.it.leshchenko.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        String filename = getPath(TaskA.class) + MATRIX_TXT;
        int[][] matrix = setRandomsIntegers(new int[6][4]);
        printToFile(matrix, filename);
        printToConsole(filename);
    }

    private static void printToConsole(String filename) {
        try {
            Files.lines(Paths.get(filename)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToFile(int[][] matrix, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            Arrays.stream(matrix).forEach(row -> {
                Arrays.stream(row).forEach(i -> out.printf("%3d ", i));
                out.println();
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] setRandomsIntegers(int[][] matrix) {
        final Random random = new Random();
        for (int i = 0, matrixLength = matrix.length; i < matrixLength; i++) {
            for (int j = 0, rowLength = matrix[i].length; j < rowLength; j++) {
                matrix[i][j] = random.nextInt(31) - 15;
            }
        }
        return matrix;
    }

    static String getPath(Class<?> clazz) {
        String userDir = System.getProperty("user.dir");
        String classDir = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return userDir + File.separator + "src" + File.separator + classDir;
    }
}