package by.it.leshchenko.jd01_04;

class Helper {

    static void sort(double[] arr) {
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
