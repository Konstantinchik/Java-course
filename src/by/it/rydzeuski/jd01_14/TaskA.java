package by.it.rydzeuski.jd01_14;

import java.io.*;
import java.util.*;

public class TaskA {
    public static final String FILENAME_BIN = "dataTaskA.bin";
    public static final String FILENAME_TXT = "resultTaskA.txt";

    private static Random random = new Random();

    public static void main(String[] args) {

        String path = getPath(TaskA.class);
        String filename = path + FILENAME_BIN;

        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int value = 123 + random.nextInt(1000);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        List<Integer> list = new ArrayList<>();
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filename)));
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                list.add(value);

            }
        } catch (IOException e) {
            throw new RuntimeException();

        } finally {
            if (Objects.nonNull(dataInputStream)) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        double sum = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            sum += integer;
        }
        double avg = sum / list.size();
        System.out.println("\navg=" + avg);

        String filenameTxt = path + FILENAME_TXT;
        try (PrintWriter out = new PrintWriter(filenameTxt)) {


            double sum2 = 0;
            for (Integer integer : list) {
                out.print(integer + " ");
                sum2 += integer;
            }
            double avg2 = sum2 / list.size();
            out.print("\navg=" + avg2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
