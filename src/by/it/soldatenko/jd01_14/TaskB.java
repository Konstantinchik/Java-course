package by.it.soldatenko.jd01_14;



import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + cldir;
    }

    public static void main(String[] args) {
        try (FileReader inp = new FileReader(dir(TaskB.class) + "text.txt");
            PrintWriter out2= new PrintWriter(new FileWriter(dir(TaskB.class)+"resultTaskB.txt"))
        ) {
            int c;
            StringBuilder sb = new StringBuilder();
            int countW = 0;
            int countD = 0;
            while ((c =inp.read())!= -1) {
            sb.append((char)c);
            }
            Pattern patW = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matchW = patW.matcher(sb);
            while (matchW.find()){
                countW++;
            }
            Pattern patD = Pattern.compile("[!.,;:?]");
            Matcher matchD =patD.matcher(sb);
            while (matchD.find()){
                countD++;
            }
            System.out.println("words="+countW+", punctuation marks="+countD);
            out2.print("words="+countW+", punctuation marks="+countD);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
