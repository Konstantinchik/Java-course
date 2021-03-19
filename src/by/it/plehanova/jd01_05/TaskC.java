package by.it.plehanova.jd01_05;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {

        step1();
        step2();

    }

    private static void step1() {

        double z;
        double x;
        double step;
        int n;


        n = (int) (Math.random() * 20 + 41);
        x = 5.33;
        step = (9 - x) / (n - 1);

        double[] arrayA = new double[n];

        int count = 0;

        for (int i = 0; i < arrayA.length; i++) {

            z = Math.cbrt(x * x + 4.5);
            x += step;
            arrayA[i] = z;

            if (z > 3.5) {
                count++;
            }
        }

        double[] arrayB = new double[count];

        int j = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] > 3.5) {
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf("%s[% -3d] = %f ", "A", i, arrayA[i]);

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        for (int i = 0; i < arrayB.length; i++) {
            System.out.printf("%s[% -3d] = %f ", "B", i, arrayB[i]);

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void step2() {

        int[] arrayA = new int[31];

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (Math.random() * 348 + 103);
        }

        int count = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (i < arrayA[i] / 10) {
                count++;
            }
        }

        int[] arrayB = new int[count];
        int index = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (i < arrayA[i] / 10) {
                arrayB[index] = arrayA[i];
                index++;
            }
        }
        Arrays.sort(arrayB);

        printArrayByRow(arrayA, "A");
        printArrayByCol(arrayB, "B");

    }

    private static void printArrayByRow(int[] array, String name) {
        int col = 5;

        System.out.println("Массив " + name);
        System.out.print("╔═════════════");

        int c = col;
        while (c - 1 > 0) {
            System.out.print("╦═════════════");
            c--;
        }
        System.out.print("╗" + "\n");

        for (int i = 0; i < array.length; i++) {

            System.out.printf("%c %s[% -3d]=%4d ", '║', "A", i, array[i]);

            if ((i + 1) % 5 == 0) {
                System.out.printf("║");
                c = col;
                System.out.printf("\n%s", "╠═════════════");

                while (c - 1 > 0) {
                    System.out.print("╬═════════════");
                    c--;
                }
                System.out.print("╣" + "\n");
            }
        }
        System.out.print("║");
        int emptyCellA = 5 - array.length % 5;
        while (emptyCellA > 0) {
            System.out.printf("%13s%c", " ", '║');
            emptyCellA--;
        }
        c = col;
        System.out.printf("\n%s", "╚═════════════");
        while (c - 1 > 0) {
            System.out.print("╩═════════════");
            c--;
        }
        System.out.print("╝" + "\n");


    }

    private static void printArrayByCol(int[] array, String name) {
        int col;
        int row;
        int size;

        size = array.length;

        if (size % 5 == 0) {
            row = size / 5;
        } else {
            row = 1 + size / 5;
        }

        col = 1 + (size - 1) / row;

        if (size >= 5) {
            System.out.println("Массив " + name);
            System.out.print("╔═════════════");

            int c = col;
            while (c - 1 > 0) {
                System.out.print("╦═════════════");
                c--;
            }
            System.out.print("╗" + "\n");

            for (int j = 0; j < row; j++) {
                System.out.printf("%c %s[% -3d]=%4d %c", '║', "B", j, array[j], '║');

                int x = j + row;

                for (int i = 1; i < col; i++) {
                    if (x >= array.length && i < col) {
                        System.out.printf("%13s%c", " ", '║');
                        continue;
                    }
                    System.out.printf("%s[% -3d]=%4d %c", " B", x, array[x], '║');
                    x = x + row;
                }
                if (j == row - 1) {
                    break;
                }

                c = col;
                System.out.printf("\n%s", "╠═════════════");
                while (c - 1 > 0) {
                    System.out.print("╬═════════════");
                    c--;
                }
                System.out.print("╣" + "\n");

            }

            c = col;
            System.out.printf("\n%s", "╚═════════════");
            while (c - 1 > 0) {
                System.out.print("╩═════════════");
                c--;
            }
            System.out.print("╝" + "\n");

        } else {
            System.out.print("╔═════════════");
            while (size > 0) {
                System.out.print("╦═════════════");
                size--;
            }
            System.out.print("╗");

            for (int i = 0; i < array.length; i++) {
                System.out.printf("%c %s[% -3d]=%4d ", '║', "A", i, array[i]);

            }
            System.out.print("║" + "\n");
            System.out.print("╚═════════════");

            while (size > 0) {
                System.out.print("╩═════════════");
                size--;
            }
            System.out.print("╝");

        }
    }
}


