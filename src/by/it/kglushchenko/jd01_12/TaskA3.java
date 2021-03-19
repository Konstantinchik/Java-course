package by.it.kglushchenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Вставка чисел в List сохраняя их порядок

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

//        for (; ; ) {
//            String s = scanner.next(); // читаем ввод
//            if (s.equals("end")) {
//                break;
//            }
//            // -1 0 4 5 7 -6 0 -2 8 --> 0 0 4 5 7 8 -1 -6 -2
//            Integer value = Integer.valueOf(s);
//            if (value < 0) {
//                list.add(value);
//            } else if (value == 0) {
//                list.add(positionZero, value);
//            }
//            else if(value >0){
//                list.add(positionZero++, value);
//            }
//
//        }
        String inputString;
        int position = 0;               // позиция числа
        while (!(inputString = scanner.next()).equals("end")) {
            Integer value = Integer.valueOf(inputString);
            if (value > 0) {            // добавляем в позицию pos число value
                list.add(position++, value); // номер позиции придобавлении инкрементируем
            } else if (value == 0) {    // для чисел равных 0 не будем увеличивать позицию.
                                        // они будут дописываться сразу после положительных
                list.add(position, 0);
            } else {
                list.add(value);        // отрицательные числа всегда будут дописываться в конец массива
            }
        }
        System.out.println(list);
    }
}
