package by.it.kglushchenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] w = {}; // слова - создаем пустой массив
    private static int[] count = {};    // число повторений  - создаем пустой массив

    private static int pos(String word) {       // метод pos возвращает позицию слова в массиве W
        for (int i = 0; i < w.length; i++) {    // переберем все элементы массива W
            if (w[i].equals(word)) {                 // если оказалось что w[i] это текщее искомое слово
                return i;                       // то сразу возвращаем i в качестве результата
            }
        }
        return -1;              //          если мы дошли до конца цикла и ничего не нашли вернем -1
    }

    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(dynText);
        while (matcher.find()) {
            String word = matcher.group(); // группа без выделений
            int pos = pos(word);           // находим позицию искомого слова
            if (pos >= 0) {                      // если слово нашлось на 0 или большей позиции
                count[pos]++;              // увеличиваем счетчик на единицу
            } else {
                int last = w.length; // последний элемент
                w = Arrays.copyOf(w, last + 1);
                w[last] = word;        // запомним слово
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;        // укажем частоту повторений = 1
            }

        }
        for (int i = 0; i < w.length; i++) {
            System.out.println(w[i] + "=" + count[i]);
        }
    }
}
/*
public class TaskA2 {
    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replaceAll("[^а-яА-ЯЁё]+", " ").trim();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            int count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (!(words[i].equals(" ")) && words[i].equals(words[j])) {
                    count++;
                    words[j] = " ";
                }
            }
            if (words[i].equals(" ")) {
                continue;
            }
            System.out.println(words[i] + "=" + count);
        }
    }
}

 */