package by.it.evstratov.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {


    static long initValue=System.nanoTime();

    public static void main(String[] args) {

            long startSlow = System.nanoTime();
            String a = slow(Poem.text);
            System.out.println(a);
            long endSlow = System.nanoTime();
            System.out.println("Время работы метода slow: "+(endSlow - startSlow)+" мск");

            long startFast = System.nanoTime();
            String b = fast(Poem.text);
            System.out.println(b);
            long endFast = System.nanoTime();
            System.out.println("Время работы метода fast: "+(endFast - startFast)+" мск");



    }

    private static String slow(String text) {
        Random r=new Random(initValue);

        Matcher matcher = Pattern.compile("[а-яА-ЯёЁ]+").matcher(text);
        Matcher matcher2 = Pattern.compile("[а-яА-ЯёЁ]+").matcher(text);

        //Определили количесвто слов и размер массива
        int countWords = 0;
        while (matcher.find()){
            countWords++;
        }
        String[] words = new String[countWords];

        //Добавили все слова в массив строк
        int count = 0;
        while (matcher2.find()){
            words[count] = matcher2.group();
            count++;
        }
        String result = "";
        while (result.length() < 100000){

            result +=" "+words[r.nextInt(words.length-1)];
        }
        return result;
    }

    private static String fast(String text){
        Random r=new Random(initValue);


        Matcher matcher = Pattern.compile("[а-яА-ЯёЁ]+").matcher(text);
        Matcher matcher2 = Pattern.compile("[а-яА-ЯёЁ]+").matcher(text);

        //Определили количесвто слов и размер массива
        int countWords = 0;
        while (matcher.find()){
            countWords++;
        }
        String[] words = new String[countWords];

        //Добавили все слова в массив строк
        int count = 0;
        while (matcher2.find()){
            words[count] = matcher2.group();
            count++;
        }
        String result = "";
        StringBuilder tmpResult = new StringBuilder();
        while (tmpResult.length() < 100000){
            tmpResult.append(" "+words[r.nextInt(words.length-1)]);
        }
        result = new String(tmpResult);
        return result;

    }

}
