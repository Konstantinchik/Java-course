package by.it.soldatenko.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskA {
    public static void main(String[] args) {
        int[][] arr = generate();
        String fn = dir() + "matrix.txt";
        toFile(fn,arr);
        toConsole(fn);
    }

    private static int[][] generate() {
        int[][] arr = new int[6][4];
        int count1 = 0;
        int count2 = 0;
        do {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = (int) (Math.round(Math.random() * 2 * 15) - 15);
                    if (arr[i][j] == 15) {
                        count1 = 1;
                    }
                    if (arr[i][j] == -15) {
                        count2 = 1;
                    }
                }
            }
        } while ((count1 + count2) < 2);
        return arr;
    }

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        return path + cldir;
    }

    public static void toFile(String fn, int[][] arr) {
        try
                (PrintWriter out = new PrintWriter(
                        fn)) {
            for (int[] row : arr) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void toConsole(String fn) {
        try {
            Files.lines(Path.of(fn)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
