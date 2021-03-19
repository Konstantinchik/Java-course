package by.it.novik.jd01_04;

public class InOut {
    static double[ ] getArray(String line){
       String[] strArray = line.split(" ");
       double[] res=new double[strArray.length]; //массив на возврат
        for (int i = 0; i < strArray.length; i++) {
            res[i]= Double.parseDouble(strArray[i]); //Переводит из строк в дабл
        }
       return res;
    }

    static void printArray(double[ ] arr){
        for (double g : arr) {
            System.out.print(g+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%6.4f ",name,i, arr[i]);
            if ((i+1)%columnCount==0 || i+1== arr.length)
                System.out.println();
        }
    }









}








