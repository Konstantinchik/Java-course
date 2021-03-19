package by.it.novik.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder Text = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{4,}");
        Matcher matcher = pattern.matcher(Text);
        while (matcher.find()) {
            int index = matcher.start();
            Text.setCharAt(index + 3, '#');
            int length = matcher.end() - matcher.start();
            if (length >= 7) {
                Text.setCharAt(index + 6, '#');
            }
        }
        System.out.println(Text);
    }

}
