package by.it.evstratov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

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

        ArrayList<String> men = new ArrayList<>(Arrays.asList("1", "1", "3", "1", "3", "5", "7", "1", "3", "5", "7", "9", "11", "13", "15", "1"));
        LinkedList<String> men1 = new LinkedList<>(Arrays.asList("1", "1", "3", "1", "3", "5", "7", "1", "3", "5", "7", "9", "11", "13", "15", "1"));
        System.out.println(process(men));
        System.out.println(process(men1));
    }

}
