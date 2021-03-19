package by.it.plehanova.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static by.it.plehanova.jd01_12.Test_jd01_12.text;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();


        while (scanner.hasNext()) {
            String text = scanner.next().trim().replaceAll("[^a-zA-Z']+", "");
            if(text.equals("end")){
                break;
            }
            if (map.containsKey(text)) {
                map.computeIfPresent(text, (k,v) -> v+1);
            } else {
                map.put(text, 1);
            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.printf("%s=%d\n", entry.getKey(), entry.getValue());
        }

    }
}
