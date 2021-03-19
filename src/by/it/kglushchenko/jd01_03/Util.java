package by.it.kglushchenko.jd01_03;

public class Util {
    public static int maxIntArray(int[] arr){
        if(arr.length==0){
            return Integer.MAX_VALUE;
        }
        else
        {
            int max = arr[0];
            for(int m : arr){
                if(max<m){
                    max=m;
                }
            }
            return max;
        }
    }

    public static int minInArray(int[] arr){
        if(arr.length==0){
            return Integer.MIN_VALUE;
        }
        else
        {
            int min = arr[0];
            for(int m : arr){
                if(min>m){
                    min=m;
                }
            }
            return min;
        }
    }
}
