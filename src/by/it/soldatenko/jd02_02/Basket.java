package by.it.soldatenko.jd02_02;

import java.util.HashMap;

public class Basket {

    static synchronized HashMap<String, Integer> getBasket() {
        HashMap<String, Integer> set = new HashMap<>();
        String[] setS;
        int goodsAmount = Helper.getRandom(1, 4);
        for (int i = 1; i <= goodsAmount; i++) {
            Helper.sleep(Helper.getRandom(500, 2000));
            setS = Good.getGood();
            set.put(setS[0], Integer.parseInt(setS[1]));
        }
        return set;
    }

}
