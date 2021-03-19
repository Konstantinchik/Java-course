package by.it.leshchenko.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        System.out.println(list2.add("One"));
        System.out.println(list2.add("22"));
        list2.add("33");
        list2.add("44");
        list2.add("55");
        list.addAll(list2);
        System.out.println(list);
    }
}
