package by.it.kglushchenko.jd01_15;

import java.io.*;

public class TaskB {

    // имя файла для вывода
    public static final String FILENAME_TXT = "TaskB.txt";
    public static final String FILENAME_JAVA = "TaskB.java";

    /**
     * @param args
     */
    public static void main(String[] args) {
        int beginrem = 0, endrem = 0;

        String infile = getPath(TaskB.class) + FILENAME_JAVA;
        String output = getPath(TaskB.class) + FILENAME_TXT;
        /*
        в программе используем метод delete класса StringBuilder
        он позволяет вырезать интересующую нас строку со стартовой заданной позиции сомвола по покечную заданную позицию
         */
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(infile)) {

            while (fileReader.ready()) {
                char currentChar = (char) fileReader.read(); // читаем из файла по одному символу
                stringBuilder.append(currentChar); // добавляем посимвольно в StringBuilder

                if (currentChar == '/') {                       // если встретили / начинаем проверку
                    char nextChar = (char) fileReader.read();
                    stringBuilder.append(nextChar);

                    if (nextChar == '*') {              // если вторй символ после / будет * стартуем многострочный комментарий
                        beginrem = stringBuilder.length() - 2;   // позиция откуда начнем вырезать подстроку - текщаа позиция - 2 символа / *
                    } else if (nextChar == '/') {
                        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

                        while ((nextChar = (char) fileReader.read()) != '\n') {
                            // дальше просто перебираем символы до знака конца строки никуда не записывая
                        }
                        stringBuilder.append(nextChar); // записываем в наш ресурс перенос строки
                    }
                }
                if (currentChar == '*') {
                    char nextChar = (char) fileReader.read();
                    stringBuilder.append(nextChar);
                    if (nextChar == '/') {
                        endrem = stringBuilder.length();
                    }
                    if (beginrem > 0 && endrem > 0 && beginrem < endrem) {
                        // если индекс начала и конца отличны от 0 и позиция начала комента в подстроке
                        stringBuilder.delete(beginrem, endrem);
                        beginrem = 0;
                        endrem = 0;
                    }
                }
            }
            // работа с файлами требует обертки try catch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        работа с файлами требует обертки try catch
        */
        try (PrintWriter printWriter = new PrintWriter(output)) {
            printWriter.print(stringBuilder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringBuilder);
    }

    /*
    метод в котором высчитывается путь до файла назначения
     */
    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

}
