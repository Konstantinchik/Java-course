package by.it.terentyev.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var{

 private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value=otherVector.value;
    }

    public Vector(String strVar) {
        String[] strArr = strVar
                .replace("{", "")
                .replace("}", "")
                .replaceAll("\\s+", "")
                .split(",");

        double[] res = value = new double[strArr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : value) {
            joiner.add(Double.toString(element));
        }

        return joiner.toString();
    }
}
