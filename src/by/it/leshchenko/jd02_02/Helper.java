package by.it.leshchenko.jd02_02;

import java.util.Random;

class Helper {
    final static Random random = new Random();

    static int random(int max) {
        return random.nextInt(max);
    }

    static int random(int min, int max) {
        return random.nextInt((max - min + 1) + min);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / ControlCentre.MARKET_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
