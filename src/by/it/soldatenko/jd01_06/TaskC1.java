package by.it.soldatenko.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] str = Poem.text.split("\n");
        String space = " ";
        int maxLenght = 0;
        for (String value : str) {
            if (value.length() > maxLenght) {
                maxLenght = value.length();
            }
        }
        for (String s : str) {
            int count = 0;
            if (maxLenght > s.length()) {
                for (int j = 1; j < s.length(); j++) {
                    if (space.indexOf(s.charAt(j)) == 0) {
                        count++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder(s);
            count = 0;
            while (count < (maxLenght - s.length())) {
                for (int j = 0; j < sb.length() - 1; j = j + 1) {
                    if (sb.charAt(j + 1) == ' ' && sb.charAt(j) != ' ') {
                        if (count < (maxLenght - s.length())) {
                            sb.insert(j + 2, " ");
                            count++;
                        }
                    }
                }
            }
            System.out.println(sb);
        }
    }
}