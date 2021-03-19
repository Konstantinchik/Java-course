package by.it.soldatenko.calc;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String a = strMatrix.replaceAll("[\\{\\}\\ ]", "");
        String[] str = a.split(",");
        double[][] d = new double[(int)Math.sqrt(str.length)][(int)Math.sqrt(str.length)];
        int count = 0;
        for (int i = 0; i < (int)Math.sqrt(str.length); i++) {
            for (int j = 0; j < (int)Math.sqrt(str.length); j++) {
                d[i][j] = Double.parseDouble(str[count]);
                count++;
            }
        }
        this.value = d;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
               res[i]= Arrays.copyOf(value[i],value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {

                    res[i][j] = res[i][j] + ((Scalar)other).getValue();
                }
            }

            return new Matrix(res);
        }
        else if(other instanceof Matrix){
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i]= Arrays.copyOf(value[i],value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {

                    res[i][j] = res[i][j] + ((Matrix)other).value[i][j];
                }
            }

            return new Matrix(res);
        }


        return super.add(other);

    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i]= Arrays.copyOf(value[i],value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {

                    res[i][j] = res[i][j] - ((Scalar)other).getValue();
                }
            }

            return new Matrix(res);
        }
        else if(other instanceof Matrix){
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i]= Arrays.copyOf(value[i],value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {

                    res[i][j] = res[i][j] - ((Matrix)other).value[i][j];
                }
            }

            return new Matrix(res);
        }



        return super.add(other);

    }


    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i]= Arrays.copyOf(value[i],value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {

                    res[i][j] = res[i][j] * ((Scalar)other).getValue();
                }
            }

            return new Matrix(res);
        }
        else if(other instanceof Vector){
            double[] mul = new double[value.length];
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < res.length; i++) {
                res[i]= Arrays.copyOf(value[i],value[i].length);
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector)other).getValue().length; j++) {
                    mul[i] = mul[i] + res[i][j]*((Vector)other).getValue()[j];
                }
            }
            return new Vector(mul);
        }
        else if(other instanceof Matrix){
            double[][] one = new double[value.length][value.length];
            for (int i = 0; i < one.length; i++) {
                one[i]= Arrays.copyOf(value[i],value[i].length);
            }
            double[][] mul = new double[one.length][((Matrix)other).value[0].length];
            for(int i = 0; i < one.length; i++) {
                for(int j = 0; j < ((Matrix)other).value[0].length; j++) {
                    for(int k = 0; k < ((Matrix)other).value.length; k++) {
                        mul[i][j] += one[i][k] * ((Matrix)other).value[k][j];
                    }
                }
            }
            return new Matrix(mul);
        }




        return super.mul(other);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            String delimiter = "";
            for (int j = 0; j < value.length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            if( i< (value.length-1)){
                sb.append(delimiter);
            }
        }
        sb.append("}");
        return sb.toString();

    }
}