package by.it._khmelov_.jd02_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class RepoVar {

    private RepoVar() {
    }

    private static String getFilename() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = RepoVar.class.getName()
                .replace(RepoVar.class.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path + "vars.txt";
    }

    static void loadVariables() {
        Parser parser = new Parser();
        try {
            Files.lines(Paths.get(getFilename())).forEach(expression -> {
                        try {
                            parser.calc(expression);
                        } catch (CalcException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }


    @SuppressWarnings("SameParameterValue")
    static void saveVariables(Map<String, Var> vars) {
        try (
                PrintWriter printWriter = new PrintWriter(getFilename())) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
