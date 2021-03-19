package by.it.soldatenko.jd02_02;

import java.util.Random;

class Helper {

    private static final Random generator = new Random();


    public static int getRandom(int start, int end) {
        return generator.nextInt(end - start + 1) + start;
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispetcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
