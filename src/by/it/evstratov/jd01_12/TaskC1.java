package by.it.evstratov.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {

        Map<Long,String> namesObjects = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        String str;

        while (!(str = scanner.next()).equals("end")){
            namesObjects.put(System.nanoTime(), str);
        }

        System.out.println(namesObjects.toString());

        Set<String> values = new HashSet<>();

        Iterator<Map.Entry<Long, String>> entries = namesObjects.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<Long, String> entry = entries.next();
            if(!values.add(entry.getValue())){
                entries.remove();
            }
        }

        System.out.println(namesObjects.toString());

    }

}
