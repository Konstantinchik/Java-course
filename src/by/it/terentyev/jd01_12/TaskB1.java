package by.it.terentyev.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> hashmap = new HashMap<String, Integer>();

        for (; ; ) {
            String word = scanner.next();
            word= word.replaceAll("[,.;)(]","");
            if (word.equals("end")) {
                break;
            }
            if (word.equals("isn't")) word = "don't";
            Integer chek = hashmap.get(word);
            if (chek == null) {
                hashmap.put(word, 1);

            } else if (chek > 0) {
                hashmap.put(word, chek + 1);

            }
        }
        if (!hashmap.isEmpty()){
            System.out.println(hashmap);
        }


    }
}
