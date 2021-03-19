package by.it.novik.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {

    /*Если не заносить в List<Integer>list1 readInt, а сразу ставить его в методы print,
    то при втором чтении бинарного файла появляются другие значения и в методе printToFile появляются другие значения
    */

    public static final String FILENAME = "dataTaskA.bin";
    public static final String TXTNAME = "resultTaskA.txt";
    private static Random random = new Random();
    public static void main(String[] args) throws FileNotFoundException {
        String path = getPath(TaskA.class);
        String filename=path + FILENAME;
        String txtname=path + TXTNAME;
        writeInt(filename);
        List<Integer> list1 = readInt(filename);
        printToConsole(list1);
        printToFile(txtname, list1);
    }

    private static String getPath(Class<?> claz) {
        String src=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String name = claz.getName();
        String path = name.replace(claz.getSimpleName(), "").replace(".", File.separator);
        return src+path;
    }

    private static void writeInt(String filename) {
        try(
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filename))))
        {
            for (int i = 0; i < 20; i++) {
                int value = random.nextInt(100);
                dataOutputStream.writeInt(value);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readInt(String filename) {
        List<Integer>list=new ArrayList<>();
        try (
                DataInputStream dataInputStream= new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filename))))
        { while (dataInputStream.available()>0){
            list.add(dataInputStream.readInt());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void printToConsole(List<Integer> list){
        double sum=0;
        for(Integer integer: list){
            System.out.print(integer+" ");
            sum+=integer;
        }
        double avg=sum/list.size();
        System.out.println("avg="+avg);
    }

    private static void printToFile(String txtname, List<Integer>list){
        try(PrintWriter printWriter= new PrintWriter(txtname)){
            double sum=0;
            for(Integer integer: list){
                printWriter.print(integer+" ");
                sum+=integer;
            }
            double avg=sum/list.size();
            printWriter.print("avg="+avg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
