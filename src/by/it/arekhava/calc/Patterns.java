package by.it.arekhava.calc;

interface Patterns {
    String OPERATION="[-+*/=]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(,"+VECTOR+")*}";

    //{1,2,3.5,4.775,-8,-99}
}
