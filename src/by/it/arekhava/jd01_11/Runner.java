package by.it.arekhava.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<String > list=new ListA<>();
        list.add("One");//0
        list.add("Two");//1
        list.add("Tree");//2
        list.add("Four");
        list.add("Five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
