package by.it.arekhava.jd01_12;

import by.it._examples_.jd01_12.HashMapConstructor;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] values1={1,1,2,2,3,3,4,4,5,5,6,6,7,7};
        Integer[] values2={5,6,7,7,8,8,9,9,3,4,5};

        List<Integer> integers1 = Arrays.asList(values1);
        List<Integer> integers2 = Arrays.asList(values2);
        HashSet<Integer> hashSet = new HashSet<>(integers1);
        TreeSet<Integer> treeSet = new TreeSet<>(integers2);
        System.out.printf("hashSet=%s\n", hashSet);
        System.out.printf("hashSet=%s\n", treeSet);
        Set<Integer> union=getUnion(hashSet, treeSet);
        System.out.printf("union=%s\n", union);
        Set<Integer> cross=getCross(hashSet, treeSet);
        System.out.printf("cross=%s\n", cross);





    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        //result.removeIf(integer -> {return !set2.contains(integer)});

        result.retainAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>();
        result.addAll(set1);
        result.addAll(set2);
        return result;
    }
}
