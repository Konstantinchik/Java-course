package by.it.kglushchenko.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

public class Matrix extends Var {
    private final double[][] value;


    public Matrix(String strValue) {
        String[] strArray = strValue.split(" ");
        double[][] numArray = new double[strArray.length][];
        for (int i = 0; i < strArray.length; i++) {
            // numArray[i]=Double.parseDouble(strArray[i]);
        }
        this.value = numArray;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        //for(double element : value){
        //    joiner.add(Double.toString(element));
        //}
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                joiner.add(Double.toString(value[i][j]));
            }
        }
        return joiner.toString();
    }
}
