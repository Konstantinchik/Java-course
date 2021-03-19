package by.it.leshchenko.jd01_04;

class InOut {

    static double[] getArray(String line) {
        String[] strArray = line.trim().split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return result;
    }

    static void printArray(double[] arr, String name, int columnCount) {
        int cols = 0;
        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            System.out.printf("%s[%3d]=%-10.5f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arrLength - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
