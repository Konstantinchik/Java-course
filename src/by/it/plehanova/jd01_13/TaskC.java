package by.it.plehanova.jd01_13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TaskC {
    private static Scanner input;
    private static Deque<Double> numbers = new ArrayDeque<>();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        input = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        while (input.hasNext()) {
            try {
                double number = Double.parseDouble(input.next());
                numbers.addFirst(number);

            } catch (NumberFormatException e) {
                Thread.sleep(100);
                for (Double number : numbers) {
                    System.out.print(number + " ");
                }
                System.out.println();
                count++;
            }
            if(count==5){
                throw new NumberFormatException();
            }
        }
    }
}
