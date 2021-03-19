package by.it.terentyev.calc;

public interface Patterns {
    String OPERATION = "[-+*/]";

    String SCALAR="-?[\\d]+(\\.[d]+)?";
    String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(,"+VECTOR+")*}";

}
