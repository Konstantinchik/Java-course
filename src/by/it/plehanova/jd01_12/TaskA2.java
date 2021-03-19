package by.it.plehanova.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] values1 = {1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7};
        Integer[] values2 = {5, 6, 7, 8, 9, 9, 8, 7, 6, 5};
        List<Integer> integer1 = Arrays.asList(values1);
        List<Integer> integer2 = Arrays.asList(values2);

        HashSet<Integer> hashSet = new HashSet<>(integer1);
        TreeSet<Integer> treeSet = new TreeSet<>(integer2);

        System.out.printf("hashset=%s\n" , hashSet);
        System.out.printf("treeSet=%s\n" , treeSet);

        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.printf("union=%s\n", union);
        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.printf("cross=%s\n", cross);
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        //result.removeIf(integer -> !set2.contains(integer));

        /*for (Integer integer : result) {
            if (!set2.contains(integer)) {
            }
        }*/
        result.retainAll(set2);
        return result;
    }

}
