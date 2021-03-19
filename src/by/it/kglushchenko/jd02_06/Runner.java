package by.it.kglushchenko.jd02_06;

public class Runner {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            String log= "Test"+i;
            new Thread(() -> {
                Logger.getLogger().log(log);
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            String log= "Test2_"+i;
            new Thread(() -> {
                Logger2.getLogger().log(log);
            }).start();
        }

    }
}
