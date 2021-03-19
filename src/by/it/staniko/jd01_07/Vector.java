package by.it.staniko.jd01_07;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }


    public Vector(String strVector) {
        String vector = strVector.replaceAll("[\\{\\}\\ ]", " ");
        String[] vectorArray = vector.split(",");
        double[] array = new double[vectorArray.length];
        for (int i = 0; i < vectorArray.length; i++) {
            array[i] = Double.parseDouble(vectorArray[i]);
        }
        this.value =array;
    }



    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : value ){
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }
}
