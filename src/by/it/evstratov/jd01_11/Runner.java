package by.it.evstratov.jd01_11;

import by.it._khmelov_.jd01_11.ListA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

        Set<String> set1 = new SetC<>();
        Set<String> set2 = new SetC<>();
        Set<String> set3 = new HashSet<>();
        set3.add(null);
        set2.add("3");
        set2.add(null);
        set2.add("null");
        set2.add("1");
        set2.add("7");
        set2.add("null");
        set2.add(null);

        System.out.println(set2.toString());

        set1.add("3");
        set1.add("4");
        set1.add(null);
        set1.add("6");
        set1.add("1");
        set1.add("7");
        set1.add("null");
        System.out.println(set1.toString());
        set2.addAll(set1);
        System.out.println(set2.toString());
    }
}
