package by.it.plehanova.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    public static final String path = getPath(TaskC.class);

    public static void main(String[] args) {

        File myPackage = new File(path).getParentFile();

        try (BufferedWriter fileWrite = new BufferedWriter(new FileWriter(path + "resultTaskC.txt"))) {
            myFiles(myPackage, fileWrite);
            fileWrite.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void myFiles(File file, BufferedWriter write) throws IOException {

        if (file.isFile()) {
            System.out.println("file:" + file.getName());
            write.write("file:" + file.getName() + "\n");

        } else {
            System.out.println("dir:" + file.getName());
            write.write("dir:" + file.getName() + "\n");
            File[] list = file.listFiles();
            for (File catalog : list) {
                myFiles(catalog, write);
            }
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
