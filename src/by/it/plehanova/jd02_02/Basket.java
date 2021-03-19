package by.it.plehanova.jd02_02;

import java.util.ArrayList;

class Basket {

    private ArrayList<Good> goodsInBasket = new ArrayList<>();

    public ArrayList<Good> getGoodsInBasket() {
        return goodsInBasket;
    }

    public void putGoods(Good good) {
        goodsInBasket.add(good);
    }
}
