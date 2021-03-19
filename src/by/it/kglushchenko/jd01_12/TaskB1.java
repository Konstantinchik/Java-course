package by.it.kglushchenko.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
//

        String inputString;
        while (!((inputString = scanner.nextLine().trim()).equals("end"))) {

            if (map.containsKey(inputString)) {     // проверяем если в Map введенное слово
                map.computeIfPresent(inputString, (key, value) -> value+1); // если есть, увеличиваем Value для рассчетанового hash
            } else {
                map.put(inputString, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s=%d\n", entry.getKey(), entry.getValue());
        }

    }
}

