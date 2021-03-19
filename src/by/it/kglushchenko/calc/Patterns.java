package by.it.kglushchenko.calc;

public interface Patterns {
    String OPERATION = "[-=+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?"; // 0 или 1 'минус', цифры от 0 до 9, + 'то что слева может
    // присутствовать 1 или больше раз
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    //{1,2,3.5,4.775,-8,-99}
}
