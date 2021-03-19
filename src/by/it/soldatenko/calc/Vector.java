package by.it.soldatenko.calc;


import java.util.Arrays;

class Vector extends Var {
    private final double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value){
        this.value = value;
    }
    Vector(Vector vector){
        this.value = vector.value;
    }
    Vector(String strVector){
        String a = strVector.replaceAll("[\\{\\}\\ ]", "");
        String[] str = a.split(",");
        double[] d = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            d[i] = Double.parseDouble(str[i]);
    }
        this.value =d;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
               res[i] = res[i] + ((Scalar)other).getValue();
            }

            return new Vector(res);
        }
        else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector)other).value[i];
            }

            return new Vector(res);
        }


            return super.add(other);

    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar)other).getValue();
            }

            return new Vector(res);
        }
        else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector)other).value[i];
            }

            return new Vector(res);
        }


        return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar)other).getValue();
            }

            return new Vector(res);
        }
        else if(other instanceof Vector){
            double  [] mulRes = new double[1];
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                mulRes[0] = mulRes[0] +(res[i] * ((Vector)other).value[i]);
            }

            return new Vector(mulRes);
        }


        return super.add(other);
    }
    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar)other).getValue();
            }

            return new Vector(res);
        }

        return super.div(other);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(value.length == 1){
            sb.append(value[0]);
            return sb.toString();}
        sb.append("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
