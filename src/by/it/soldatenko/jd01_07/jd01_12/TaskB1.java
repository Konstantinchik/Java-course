package by.it.soldatenko.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> hashMap = new HashMap<>();
//        String t = Test_jd01_12.text;
//        System.out.println(t);
        Pattern pat = Pattern.compile("[a-zA-Z']+");
        for (;;) {
            String s = scanner.next();
            if (s.equals(("end"))) {
                break;
            }
            Matcher match = pat.matcher(s);
            while (match.find()) {
                String word = match.group();
                if (!hashMap.containsKey(word)) {
                    hashMap.put(word, 1); //map.put(key, map.get(value)+1)

                } else {
                    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        if (entry.getKey().equals(word)) {
                            int v = entry.getValue();
                            hashMap.put(word, v + 1);
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry: hashMap.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());
    }
}
