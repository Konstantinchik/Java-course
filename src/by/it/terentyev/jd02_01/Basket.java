package by.it.terentyev.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Basket {

    public static List<String> putToBasket (int numberGoods){
        List<String> basket = new ArrayList<>();
        List<String> keys = new ArrayList<>(Good.goods.keySet());
        Random random = new Random();
        for (int i = 0; i <= numberGoods; i++) {
            int timeout = Helper.getRandom(500,2000);
            Helper.sleep(timeout);
            String randomKey = keys.get(random.nextInt(keys.size()));
            basket.add(randomKey + " " + Good.goods.get(randomKey));
        }
        return basket;
    }

}
