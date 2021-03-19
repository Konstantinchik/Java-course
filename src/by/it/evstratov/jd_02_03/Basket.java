package by.it.evstratov.jd_02_03;

import java.util.ArrayList;

class Basket {

    private final ArrayList<Good> goods = new ArrayList<>();

    public void put(Good good){
     this.goods.add(good);
    }

    public ArrayList<Good> getGoods() {
        return goods;
    }
}
