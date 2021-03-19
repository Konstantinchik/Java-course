package by.it.leshchenko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Good> goods = new ArrayList<>();

    void put(Good good) {
        this.goods.add(good);
    }
}
