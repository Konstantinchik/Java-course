package by.it.plehanova.jd01_04;

/*  A. Реализуйте статические методы ввода и простого/форматного вывода для одномерных
    массивов типа double. Разместите эти методы в классе by.it.familiya.jd01_03.InOut

    Сигнатура для ввода: static double[ ] getArray(String line)
    Сигнатуры для вывода: static void printArray(double[ ] arr) (используйте System.out.print)
    ( а тут printf ) static void printArray(double[ ] arr, String name, int columnCount)
*/

class InOut {
    /**
     *
     * @param line - String array data
     * @return double array
     */
    static double[] getArray(String line) {

        line = line.trim();

        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    /**
     *
     * @param array - double array[] for print
     */
    static void printArray(double[] array) {
        System.out.println("Array");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");

            if ((i + 1) % 5 == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     *
     * @param array - double array[] data
     * @param name - name of array
     * @param columnCount - amount of elements print in line
     */
    static void printArray(double[] array, String name, int columnCount) {

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-5.1f  ",name, i, array[i]);

            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     *
     * @param array - double array[][] data
     * @param name - name of array
     */
    static void printMultiArray(double[][] array, String name) {
        System.out.println(name);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-7.2f", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
