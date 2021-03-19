package by.it.plehanova.jd02_01;

import java.util.HashMap;

class ListGoods {
    private static HashMap<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Salt", 20.0));
        goods.put(2, new Good("Water", 25.2));
        goods.put(3, new Good("Bread", 32.1));
        goods.put(4, new Good("Milk", 45.3));
        goods.put(5, new Good("Cheese", 73.4));
        goods.put(6, new Good("Potato", 62.1));
    }

    public static Good randomGood() {
        int randomKey = Helper.getRandom(1,goods.size());
        Good good = goods.get(randomKey);
        return good;
    }
}
