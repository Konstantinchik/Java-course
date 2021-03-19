package by.it.leshchenko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Good> goods = new ArrayList<>();

    void put(Good good) {
        this.goods.add(good);
    }
}
