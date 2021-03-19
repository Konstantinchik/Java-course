package by.it.soldatenko.jd01_03;

import javax.sound.sampled.Line;


import static javax.sound.sampled.Line.*;

class InOut {
   static double[ ] getArray(String line){
      String[] arrStr = line.split(" ");
      double []res = new double[arrStr.length] ;
       for (int i = 0; i < arrStr.length; i++) {
           res[i] = Double.parseDouble(arrStr[i]);
       }
       return res;

   }
   static void printArray(double[ ] arr){
       for (double v : arr) {
           System.out.print(v + " ");
       }
       System.out.println();
   }
   static void printArray(double[ ] arr, String name, int columnCount){
       for (int i = 0; i < arr.length; i++) {
           System.out.printf("%s[% -3d]=%-10.4f", name, i, arr[i]);
           if ((i+1)%columnCount==0 || i+1 == arr.length){
               System.out.println();
           }
       }
   }

}


