package by.it.soldatenko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueBuyers {

    private final BlockingDeque<Buyer> deque ;

    public QueueBuyers(int maxLenght) {
        deque= new LinkedBlockingDeque<>(maxLenght);
    }
//    private static final Deque<Buyer> deque= new LinkedList<>(); //для пенсионеров

     void add(Buyer buyer){
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
     Buyer extract(){
         try {
             return deque.pollFirst(100, TimeUnit.MICROSECONDS);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         throw new RuntimeException("");

     }
}
