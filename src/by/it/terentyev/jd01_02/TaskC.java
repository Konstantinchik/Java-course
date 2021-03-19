package by.it.terentyev.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int[n][n] arr TaskC.step1(n);
        int [][] arr = new int[n][n];
        TaskC.step1(arr, n);
    }
    static void step1(int[][] arr, int n) {


        for (int one = 0; one < n; one++) {
            for (int too = 0; too < n; too++) {
                int min = -n;
                int max = n;
                int diff = max - min;
                Random random = new Random();
                int j = random.nextInt(diff + 1);
                j += min;
                arr[one][too] = j;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
