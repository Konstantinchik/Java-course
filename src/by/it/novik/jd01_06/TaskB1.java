package by.it.novik.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static char[] b = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
    private static char[] a = {'а', 'о', 'у', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String words = matcher.group();
            word(words);
        }
    }

    private static void word(String words) {
        String Str = words.toLowerCase();
        char per = Str.charAt(0);
        char pos = Str.charAt(words.length() - 1);
        for (int i = 0; i < b.length; i++) {
            if (per == b[i]) {
                for (int j = 0; j < a.length; j++) {
                    if (pos == a[j]) {
                        System.out.println(words);
                    }
                }
            }
        }
    }
}
