package by.it.soldatenko.jd01_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskC {
static Scanner scanner;
    public static void main(String[] args) {
         scanner = new Scanner(System.in);
         readData();


   }




    static void readData (){
        ArrayList<Double> doubles = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            try {
                for (; ; ) {
                    String s = scanner.nextLine();

                    double result = Double.parseDouble(s);
                    doubles.add(result);
                }


            }catch (NumberFormatException e){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                doubles.sort(Collections.reverseOrder());
                for (Double aDouble : doubles) {
                    System.out.print(aDouble + " ");
                }
                System.out.println();
                doubles.sort(Collections.reverseOrder());

            }
        }
        throw new NumberFormatException();


    }
}
