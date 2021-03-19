package by.it.kglushchenko.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

 class Matrix extends Var {
   /* private final double[][] value;


    Matrix(String strValue) {
        //String[][] strArray = strValue.split(" ");
        String[] strArray = strValue.split(" ");
        double[][] numArray = new double[strArray.length][];
        for (int i = 0; i < strArray.length; i++) {
            // numArray[i]=Double.parseDouble(strArray[i]);
        }
        this.value = numArray;
    }

    Matrix(double[][] value){
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            // Result: Matrix + Matrix
            double[][] sum = new double[value.length][value.length];
            for (int i=0; i< value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    sum[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            // Возвращаемый тип должен быть Var или его потомком
            return new Matrix(sum);
        }
        else
            // если other vector -> vector.add
            // если other scalar -> scalar.add
            return other.add(this);
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
    }*/
}
