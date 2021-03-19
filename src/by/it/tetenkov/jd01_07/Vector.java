package by.it.tetenkov.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var{

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = Arrays.copyOf(otherVector.value,otherVector.value.length);
    }

    public Vector(String stringValue) {

        String[] subString;
        String replace = stringValue.replace("{"," ");
        replace = replace.replace("}", " ");
        replace = replace.trim();
        subString = replace.split(",");
        double[] doubleArray = new double[subString.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(subString[i]);
        }
        this.value = doubleArray;

    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double elements : value) {
            joiner.add(Double.toString(elements));
            
        }
        System.out.println(joiner.toString());

        return joiner.toString();
    }
}
