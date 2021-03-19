package by.it.evstratov.jd01_15;

import java.io.*;

public class TaskC {

    private static final String CD = "cd";
    private static final String DIR = "dir";
    private static final String END = "end";
    private static StringBuilder place = new StringBuilder(getPath(TaskC.class));

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    private static void showDir(String command) {
        File file = new File(place.toString());
        String commandGoUp = (command.replaceFirst(CD,"")).trim();
        if(file.isDirectory()){
            if(command.equals(DIR)){
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    System.out.println(files[i]);
                }
            }else if((commandGoUp.equals(".."))){
                StringBuilder newPlace = new StringBuilder();
                String[] address = (place.toString()).split(("\\\\"));
                for (int i = 0; i < address.length-1; i++) {
                    newPlace.append(address[i]).append(File.separator);
                }
                place = newPlace;
                System.out.println(place);
            }else if(command.equals(CD)){
                System.out.println(place);
            }
            String[] getNameFile = command.split(CD);
            if(getNameFile.length > 1 && !getNameFile[getNameFile.length-1].equals("..")){
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if(files[i].getName().equals(command.replace(CD,"").trim())){
                       if(files[i].isDirectory()){
                           place.append(command.replace(CD,"").trim()).append(File.separator);
                           System.out.println(place);
                       }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while (!(line = reader.readLine()).equals(END)){
                showDir(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
