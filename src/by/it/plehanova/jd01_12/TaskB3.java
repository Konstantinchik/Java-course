package by.it.plehanova.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoples1 = new ArrayList<>();
        LinkedList<String> peoples2 = new LinkedList<>();

        String s = "";
        for (int i = 0; i < 4096; i++) {
            peoples1.add(s + i);
            peoples2.add(s + i);
        }
        long time1 = System.nanoTime();
        process(peoples1);
        System.out.println("ArrayList " + (System.nanoTime() - time1));
        long time2 = System.nanoTime();
        process(peoples2);
        System.out.println("LinkedList " + (System.nanoTime() - time2));
        long time3 = System.nanoTime();
        process1(peoples2);
        System.out.println("LinkedList with iterator " + (System.nanoTime() - time3));
    }

    static String process(ArrayList<String> peoples) {
        int count = 0;

        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {

        while (peoples.size() > 1) {
            String s = peoples.pollFirst();
            peoples.addLast(s);
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

    static String process1(LinkedList<String> peoples) {
        int count = 0;

        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }
}
