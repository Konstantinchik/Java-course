package by.it.rydzeuski.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int pozitionZero=0;
        for (;;) {

            String s= sc.next();
            if (s.equals("end")){
                break;
            }
            Integer value=Integer.valueOf(s);
            if (value<0){
                list.add(value);

            }else if(value==0){
                list.add(pozitionZero,value);
            }else {
                list.add(pozitionZero++,value);
            }
        }
        System.out.println(list);
    }

}
