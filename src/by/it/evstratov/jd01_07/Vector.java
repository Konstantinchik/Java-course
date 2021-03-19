package by.it.evstratov.jd01_07;


import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var{

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String strVector) {
        String str = strVector.replaceAll("[{}]","");
        String[] arrayStrings = str.split(",");
        this.value = new double[arrayStrings.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(arrayStrings[i].trim());
        }

    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (double v : value) {
            stringJoiner.add(Double.toString(v));
        }
        return stringJoiner.toString();
    }
}
