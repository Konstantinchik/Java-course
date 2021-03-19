package by.it.soldatenko.jd01_11;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<String> list=new SetC<>();
        Set <String> orList = new HashSet<>();
        orList.add("One");
        orList.add("Two");
        orList.add("Three");
        orList.add("Four");
        orList.add("Two");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Two");
        System.out.println(list + " "+ list.size());
        System.out.println(orList + " "+ orList.size());
//        Set <String> newList = new HashSet<>();
//        newList.add("Seven");newList.add("Eight");

//        list.addAll(newList);
//        orList.addAll(newList);
//        System.out.println("есть "+list);
//        System.out.println( "надо " + orList);

//        List<String> list=new ListB<>();
//        List <String> orList = new ArrayList<>();
//        list.add("One"); orList.add("One");
//        list.add("Two"); orList.add("Two");
//        list.add("Three"); orList.add("Three");
//        list.add("Four"); orList.add("Four");
//        list.add("Five"); orList.add("Five");
//        System.out.println(list);
//        System.out.println(orList);
//        List <String> newList = new ArrayList<>();
//        newList.add("Seven");newList.add("Eight");


//        orList.set(2, "Six");
//        list.set(2, "Six");
//        List<String> list=new ListA<>();
//        List <String> orList = new ArrayList<>();
//        list.add("One"); orList.add("One");
//        list.add("Two"); orList.add("Two");
//        list.add("Three"); orList.add("Three");
//        list.add("Four"); orList.add("Four");
//        list.add("Five"); orList.add("Five");
//        System.out.println(list);
//        System.out.println(orList);
//        list.remove(4);
//        orList.remove(4);
//        System.out.println(list);
//        System.out.println(orList);

    }
}
