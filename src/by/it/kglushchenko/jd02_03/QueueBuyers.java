package by.it.kglushchenko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueBuyers {

    private final BlockingDeque<Buyer> deque;

    public QueueBuyers(int maxLength) {
        deque = new LinkedBlockingDeque<>(maxLength);
    }

    void add(Buyer buyer) {
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer extract() {
        try {
            return deque.pollFirst(100, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("НИКОГДА НЕ СЛУЧИТСЯ");
    }
/*
ВЕРСИЯ С LOCK

    // нужно обеспечить безопасное добавление несклькиз покупателей
    private static final Deque<Buyer> deque = new ArrayDeque<>();
    // если использовать пенсионеров - нужно использовать LinkedList

    // из какого-то потока добавляют покупателя
    // внутри этой очереди может прийти одновременно 2 покупателя и одновременно доктукиваться к методу add
    // значит ему нужно обеспечить потокобезопасность

    static synchronized void add(Buyer buyer){   // создали критическую секцию с помощьб synchronized
        deque.addLast(buyer); // добавляет в конец покупателя
    }

    static synchronized Buyer extract(){   // возвращает из очереди  кого-то
        // remove не используем - генерирует Exception если очередь пустая
        return deque.pollFirst(); // возвращает null если в очереди никого нет. Этот метод будет вызывать кассир
        // когда кассир будет извлекать, он будет проверять, есть там такой покупатель или нет
        // если он есть, то он его обслуживает, если его нет - кассир делает что-то свое...
    }
    // никто не влезет внуть, пока кто-то обладает мониторами add и extract

 */
}
