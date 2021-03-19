package by.it.terentyev.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double z;
        int col = 30;
        double[]arr = new double[col];
        int i = 0;
        double step = (9 - 5.33) / col;
        for (double x = 5.33; x <= 9; x = x + step) {
            z = cbrt((x * x) + 4.5);
            arr[i]= z;
            i = i+1;

        }
        System.out.println("Массив А[]");
        int colCount=5;
        for (int j = 0; j < col; j++) {
            System.out.printf("A [%- 3d] = %6.4f",j, arr[j]);
            if ((j+1)%colCount==0 || j==arr.length-1) {
                System.out.println();
            }
        }
        int colBig = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j]>3.5) colBig=colBig+1;
        }
        double[]arrBig=new double[colBig];
        int n =0;
        double summArrBig =1;
        for (int m = 0; m < arr.length; m++) {
            if (arr[m] > 3.5)  {
             arrBig[n]=arr[m];
             summArrBig = summArrBig * arrBig[n];
             n = n+1;
            }
        }
        double doubColBig = colBig;
        double dowPow = 1/doubColBig;
        double midGeom = pow(summArrBig,dowPow);
        System.out.println();
        System.out.println("Массив В[] из элементов массива А > 3.5");
        colCount=5;
        for (int j = 0; j < colBig; j++) {
            System.out.printf("A [%- 3d] = %6.4f",j, arrBig[j]);
            if ((j+1)%colCount==0 || j==arrBig.length-1) {
                System.out.println();
            }
        }
        //System.out.println(midGeom);
    }
}
