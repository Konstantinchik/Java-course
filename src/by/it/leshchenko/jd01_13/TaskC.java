package by.it.leshchenko.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {
    static Scanner scanner;
    static int count = 0;
    static LinkedList<Double> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }

    @SuppressWarnings("BusyWait")
    static void readData() throws InterruptedException {
        while (scanner.hasNext()) {
            if (count < 5) {
                String s = scanner.nextLine();
                try {
                    double number = Double.parseDouble(s);
                    list.addFirst(number);
                } catch (NumberFormatException e) {
                    Thread.sleep(100);
                    count++;
                    for (Double n : list) {
                        System.out.print(n + " ");
                    }
                    System.out.println();
                }
            } else {
                throw new NumberFormatException();
            }
        }
    }
}