package by.it.leshchenko.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private final double[] value;

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
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double item : value) {
            joiner.add(Double.toString(item));
        }
        return joiner.toString();
    }
}
