package by.it.plehanova.jd02_01;

import java.util.ArrayList;

class Basket {

    private ArrayList<Good> goodsInBasket = new ArrayList<>();

    public void putGoods(Good good) {
        goodsInBasket.add(good);
    }

    public ArrayList<Good> getGoodsInBasket() {
        return goodsInBasket;
    }
}
