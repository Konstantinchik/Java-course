
package by.it.plehanova.jd01_15;

/*Класс TaskB
 В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
 Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”) и внутри комментария тоже.
Регулярные выражения использовать нельзя */

import java.io.*;

public class TaskB {
    public static final String TaskB_JAVA = "TaskB.java";
    public static final String TaskB_TXT = "TaskB.txt";

    public static void main(String[] args) {
        /*
         * тестовый многострочный комментарий
         */
        String javaPath = getPath(TaskB.class) + TaskB_JAVA;
        String txtPath = getPath(TaskB.class) + TaskB_TXT;
        StringBuilder text = deleteComments(javaPath);
        printTextInFile(txtPath, text);
        System.out.println(text);
    }

    private static void printTextInFile(String txtPath, StringBuilder str) {
        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            printWriter.print(str);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //читаем в переменную и удаляем комментарии
    private static StringBuilder deleteComments(String javaPath) {
        try (FileReader fileReader = new FileReader(javaPath)) {
            StringBuilder text = new StringBuilder();
            int indexStart = 0;
            int indexEnd = 0;

            while (fileReader.ready()) {
                char currentChar = (char) fileReader.read();
                text.append(currentChar);

                if (currentChar == '/') {
                    char nextChar = (char) fileReader.read();
                    text.append(nextChar);

                    if (nextChar == '*') {
                        indexStart = text.length() - 2;
                    } else if (nextChar == '/') {
                        text.delete(text.length() - 2, text.length());

                        while ((nextChar = (char) fileReader.read()) != '\n') {
                        }
                        text.append(nextChar);
                    }
                }
                if (currentChar == '*') {
                    char nextChar = (char) fileReader.read();
                    text.append(nextChar);
                    if (nextChar == '/') {
                        indexEnd = text.length();
                    }
                }
                if (indexStart > 0 && indexEnd > 0 && indexStart < indexEnd) {
                    text.delete(indexStart, indexEnd);
                    indexStart = 0;
                    indexEnd = 0;
                }
            }
            return text;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //получаем путь к файлу
    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getPackageName().replace(".", File.separator).concat(File.separator);
        return src + path;
    }
}