package by.it.kglushchenko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    // приватное поле для экземпляра класса
    // volatile защищает от оптимизации - чтобы два if не превратились в один, logger не закэшируется
    private static volatile Logger logger; // volatile - защищает атомарную операцию от вмешательства

    @SuppressWarnings("FieldCanBeLocal")
    private final String logName = "log.txt";

    private Logger() {  // private constructor защищает от вызова конструктора извне
    }

    static Logger getLogger() {             // get Instance
        Logger local = logger;              // для уменьшения обращения к volatile
        if (local == null) {
            synchronized (Logger.class) {   // засинхронизируем обращение на Logger.class
                local = logger;             // пока мы висели на синхронизации logger мог родиться из другого потока
                if (local == null) {        // повторно проверяем
                    local = logger = new Logger();  // если logger еще не создан, создаем его.
                }
            }
        }
        return local;   // чтобы не читать volatile
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
        String path = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path + logName;
    }
}
