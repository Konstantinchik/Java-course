package by.it.evstratov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> integers = new ArrayList<>();

    private void clearBad(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int grade = iterator.next();
            if(grade < 4){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i < 25; i++) {
            taskA1.integers.add((int)Math.ceil(Math.random() * 10));
        }
        taskA1.clearBad(taskA1.integers);

    }

}
