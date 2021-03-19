package by.it.plehanova.jd01_15;

/* Класс TaskA
 Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
 Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/

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
        String path = getPath(TaskA.class) + MATRIX_TXT;
        int[][] matrix = generateMatrix();
        writeMatrix(path, matrix);
        printMatrixFromFile(path);
    }

    private static void printMatrixFromFile(String path) {
        try {
            Files.lines(Paths.get(path)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeMatrix(String path, int[][] matrix) {
        try (PrintWriter write = new PrintWriter(path)) {

            for (int[] rowElement : matrix) {
                Arrays.stream(rowElement).forEach(element -> write.printf("%3d ", element));
                write.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] generateMatrix() {
        int n = 15;
        int[][] matrix = new int[6][4];
        boolean checkPositiveN = false;
        boolean checkNegativeN = false;
        Random random = new Random();
        while (true) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = random.nextInt(n + n + 1) - n;
                    if (matrix[i][j] == n) {
                        checkPositiveN = true;
                    }
                    if (matrix[i][j] == -n) {
                        checkNegativeN = true;
                    }
                }
            }
            if (checkPositiveN && checkNegativeN) {
                return matrix;
            }
        }
    }

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getPackageName().replace(".", File.separator).concat(File.separator);
        return src + path;
    }
}
