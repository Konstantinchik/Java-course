package by.it.evstratov.jd01_15;


/*
      Method main
*/


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



public class TaskB {

    //static method getPath

    private static final String TASK_B = "TaskB.txt";

    private static String getPathJava(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(".", File.separator);
        return src + path + ".java";
    }
    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }


    /*
      Method main
   */

    public static void main(String[] args) {

        try(FileReader fr = new FileReader(getPathJava(TaskB.class)); PrintWriter pr = new PrintWriter(getPath(TaskB.class)+TASK_B)){

            /*
               Установка флагов для отлавливания комментов
            */

            boolean isCommentOpen = false;
            boolean isLineComment = false;
            boolean isDocComment = false;
            StringBuilder fileToStr = new StringBuilder();

            while (fr.ready()){
                char character = (char) fr.read();
                String charToString = character+"";

                if(!isCommentOpen){
                    if(charToString.equals("/")){
                        isCommentOpen = true;
                    }else{
                        fileToStr.append(charToString);
                        pr.write(charToString);
                    }
                }else{
                    if(isLineComment){
                        if(charToString.equals("\n")) {
                            isLineComment = false;
                            isCommentOpen = false;
                            fileToStr.append(charToString);
                            pr.write(charToString);
                        }
                    }else if(isDocComment){
                        if(charToString.equals("/")) {
                            isDocComment = false;
                            isCommentOpen = false;
                        }
                    }else{
                        if(charToString.equals("/")){
                            isLineComment = true;
                        }else if(charToString.equals("*")){
                            isDocComment = true;

                        }else{
                            isCommentOpen = false;
                            fileToStr.append("/").append(charToString);
                            pr.write('/'+ charToString);
                        }
                    }
                }

            }
            System.out.println(fileToStr);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}