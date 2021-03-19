package by.it.soldatenko.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TaskC {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + cldir;

    }
    private static String dirSol(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir =cl.getPackageName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        File sol = new File(path + cldir);
        return sol.getParent();

    }


    public static void main(String[] args) {
        try (PrintWriter ouT = new PrintWriter(new FileWriter(dir(TaskC.class) + "resultTaskC.txt")))
        {
            printAll(dirSol(TaskC.class), ouT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printAll(String path, PrintWriter oUt) {
        try {
            File f = new File(path);
            File[] d = f.listFiles();
            for (File file : d) {
                if (file.isFile()) {
                    System.out.println("file:" + file.getName());
                    oUt.println("file:" + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println("dir:" + file.getName());
                    oUt.println("dir:" + file.getName());
                    printAll(String.valueOf(file),oUt);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

