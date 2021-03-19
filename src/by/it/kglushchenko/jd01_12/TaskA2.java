package by.it.kglushchenko.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
//        Integer[] val1 = {1,2,3,4,5,6,7,8};
//        Integer[] val2 = {1,2,3,4,5,6,7,8};
//
//        List<Integer> int1 = Arrays.asList(val1);
//        List<Integer> int2 = Arrays.asList(val2);

        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(9,8,7,4,4,4,5,5,6,6));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,4,4,5,5,6,6));
//        System.out.printf(" HashSet=%s\n", hashSet);
//        System.out.printf(" TreeSet=%s\n", treeSet);
//
//        Set<Integer> union = getUnion(hashSet, treeSet);
//        System.out.printf(" Union=%s\n", union);
//        Set<Integer> cross = getCross(hashSet, treeSet);
//        System.out.printf(" Cross=%s\n", cross);

//        System.out.println();
        System.out.println(getUnion(hashSet, treeSet));
        System.out.println(getCross(hashSet, treeSet));
    }

    public static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
       /* while(iterator.hasNext){
            Integer integer1;
            if(!set2.contains(integer)){

            }
        }*/
        result.retainAll(set2);
        return  result;
    }

    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return  result;
    }
}
