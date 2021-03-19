package by.it.terentyev.jd01_15;



public class test {
    public static void main(String[] args) {
        int[][] array = {{12, 15},{2, -15}};
       // boolean contains = IntStream.of(array).anyMatch(x -> x == -5);
        boolean ok;
        boolean ok2;
        do {
            ok = false;
            ok2 = false;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (array[i][j] == 15) {
                        ok = true;
                    } else if (array[i][j] == -15) {
                        ok2 = true;
                    }
                }
            }
        }
        while (!(ok && ok2));
        System.out.println(ok);
        System.out.println(ok2);



        }

    }

