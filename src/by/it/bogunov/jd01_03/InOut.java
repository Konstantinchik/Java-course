package by.it.bogunov.jd01_03;

public class InOut {
    public static double[] getArray(String line) {
        //"100 2 4 6 90 23 44 51"
        String[] strArray = line.trim().split(" ");
        double[] result=new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i]=Double.parseDouble(strArray[i]);

        }

        return result;
    }

    public static void printArray(double[] array) {
        for (double value : array) {
            System.out.print(value+" ");
        }
        System.out.println();

    }

    public static void printArray(double[] array, String name, int cloCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% 3d]=%-10.5f",name,i,array[i]);
            if ((i+1)%cloCount==0 || i== array.length-1);{
                System.out.println();
            }

        }


    }
}
