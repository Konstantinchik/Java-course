package by.it.kglushchenko.jd02_01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {

    public static List<Good> goods; // создаем List товаров чтобы можно было сортировать товары по именам

    public static Map<Good, BigDecimal> priceList; // объединяем товар с ценой

    private static void addGood(String name, BigDecimal price) {
        Good good = new Good(name);
        goods.add(good);
        priceList.put(good, price);
    }

    private static void addGoodsAndPrices() {
        goods = new ArrayList<>();
        priceList = new HashMap<>();

        addGood("Хлеб", BigDecimal.valueOf(10.50));
        addGood("Молоко", BigDecimal.valueOf(2.33));
        addGood("Печенье", BigDecimal.valueOf(2.33));
        addGood("Сок", BigDecimal.valueOf(2.33));
        addGood("Варенье", BigDecimal.valueOf(2.33));
        addGood("Конфеты", BigDecimal.valueOf(2.33));
        addGood("Кофе", BigDecimal.valueOf(2.33));
        addGood("Чай", BigDecimal.valueOf(2.33));
    }

    public static void main(String[] args) {
        Dispatcher.buyersInMarket = 0;          // в магазине никого

        addGoodsAndPrices();

        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();

        int n = 0;
        for (int t = 1; t <= 120; t++) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count; i++) {
                boolean pensioner = false;
                //
                if (Helper.getRandom(1, 4) == 4){
                    pensioner = true;
                }



                Buyer buyer = new Buyer(++n);
                buyers.add(buyer);                      // добавили покупателя
                buyer.setPensioneerState(pensioner);    // задали пенсионный статус
                buyer.start();                          // запустили его поток
                //noinspection NonAtomicOperationOnVolatileField
                Dispatcher.buyersInMarket++;
            }
            Helper.sleep(1000);
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();               // Thread  main ждет отработки всех потоков покупателей
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");
    }

}
