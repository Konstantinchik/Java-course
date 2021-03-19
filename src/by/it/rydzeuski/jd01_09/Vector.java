package by.it.rydzeuski.jd01_09;


import java.util.Arrays;

class Vector extends Var {


    private final double[] value;

    Vector(double[] value) {
        this.value = value;

    }

    Vector(Vector vector) {
        this.value = vector.value;

    }

    public Vector(String strVar) {
        String[] strArr = strVar
                .replace("{", "")
                .replace("}", "")
                .replaceAll("\\s+", "")
                .split(",");
        double[] res = value = new double[strArr.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];

            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
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

