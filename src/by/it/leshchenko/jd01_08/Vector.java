package by.it.leshchenko.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private final double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        double[] array;
        Matcher matcher = Pattern.compile("\\{(.*)}").matcher(strVector);
        String[] strings;
        if (matcher.find()) {
            strings = matcher.group(1).split(",\\s?");
        } else {
            strings = new String[0];
        }
        array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        value = Arrays.copyOf(array, array.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] array = Arrays.copyOf(value, value.length);
            double result = 0;
            for (int i = 0; i < array.length; i++) {
                result += array[i] * ((Vector) other).value[i];
            }
            return new Scalar(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            if (otherValue == 0) {
                System.out.println("Деление на 0 невозможно");
                return null;
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double item : value) {
            joiner.add(Double.toString(item));
        }
        return joiner.toString();
    }
}
