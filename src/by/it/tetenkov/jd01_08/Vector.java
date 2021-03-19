package by.it.tetenkov.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }



    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] thisArray = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisArray.length; i++) {
                thisArray[i] += otherValue;
            }
            return new Vector(thisArray);
        } else if (other instanceof Vector) {
            double[] thisVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisVector.length; i++) {
                thisVector[i] += ((Vector) other).value[i];
            }
            return new Vector(thisVector);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] thisArray = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisArray.length; i++) {
                thisArray[i] -= otherValue;
            }
            return new Vector(thisArray);
        } else if (other instanceof Vector) {
            double[] thisVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisVector.length; i++) {
                thisVector[i] -= ((Vector) other).value[i];
            }
            return new Vector(thisVector);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] thisArray = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisArray.length; i++) {
                thisArray[i] *= otherValue;
            }
            return new Vector(thisArray);
        } else if (other instanceof Vector) {
            double[] thisVector = Arrays.copyOf(value, value.length);
            double vectorMul = 0;
            for (int i = 0; i < thisVector.length; i++) {
                vectorMul += thisVector[i] * ((Vector) other).value[i];

            }
            return new Scalar(vectorMul);
        }
        return super.add(other);
    }

    public Var div(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] thisArray = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisArray.length; i++) {
                if (otherValue == 0) {
                    System.out.println("Division on zero");
                    return null;
                }
                thisArray[i] /= otherValue;
            }
            return new Vector(thisArray);
        } else if (other instanceof Vector) {
            System.out.println("Impossible to divide vector on vector");
            return null;
        }
        return super.add(other);
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
