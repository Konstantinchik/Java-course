package by.it.tetenkov.jd01_03;

class InOut {

    static double[] getArray(String line) {
        // String line = "1 100 3 4 5 6 24";

        line = line.trim();
        String[] strArray = line.trim().split(" ");
        double[] result = new double[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);

        }
        return result;
    }


    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
        System.out.println(" ");
    }

    static void printArray(double[] array, String name, int colCount) {
        for (int i = 0; i < array.length; i++){
            System.out.printf("%s[%- 3d]=%-10.5f", name, colCount, array[i]);
            if ((i + 1) % colCount == 0 || i == array.length - 1){
                System.out.println();

            }
        }

    }
}
// A [xxx] = -123.45700