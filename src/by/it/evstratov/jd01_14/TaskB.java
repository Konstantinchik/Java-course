package by.it.evstratov.jd01_14;

import java.io.*;

public class TaskB {

    public static final String FILENAME_TEXT = "TaskB.txt";
    public static final String FILENAME_TXT_RESULT = "resultTaskB.txt";

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    public static void main(String[] args) {

        int countWords = 0;
        int countMarks = 0;
        int lengthWord = 0;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(getPath(TaskB.class)+FILENAME_TEXT));
            while (inputStreamReader.ready()){
                char character = Character.valueOf((char)inputStreamReader.read());
                String charToString = character+"";

                if((charToString).matches("[!|?|,|.|;|:]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)")){
                    countMarks++;
                }
                if(charToString.matches("[а-яА-ЯёЁ]")){
                    lengthWord++;
                }
                if(charToString.equals(" ") || charToString.matches("[!|?|,|.|;|:]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)") || charToString.equals("\n")){
                    if(lengthWord != 0){
                        lengthWord = 0;
                        countWords++;
                    }
                }
            }
            String result = "words="+ countWords+", punctuation marks="+countMarks;
            System.out.println(result);
            inputStreamReader.close();

            OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(getPath(TaskB.class)+FILENAME_TXT_RESULT));
            outputStream.append(result);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
