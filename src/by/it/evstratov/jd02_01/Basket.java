package by.it.evstratov.jd02_01;

import java.util.ArrayList;

class Basket {

    private ArrayList<Good> basket = new ArrayList<>();

    public void put(Good good){
     this.basket.add(good);
    }

}
