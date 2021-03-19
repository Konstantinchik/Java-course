package by.it.soldatenko.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, Object> map = new TreeMap<>();
        Map<Integer, Object> squizeMap = new TreeMap<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            Object s = scanner.next();
            if (s.equals(("end"))) {
                break;
            }
            for (; ; ) {
                int key = random.nextInt(1000000);
                if (!map.containsKey(key)) {
                    map.put(key, s);
                    break;
                }
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
           if(!squizeMap.containsValue(entry.getValue())){
               squizeMap.put(entry.getKey(), entry.getValue());
           }

        }
        System.out.println(squizeMap);



    }






}



