package by.it.novik.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.next()).equals("end")) {
            String word=str.replaceAll("[,.:;]", "");
            if(!words.containsKey(word)){
                words.put(word,1);
            }else{
                words.put(word,words.get(word)+1);
            }
        }

        for(Map.Entry<String,Integer> i: words.entrySet()){
            System.out.printf("%s=%d\n", i.getKey(), i.getValue());
        }
    }
}
