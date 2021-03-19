package by.it.evstratov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        int pos = 0;
        while (!(str = scanner.next()).equals("end")){
            Integer value = Integer.valueOf(str);
            if(value > 0){
                list.add(pos++,value);
            }else if(value == 0){
                list.add(pos,0);
            }else{
                list.add(value);
            }
        }
        System.out.println(list);

    }

}
