package by.it.soldatenko.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + cldir;

    }

    public static void main(String[] args) {
        File f = new File(dir(TaskC.class));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.print(f.getAbsolutePath() + ">");
            String s = scanner.nextLine();
            if (s.equals("end")) {
                break;
            }
            if (s.equals("dir")) {
                File[] d = f.listFiles();
                int countDir = 0;
                int countFile = 0;
                long fileSum = 0;
                for (File file : d) {
                    if (file.isDirectory()) {
                        System.out.printf("%d %s %8s %s", file.lastModified(), "   <DIR>   ", "", file.getName());
                        System.out.println();
                        countDir++;
                    }
                    if (file.isFile()) {
                        System.out.printf("%d %s %8d %s", file.lastModified(), "           ", file.length(), file.getName());
                        System.out.println();
                        countFile++;
                        fileSum = fileSum + file.length();
                    }
                }
                System.out.printf("%15d %s %10d %s", countFile, "файлов", fileSum, "байт");
                System.out.println();
                System.out.printf("%15d %s %10d %s", countDir, "папок", f.getFreeSpace(), "байт свободно");
                System.out.println();
                System.out.println();
            }
            if (s.equals("cd..")) {
                f = new File(f.getParent());
            }
            if (!s.equals("cd..") && !s.equals("dir")) {
                sb.append(s);
                sb = sb.replace(0, 3, "");
                f = new File(f.getAbsolutePath() + "\\" + sb);
            }
            sb.delete(0, sb.capacity());

        }


    }
}