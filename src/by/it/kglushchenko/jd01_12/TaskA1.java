package by.it.kglushchenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private  ArrayList<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        //ArrayList<Integer> grades = new ArrayList<>();

        Random random = new Random();
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 40; i++) {
            //task.grades.add(1+ random.nextInt(10));
            task.grades.add((int) Math.ceil(Math.random() * 10));
        }
        System.out.println(task.grades); // вывод всего списка

        task.clearBad(task.grades);
        System.out.println(task.grades); // вывод откорректированного текста
    }

    void clearBad(List<Integer> grades) {
        /*
        while(iterator.hasNext()){
            Integer value = iterator.next();
            if(value <4){
                iterator.remove();
            }
        }*/
        grades.removeIf(value -> value < 4);
    }
}
