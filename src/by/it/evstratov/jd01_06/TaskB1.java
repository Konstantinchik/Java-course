package by.it.evstratov.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static boolean chekWord(String word){

        String str = word.toLowerCase();

        String vowels = "уеыаоэяиёю";

        if(vowels.contains(str.substring(word.length()-1)) && !vowels.contains(str.substring(0,1))){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {

        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(dynText);

        while (matcher.find()){
            if(chekWord(matcher.group())){
                System.out.println(matcher.group());
            }
        }



    }

}
