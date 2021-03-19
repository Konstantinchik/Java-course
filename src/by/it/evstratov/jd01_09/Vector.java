package by.it.evstratov.jd01_09;


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

    public Vector(String strVector) {
        String str = strVector.replaceAll("[{}]","");
        String[] arrayStrings = str.split(",");
        this.value = new double[arrayStrings.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(arrayStrings[i].trim());
        }

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double otherValue = ((Scalar) other).getValue();
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i]+=otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector){
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i]+=((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            return this.add(new Scalar(-1).mul(other));
        }else if(other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length){
                return this.add(new Vector((Vector) other.mul(new Scalar(-1))));
            }else{
                System.out.println("Вектора разной длинны");
                return null;
            }
        }else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length){
                double res = 0;
                for (int j = 0; j < this.value.length; j++) {
                    res = res + ((Vector) other).value[j] * this.value[j];
                }
                return new Scalar(res);
            }else{
                System.out.println("Вектора разной длинны");
                return null;
            }
        }else{
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            if (((Scalar) other).getValue()==0){
                System.out.println("Division by zero");
                return null; //stub
            }else{
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                }
                return new Vector(res);
            }
        }else{
            return super.div(other);
        }
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (double v : value) {
            stringJoiner.add(Double.toString(v));
        }
        return stringJoiner.toString();
    }
}
