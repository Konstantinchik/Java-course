package by.it.novik.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ввод: ");
        String str= scanner.nextLine();
        double[] array =InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        System.out.print("Введите одномерный массив: ");
        String strr = scanner.nextLine();
        double[] mas = InOut.getArray(strr);
        Helper.findMin(mas);
        Helper.findMax(mas);
        Helper.sort(mas);
    }
}
