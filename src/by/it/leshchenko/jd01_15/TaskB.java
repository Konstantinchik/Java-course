package by.it.leshchenko.jd01_15;
/**
 * Java doc /
 */
import java.io.FileReader;
//        One-line comment 1
import java.io.FileWriter;
        /* Miltiline
        comment 2 */
import java.io.IOException;
// One-line comment 2 <<p>> //
// One-line comment 3 / <<p>> /
import static by.it.leshchenko.jd01_15.TaskA.getPath;
/*
Miltiline //
comment 1 **
*/

public class TaskB {

    public static final String FILENAME_JAVA = "TaskB.java";
    public static final String FILENAME_TXT = "TaskB.txt";

    public static void main(String[] args) {

        String filename = getPath(TaskB.class) + FILENAME_JAVA;
        final StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(filename);
             final FileWriter fileWriter = new FileWriter(getPath(TaskB.class) + FILENAME_TXT)) {
            while (reader.ready()) {
                char c = (char) reader.read();
                if (c != '/') {
                    sb.append(c);
                } else {
                    char c2 = (char) reader.read();
                    if (c2 != '/' && c2 != '*') {
                        sb.append(c).append(c2);
                    } else if (c2 == '/') {
                        while (reader.ready() && reader.read() != '\n') {
                        }
                        sb.append('\n');
                    } else if (c2 == '*') {
                        while (reader.ready()) {
                            char c3 = (char) reader.read();
                            if (c3 == '*') {
                                char c4 = (char) reader.read();
                                if (c4 == '/') {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(sb);
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}