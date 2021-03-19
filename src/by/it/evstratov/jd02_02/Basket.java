package by.it.evstratov.jd02_02;

import java.util.ArrayList;

class Basket {

    private ArrayList<Good> goods = new ArrayList<>();

    public void put(Good good){
     this.goods.add(good);
    }

    public ArrayList<Good> getGoods() {
        return goods;
    }
}
