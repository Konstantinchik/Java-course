package by.it.novik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoples1=new ArrayList<>();
        LinkedList<String> peoples2=new LinkedList<>();
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
        String g="";
        for (int i = 0; i < 4096; i++) {
            peoples1.add(g + i);
            peoples2.add(g + i);
        }
        long time = System.nanoTime();
        process(peoples1);
        time = System.nanoTime() - time;
        System.out.println(time);
        long time2 = System.nanoTime();
        process(peoples2);
        time2 = System.nanoTime() - time;
        System.out.println(time2);
    }


    static String process(ArrayList<String> peoples){
        int count=0;
        while (peoples.size()>1){
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()){
                iter.next();
                count++;
                if(count%2==0){
                    iter.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int count=0;
        while (peoples.size()>1){
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()){
                iter.next();
                count++;
                if (count%2==0){
                    iter.remove();
                }
            }
        }
        return peoples.get(0);
    }
}
