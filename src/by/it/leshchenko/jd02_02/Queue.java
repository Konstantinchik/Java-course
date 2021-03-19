package by.it.leshchenko.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    private final static Deque<Buyer> queue = new ArrayDeque<>();

    static synchronized void addBuyer(Buyer buyer) {
        queue.addLast(buyer);
    }

    static synchronized Buyer leftBuyer() {
        return queue.pollFirst();
    }
}