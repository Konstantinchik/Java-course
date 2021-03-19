package by.it.terentyev.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3  {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // -6 -5 4 8 65 45 -54 5 0 8 7 - 1 --> -6 - 5
        int positionZero=0;
        for(;;) {
            String s = scanner.next();
            if (s.equals("end")){
                break;
            }
            Integer value=Integer.valueOf(s);
            if (value<0) {
                list.add(value);
            }
            else if (value==0) {
                list.add(positionZero, value);
            }
            else {
                list.add(positionZero++,value);
            }
        }
        System.out.println(list);
    }

}
