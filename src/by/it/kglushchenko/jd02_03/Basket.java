package by.it.kglushchenko.jd02_03;


import java.util.HashMap;
import java.util.Map;

public class Basket {
    // название товара, количество товара
    private final Map<Good, Integer> goods = new HashMap<>();

    // добавляем товар в Map
    public void add(Good good, Integer countAdd) {
        Integer count = goods.get(good);
        if (count == null) {
            goods.put(good, countAdd);
        } else {                                     // если такой товар уже есть увеличиваем его количество
            goods.put(good, count + countAdd);
        }
    }

    public boolean isInBasket(Good good) {
        return goods.containsKey(good);
    }
}
