package by.it.leshchenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public class TaskB3 {

    public static void main(String[] args) {

        int count = 4096;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add("n" + i);
        }
        long startTimer = System.nanoTime();
        System.out.println(process(arrayList));
        System.out.printf("Время работы для ArrayList = %s\n", System.nanoTime() - startTimer);

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            linkedList.add("n" + i);
        }
        long startTimer2 = System.nanoTime();
        System.out.println(process(linkedList));
        System.out.printf("Время работы для LinkedList = %s\n", System.nanoTime() - startTimer2);

        LinkedList<String> linkedList2 = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            linkedList2.add("n" + i);
        }
        long startTimer3 = System.nanoTime();
        System.out.println(queueProcess(linkedList2));
        System.out.printf("Время работы для LinkedList (queueProcess) = %s\n", System.nanoTime() - startTimer3);

    }

    static String process(ArrayList<String> peoples) {
        int n = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                n++;
                if (n % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int n = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                n++;
                if (n % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String queueProcess(LinkedList<String> peoples) {
        int n = 0;
        while (peoples.size() > 1) {
            peoples.addLast(peoples.pollFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

}
