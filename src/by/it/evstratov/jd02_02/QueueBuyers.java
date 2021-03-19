package by.it.evstratov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

   private static final Deque<Buyer> deque = new ArrayDeque<>();
    private static final Deque<Buyer> dequePensioners = new ArrayDeque<>();

   static synchronized void add(Buyer buyer){
       if(buyer.isPensioneer()){
           dequePensioners.addLast(buyer);
       }else{
           deque.addLast(buyer);
       }
   }

    static synchronized Buyer extract(){
        if(dequePensioners.size() > 0){
            return dequePensioners.pollFirst();
        }else{
            return deque.pollFirst();
        }
    }

    static synchronized int getSize(){
       return deque.size() + dequePensioners.size();
    }

}
