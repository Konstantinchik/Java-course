package by.it.plehanova.jd01_07;

import java.util.Arrays;

import static java.lang.Double.parseDouble;

class Vector extends Var {

    private double[] array;

    Vector(double[] value) {
        this.array = Arrays.copyOf(value, value.length);
    }

    Vector(String strVector) {
        this.array = Arrays.copyOf(number(strVector), number(strVector).length);
    }

    Vector(Vector vector) {
        this.array = Arrays.copyOf(vector.array, vector.array.length);
    }

    private static double[] number(String line) {

        String[] number = line.replaceAll("[{}]", "").trim().split(",");
        double[] arrayOfNumber = new double[number.length];

        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = Double.parseDouble(number[i]);
        }
        return arrayOfNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : array) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }


}
