package by.it.terentyev.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector) {
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] -= ((Vector) other).value[i];
                }
                return new Vector(arr);
            }
            return super.sub(other);
        }

    @Override

    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= ((Vector) other).value[i];
            }
            double mulVecScal = 0;
            for (int i = 0; i < arr.length; i++) {
                mulVecScal+=arr[i];
            }
            return new Scalar(mulVecScal);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            if (otherValue==0) {
                System.out.println("Division by zero");
                return null; //stub
            }
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] /= otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector) {
            System.out.println("Division by vector");
            return null; //stub
        }
        return super.div(other);
    }

        @Override
        public String toString () {
            StringJoiner joiner = new StringJoiner(", ", "{", "}");
            for (double element : value) {
                joiner.add(Double.toString(element));
            }

            return joiner.toString();
        }
    }
