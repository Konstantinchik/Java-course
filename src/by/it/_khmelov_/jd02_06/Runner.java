package by.it._khmelov_.jd02_06;

public class Runner {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                Logger.getLogger().log("Test ");
            }).start();
        }

    }
}
