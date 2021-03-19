package by.it.evstratov.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String str;

        while (!(str = scanner.next()).equals("end")){
            String string = str.replaceAll("[-=+,.!:;?()]","");
                if(!words.containsKey(string)){
                    words.put(string,1);
                }else{
                    words.put(string,words.get(string)+1);
                }

        }
        for(Map.Entry<String, Integer> item : words.entrySet()){
            System.out.printf("%s=%d\n",item.getKey(),item.getValue());
        }
    }

}
