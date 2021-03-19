package by.it.leshchenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TaskA {

    private static final Random random = new Random();
    public static final String FILENAME_BIN = "dataTaskA.bin";
    public static final String FILENAME_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        writeToFile(path + FILENAME_BIN);
        final List<Integer> list = readToList(path + FILENAME_BIN);
        printToConsole(list);
        printToFile(path + FILENAME_TXT, list);
    }

    private static void printToFile(String filename, List<Integer> list) {
        try (final PrintWriter printWriter = new PrintWriter(filename)) {
            double sum = 0;
            for (Integer integer : list) {
                printWriter.print(integer + " ");
                sum += integer;
            }
            printWriter.print("\navg=" + sum / list.size() + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.printf(Locale.ENGLISH, "%d ", integer);
            sum += integer;
        }
        System.out.printf(Locale.ENGLISH, "\navg=%f\n", sum / list.size());
    }

    private static List<Integer> readToList(String filename) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)
                )
        )) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeToFile(String filename) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)
                )
        )) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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