package by.it.kglushchenko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger2 {

    INSTANCE;

    @SuppressWarnings("FieldCanBeLocal")
    private final String logName = "log2.txt";

    static Logger2 getLogger() {
        return INSTANCE;
    }

    void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getPath(), true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private synchronized String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = Logger2.class.getName()
                .replace(Logger2.class.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path + logName;
    }
}
