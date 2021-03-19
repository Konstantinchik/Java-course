package by.it.soldatenko.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replace("...", "");
        String[] str = text.split("[\\.\\!]");
        int[] leinght = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replace("\n", " ");
            str[i] = str[i].replace(",", "");
            str[i] = str[i].replace(":", "");
            str[i] = str[i].replace(" -", "");
            str[i] = str[i].trim();
            leinght[i] = str[i].length();
        }

        int n = leinght.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (leinght[j] > leinght[j+1]) {
                    int temp = leinght[j]; String tempS = str[j];
                    leinght[j] = leinght[j+1]; str[j] = str[j+1];
                    leinght[j+1] = temp; str[j+1]= tempS;
                }
        for (String s : str) {
            System.out.println(s);
        }
    }

}
