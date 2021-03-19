package by.it.evstratov.jd_02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueBuyers {

    public QueueBuyers(int maxLength) {
        this.deque = new LinkedBlockingDeque<>(maxLength);
    }

    private final BlockingDeque<Buyer> deque;
    private final BlockingDeque<Buyer> dequePensioners = new LinkedBlockingDeque<>();

    void add(Buyer buyer){
        try {
            if(buyer.isPensioneer()){
                dequePensioners.putLast(buyer);
            }else{
                deque.putLast(buyer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer extract(){
        Buyer buyer = null;
        try {
            if(!dequePensioners.isEmpty()){
                buyer = dequePensioners.pollFirst(100, TimeUnit.MICROSECONDS);
            }else{
                buyer = deque.pollFirst(100, TimeUnit.MICROSECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buyer;
    }

    public int getSize(){
        int sizeDeque = deque.size() + dequePensioners.size();
        return sizeDeque;
    }

}
