package by.it.arekhava.jd01_04;

public class InOut{

    static double[] getArray(String line) {
        //"100 3 4 6 2 80 90 40"
       
        line= line.trim();
        String[] strArray =line.split(" ");
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

    public static void printArray(double[] array, String name, int colCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.5f", name,i,array[i]);
            if ((i+1)%colCount==0 || i==array.length-1){
    System.out.println();

            }


        }
    }
    //a[xxx]=-123,4578
}
