package by.it.plehanova.jd01_15;

/*
Класс TaskC Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
использовать класс File и поддерживать две команды консоли:
 команду cd - смена каталога (посмотрите пример: Win+R → cmd → cd \ → dir ). В тестах проверяются всего
две команды cd .. и cd имя_папки_в_текущем_каталоге
 команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
 команда end – завершение работы.
 Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskC {
    public static final String END = "end";
    public static final String DIR = "dir";
    public static String path = getPath(TaskC.class);

    public static void main(String[] args) {

        try (BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(path);
            while (true) {
                String enterFromConsole = readFromConsole.readLine();
                if (enterFromConsole.equals(END)) {
                    break;
                }
                getFile(enterFromConsole);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void getFile(String enterFromConsole) {
        File catalog = new File(path);

        if (enterFromConsole.startsWith("cd")) {
            enterFromConsole = enterFromConsole.replace("cd", "").trim();

            if (enterFromConsole.equals("..")) {
                catalog = new File(catalog.getParent());
                path = catalog.toString();
                System.out.println(catalog);

            } else if (enterFromConsole.isEmpty()) {
                System.out.println(catalog);

            } else {
                catalog = new File(catalog + File.separator + enterFromConsole);
                path = catalog.toString();

                if (catalog.isDirectory()) {
                    System.out.println(catalog);
                } else {
                    System.out.println("The directory name is invalid.");
                }
            }
        } else if (enterFromConsole.equals(DIR)) {
            System.out.println(catalog);
            File[] files = catalog.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.printf("%10s%s\n", "", file.getName());
                } else if (file.isDirectory()) {
                    System.out.printf("%10s%s\n", "<DIR> ", file.getName());
                }
            }
        }
    }

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getPackageName().replace(".", File.separator).concat(File.separator);
        return src + path;
    }


}
