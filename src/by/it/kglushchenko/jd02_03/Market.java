package by.it.kglushchenko.jd02_03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        QueueBuyers queueBuyers = new QueueBuyers(30); // в очереди максимум покупателей, остальные на входе
        // Открыли магазин
        System.out.println("Market opened");

        addGoodsAndPrices(); // сформировали товары и цены

        /* OLD SCHOOL
        // Создали список покупателей и кассиров
        // чтобы и кассиры и покупатели были в одном List меняем Buyers на Thread
        //List<Thread> threads = new ArrayList<>();     // ArrayList не потокобезопасный но доступ к неиу только из потока main
                 // запускаем кассиров
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread); // добавляем кассира
            thread.start();
        }
         */

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, queueBuyers);
            threadPool.execute(cashier);
        }

        int n = 0;

        while (Dispatcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n, queueBuyers);
                //threads.add(buyer);                           // OLD
                buyer.start(); //threadPool.execute(buyer);
            }
            Helper.sleep(1000);
        }
        /* OLD SCHOOL
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
        */

        threadPool.shutdown(); //no more threads
        while (true) {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.DAYS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Market closed");
    }
}

//  OLD SCHOOL
 //   public static void main(String[] args) {
 /*       Dispatcher.buyersInMarket = 0;              // DANGER
        // Открыли магазин
        System.out.println("Market opened");

        // Создали список покупателей и кассиров
        // чтобы и кассиры и покупатели были в одном List меняем Buyers на Thread
//        List<Thread> threads = new ArrayList<>();     // ArrayList не потокобезопасный но доступ к неиу только из потока main

        ExecutorService threadCashier = Executors.newFixedThreadPool(5); // max одновренно кассиров
        //threadPool.
        // запускаем кассиров
        for (int i = 1; i <= 2 ; i++) {
            Cashier cashier = new Cashier(i);
            threadCashier.execute(cashier);
//            Thread thread = new Thread(cashier);
//            threads.add(thread); // добавляем кассира
//            thread.start();
        }
        //threadCashier.shutdown(); // нет больше кассиров
        int n = 0;
        // время от 1 секунды до 120
        for (int t = 1; t <= 120; t++) {            // мат ожидание дает в среднем заход 120 человек
            // количество покупателей
            int count = Helper.getRandom(2);   // каждую секунду заходит 0 или 1 или 2 человека +
            for (int i = 1; i <= count; i++) {      //                                               |
                Buyer buyer = new Buyer(++n);       //                                               |
                threads.add(buyer);                  // добавляем нового посетителя в коллекцию       |
                // buyer - extended Thread - его можно добамить в List
                buyer.start();                      // cтартуем поток посетителя                     |
                //noinspection NonAtomicOperationOnVolatileField
                //Dispatcher.buyersInMarket++;        //                                               |
                Dispatcher.addBuyer();
            }                                       //                                               |
            Helper.sleep(1000);              //                                         <-----|
        }

        // чтобы магазин закрылся после последнего покупателя
        try {
            for (Thread thread : threads) {
                thread.join();                   // join-им Thread main-а ко всем потокам созданным покупателям
            }
            int a=0;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        while (Dispatcher.buyersInMarket > 0) {     // пока в магазине кто-то есть ожидаем не теряя ни секунды
            Thread.yield();
        }
        // ко всем потокам прицепились, когда все закончились, закрываемся
        threadCashier.shutdown(); // нет больше кассиров
        for(;;){
            try {
                if(threadCashier.awaitTermination(10, TimeUnit.DAYS)){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
//        System.out.println("Market closed");
//    }
//}
