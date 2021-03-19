package by.it.soldatenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            list.add("a");
        }
        process(list);

        LinkedList<String> lList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {

            lList.add("a");
        }
        process(lList);

        LinkedList<String> shortList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            shortList.add("a");
        }
        shortProcess(shortList);

    }
    static String process(ArrayList<String> peoples){
        Long t1 = System.nanoTime();
        int count = 0;
        Iterator i = peoples.iterator();
        while(peoples.size() > 1) {
            if(i.hasNext()) {
                i.next();
                count++;
                if(count == 2) {
                    i.remove();
                    count = 0;
                }
            }
            else {
                i = peoples.iterator();
            }

        }
        Long t2 = System.nanoTime();
        System.out.println("ArrayList " + (t2-t1));
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples){

        peoples.addLast(peoples.removeFirst());
        peoples.removeFirst();
        Long t1 = System.nanoTime();
        int count = 0;
        Iterator i = peoples.iterator();
        while(peoples.size() > 1) {
            if(i.hasNext()) {
                i.next();
                count++;
                if(count == 2) {
                    i.remove();
                    count = 0;
                }
            }
            else {
                i = peoples.iterator();
            }

        }
        Long t2 = System.nanoTime();
        System.out.println("LinkedList " + (t2-t1));
        return peoples.get(0);
    }
    static String shortProcess(LinkedList<String> peoples){
        Long t1 = System.nanoTime();
        while (peoples.size()>1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        Long t2 = System.nanoTime();
        System.out.println("LinkedList " + (t2-t1));
        return peoples.get(0);
    }

}
