package by.it.plehanova.jd01_06;

public class TaskA2 {
    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replaceAll("[^а-яА-ЯЁё]+", " ").trim();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            int count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (!(words[i].equals(" ")) && words[i].equals(words[j])) {
                    count++;
                    words[j] = " ";
                }
            }
            if (words[i].equals(" ")) {
                continue;
            }
            System.out.println(words[i] + "=" + count);
        }
    }
}
