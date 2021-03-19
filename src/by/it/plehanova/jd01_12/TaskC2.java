package by.it.plehanova.jd01_12;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Integer[] values1 = {1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7};
        Double[] values2 = {5.0, 6.0, 7.0, 8.0, 9.0, 9.0, 8.0, 7.0, 6.0, 5.0};
        Long[] values3 = {5L, 6L, 7L, 8L, 9L, 9L, 8L, 7L, 6L, 5L};
        List<Integer> integers = Arrays.asList(values1);
        List<Double> doubles = Arrays.asList(values2);
        List<Long> longs = Arrays.asList(values3);

        HashSet<Number> hashSet = new HashSet<>(integers);
        TreeSet<Number> treeSet = new TreeSet<>(doubles);
        LinkedHashSet<Number> linkedSet = new LinkedHashSet<>(longs);

        System.out.printf("hashset=%s\n", hashSet);
        System.out.printf("treeSet=%s\n", treeSet);
        System.out.printf("linkedSet=%s\n", linkedSet);

        Set<Number> union = getUnion(hashSet, treeSet, linkedSet);
        System.out.printf("union=%s\n", union);

        Set<Number> cross = getCross(hashSet, treeSet, linkedSet);
        System.out.printf("cross=%s\n", cross);
    }

    private static Set<Number> getUnion(Set<Number>... set) {
        HashSet<Number> result = new HashSet<>();
        for (int i = 0; i < set.length; i++) {
            result.addAll(parse(set[i]));
        }
        return result;
    }

    private static Set<Number> getCross(Set<Number>... set) {
        HashSet<Number> result = new HashSet<>(parse(set[0]));
        for (int i = 1; i < set.length; i++) {
            result.retainAll(parse(set[i]));
        }
        return result;
    }

    private static Set<Double> parse(Set<Number> set) {
        Set<Double> result = new TreeSet<>();
        Iterator<Number> iterator = set.iterator();
        while (iterator.hasNext()) {
            Number n = iterator.next();
            Double d = n.doubleValue();
            result.add(d);
        }
        return result;
    }
}
