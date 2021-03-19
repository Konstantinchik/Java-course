package by.it.leshchenko.calc;

public interface Patterns {
    String OPERATION = "(?<=[^-+*/=,{])[-+*/=]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{"+ SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{"+ VECTOR + "(," + VECTOR + ")*}";
    String BRACKETS = "(?<=\\().+?(?=\\))";
}
//D=((40.15-0.15)-20)/(7-5)
//2+(2*(-3+4/-2-(7-12)--2)+(11*-2)/2)+(4+11)