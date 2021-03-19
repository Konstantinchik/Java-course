package by.it.leshchenko.jd01_14;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class TaskC {
    public static final String FILENAME_OUT = "resultTaskC.txt";
    final static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        final Path parent = Paths.get(TaskA.getPath(TaskC.class));
        final File path = new File(parent.getParent().toString());
        String files = readFiles(path);
        TaskB.printToFile(files, TaskA.getPath(TaskC.class) + FILENAME_OUT);
    }

    private static String readFiles(File path) {
        if (path.isDirectory()) {
            for (File file : Objects.requireNonNull(path.listFiles())) {
                if (file.isFile()) {
                    String s = "file:" + file.getName();
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                } else {
                    String s = "dir:" + file.getName();
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                    readFiles(file);
                }
            }
        }
        return stringBuilder.toString();
    }
}
