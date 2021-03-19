package by.it._khmelov_.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(dynText);
        while (matcher.find()){
            int index=matcher.start();
            dynText.setCharAt(index+3,'#');
            int length=matcher.end()-matcher.start();
            if (length>=7){
                dynText.setCharAt(index+6,'#');
            }

        }
        System.out.println(dynText);
    }
}
