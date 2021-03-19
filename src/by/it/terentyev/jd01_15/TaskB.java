package by.it.terentyev.jd01_15;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskB {
    /** JavaDoc
     * doc
     */
    public static void main(String[] args) {

        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        Class<TaskB> taskBClass = TaskB.class;
        String className = taskBClass.getName();
        String path = className.replace(".", File.separator);
        String fileTaskB = src + path + ".java";

        List<Character> list = new ArrayList<>();
//        StringBuilder stringBuilder = null;
//
//            stringBuilder = new DataInputStream(new BufferedInputStream(new FileInputStream(fileTaskB)));
//            while (stringBuilder.available() > 0) {
//                char letter = stringBuilder.readChar();
//                list.add(letter);
//            }
//
//
//
//        System.out.println(list);
        System.out.println(src);
        System.out.println(path);
        System.out.println(fileTaskB);
    }

    /*  String clazz = TaskA.class;
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
    }


     */
    //  boolean ok= false;


     /*   while (!(ok && ok2));
        System.out.println(ok);
      System.out.println(ok2);
      */


    // Test comment
        /*
Pora. Ya gotov nachat.
Nevazhno. s chego. Otkryt
rot. Ya mogu molchat.
No luchshe mne govorit.

          */
    //Per aspera ad astra
}
