package by.it.evstratov.calc;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class RepoVar {

    static final String FILE_LOG = "log.txt";
    static final String FILE_VARS = "vars.txt";

    private RepoVar() {
    }

    private static String getFilename() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = RepoVar.class.getName()
                .replace(RepoVar.class.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    static void loadVariables() {
        Parser parser = new Parser();
        try {
            Files.lines(Paths.get(getFilename()+FILE_VARS)).forEach(expression -> {
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
                PrintWriter printWriter = new PrintWriter(getFilename()+FILE_VARS)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveToLog(String message) {

        try(OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(getFilename()+FILE_LOG,true))){
            outputStream.write(message+"\n");
            clearFile();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void clearFile(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(getFilename()+FILE_LOG))
        ){
            ArrayList<String> lines = new ArrayList<>();
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
            if(lines.size() >= 50){
                lines.remove(lines.get(0));
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFilename()+FILE_LOG))){
                    for (String line : lines) {
                        bufferedWriter.write(line + "\n");
                    }
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
