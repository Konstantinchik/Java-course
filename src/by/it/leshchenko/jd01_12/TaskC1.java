package by.it.leshchenko.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Long, String> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("end")) {
                break;
            }
            map.put(System.nanoTime(), s);
        }
        System.out.println(map.toString());

        HashSet<String> hashSet = new HashSet<>();
        Iterator<String> it = map.values().iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (hashSet.contains(s)) {
                it.remove();
            } else {
                hashSet.add(s);
            }
        }
        System.out.println(map.toString());
    }
}
