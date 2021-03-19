package by.it.evstratov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

    static String process(ArrayList<String> peoples){
        ArrayList<String> result = peoples;
        int count = 1;
        while (result.size() != 1){
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()){
                String name = iterator.next();
                if(count%2 == 0){
                    iterator.remove();
                }
                count++;
            }
        }

        return result.get(0);
    }

    static String process(LinkedList<String> peoples){
        LinkedList<String> result = peoples;
        int count = 1;
        while (result.size() != 1){
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()){
                String name = iterator.next();
                if(count%2 == 0){
                    iterator.remove();
                }
                count++;
            }
        }

        return result.get(0);
    }

    public static void main(String[] args) {

        ArrayList<String> people1 = new ArrayList<>();
        LinkedList<String> people2 = new LinkedList<>();

        for (int i = 0; i < 4096; i++) {
            people1.add(i+"");
            people2.add(i+"");
        }

        long start1 = System.nanoTime();
        System.out.println(process(people1));
        long end1 = System.nanoTime();
        System.out.println("Метод с ArrayList: "+(end1 - start1));

        long start2 = System.nanoTime();
        System.out.println(process(people2));
        long end2 = System.nanoTime();
        System.out.println("Метод с LinkedList: "+(end2 - start2));
    }
    
}
