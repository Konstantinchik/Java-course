package by.it.rydzeuski.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class RepoVar {

    public RepoVar() {
    }

    static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);

        return src + path;
    }
    static void loadToVars(){
        Parser parser=new Parser();
        try {
            Files.lines(Paths.get(filename)).forEach(expression->{
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
    private static final  String filename=getPath(RepoVar.class)+"vars.txt";

    static void saveToFile(Map<String,Var>vars){

        try (
            PrintWriter printWriter=new PrintWriter(filename))
        {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
