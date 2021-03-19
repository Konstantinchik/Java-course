package by.it.terentyev.jd01_09;

public interface Patterns {
    String OPERATION = "[-+*/]";

    String SCALAR="-?[\\d]+(\\.[d]+)?";
    String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(,"+VECTOR+")*}";

}
