package by.it.plehanova.jd01_06;

import java.util.Random;

public class TaskC2 {

    private static long number = System.nanoTime();

    public static void main(String[] args) {

        long start;

        start = System.nanoTime();
        String sentence1 = slow(Poem.text);

        System.out.println("timeSlow = " + (System.nanoTime() - start) / 1000_000.0 + "ms");
        System.out.println(sentence1);

        start = System.nanoTime();
        String sentence2 = fast(Poem.text);

        System.out.println("timeFast = " + (System.nanoTime() - start) / 1000_000.0 + "ms");
        System.out.println(sentence2);

    }

    private static String slow(String text) {
        Random random = new Random(number);

        text = text.replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        String[] array = text.split(" ");

        String gen1 = "";
        while (gen1.length() < 100000) {
            int i = random.nextInt(array.length);
            gen1 = gen1 + " " + array[i];
        }
        return gen1;
    }

    private static String fast(String text) {
        Random random = new Random(number);

        text = text.replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        String[] array = text.split(" ");


        StringBuilder words = new StringBuilder();
        while (words.length() < 100000) {
            int i = random.nextInt(array.length);
            words = words.append(" ").append(array[i]);
        }

        String str = new String(words);

        return str;
    }
}
