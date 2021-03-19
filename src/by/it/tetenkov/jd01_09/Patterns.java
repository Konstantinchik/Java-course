package by.it.tetenkov.jd01_09;

public interface Patterns {
    String OPERATION = "[-+*/]";

    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}


// 1 2 3 4.5 -8 -99 4.775
// {1,2,3,4.5,4.874,-8,-99}

