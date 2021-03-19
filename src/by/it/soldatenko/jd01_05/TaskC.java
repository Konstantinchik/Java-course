package by.it.soldatenko.jd01_05;


import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        Step1();
        Step2();
    }

    private static void Step1() {
        double deltaX = 0.1468;
        int n = 26;
        double x = 5.33;
        double[] arr = new double[n];
        int count = 0;
        double value = (double) 1 / 3;
        while (x <= 9) {
            x = (int) (x * 10000 + 0.5);
            x = x / 10000;
            arr[count] = pow((x * x + 4.5), value);
            x = x + deltaX;
            count++;
        }
        System.out.println("Массив V[]");
        printArray(arr, "V");
        count = 0;
        for (double v : arr) {
            if (v > 3.5) {
                count++;
            }
        }
        double[] arr_3_5 = new double[count];
        count = 0;
        for (double v : arr) {
            if (v > 3.5) {
                arr_3_5[count] = v;
                count++;
            }
        }
        System.out.println("Массив W[] из элементов массива A > 3.5");
        printArray(arr_3_5, "W");

        double mul = 1;
        for (double v : arr_3_5) {
            mul = mul * v;
        }
        value = 1 / (double) arr_3_5.length;
        double geom_mean = pow(mul, value);
        System.out.println("Среднее геометрическое " + geom_mean);
    }

    static void printArray(double[] arr, String name) {

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10f", name, i, arr[i]);
            if ((i + 1) % 5 == 0 || i + 1 == arr.length) {
                System.out.println();
            }
        }
    }
    private static void Step2() {
        int[] arr = new int[31];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {//инициализация А
            arr[i] = (int) (round(random() * 347) + 103);
            if (arr[i] * 0.1 > i) {
                count = count + 1;
            }
        }
        int[] arr_10 = new int[count];// Инициализация В
        count = 0;
        for (int i = 0; i < 31; i++) {
            if (arr[i] * 0.1 > i) {
                arr_10[count] = arr[i];
                count = count + 1;
            }
        }

        int n = arr_10.length; // сортировка В
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr_10[j] > arr_10[j + 1]) {
                    int temp = arr_10[j];
                    arr_10[j] = arr_10[j + 1];
                    arr_10[j + 1] = temp;
                }
        }
        //печать А
        System.out.println("Massiv A (index to rows)");
        System.out.print("╔"+"══════════"+"╦"+"══════════"+"╦"+"══════════"+"╦"+"══════════"+"╦"+"══════════"+"╗");
        System.out.println();
        for (int i = 0; i < 35; i++) {
            String name = "A";
            if(i<arr.length) {
                System.out.printf("║%s[%2d]=%-4d", name, i, arr[i]);
            }else System.out.print("║          ");

            if ((i + 1) % 5 == 0 || i + 1 == 35) {
                System.out.println("║");
                if (i <34) {
                    System.out.println("╠" + "══════════" + "╬" + "══════════" + "╬" + "══════════" + "╬" + "══════════" + "╬" + "══════════" + "╣");
                }
            }

        }
        System.out.println("╚"+"══════════"+"╩"+"══════════"+"╩"+"══════════"+"╩"+"══════════"+"╩"+"══════════"+"╝");


        // печать В
        System.out.println("Massiv B (index to cols)");
        String name = "B";
        double d = arr_10.length;
        int value = (int) ceil(d / 5);
        System.out.print("╔"+"══════════"+"╦"+"══════════"+"╦"+"══════════"+"╦"+"══════════"+"╦"+"══════════"+"╗");
        System.out.println();
        for (int i = 0; i < value; i++) {
            for (int k = 0; k < 25; k = k + 5) {
                if (i + k < arr_10.length) {
                    System.out.printf("║%s[%2d]=%-4d", name, i + k, arr_10[i + k]);
                } else {
                    System.out.print("║          ");
                    break;
                }
            }
            System.out.print("║");
            System.out.println();
            if (i<value-1) {
                System.out.println("╠" + "══════════" + "╬" + "══════════" + "╬" + "══════════" + "╬" + "══════════" + "╬" + "══════════" + "╣");
            }
        }
        System.out.println("╚"+"══════════"+"╩"+"══════════"+"╩"+"══════════"+"╩"+"══════════"+"╩"+"══════════"+"╝");

    }




}
