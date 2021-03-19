package by.it.leshchenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int positionZero = 0;
        while (true) {
            String s = scanner.next();
            if (s.equals("end")) {
                break;
            }

            Integer v = Integer.valueOf(s);
            if (v < 0) {
                list.add(v);
            } else if (v == 0) {
                list.add(positionZero, v);
            } else {
                list.add(positionZero++, v);
            }
        }
        System.out.println(list);
    }
}
