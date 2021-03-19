package by.it.terentyev.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        HashMap<String, Integer> x = new HashMap<>();
        List<String> purchases = new ArrayList<String>();

        x.put("apple", 2);
        x.put("juice", 7);
        x.put("Tea", 4);
        x.put("coffee", 8);
        x.put("ice-cream", 1);
        x.put("milk", 3);
        Random random = new Random();
        List<String> keys = new ArrayList<>(x.keySet());

        int quantityGoods = random.nextInt(3);
        for (int i = 0; i <= quantityGoods; i++) {
            String randomKey = keys.get(random.nextInt(keys.size()));
            purchases.add(randomKey + " " + x.get(randomKey));
        }

        System.out.println(purchases);
        System.out.println(keys);
        System.out.println(quantityGoods);

    }
}
