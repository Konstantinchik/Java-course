package by.it.zavoiskikh.jd01_06;
import java.util.ArrayList;
public class TaskB1 {


    public static void main(String[] args) {


        String words[] = Poem.text.split(" ");
        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            if (ch == 'а' || ch == 'е' || ch == 'ё' || ch == 'и' || ch == 'о' || ch == 'у' || ch == 'ы' || ch == 'э' || ch == 'ю' || ch == 'я' || ch == 'А' || ch == 'Е' || ch == 'Ё' || ch == 'И' || ch == 'О' || ch == 'У' || ch == 'Ы' || ch == 'Э' || ch == 'Ю' || ch == 'Я');
            System.out.println(words[i]);
        }
    }
        }



//if (ch == 'б' || ch == 'в' || ch == 'г' || ch == 'д' || ch == 'ж' || ch == 'з' || ch == 'й' || ch == 'к' || ch == 'л' || ch == 'м' ||
//                        ch == 'н' || ch == 'п' || ch == 'р' || ch == 'с' || ch == 'т' || ch == 'ф' || ch == 'х' || ch == 'ц' || ch == 'ч' || ch == 'ш' ||
//                        ch == 'ш' || ch == 'Б' || ch == 'В' || ch == 'Г' || ch == 'Д' || ch == 'Ж' || ch == 'З' || ch == 'Й' || ch == 'К' || ch == 'Л' || ch == 'М' ||
//                        ch == 'Н' || ch == 'П' || ch == 'Р' || ch == 'С' || ch == 'Т' || ch == 'Ф' || ch == 'Х' || ch == 'Ц' || ch == 'Ч' || ch == 'Щ' ||
//                        ch == 'Щ') ;






