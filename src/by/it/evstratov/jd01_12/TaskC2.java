package by.it.evstratov.jd01_12;

import java.math.BigDecimal;
import java.util.*;

public class TaskC2 {

    private static Set<?> getUnion(Set<? extends Number>... sets){
        Set<Number> result = new TreeSet<>(new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                BigDecimal b1 = new BigDecimal(n1.doubleValue());
                BigDecimal b2 = new BigDecimal(n2.doubleValue());
                return b1.compareTo(b2);
            }
        });

        for (Set<? extends Number> set : sets) {
            Iterator<? extends Number> iterator = set.iterator();
            while (iterator.hasNext()){
                Number next = iterator.next();
                result.add(next);
            }
        }

        return result;
    }

    private static Set<?> getCross(Set<? extends Number>... sets){
        Map<Number, Integer> numberIntegerMap = new HashMap<>();
        Set<Number> resultNumbers = new HashSet<>();
        Set<Number> result = new TreeSet<>(new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                if(n1.longValue() == n2.longValue() || n1.doubleValue() == n2.doubleValue()){
                    return 0;
                }else if(n1.longValue() > n2.longValue() || n1.doubleValue() > n2.doubleValue()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        result.addAll(sets[0]);


        for (Set<? extends Number> set : sets) {
            int count = 0;
            Iterator<? extends Number> iterator1 = set.iterator();
            while (iterator1.hasNext()){
                Number next1 = iterator1.next();

                Iterator<Number> iterator2 = result.iterator();
                while (iterator2.hasNext()){
                    Number next2 = iterator2.next();

                    BigDecimal b1 = new BigDecimal(next1.doubleValue());
                    BigDecimal b2 = new BigDecimal(next2.doubleValue());

                    BigDecimal b1Long = new BigDecimal(next1.longValue());
                    BigDecimal b2Long = new BigDecimal(next2.longValue());

                    if(b1.compareTo(b2) == 0 || b1Long.compareTo(b2Long) == 0){
                        if(!numberIntegerMap.containsKey(next1.doubleValue())){
                            numberIntegerMap.put(next1.doubleValue(), count);
                        }else{
                            numberIntegerMap.put(next1.doubleValue(), numberIntegerMap.get(next1.doubleValue())+1);
                        }
                    }
                }

            }

        }
        for(Map.Entry<Number, Integer> item : numberIntegerMap.entrySet()){
            if(item.getValue() == sets.length-1){
                resultNumbers.add(item.getKey());
            }
        }

        return resultNumbers;
    }


    public static void main(String[] args) {

        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));

        System.out.println(getUnion(a,b,c,d));
        System.out.println(getCross(a,b,c,d));
    }

}
