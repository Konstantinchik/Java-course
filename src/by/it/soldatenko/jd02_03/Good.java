package by.it.soldatenko.jd02_03;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

class Good {
    static String[] getGood() {
        final Map<String, Integer> assortment = new ConcurrentHashMap<>();
        String[] good = new String[2];
        int r = Helper.getRandom(1, 4);
        assortment.put("food", 1);
        assortment.put("shoes", 2);
        assortment.put("closes", 3);
        assortment.put("ipfone", 4);
        for (Entry entry : assortment.entrySet()) {
            if (entry.getValue().equals(r)) {
                good[0] = (String) entry.getKey();
                good[1] = Integer.toString((Integer) entry.getValue());
            }
        }
        return good;

    }

}

