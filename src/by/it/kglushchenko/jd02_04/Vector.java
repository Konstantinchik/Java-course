package by.it.kglushchenko.jd02_04;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public double[] getValue(){
        return value;
    }

    public double[] getArray() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strVar) {
        String[] strArr = strVar
                .replace("{", "")
                .replace("}", "")
                .replaceAll("\\s", "")
                .split(",");
        double[] res = value = new double[strArr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += otherValue;
            }
            return new Vector(arr);
        } else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= otherValue;
            }
            return new Vector(arr);
        } else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= otherValue;
            }
            return new Vector(arr);
        } else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                throw new CalcException("Division by zero");
            }
            double[] arr = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] /= ((Scalar) other).getValue();
            }
            return new Vector(arr);
        } else {
            return super.div(other);
        }
    }


    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
 /*   @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for(double element : value){
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }*/
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stringBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
