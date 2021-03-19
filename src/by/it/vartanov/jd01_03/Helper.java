package by.it.vartanov.jd01_03;

 class Helper {

    public static double findMax(double[] arr) {

        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }


    public static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;

        }
    }


    public static void sort(double[] arr) {

        boolean swap;
        double last=arr.length-1;
        do {
            swap = false;
                    for ( int i=0; i<last; i++) {
                        if (arr [i] > arr [i+1]) {
                            double buffer = arr [i];
                            arr [i] = arr [i +1];
                            arr [i +1] = buffer;
                            swap = true;
                        }
                    }
                    last--;
        }
        while (swap);
        for (double e:arr) System.out.print(e + " ");
        System.out.println ();
    }



}