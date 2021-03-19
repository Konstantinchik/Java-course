package by.it.novik.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer>one,Set<Integer>two){
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer>one,Set<Integer>two){
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }



    public static void main(String[] args) {
        TreeSet<Integer>threeSet = new TreeSet<>(Arrays.asList(1,2,3,4,4,4,5,6,7,8,8,9));
        HashSet<Integer>hashSet = new HashSet<>(Arrays.asList(1,1,2,3,6,54,3,5,7,6));
        System.out.println(getCross(threeSet,hashSet));
        System.out.println(getUnion(threeSet,hashSet));


    }
}
