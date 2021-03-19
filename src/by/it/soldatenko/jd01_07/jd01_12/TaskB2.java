package by.it.soldatenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        System.out.println(process(list));
       process(list);
        LinkedList<String> lList = new LinkedList<>();
        lList.add("One");
        lList.add("Two");
        lList.add("Three");
        lList.add("Four");
        lList.add("Five");
        lList.add("Six");
        lList.add("Seven");
        System.out.println(process(lList));
        process(lList);


    }
    static String process(ArrayList<String> peoples){
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

        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples){
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

        return peoples.get(0);
    }
}
