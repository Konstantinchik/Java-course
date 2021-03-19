package by.it._khmelov_.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static volatile Logger logger;

    @SuppressWarnings("FieldCanBeLocal")
    private final String logName = "log.txt";

    private Logger() {
    }

    static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    local = logger = new Logger();
                }
            }
        }
        return local;
    }

    void log(String message) {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter(getPath(), true))
        ) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private synchronized String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path + logName;
    }
}
