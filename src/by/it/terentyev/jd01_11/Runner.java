package by.it.terentyev.jd01_11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list =new ListB<>();
        List<String> list2 =new ListB<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        list2.add("Four");
        list2.add("Five");
        System.out.println(list);
        list.remove(2);
        list.set(2, "Seven");
        System.out.println(list);
        list.add(2, "Six");
        System.out.println(list);
       //list.addAll(2, Arrays.list2);
        System.out.println(list);


    }
}
