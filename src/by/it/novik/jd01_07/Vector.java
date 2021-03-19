package by.it.novik.jd01_07;

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
