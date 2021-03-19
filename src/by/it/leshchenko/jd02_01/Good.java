package by.it.leshchenko.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Good {

    private final String name;
    private final int price;

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    static Map<String, Integer> goods = new HashMap<>();

    static {
        goods.put("Milk", 150);
        goods.put("Bread", 120);
        goods.put("Cheese", 230);
        goods.put("Beef", 510);
        goods.put("Chicken", 440);
    }

    static Good getRandomGood() {
        final List<String> values = new ArrayList<>(goods.keySet());
        final String value = values.get(Helper.random(Good.goods.size()));
        for (Map.Entry<String, Integer> entry : goods.entrySet()) {
            if (entry.getKey().equals(value)) {
                return new Good(entry.getKey(), entry.getValue());
            }
        }
        throw new RuntimeException("getRandomGood() invalid");
    }

    @Override
    public String toString() {
        return name + " with price " + price;
    }
}