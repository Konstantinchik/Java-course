package by.it._khmelov_.calc;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
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
    public Var add(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += otherValue;
            }
            return new Vector(arr);
        } else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
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
