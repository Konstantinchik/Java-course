package by.it.plehanova.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {

        String text = Poem.text;
        String[] sentOne = text.split("[\\.\\!\\?][^\\. ]");
        String[] sentTwo = text.split("[\\.\\!\\?]");

        sentOne = sort(sentOne);
        sentTwo = sort(sentTwo);

        for (int i = 0; i < sentOne.length; i++) {
            System.out.print(sentOne[i] + "\n");
        }
        for (int i = 0; i < sentTwo.length; i++) {
            System.out.print(sentTwo[i] + "\n");
        }
    }

    private static String[] sort(String[] sentence) {

        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].replaceAll("[^а-яА-ЯЁё]+", " ").trim();
        }

        boolean check;
        String temp;
        int count = sentence.length - 1;

        do {
            check = false;
            for (int i = 0; i < count; i++) {
                if (sentence[i].length() > sentence[i + 1].length()) {
                    temp = sentence[i];
                    sentence[i] = sentence[i + 1];
                    sentence[i + 1] = temp;

                    check = true;
                }
            }
            count--;
        } while (check);

        return sentence;
    }
}
