package by.it.leshchenko.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
        System.out.println();

        long slow_start = System.nanoTime();
        String slow_line = slow(Poem.text);
        long slow_finish = System.nanoTime();
        System.out.println("slow dt=" + (slow_finish - slow_start));
        System.out.println(slow_line);

        long fast_start = System.nanoTime();
        String fast_line = fast(Poem.text);
        long fast_finish = System.nanoTime();
        System.out.println("fast dt=" + (fast_finish - fast_start));
        System.out.println(fast_line);
    }

    private static String slow(String text) {
        String result = "";
        String[] array = text.split("[^а-яА-яёЁ]+");
        int symbols = 0;
        while (100000 > symbols) {
            for (String s : array) {
                result += s + " ";
                symbols += s.length() + 1;
            }
        }
        return result;
    }

    private static String fast(String text) {
        StringBuilder result = new StringBuilder("");
        String[] array = text.split("[^а-яА-яёЁ]+");
        int symbols = 0;
        while (100000 > symbols) {
            for (String s : array) {
                result.append(s).append(" ");
                symbols += s.length() + 1;
            }
        }
        return result.toString();
    }
}
