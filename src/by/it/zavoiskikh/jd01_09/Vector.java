package by.it.zavoiskikh.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strVar) {
    value = new double[0];//stub
    }



    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder ("{");
        String delimiter = "";
        for (double element:value) {
            sb.append(delimiter).append(element);
            delimiter =", ";
        }
       sb.append ("}");
        return sb.toString();
    }
}
