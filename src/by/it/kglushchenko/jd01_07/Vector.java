package by.it.kglushchenko.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strValue){
        String str = strValue.replaceAll("[^0-9.]+", " ").trim();

                //joiner = new StringJoiner(", ", "{", "}");
        //for(int i=0; i<)
        //
        String[] strArray = str.split(" ");
        double[] numArray = new double[strArray.length];
        for(int i=0;i<strArray.length;i++){
            numArray[i]=Double.parseDouble(strArray[i]);
        }
        this.value = numArray;
    }

    public Vector(Vector otherVector) {
        this.value= otherVector.value;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for(double element : value){
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }
}
