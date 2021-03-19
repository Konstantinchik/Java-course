package by.it.leshchenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("0 Владислав");
        arrayList.add("1 Борис");
        arrayList.add("2 Константин");
        arrayList.add("3 Дмитрий");
        arrayList.add("4 Александра");
        arrayList.add("5 Андрей");
        arrayList.add("6 Игорь");
        arrayList.add("7 Илья");
        System.out.println(process(arrayList));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0 Наталья");
        linkedList.add("1 Анастасия");
        linkedList.add("2 Сергей");
        linkedList.add("3 Иван");
        linkedList.add("4 Мария");
        linkedList.add("5 Роман");
        linkedList.add("6 Георгий");
        linkedList.add("7 Владимир");
        System.out.println(process(linkedList));
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
}
