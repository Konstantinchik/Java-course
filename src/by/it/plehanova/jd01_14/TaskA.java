package by.it.plehanova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TaskA {
    private static Random random = new Random();

    public static void main(String[] args) {

        String path = getPath(TaskA.class);
        writeFile(path);
        List<Integer> list = readFile(path);
        printToConsole(list);
        printToFile(path, list);
    }

    private static void printToFile(String path, List<Integer> list) {
        try (PrintWriter print = new PrintWriter(path + "resultTaskA.txt")) {
            double sum = 0;
            for (Integer integer : list) {
                print.print(integer + " ");
                sum += integer;
            }
            double avg = sum / list.size();
            print.printf(Locale.ENGLISH, "\navg=%f\n", avg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        double avg;
        for (Integer integer : list) {
            sum += integer;
            System.out.print(integer + " ");
        }
        avg = sum / list.size();
        System.out.printf(Locale.ENGLISH, "\navg=%f\n", avg);
    }

    private static List<Integer> readFile(String path) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(path + "dataTaskA.bin")))
        ) {

            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void writeFile(String fileName) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName + "dataTaskA.bin")
                )
        )
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(1000) + 123);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
