package by.it.plehanova.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class RepoVar {
    private static final String VARS_TXT = "vars.txt";
    private static final String LOG_TXT = "log.txt";

    private RepoVar() {

    }

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = RepoVar.class.getPackageName().replace(".", File.separator).concat(File.separator);
        return src + path;
    }

    static void loadVariables() {
        Parser parser = new Parser();
        try {
            Files.lines(Paths.get(getFileName() + VARS_TXT)).forEach(expression -> {
                try {
                    parser.calc(expression);
                } catch (CalcException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    static void saveVariables(Map<String, Var> vars) {
        try (PrintWriter writer = new PrintWriter(getFileName() + VARS_TXT)) {

            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveConsoleOut(String message) {

        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(getFileName() + LOG_TXT, true))) {
            printWriter.println(message);
            deleteOverLimit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void deleteOverLimit() {

        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName() + LOG_TXT))) {
            ArrayList<String> fileString = new ArrayList<>();
            reader.lines().forEach(fileString::add);
            if (fileString.size() >= 50) {
                fileString.remove(0);
                BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName() + LOG_TXT));
                for (String s : fileString) {
                    writer.write(s + "\n");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}