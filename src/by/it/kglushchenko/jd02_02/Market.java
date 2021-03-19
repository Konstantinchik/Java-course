package by.it.kglushchenko.jd02_02;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {

    public static List<Good> goods;                 // создаем List товаров чтобы можно было сортировать товары по именам

    public static Map<Good, BigDecimal> priceList;  // объединяем товар с ценой

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
        Dispatcher.reset();
        // Открыли магазин
        System.out.println("Market opened");

        // Создали список покупателей и кассиров
        // чтобы и кассиры и покупатели были в одном List меняем Buyers на Thread
        List<Thread> threads = new ArrayList<>();     // ArrayList не потокобезопасный но доступ к неиу только из потока main

        // запускаем кассиров
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread); // добавляем кассира
            thread.start();
        }
        int n = 0;
        /*
        теперь не привязываемся ко времени.
         */
//        // время от 1 секунды до 120
//        for (int t = 1; t <= 120; t++) {            // мат ожидание дает в среднем заход 120 человек
//            // количество покупателей
//            int count = getRandom(2);   // каждую секунду заходит 0 или 1 или 2 человека +
//            for (int i = 1; i <= count; i++) {      //                                               |
//                Buyer buyer = new Buyer(++n);       //                                               |
//                threads.add(buyer);                  // добавляем нового посетителя в коллекцию       |
//                // buyer - extended Thread - его можно добамить в List
//                buyer.start();                      // cтартуем поток посетителя                     |
//                //noinspection NonAtomicOperationOnVolatileField
//                //Dispatcher.buyersInMarket++;        //                                               |
//                Dispatcher.addBuyer();
//            }                                       //                                               |
//            sleep(1000);              //                                         <-----|
//        }
        while (Dispatcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count && Dispatcher.marketIsOpened(); i++) {
                boolean pensioner = Helper.getRandom(1, 4) == 4;
                Buyer buyer = new Buyer(++n, pensioner);
                threads.add(buyer);
                buyer.start();

                // todo Убрать. Это для примера
                // ....
                /*
                // Это делает вот что
                //      buyer.interrupt = true
                buyer.interrupt();
                */
            }
            Helper.sleep(1000);
        }
        // чтобы магазин закрылся после последнего покупателя
        try {
            for (Thread thread : threads) {
                thread.join();                   // join-им Thread main-а ко всем потокам созданным покупателям
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // ко всем потокам прицепились, когда все закончились, закрываемся
        System.out.println("Market closed");
    }
}
