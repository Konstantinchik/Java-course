package by.it.soldatenko.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Good {
    static String getGood (){
        Map<String, Integer> assortment = new HashMap<>();
        String good = "";
        int r =Helper.getRandom(1,4);
        assortment.put("food",1);
        assortment.put("shoes",2);
        assortment.put("closes",3);
        assortment.put("ipfone",4);
        for (Entry entry : assortment.entrySet())
            if (entry.getValue().equals(r)) {
                good = (String) entry.getKey();
            }
        return good;
    }

}

