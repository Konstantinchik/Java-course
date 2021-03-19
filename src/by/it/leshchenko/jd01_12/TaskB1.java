package by.it.leshchenko.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().trim().replaceAll("[.,—;]", "");
            if (!word.equals("end")) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);
                }
            } else {
                break;
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }
}
