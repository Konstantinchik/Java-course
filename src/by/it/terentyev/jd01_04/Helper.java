package by.it.terentyev.jd01_04;
public class Helper {

//    static double[] getArray(String line) {
//        return null;
//        String[] strArray = line.trim().split(" ");
//        double[] result=new double[strArray.length];
    //return new double[0];

    static double[] printLine(String line) {
        String[] findMin = line.trim().split(" ");
        double[] result = new double[findMin.length];
        for (int i = 0; i < findMin.length; i++) {
            result[i] = Double.parseDouble(findMin[i]);
        }
        return result;
    }

    static double findMin(double[] array) {
        if (0==array.length)
        {return Double.MIN_VALUE;}
        else {
               double min=array[0];
               for (double m:array) {if (min>m) min=m;}
        System.out.println(min);
               return min;
        }
        //return 0;
    }

    static double findMax(double[] array) {
        if (0== array.length)
        {return Double.MAX_VALUE;}
        else {
            double max=array[0];
            for (double m:array) {if (max<m) max=m;}
            System.out.println(max);
            return max;
        }
       // return 0;
    }

//    public static void sort1(double[] array) {
//        boolean upDirection = true;
//        for (int start = 0; start < array.length-1; start++) {
//            int least = start;
//            for (int j = start+1; j<array.length; j++) {
//                if ((upDirection && array[j] < array[least]) ||
//                (!upDirection && array[j] > array[least]))
//                {
//                    least=j;
//                }
//        }
//            double tmp = array[start];
//            array[start]= array[least];
//            array[least] = tmp;
//        }
//    }

    public static void sort(double[] array) {
        boolean swap;
        int last=array.length-1;
        do {
            swap = false;
            for (int j=0; j < last; j++) {
                if (array[j] > array[j+1]) {
                    double buffer = array[j];
                    array[j] = array[j+1];
                    array[j + 1]=buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }
    //       System.out.println(Min);
        //return findMin(array);
}
