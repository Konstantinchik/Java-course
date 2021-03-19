package by.it.soldatenko.jd01_06;

public class TaskB1 {
    public static void main(String[] line) {
        String[] str = Poem.text.split("\\s");
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replace(",", "");
            str[i] = str[i].replace(".", "");
            str[i] = str[i].replace(":", "");
            strMatchPrint(str[i]);
        }
    }
    public static void strMatchPrint(String str) {
        String consonant = "йцкнгшщзхфвпрлджбтмсч";
        String vowels = "аоуэиыеёяю";
        if (str.length()>1){
            if (consonant.indexOf(Character.toLowerCase(str.charAt(0))) != -1
                    && vowels.indexOf(Character.toLowerCase(str.charAt(str.length()-1))) != -1)
            {
                System.out.println(str);
            }
        }
    }
}
