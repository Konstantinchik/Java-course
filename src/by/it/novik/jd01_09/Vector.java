package by.it.novik.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value){
        this.value=value;
    }

    Vector(Vector vector){
        this.value=vector.value;
    }

    Vector(String str){
        this.value = Arrays.copyOf(mas(str), mas(str).length);
    }

    private static double[] mas(String vector){
        String[] string = vector.replaceAll("[{}]", "").split(",");
        double[] mas0 = new double[string.length];
        for (int i = 0; i < mas0.length; i++) {
            mas0[i] = Double.parseDouble(string[i]);
        }
        return mas0;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector) other).value[i];
            }
            return new Vector(res);
        } else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            double s=0;
            for (int i = 0; i < res.length; i++) {
                s+=res[i]*((Vector) other).value[i];
            }
            return new Scalar(s);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]/((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder("{");
        String delimeter ="";
        for (double element:value) {
            sb.append(delimeter).append(element);
            delimeter=", ";
            
        }
        sb.append("}");

        return sb.toString();
    }
}
