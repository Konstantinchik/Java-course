package by.it.leshchenko.jd01_15;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File(getPath(TaskC.class));
        System.out.print(file.getPath() + ">");
        while (!scanner.hasNext("end")) {
            String command = scanner.nextLine();
            if (command.equals("dir")) {
                readFiles(file);
            }
            else if (command.equals("cd ..") || command.equals("cd..")) {
                file = new File(file.getParent());
            } else if (command.matches("cd\\s+[0-9a-zA-z_]+")) {
                File tempFile = new File(file.getPath() + File.separator + command.substring(3));
                if (tempFile.isDirectory()) {
                    file = tempFile;
                } else {
                    System.out.println("unknown dir");
                }
            } else {
                System.out.println("unknown command");
            }
            System.out.print(file.getPath() + ">");
        }
    }

    private static void readFiles(File path) {
        if (path.isDirectory()) {
            for (File file : Objects.requireNonNull(path.listFiles())) {
                if (file.isFile()) {
                    String s = "file:" + file.getName();
                    System.out.println(s);
                } else {
                    String s = "dir:" + file.getName();
                    System.out.println(s);
                }
            }
        }
    }

    static String getPath(Class<?> clazz) {
        String userDir = System.getProperty("user.dir");
        String classDir = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return userDir + File.separator + "src" + File.separator + classDir;
    }
}