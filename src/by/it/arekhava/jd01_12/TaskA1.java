package by.it.arekhava.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private ArrayList<Integer> grades=new ArrayList<>();



    public static void main(String[] args) {
        Random random = new Random();
      TaskA1 instance =new TaskA1();
        for (int i = 0; i < 40; i++) {
            instance.grades.add(1+random.nextInt(10));
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }
        void clearBad(List<Integer> grades){
            Iterator<Integer> iterator = grades.iterator();
            while (iterator.hasNext()){
                Integer value = iterator.next();
                if (value<4){
                     iterator.remove();
                }
            }
    }
}
