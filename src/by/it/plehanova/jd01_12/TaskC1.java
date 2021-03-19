package by.it.plehanova.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<Long, String> objects = new HashMap<>();

        while (!scanner.hasNext("end")) {
            objects.put(System.nanoTime(), scanner.next());
        }
        System.out.println(objects.toString());
        Collection<String> values = objects.values();
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (Collections.frequency(values, value) > 1) {
                iterator.remove();
            }
        }
        System.out.println(objects.toString());
    }
}
