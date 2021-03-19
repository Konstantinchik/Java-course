package by.it.staniko.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends by.it.staniko.jd01_08.Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }


    public Vector(String strVector) {
        String vector = strVector.replaceAll("[\\{\\}\\ ]", " ");
        String[] vectorArray = vector.split(",");
        double[] array = new double[vectorArray.length];
        for (int i = 0; i < vectorArray.length; i++) {
            array[i] = Double.parseDouble(vectorArray[i]);
        }
        this.value =array;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double otherValue = ((Scalar) other).getValue();
            double[] arr=Arrays.copyOf(value,value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i]+=otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector){
            //double otherValue = ((Scalar) other).getValue();
            double[] arr=Arrays.copyOf(value,value.length);
            //double[] arrOther=Arrays.copyOf(other,other.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i]+=((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
    }
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double otherValue = ((Scalar) other).getValue();
            double[] arr=Arrays.copyOf(value,value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i]-=otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector){
            //double otherValue = ((Scalar) other).getValue();
            double[] arr=Arrays.copyOf(value,value.length);

            for (int i = 0; i < arr.length; i++) {
                arr[i]-=((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        return super.add(other);
    }
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double otherValue = ((Scalar) other).getValue();
            double[] arr=Arrays.copyOf(value,value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i]*=otherValue;
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector){
            //double otherValue = ((Scalar) other).getValue();
            double[] arr=Arrays.copyOf(value,value.length);
            double result= 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i]*=((Vector) other).value[i];
                result+=arr[i];
            }
            return new Scalar(result);
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) {
            if (other instanceof Scalar){
                double otherValue = ((Scalar) other).getValue();
                if (otherValue == 0) {
                    System.out.println("Division by zero");
                    return null;
                }
                double[] arr=Arrays.copyOf(value,value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i]/=otherValue;
                }
                return new Vector(arr);
            } else
        return super.div(other);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : value ){
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }
}
