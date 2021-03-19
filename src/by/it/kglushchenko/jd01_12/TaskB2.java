package by.it.kglushchenko.jd01_12;

import java.util.*;

// Люди удаляются покругу

public class TaskB2 {
    public static void main(String[] args) {
        int players = 7; // 7 игроков задействовано
        ArrayList<String> list1 = new ArrayList<>();
        //list1 = Arrays.asList("Vanya", "Manya", "Petya", "Dania", "Sonya", "Monya", "Borya");
        list1.add("Vanya");
        list1.add("Manya");
        list1.add("Petya");
        list1.add("Dania");
        list1.add("Sonya");
        list1.add("Monya");
        list1.add("Borya");

        LinkedList<String> list2 = new LinkedList<>();
        //list2 = Arrays.asList("Vanya", "Manya", "Petya", "Dania", "Sonya", "Monya", "Borya");
        list2.add("Vanya");
        list2.add("Manya");
        list2.add("Petya");
        list2.add("Dania");
        list2.add("Sonya");
        list2.add("Monya");
        list2.add("Borya");

        //System.out.println(list1.indexOf(2));

        System.out.println(process(list1));
        System.out.println(process(list2));

    }

    static String process(ArrayList<String> peoples) {
        //Iterator<String> iterator = peoples.iterator();
        String result = ""; // имя счастливчика
        int second = 0;    // если элемент второй - его удаляем
        int index = 0;    // индекс элемента
        int size = peoples.size();


//        for (; ; ) {
//            if (second == 1) {
//                peoples.remove(index);
//                size = peoples.size(); // обновляем размер списка
//                System.out.println("Size " + size); // отслеживаем размер списка
//                second = 0;
//                continue;
//            }
//
        while (peoples.size() >1) {

            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                index++;
                if (index % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        //ListIterator<String> listIterator = peoples.listIterator(); // помещаем указатель в начало списка
        String result = " "; // имя счастливчика
        int second = 0;    // если элемент второй - его удаляем
        int index = 0;    // индекс элемента


//        ListIterator<String> listIterator = peoples.listIterator(); // помещаем указатель в начало списка
        // peoples.descendingIterator() - обход с конца списка
        //int second=0; // если элемент второй - его удаляем
//        while (listIterator.hasNext()){
//            if(second==1){
//                listIterator.remove();
//                second=0;
//                continue;
//         }
//            System.out.println(listIterator.toString());

        while (peoples.size() >1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                index++;
                if (index % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }
}
