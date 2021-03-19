package by.it.soldatenko.jd01_15;

import java.io.*;

public class TaskB {
    /*



    многострочный пример1



     */
    public static void main(String[] args) {
        //однострочный пример 1


//  однострочный пример 2


        /* многострочный пример 2


         */
        try (FileReader inp = new FileReader(dir() + "TaskB.java");
             PrintWriter out2 = new PrintWriter(new FileWriter(dir() + "TaskB.txt"))
        ) {
            /** java documentation */
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = inp.read()) != -1) {
                if (c == '/') {
                    if (((c = inp.read()) != -1)&&(c!= '/')&&(c!= '*')) {
                        sb.append('/');
                    } else {
                        if (c == '*'){
                            while ((c = inp.read()) != -1) {
                                if (c == '*') {
                                    if (((c = inp.read()) != -1) && (c == '/')) {
                                        c = inp.read();
                                        break;
                                    }
                                }
                            }
                    }
                        if (c == '/') {
                            while ((c = inp.read()) != -1) {
                                if (c == '\n') {
                                    break;
                                }
                            }
                        }
                    }
                }
                sb.append((char) c);
            }
            System.out.println(sb);
            out2.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + cldir;
    }
}
