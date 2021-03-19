package by.it.plehanova.jd01_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Runner {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        List<String> myAList = new ListA<>();
        List<String> myBList = new ListB<>();
        HashSet hs = new HashSet();

        hs.add("One");
        hs.add("Two");
        hs.add("Three");
        hs.add("Four");
        hs.add("Five");

        System.out.println(hs);

        System.out.println("====================================================");
        arrList.add("One");
        arrList.add("Two");
        arrList.add("Three");
        arrList.add("Four");
        arrList.add("Five");

        myAList.add("One");
        myAList.add("Two");
        myAList.add("Three");
        myAList.add("Four");
        myAList.add("Five");

        myBList.add("One");
        myBList.add("Two");
        myBList.add("Three");
        myBList.add("Four");
        myBList.add("Five");

        System.out.println("arrList: " + arrList + "\nmyAList: " + myAList + "\nmyBList: " + myBList);

        arrList.remove(2);
        arrList.remove(3);

        myAList.remove(2);
        myAList.remove(3);

        myBList.remove(2);
        myBList.remove(3);

        System.out.println("arrList: " + arrList + "\nmyAList: " + myAList + "\nmyAList: " + myBList);

        String s = myBList.set(2, "Hello");
        System.out.println("\nmyBList: " + myBList + "   " + s);

        SetC<Short> number = new SetC<>();

        boolean check = number.contains(7);

        number.addAll(Arrays.asList(null,null,1,2,3,4,5));
        System.out.println(number + "   " + number.size() + check);
        number.removeAll(Arrays.asList(null,null,1,2,3,4,5));
        System.out.println(number + "   " + number.size() + check);


    }
}
