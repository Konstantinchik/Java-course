package by.it.kglushchenko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {
        // убираем ререносы строкб делить потом будем по точкам
        StringBuilder stringBuilder = new StringBuilder(Poem.text.replace("\n", " ")); //

        String stringText = stringBuilder.toString();                                    // загоняем текст в строку
        //String[] sentences = stringText.split("(\\s*(?<!\\.)\\.(?!\\.)\\s*)"); // делим сторку на предложения
        String[] sentences = stringText.split("\\.");

        // Сначала делим текст на предложения
        // Количество предложений
        int sentences_num = sentences.length;
        StringBuilder[] strBldrSentences = new StringBuilder[sentences_num]; // создаем массив StringBulder-ов
                                                        // и копируем туда строки из массива String[]
        // Потом удаляем из предложений знаки препинания
        for(int i=0; i < sentences_num; i++){    // перебираем все предложения и создаем новые строки без знаком препинания
            strBldrSentences[i] = new StringBuilder(sentences[i].replaceAll("[^а-яА-ЯЁё]+", " ").trim());
        }

        // Пузырьковая сортировка строк по длине
        for (int i=0; i<sentences_num; i++){
            for(int j=0; j<sentences_num-1;j++){
                if(strBldrSentences[j].length() > strBldrSentences[j+1].length() ){ //если текущая строка длинее следующей
                    // меняем строки местами
                    StringBuilder tmp = strBldrSentences[j];
                    strBldrSentences[j] = strBldrSentences[j+1];
                    strBldrSentences[j+1] = tmp;
                }
            }
        }

        for(StringBuilder str : strBldrSentences){
            //System.out.println(str);
            System.out.print(str+"\n");
        }
    }
}

/*  VERS 1
public class TaskB2 {

    public static void main(String[] args) {

        String[] sentences = Poem.text.split("[!|?]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)");
        StringBuilder[] stringBuilderSentences = new StringBuilder[sentences.length];

        for (int i = 0; i < stringBuilderSentences.length; i++) {
            stringBuilderSentences[i] = new StringBuilder(sentences[i].replaceAll("[^а-яА-ЯёЁ]+"," ").trim());
        }

        for (int i = 0; i < stringBuilderSentences.length; i++) {
            for (int j = 0; j <stringBuilderSentences.length-1; j++) {
                if(stringBuilderSentences[j].length()>stringBuilderSentences[j+1].length()){
                    StringBuilder tmp = stringBuilderSentences[j];
                    stringBuilderSentences[j] = stringBuilderSentences[j+1];
                    stringBuilderSentences[j+1] = tmp;
                }
            }
        }
        for (StringBuilder stringBuilderSentence : stringBuilderSentences) {
            System.out.print(stringBuilderSentence+"\n");
        }
    }
}
 */

/*  VERS 2
public class TaskB2 {
    public static void main(String[] args) {

        String text = Poem.text;
        String[] sentOne = text.split("[\\.\\!\\?][^\\. ]");
        String[] sentTwo = text.split("[\\.\\!\\?]");

        sentOne = sort(sentOne);
        sentTwo = sort(sentTwo);

        for (int i = 0; i < sentOne.length; i++) {
            System.out.print(sentOne[i] + "\n");
        }
        for (int i = 0; i < sentTwo.length; i++) {
            System.out.print(sentTwo[i] + "\n");
        }
    }

    private static String[] sort(String[] sentence) {

        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].replaceAll("[^а-яА-ЯЁё]+", " ").trim();
        }

        boolean check;
        String temp;
        int count = sentence.length - 1;

        do {
            check = false;
            for (int i = 0; i < count; i++) {
                if (sentence[i].length() > sentence[i + 1].length()) {
                    temp = sentence[i];
                    sentence[i] = sentence[i + 1];
                    sentence[i + 1] = temp;

                    check = true;
                }
            }
            count--;
        } while (check);

        return sentence;
    }
}
 */
