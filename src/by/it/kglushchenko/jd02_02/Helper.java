package by.it.kglushchenko.jd02_02;


import java.util.Random;

class Helper {

    private static final Random generator = new Random();

    public static int getRandom(int start, int end) {
        return generator.nextInt(end - start + 1) + start;
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    // Из какого метода этот sleep вызывается, из его потока и его стек используется Buyer, Kassir ....
    // пауза будет относится к их потоку
    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);   // разгоняем скорость эмуляции
        } catch (InterruptedException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void sleepRandom(int start, int end) {
        int timeout = getRandom(start, end);
        sleep(timeout);
    }

    public static void sleepRandom(int max) {
        int timeout = getRandom(0, max);
        sleep(timeout);
    }

}
