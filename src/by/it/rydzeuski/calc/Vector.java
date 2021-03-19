package by.it.rydzeuski.calc;


import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    Vector (Vector otherVector) {
        this.value = Arrays.copyOf(otherVector.value, otherVector.value.length);
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(String strVector) throws CalcException {
        String[] strValues = strVector
                .replaceAll("[{}]", "")
                .trim()
                .split(",\\s*");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] += scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                vector[i] += ((Vector) other).value[i];

            }
            return new Vector(vector);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= ((Vector) other).value[i];

            }
            return new Vector(vector);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other)throws CalcException  {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res += this.value[i] * ((Vector) other).value[i];

            }
            return new Scalar(res);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= scalar;
            }
            return new Vector(vector);
        }
        else
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

