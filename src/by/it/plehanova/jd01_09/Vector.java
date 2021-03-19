package by.it.plehanova.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] array;

    public double[] getArray() {
        return array;
    }

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += otherValue;
            }
            return new Vector(arr);

        } else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += ((Vector) other).array[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= ((Scalar) other).getValue();
            }
            return new Vector(arr);

        } else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= ((Vector) other).array[i];
            }
            return new Vector(arr);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= ((Scalar) other).getValue();
            }
            return new Vector(arr);
        } else if (other instanceof Vector) {
            double sum = 0;
            for (int i = 0; i < this.array.length; i++) {
                sum += this.array[i] * ((Vector) other).array[i];
            }
            return new Scalar(sum);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if(((Scalar) other).getValue() == 0){
                System.out.println("Division by zero");
                return null;
            }
            double[] arr = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] /= ((Scalar) other).getValue();
            }
            return new Vector(arr);
        } else {
            return super.div(other);
        }
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
