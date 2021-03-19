package by.it.leshchenko.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Double[] values1 = {1.0, 1.1, 2.0, 2.0, 3.0, 3.1, 4.0, 4.1, 5.0, 5.0};
        Integer[] values2 = {9, 8, 8, 7, 6, 5, 4, 3, 2, 0};
        List<Number> integers1 = Arrays.asList(values1);
        List<Number> integers2 = Arrays.asList(values2);

        HashSet<Number> hashSet = new HashSet<>(integers1);
        TreeSet<Number> treeSet = new TreeSet<>(integers2);

        System.out.printf("hashSet=%s\n", hashSet);
        System.out.printf("treeSet=%s\n", treeSet);
        Set<Number> union = getUnion(hashSet, treeSet);
        System.out.printf("union=%s\n", union);
        Set<Number> cross = getCross(hashSet,treeSet);
        System.out.printf("cross=%s\n", cross);
    }

    @SafeVarargs
    private static Set<Number> getCross(Set<Number>... set) {
        Set<Number> result = new HashSet<>();
        for (Number number : set[0]) {
            result.add(number.doubleValue());
        }
        for (int i = 1; i < set.length; i++) {
            Set<Number> tempSet = new HashSet<>();
            for (Number number : set[i]) {
                tempSet.add(number.doubleValue());
            }
            result.retainAll(tempSet);
        }
        return result;
    }

    @SafeVarargs
    private static Set<Number> getUnion(Set<Number>... set) {
        Set<Number> result = new HashSet<>();
        for (Set<Number> numbers : set) {
            for (int j = 0; j < numbers.size(); j++) {
                for (Number number : numbers) {
                    result.add(number.doubleValue());
                }
            }
        }
        return result;
    }
}
