package by.it.plehanova.jd02_02;

import java.util.LinkedList;

public class QueueBuyers {
    private static final LinkedList<Buyer> queue = new LinkedList<>();
    private static int position = 0;

    public static LinkedList<Buyer> getQueue() {
        return queue;
    }

    static synchronized void add(Buyer buyer) {
        if (buyer.isPensioner()) {
            queue.add(position, buyer);
            position++;
        } else {
            queue.addLast(buyer);
        }
    }

    static synchronized Buyer extract() {
        if(queue.peekFirst() != null && queue.peekFirst().isPensioner()){
            position--;
        }
        return queue.pollFirst();
    }
}
