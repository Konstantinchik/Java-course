package by.it.soldatenko.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Good {
    static String []getGood() {
        Map<String, Integer> assortment = new HashMap<>();
        String [] good = new String[2];
        int r = Helper.getRandom(1, 4);
        assortment.put("food", 1);
        assortment.put("shoes", 2);
        assortment.put("closes", 3);
        assortment.put("ipfone", 4);
        for (Entry entry : assortment.entrySet()){
            if (entry.getValue().equals(r)) {
                good [0]= (String) entry.getKey();
                good [1]= Integer. toString((Integer) entry.getValue());
            }}
        return good;

    }

}

